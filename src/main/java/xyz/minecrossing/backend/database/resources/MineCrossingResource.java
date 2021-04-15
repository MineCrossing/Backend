package xyz.minecrossing.backend.database.resources;

import xyz.minecrossing.backend.database.builders.ModelBuilder;
import xyz.minecrossing.backend.database.helpers.AutoCloseNamedParamStatement;
import xyz.minecrossing.backend.database.helpers.EntityToPreparedStatementMapper;
import xyz.minecrossing.backend.database.helpers.ParamSpecification;
import xyz.minecrossing.backend.database.helpers.QueryBuilder;
import xyz.minecrossing.backend.database.interfaces.ColName;
import xyz.minecrossing.backend.database.interfaces.ICRUDResource;
import xyz.minecrossing.backend.database.interfaces.IDatabaseModel;
import xyz.minecrossing.databaseconnector.DatabaseConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * An implementation of ICRUDResource providing all CRUD functionality to its children provided that they implement
 * queryBuilder and modelBuilder
 *
 * @author Matthew Dodds W18020972
 */
public abstract class MineCrossingResource<T extends IDatabaseModel<K>, K> implements ICRUDResource<T, K> {
	protected abstract QueryBuilder queryBuilder();

	protected abstract ModelBuilder<T> modelBuilder();

	public Connection getConnection() {
		Connection connection;

		DatabaseConnector dbc = DatabaseConnector.getInstance();

		try {
			connection = dbc.getConnection("minecrossing");
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}

		return connection;
	}

	public AutoCloseNamedParamStatement getNamedParamStatement(String query) throws SQLException {
		return new AutoCloseNamedParamStatement(
				getConnection(),
				query,
				false);
	}

	/**
	 * Provides CREATE functionality
	 *
	 * @param entity The entity to create
	 * @return True if successful, false otherwise
	 */
	@Override
	public boolean add(T entity) {
		try (var ps = new EntityToPreparedStatementMapper<>(getNamedParamStatement(
				queryBuilder()
						.insert(getColumnNames(entity))
						.build()
		)).mapParams(entity)) {

			ps.execute();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			return false;
		}

		return true;
	}

	/**
	 * Provides UPDATE functionality
	 *
	 * @param entity The entity to update
	 * @return True if successful, false otherwise
	 */
	@Override
	public boolean update(T entity) {
		var columnsToUpdate = getColumnNames(entity)
				.stream()
				.filter(c -> !c.equals(entity.getKey()))
				.collect(Collectors.toList());

		try (var ps = new EntityToPreparedStatementMapper<>(
				getNamedParamStatement(
						queryBuilder()
								.update(columnsToUpdate)
								.where(getPrimaryKeyColName(entity))
								.build()
				)
		).mapParams(entity)) {

			ps.execute();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			return false;
		}

		return true;
	}

	/**
	 * Provides READ functionality
	 *
	 * @param keyCol The name of the primary key column
	 * @param key The value to search by
	 * @return True if successful, false otherwise
	 */
	@Override
	public T find(String keyCol, K key) {
		try (var ps = new EntityToPreparedStatementMapper<>(getNamedParamStatement(queryBuilder().select().where(keyCol).build()))
				.mapParams(keyCol, key)) {

			var resultSet = ps.executeQuery();
			resultSet.first();

			var entity = modelBuilder().fromResultSet(resultSet).build();

			resultSet.close();

			return entity;

		} catch (Exception throwables) {
			throwables.printStackTrace();
			return null;
		}
	}

	/**
	 * Finds an item by a given param specification
	 *
	 * @param spec The column name/value pair to search by
	 * @return A list of matching rows
	 */
	@Override
	public List<T> findBy(ParamSpecification<?> spec) {
		var foundEntities = new ArrayList<T>();

		try (var ps = new EntityToPreparedStatementMapper<>(getNamedParamStatement(queryBuilder().select().where(spec.getColName()).build()))
				.mapParams(spec.getColName(), spec.getColValue())) {

			var rs = ps.executeQuery();

			while (rs.next()) {
				foundEntities.add(modelBuilder().fromResultSet(rs).build());
			}

			rs.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		return foundEntities;
	}

	/**
	 * Provides SELECT * functionality and finds all items in the collection
	 * @return A list of all items
	 */
	@Override
	public List<T> findAll() {
		var entities = new ArrayList<T>();

		try (var ps = getNamedParamStatement(queryBuilder().select().build())) {
			var rs = ps.executeQuery();

			while (rs.next()) {
				entities.add(modelBuilder().fromResultSet(rs).build());
			}

			rs.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		return entities;
	}

	/**
	 * Provides DELETE functionality
	 *
	 * @param entity the object to remove
	 * @return True if successful, false otherwise
	 */
	@Override
	public boolean delete(T entity) {
		if (entity.getKey() == null)
			return false;

		var keyCol = getPrimaryKeyColName(entity);

		if (keyCol == null)
			return false;

		try (var ps = new EntityToPreparedStatementMapper<>(getNamedParamStatement(queryBuilder().delete().where(keyCol).build()))
				.mapParams(keyCol, entity.getKey())) {

			ps.execute();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			return false;
		}

		return true;
	}

	/**
	 * Creates a new row if one does not already exist. Updates a row if it does already exist.
	 *
	 * @param entity The entity to add or update
	 * @return True if successful, false otherwise
	 */
	@Override
	public boolean addOrUpdate(T entity) {
		return (find(getPrimaryKeyColName(entity), entity.getKey()) == null) ? add(entity) : update(entity);
	}

	private String getPrimaryKeyColName(T entity) {
		var keyColField = Arrays.stream(entity.getClass().getDeclaredFields()).filter(f -> {
			f.setAccessible(true);
			try {
				return f.get(entity).equals(entity.getKey()) && f.getAnnotation(ColName.class) != null;
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				return false;
			}
		}).findFirst().orElse(null);

		if (keyColField == null)
			return null;

		return keyColField.getAnnotation(ColName.class).col();
	}

	private List<String> getColumnNames(T entity) {
		return Arrays.stream(entity.getClass().getDeclaredFields()).filter(a -> a.getAnnotation(ColName.class) != null).map(c -> c.getAnnotation(ColName.class).col()).collect(Collectors.toList());
	}
}

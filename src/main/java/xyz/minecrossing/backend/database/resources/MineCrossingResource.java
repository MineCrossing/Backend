package xyz.minecrossing.backend.database.resources;

import xyz.minecrossing.backend.database.builders.ModelBuilder;
import xyz.minecrossing.backend.database.helpers.ConnectionAwareNamedParamStatement;
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

	public ConnectionAwareNamedParamStatement getNamedParamStatement(String query) throws SQLException {
		return new ConnectionAwareNamedParamStatement(
				getConnection(),
				query,
				false);
	}

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

	@Override
	public boolean addOrUpdate(T entity) {
		return (find(getPrimaryKeyColName(entity), entity.getKey()) == null) ? add(entity) : update(entity);
	}

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

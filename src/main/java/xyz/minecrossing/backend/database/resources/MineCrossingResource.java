package xyz.minecrossing.backend.database.resources;

import org.sql2o.tools.NamedParameterStatement;
import xyz.minecrossing.backend.database.builders.DTOBuilder;
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
	protected Connection connection;

	protected abstract QueryBuilder queryBuilder();

	protected abstract DTOBuilder<T> modelBuilder();

	public Connection getConnection() {
		if (connection == null) {
			DatabaseConnector dbc = DatabaseConnector.getInstance();

			try {
				connection = dbc.getConnection("minecrossing");
			} catch (SQLException ex) {
				ex.printStackTrace();
				return null;
			}
		}

		return connection;
	}

	public NamedParameterStatement getNamedParamStatement(String query) throws SQLException {
		return new NamedParameterStatement(
				getConnection(),
				query,
				false);
	}

	@Override
	public boolean add(T entity) {
		try {
			var ps = new EntityToPreparedStatementMapper<>(getNamedParamStatement(
					queryBuilder()
							.insert(getColumnNames(entity))
							.build()
			)).mapParams(entity);

			ps.execute();
			ps.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public boolean update(T entity) {
		try {
			var columnsToUpdate = getColumnNames(entity)
					.stream()
					.filter(c -> !c.equals(entity.getKey()))
					.collect(Collectors.toList());

			var ps = new EntityToPreparedStatementMapper<>(
					getNamedParamStatement(
							queryBuilder()
									.update(columnsToUpdate)
									.where(getPrimaryKeyColName(entity))
									.build()
					)
			).mapParams(entity);

			ps.execute();
			ps.close();
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
		try {
			if (entity.getKey() == null)
				return false;

			var keyCol = getPrimaryKeyColName(entity);

			if (keyCol == null)
				return false;

			new EntityToPreparedStatementMapper<>(getNamedParamStatement(queryBuilder().delete().where(keyCol).build()))
					.mapParams(keyCol, entity.getKey())
					.execute();

		} catch (SQLException throwables) {
			throwables.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public T find(String keyCol, K key) {
		try {
			var ps = new EntityToPreparedStatementMapper<>(getNamedParamStatement(queryBuilder().select().where(keyCol).build()))
					.mapParams(keyCol, key);

			var resultSet = ps.executeQuery();

			resultSet.first();

			return modelBuilder().fromResultSet(resultSet).build();
		} catch (Exception throwables) {
			throwables.printStackTrace();
			return null;
		}
	}

	@Override
	public List<T> findBy(ParamSpecification<?> spec) {
		var foundItems = new ArrayList<T>();

		try {
			var rs = new EntityToPreparedStatementMapper<>(getNamedParamStatement(queryBuilder().select().where(spec.getColName()).build()))
					.mapParams(spec.getColName(), spec.getColValue())
					.executeQuery();

			while (rs.next()) {
				foundItems.add(modelBuilder().fromResultSet(rs).build());
			}

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		return foundItems;
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

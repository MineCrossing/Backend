package xyz.minecrossing.backend.database.resources;

import org.sql2o.tools.NamedParameterStatement;
import xyz.minecrossing.backend.database.helpers.EntityToPreparedStatementMapper;
import xyz.minecrossing.backend.database.helpers.QueryBuilder;
import xyz.minecrossing.coreutilities.dbmodels.IDatabaseModel;
import xyz.minecrossing.databaseconnector.DatabaseConnector;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class MineCrossingResource<T extends IDatabaseModel<?>>  {
	private Connection connection;

	abstract QueryBuilder queryBuilder();

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

	public boolean add(T entity) {
		try {
			var ps = new EntityToPreparedStatementMapper<>(getNamedParamStatement(
					queryBuilder()
							.insert(entity.getColumnNames())
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
}

package xyz.minecrossing.backend.database.helpers;

import org.sql2o.tools.NamedParameterStatement;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionAwareNamedParamStatement extends NamedParameterStatement implements AutoCloseable {
	private final Connection connection;

	public ConnectionAwareNamedParamStatement(Connection connection, String query, boolean returnGeneratedKeys) throws SQLException {
		super(connection, query, returnGeneratedKeys);
		this.connection = connection;
	}

	public Connection getConnection() {
		return connection;
	}

	@Override
	public void close() throws SQLException {
		super.close();
		if (connection != null && !connection.isClosed())
			connection.close();

		if (getStatement() != null && !getStatement().isClosed())
			getStatement().close();
	}
}

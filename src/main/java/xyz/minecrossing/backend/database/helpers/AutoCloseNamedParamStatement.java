package xyz.minecrossing.backend.database.helpers;

import org.sql2o.tools.NamedParameterStatement;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * A wrapper class for NamedParameterStatement which implements AutoClosable and handles closing the prepared statement and connection after use
 *
 * @author Matthew Dodds W18020972
 */
public class AutoCloseNamedParamStatement extends NamedParameterStatement implements AutoCloseable {
	private final Connection connection;

	public AutoCloseNamedParamStatement(Connection connection, String query, boolean returnGeneratedKeys) throws SQLException {
		super(connection, query, returnGeneratedKeys);
		this.connection = connection;
	}

	/**
	 * An implementation of AutoCloseable which closes the prepared statement and connection.
	 * This implementation allows the class to be used with try-with-resource to properly dispose of the resources in use
	 *
	 * @throws SQLException Exceptions can occur when closing the connection or prepared statement.
	 */
	@Override
	public void close() throws SQLException {
		super.close();

		if (getStatement() != null && !getStatement().isClosed())
			getStatement().close();

		if (connection != null && !connection.isClosed())
			connection.close();
	}
}

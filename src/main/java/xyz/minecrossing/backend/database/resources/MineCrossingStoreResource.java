package xyz.minecrossing.backend.database.resources;

import xyz.minecrossing.backend.database.interfaces.IDatabaseModel;
import xyz.minecrossing.databaseconnector.DatabaseConnector;
import xyz.minecrossing.databaseconnector.DatabaseDetails;
import xyz.minecrossing.databaseconnector.DatabaseProperties;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class MineCrossingStoreResource<T extends IDatabaseModel<K>, K> extends MineCrossingResource<T, K> {
	@Override
	public Connection getConnection() {
		Connection connection;

		DatabaseConnector dbc = DatabaseConnector.getInstance();
		try {
			connection = dbc.getConnection("store-minecrossing");
			if (connection != null && !connection.isClosed())
				return connection;

			var dataDatabaseProperties = new DatabaseProperties().loadProperties();
			var dataBaseDetails = new DatabaseDetails(
					dataDatabaseProperties.getHostname(),
					dataDatabaseProperties.getPort(),
					"store-minecrossing",
					dataDatabaseProperties.getUsername(),
					dataDatabaseProperties.getPassword()
			);

			dbc.addDatabase(dataBaseDetails);
			connection = dbc.getConnection("store-minecrossing");
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}

		return connection;
	}
}

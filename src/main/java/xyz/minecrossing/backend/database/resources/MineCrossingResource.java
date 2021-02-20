package xyz.minecrossing.backend.database.resources;

import xyz.minecrossing.databaseconnector.DatabaseConnector;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class MineCrossingResource {
	public Connection getConnection() {
		DatabaseConnector dbc = DatabaseConnector.getInstance();
		Connection con;

		try {
			con = dbc.getConnection("minecrossing");
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		return con;
	}
}

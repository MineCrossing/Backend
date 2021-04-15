package xyz.minecrossing.backend.database.builders;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * An abstract model builder
 *
 * @param <T> The type of object to be created by the builder
 * @author Matthew Dodds W18020972
 */
public abstract class ModelBuilder<T> {
	/**
	 * A method to build the object
	 *
	 * @return An instance of the object
	 */
	public abstract T build();

	/**
	 * A method to build an object from a ResultSet
	 *
	 * @param rs The ResultSet containing the data with which to create the object
	 * @return An instance of the object with data populated from the result set
	 * @throws SQLException A potential exception which can be thrown if there is an issue retrieving data from the ResultSet
	 */
	public abstract ModelBuilder<T> fromResultSet(ResultSet rs) throws SQLException;
}

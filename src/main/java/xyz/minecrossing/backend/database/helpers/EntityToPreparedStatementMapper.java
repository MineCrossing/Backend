package xyz.minecrossing.backend.database.helpers;


import xyz.minecrossing.backend.database.interfaces.ColName;
import xyz.minecrossing.backend.database.interfaces.IDatabaseModel;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A class to map values to AutoCloseNamedParamStatement prepared statement placeholders
 *
 * @param <T> The type of entity which the params will be mapped from which must implement IDatabaseModel
 * @author Matthew Dodds W18020972
 */
public class EntityToPreparedStatementMapper<T extends IDatabaseModel<?>> {
	protected AutoCloseNamedParamStatement namedParameterStatement;

	public EntityToPreparedStatementMapper(AutoCloseNamedParamStatement namedParameterStatement) {
		this.namedParameterStatement = namedParameterStatement;
	}

	/**
	 * Takes an entity and maps its values to the prepared statement
	 *
	 * @param entity The entity containing the values to be mapped
	 * @return An AutoCloseNamedParamStatement containing the mapped params
	 */
	public AutoCloseNamedParamStatement mapParams(T entity) {
		Arrays.stream(entity.getClass().getDeclaredFields()).forEach(f -> {
			f.setAccessible(true);

			if (f.isAnnotationPresent(ColName.class)) {
				try {
					var param = f.get(entity);

					namedParameterStatement.setObject(f.getAnnotation(ColName.class).col(), param);
				} catch (SQLException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		});

		return namedParameterStatement;
	}

	/**
	 * An alternative way to map params to a prepared statement via a map of key -> value pairs
	 *
	 * @param entity The map of KV pairs
	 * @return An AutoCloseNamedParamStatement containing the mapped params
	 */
	public AutoCloseNamedParamStatement mapParams(Map<String, ?> entity) {
		entity.forEach((key, value) -> {
			try {
				namedParameterStatement.setObject(key, value);
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
			}
		});

		return namedParameterStatement;
	}

	/**
	 * An alternative way to map params to a prepared statement via two lists: a list of column names and a list of values. This method assumes the lists are
	 * ordered, i.e. colNames[0] will map to values[0]. Passing lists of different sizes will result in an IllegalArgumentException
	 *
	 * @param colNames The list of column names
	 * @param values The list of column values
	 * @param <V> The dataType of the column values
	 * @return An AutoCloseNamedParamStatement containing the mapped params
	 */
	public <V> AutoCloseNamedParamStatement mapParams(List<String> colNames, List<V> values) {
		if (colNames.size() != values.size())
			throw new IllegalArgumentException("Both lists must be of equal size");

		var map = new HashMap<String, V>();

		for (int i = 0; i < colNames.size(); i++) {
			map.put(colNames.get(i), values.get(i));
		}

		return mapParams(map);
	}

	/**
	 * An alternative way to map params to a prepared statement a column name and a column value
	 *
	 * @param colName The column name
	 * @param value The column value
	 * @param <V> The dataType of the column value
	 * @return An AutoCloseNamedParamStatement containing the mapped params
	 */
	public <V> AutoCloseNamedParamStatement mapParams(String colName, V value) {
		return mapParams(List.of(colName), List.of(value));
	}
}

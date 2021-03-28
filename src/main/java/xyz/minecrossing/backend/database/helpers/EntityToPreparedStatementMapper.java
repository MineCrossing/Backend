package xyz.minecrossing.backend.database.helpers;


import xyz.minecrossing.backend.database.interfaces.ColName;
import xyz.minecrossing.backend.database.interfaces.IDatabaseModel;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityToPreparedStatementMapper<T extends IDatabaseModel<?>> {
	protected ConnectionAwareNamedParamStatement namedParameterStatement;

	public EntityToPreparedStatementMapper(ConnectionAwareNamedParamStatement namedParameterStatement) {
		this.namedParameterStatement = namedParameterStatement;
	}

	public ConnectionAwareNamedParamStatement getNamedParameterStatement() {
		return namedParameterStatement;
	}

	public ConnectionAwareNamedParamStatement mapParams(T entity) {
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

	public ConnectionAwareNamedParamStatement mapParams(Map<String, ?> entity) {
		entity.forEach((key, value) -> {
			try {
				namedParameterStatement.setObject(key, value);
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
			}
		});

		return namedParameterStatement;
	}

	public <V> ConnectionAwareNamedParamStatement mapParams(List<String> colNames, List<V> values) {
		if (colNames.size() != values.size())
			throw new IllegalArgumentException("Both lists must be of equal size");

		var map = new HashMap<String, V>();

		for (int i = 0; i < colNames.size(); i++) {
			map.put(colNames.get(i), values.get(i));
		}

		return mapParams(map);
	}

	public <V> ConnectionAwareNamedParamStatement mapParams(String colName, V value) {
		return mapParams(List.of(colName), List.of(value));
	}
}

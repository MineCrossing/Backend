package xyz.minecrossing.backend.database.helpers;

import org.sql2o.tools.NamedParameterStatement;
import xyz.minecrossing.coreutilities.dbmodels.ColName;
import xyz.minecrossing.coreutilities.dbmodels.IDatabaseModel;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityToPreparedStatementMapper<T extends IDatabaseModel<?>> {
	protected NamedParameterStatement namedParameterStatement;

	public EntityToPreparedStatementMapper(NamedParameterStatement namedParameterStatement) {
		this.namedParameterStatement = namedParameterStatement;
	}

	public NamedParameterStatement getNamedParameterStatement() {
		return namedParameterStatement;
	}

	public NamedParameterStatement mapParams(T entity) {
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

	public NamedParameterStatement mapParams(Map<String, ?> entity) {
		entity.forEach((key, value) -> {
			try {
				namedParameterStatement.setObject(key, value);
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
			}
		});

		return namedParameterStatement;
	}

	public <V> NamedParameterStatement mapParams(List<String> colNames, List<V> values) {
		if (colNames.size() != values.size())
			throw new IllegalArgumentException("Both lists must be of equal size");

		var map = new HashMap<String, V>();

		for (int i = 0; i < colNames.size(); i++) {
			map.put(colNames.get(i), values.get(i));
		}

		return mapParams(map);
	}

	public <V> NamedParameterStatement mapParams(String colNames, V value) {
		return mapParams(List.of(colNames), List.of(value));
	}
}

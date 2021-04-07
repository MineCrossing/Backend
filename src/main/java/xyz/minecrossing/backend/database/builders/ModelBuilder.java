package xyz.minecrossing.backend.database.builders;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class ModelBuilder<T> {
	public abstract T build();

	public abstract ModelBuilder<T> fromResultSet(ResultSet rs) throws SQLException;
}

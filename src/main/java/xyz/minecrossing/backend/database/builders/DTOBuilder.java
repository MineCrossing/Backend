package xyz.minecrossing.backend.database.builders;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DTOBuilder<T> {
	public abstract T build();

	public abstract DTOBuilder<T> fromResultSet(ResultSet rs) throws SQLException;
}

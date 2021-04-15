package xyz.minecrossing.backend.database.builders;


import xyz.minecrossing.backend.database.models.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 * An Role model builder
 *
 * @author Matthew Dodds W18020972
 */
public class RoleBuilder extends ModelBuilder<Role> {
	private int roleID;
	private String roleName;
	private String displayName;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;

	/**
	 * A method to build an object from a ResultSet
	 *
	 * @param rs The ResultSet containing the data with which to create the object
	 * @return An instance of the object with data populated from the result set
	 * @throws SQLException A potential exception which can be thrown if there is an issue retrieving data from the ResultSet
	 */
	public RoleBuilder fromResultSet(ResultSet rs) throws SQLException {
		roleID = rs.getInt(Role.ROLE_ID_COL);
		roleName = rs.getString(Role.ROLE_NAME_COL);
		displayName = rs.getString(Role.DISPLAY_NAME_COL);
		createdDate = rs.getTimestamp(Role.CREATED_DATE_COL).toLocalDateTime();
		updatedDate = rs.getTimestamp(Role.UPDATE_DATE_COL).toLocalDateTime();

		return this;
	}

	public RoleBuilder setRoleID(int roleID) {
		this.roleID = roleID;
		return this;
	}

	public RoleBuilder setRoleName(String roleName) {
		this.roleName = roleName;
		return this;
	}

	public RoleBuilder setDisplayName(String displayName) {
		this.displayName = displayName;
		return this;
	}

	public RoleBuilder setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
		return this;
	}

	public RoleBuilder setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
		return this;
	}

	/**
	 * A method to build the object
	 *
	 * @return An instance of the object
	 */
	@Override
	public Role build() {
		return new Role(roleID, roleName, displayName, createdDate, updatedDate);
	}
}
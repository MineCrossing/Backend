package xyz.minecrossing.backend.database.builders;


import xyz.minecrossing.backend.database.models.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class RoleBuilder extends ModelBuilder<Role> {
	private int roleID;
	private String roleName;
	private String displayName;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;

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

	public Role build() {
		return new Role(roleID, roleName, displayName, createdDate, updatedDate);
	}
}
package xyz.minecrossing.backend.database.builders;


import xyz.minecrossing.backend.database.models.RoleDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class RoleDTOBuilder extends DTOBuilder<RoleDTO> {
	private int roleID;
	private String roleName;
	private String displayName;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;

	public RoleDTOBuilder fromResultSet(ResultSet rs) throws SQLException {
		roleID = rs.getInt(RoleDTO.ROLE_ID_COL);
		roleName = rs.getString(RoleDTO.ROLE_NAME_COL);
		displayName = rs.getString(RoleDTO.DISPLAY_NAME_COLUMN);
		createdDate = rs.getTimestamp(RoleDTO.CREATED_DATE_COL).toLocalDateTime();
		updatedDate = rs.getTimestamp(RoleDTO.UPDATE_DATE_COL).toLocalDateTime();

		return this;
	}

	public RoleDTOBuilder setRoleID(int roleID) {
		this.roleID = roleID;
		return this;
	}

	public RoleDTOBuilder setRoleName(String roleName) {
		this.roleName = roleName;
		return this;
	}

	public RoleDTOBuilder setDisplayName(String displayName) {
		this.displayName = displayName;
		return this;
	}

	public RoleDTOBuilder setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
		return this;
	}

	public RoleDTOBuilder setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
		return this;
	}

	public RoleDTO build() {
		return new RoleDTO(roleID, roleName, displayName, createdDate, updatedDate);
	}
}
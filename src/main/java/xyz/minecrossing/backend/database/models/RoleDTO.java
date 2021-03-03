package xyz.minecrossing.backend.database.models;

import xyz.minecrossing.backend.database.interfaces.ColName;
import xyz.minecrossing.backend.database.interfaces.IDatabaseModel;

import java.time.LocalDateTime;

public class RoleDTO implements IDatabaseModel<Integer> {
	@ColName(col = "id")
	private int roleID;
	@ColName(col = "name")
	private String roleName;
	@ColName(col = "displayName")
	private String displayName;
	@ColName(col = "created_at")
	private LocalDateTime createdDate;
	@ColName(col = "updated_at")
	private LocalDateTime updatedDate;

	public static String ROLE_ID_COL = "id";
	public static String ROLE_NAME_COL = "name";
	public static String DISPLAY_NAME_COLUMN = "displayName";
	public static String CREATED_DATE_COL = "created_at";
	public static String UPDATE_DATE_COL = "updated_at";

	public RoleDTO() {
	}

	public RoleDTO(int roleID, String roleName, String displayName, LocalDateTime createdDate, LocalDateTime updatedDate) {
		this.roleID = roleID;
		this.roleName = roleName;
		this.displayName = displayName;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public Integer getKey() {
		return roleID;
	}
}

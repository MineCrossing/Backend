package xyz.minecrossing.backend.controller.api.responses;

public class AuthResponse {
	private boolean loggedIn;
	private boolean admin;
	private int userID;

	public AuthResponse() {
		this.loggedIn = false;
		this.admin = false;
	}

	public AuthResponse(boolean loggedIn, boolean admin, int userID) {
		this.loggedIn = loggedIn;
		this.admin = admin;
		this.userID = userID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}

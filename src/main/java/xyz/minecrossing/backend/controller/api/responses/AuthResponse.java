package xyz.minecrossing.backend.controller.api.responses;

public class AuthResponse {
	private boolean authed;
	private boolean admin;

	public AuthResponse() {
		this.authed = false;
		this.admin = false;
	}

	public AuthResponse(boolean authed, boolean admin) {
		this.authed = authed;
		this.admin = admin;
	}

	public boolean isAuthed() {
		return authed;
	}

	public void setAuthed(boolean authed) {
		this.authed = authed;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}

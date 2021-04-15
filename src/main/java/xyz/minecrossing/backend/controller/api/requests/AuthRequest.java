package xyz.minecrossing.backend.controller.api.requests;

/**
 * A class to store data relating to a user authentication request
 *
 * @author Matthew Dodds W18020972
 */
public class AuthRequest {
	private int userId;
	private String token;

	public AuthRequest() {
	}

	public AuthRequest(int userId, String token) {
		this.userId = userId;
		this.token = token;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}

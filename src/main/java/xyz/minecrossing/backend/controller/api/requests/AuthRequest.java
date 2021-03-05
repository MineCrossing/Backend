package xyz.minecrossing.backend.controller.api.requests;

public class AuthRequest {
	private int userID;
	private String JTI;

	public AuthRequest() {
	}

	public AuthRequest(int userID, String JTI) {
		this.userID = userID;
		this.JTI = JTI;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getJTI() {
		return JTI;
	}

	public void setJTI(String JTI) {
		this.JTI = JTI;
	}
}

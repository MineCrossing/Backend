package xyz.minecrossing.backend.helpers;

public class StringUtils {
	public static boolean isNullOrEmpty(String str) {
		return str == null || str.trim().isEmpty();
	}
}

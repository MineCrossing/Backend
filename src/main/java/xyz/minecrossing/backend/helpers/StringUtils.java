package xyz.minecrossing.backend.helpers;

public class StringUtils {
	public static boolean isNullOrEmpty(String str) {
		return str == null || str.trim().isEmpty();
	}

	public static boolean anyNullOrEmpty(String... str) {
		for(var s : str) {
			if (isNullOrEmpty(s))
				return true;
		}
		return false;
	}

	public static String defaultIfEmpty(String toCheck, String defaultValue) {
		return isNullOrEmpty(toCheck) ? defaultValue : toCheck;
	}
}

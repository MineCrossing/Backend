package xyz.minecrossing.backend.helpers;

/**
 * A utility class containing string helper methods
 *
 * @author Matthew Dodds W18020972
 */
public class StringUtils {
	/**
	 * Identifies whether a string is null or empty. Whitespace only is treated as empty.
	 *
	 * @param str The string to check
	 * @return True if the string is null or empty, false otherwise
	 */
	public static boolean isNullOrEmpty(String str) {
		return str == null || str.trim().isEmpty();
	}

	/**
	 * Checks whether at least one string in a collection if given strings is null or empty
	 *
	 * @param str The strings to check
	 * @return True if at least one string is null or empty, false otherwise
	 */
	public static boolean anyNullOrEmpty(String... str) {
		if (str == null)
			return true;

		for(var s : str) {
			if (isNullOrEmpty(s))
				return true;
		}

		return false;
	}

	/**
	 * Returns a default string if the given string is null or empty.
	 *
	 * @param toCheck The given string to check
	 * @param defaultValue The default value to return
	 * @return The toCheck string is it is not null or empty, the default string otherwise
	 */
	public static String defaultIfEmpty(String toCheck, String defaultValue) {
		return isNullOrEmpty(toCheck) ? defaultValue : toCheck;
	}
}

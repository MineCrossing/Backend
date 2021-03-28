package xyz.minecrossing.backend.helpers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringUtilsTests {

	@Test
	void returnsTrueOnNull()
	{
		assertTrue(StringUtils.isNullOrEmpty(null));
	}

	@Test
	void returnsTrueOnEmpty()
	{
		assertTrue(StringUtils.isNullOrEmpty(""));
	}

	@Test
	void returnsTrueOnWhiteSpace()
	{
		assertTrue(StringUtils.isNullOrEmpty("       "));
	}

	@Test
	void returnsFalseOnString()
	{
		assertFalse(StringUtils.isNullOrEmpty("A string"));
	}
}

package xyz.minecrossing.backend.helpers;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTests {

	@Nested
	class IsNullOrEmpty {
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

	@Nested
	class AnyNullOrEmpty {
		@Test
		void returnsTrueOnNull()
		{
			assertTrue(StringUtils.anyNullOrEmpty(null));
		}

		@Test
		void returnsTrueOnEmpty()
		{
			assertTrue(StringUtils.anyNullOrEmpty(""));
		}

		@Test
		void returnsTrueOnWhiteSpace()
		{
			assertTrue(StringUtils.anyNullOrEmpty("       "));
		}

		@Test
		void returnsTrueOnFirstItemNull() {
			assertTrue(StringUtils.anyNullOrEmpty(null, "a", "a"));
		}

		@Test
		void returnsTrueOnLastItemNull() {
			assertTrue(StringUtils.anyNullOrEmpty("a", "a", null));
		}

		@Test
		void returnsFalseOnString()
		{
			assertFalse(StringUtils.anyNullOrEmpty("A string"));
		}
	}

	@Nested
	class DefaultIfEmpty {
		String defaultStr = "abc";

		@Test
		void returnsDefaultOnNull()
		{
			assertEquals(StringUtils.defaultIfEmpty(null, defaultStr), defaultStr);
		}

		@Test
		void returnsDefaultOnEmpty()
		{
			assertEquals(StringUtils.defaultIfEmpty("", defaultStr), defaultStr);
		}

		@Test
		void returnsDefaultOnWhiteSpace()
		{
			assertEquals(StringUtils.defaultIfEmpty("    ", defaultStr), defaultStr);
		}

		@Test
		void returnsValueOnNoNullOrEmpty()
		{
			var value = "a";
			assertEquals(StringUtils.defaultIfEmpty(value, defaultStr), value);
		}
	}
}

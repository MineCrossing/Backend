package xyz.minecrossing.backend.database.helpers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueryBuilderTests {
	private QueryBuilder qb;

	@BeforeEach
	void setup() {
		qb = new QueryBuilder("table");
	}

	@Nested
	class Select {
		@Test
		void selectStar_IsValidSQL() {
			var actual = qb.select().build().toLowerCase();
			var expected = "select * from table";
			assertEquals(expected, actual);
		}

		@Test
		void selectSingleNamedColumn_IsValidSQL() {
			var actual = qb.select("col1").build().toLowerCase();
			var expected = "select col1 from table";
			assertEquals(expected, actual);
		}

		@Test
		void selectNamedColumns_IsValidSQL() {
			var actual = qb.select("col1", "col2").build().toLowerCase();
			var expected = "select col1, col2 from table";
			assertEquals(expected, actual);
		}
	}

	@Nested
	class Insert {
		@Test
		void insertSingle_IsValidSQL() {
			var actual = qb.insert("col1").build().toLowerCase();
			var expected = "insert into table (col1) values (:col1)";
			assertEquals(expected, actual);
		}

		@Test
		void insertMultiple_IsValidSQL() {
			var actual = qb.insert("col1", "col2", "col3").build().toLowerCase();
			var expected = "insert into table (col1, col2, col3) values (:col1, :col2, :col3)";
			assertEquals(expected, actual);
		}
	}

	@Nested
	class Update {
		@Test
		void updateSingle_IsValidSQL() {
			var actual = qb.update("col1").build().toLowerCase();
			var expected = "update table set col1 = :col1";
			assertEquals(expected, actual);
		}

		@Test
		void updateMultiple_IsValidSQL() {
			var actual = qb.update("col1", "col2", "col3").build().toLowerCase();
			var expected = "update table set col1 = :col1, col2 = :col2, col3 = :col3";
			assertEquals(expected, actual);
		}
	}


}

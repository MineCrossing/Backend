package xyz.minecrossing.backend.database.helpers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
		void selectSingleColumn_IsValidSQL() {
			var actual = qb.select("col1").build().toLowerCase();
			var expected = "select col1 from table";
			assertEquals(expected, actual);
		}

		@Test
		void selectMultipleColumns_IsValidSQL() {
			var actual = qb.select("col1", "col2").build().toLowerCase();
			var expected = "select col1, col2 from table";
			assertEquals(expected, actual);
		}

		@Test
		void selectNull_ThrowsError() {
			assertThrows(NullPointerException.class, () -> qb.select((String) null).build());
		}
	}

	@Nested
	class Insert {
		@Test
		void insertSingleRow_IsValidSQL() {
			var actual = qb.insert("col1").build().toLowerCase();
			var expected = "insert into table (col1) values (:col1)";
			assertEquals(expected, actual);
		}

		@Test
		void insertMultipleRows_IsValidSQL() {
			var actual = qb.insert("col1", "col2", "col3").build().toLowerCase();
			var expected = "insert into table (col1, col2, col3) values (:col1, :col2, :col3)";
			assertEquals(expected, actual);
		}

		@Test
		void insertNull_ThrowsError() {
			assertThrows(NullPointerException.class, () -> qb.insert((String) null).build());
		}
	}

	@Nested
	class Update {
		@Test
		void updateSingleRow_IsValidSQL() {
			var actual = qb.update("col1").build().toLowerCase();
			var expected = "update table set col1 = :col1";
			assertEquals(expected, actual);
		}

		@Test
		void updateMultipleRows_IsValidSQL() {
			var actual = qb.update("col1", "col2", "col3").build().toLowerCase();
			var expected = "update table set col1 = :col1, col2 = :col2, col3 = :col3";
			assertEquals(expected, actual);
		}

		@Test
		void updateNull_ThrowsError() {
			assertThrows(NullPointerException.class, () -> qb.update((String) null).build());
		}
	}

	@Nested
	class Delete {
		@Test
		void delete_isValidSQL() {
			var actual = qb.delete().build().toLowerCase();
			var expected = "delete from table";
			assertEquals(expected, actual);
		}
	}

	@Nested
	class Where {
		@Test
		void whereEqualOperator_IsValidSQL() {
			var actual = qb.select().where("col1").build().toLowerCase();
			var expected = "select * from table where col1 = :col1";
			assertEquals(expected, actual);
		}

		@Test
		void whereNotEqualOperator_IsValidSQL() {
			var actual = qb.select().where("col1", "!=").build().toLowerCase();
			var expected = "select * from table where col1 != :col1";
			assertEquals(expected, actual);
		}

		@Test
		void whereGreaterThanOperator_IsValidSQL() {
			var actual = qb.select().where("col1", ">").build().toLowerCase();
			var expected = "select * from table where col1 > :col1";
			assertEquals(expected, actual);
		}

		@Test
		void whereGreaterThanOrEqualOperator_IsValidSQL() {
			var actual = qb.select().where("col1", ">=").build().toLowerCase();
			var expected = "select * from table where col1 >= :col1";
			assertEquals(expected, actual);
		}

		@Test
		void whereLessThanOperator_IsValidSQL() {
			var actual = qb.select().where("col1", "<").build().toLowerCase();
			var expected = "select * from table where col1 < :col1";
			assertEquals(expected, actual);
		}

		@Test
		void whereLessThanOrEqualOperator_IsValidSQL() {
			var actual = qb.select().where("col1", "<=").build().toLowerCase();
			var expected = "select * from table where col1 <= :col1";
			assertEquals(expected, actual);
		}

		@Test
		void whereNull_ThrowsError() {
			assertThrows(NullPointerException.class, () -> qb.select().where((String) null).build());
		}
	}

	@Nested
	class And {
		@Test
		void andSingleParam_IsValidSQL() {
			var actual = qb.select().where("col1").and("col2").build().toLowerCase();
			var expected = "select * from table where col1 = :col1 and col2 = :col2";
			assertEquals(expected, actual);
		}

		@Test
		void andMultipleParam_IsValidSQL() {
			var actual = qb.select().where("col1").and("col2").and("col3").build().toLowerCase();
			var expected = "select * from table where col1 = :col1 and col2 = :col2 and col3 = :col3";
			assertEquals(expected, actual);
		}

		@Test
		void andNull_ThrowsError() {
			assertThrows(NullPointerException.class, () -> qb.select().where("col1").and((String) null).build());
		}
	}

	@Nested
	class Or {
		@Test
		void orSingleParam_IsValidSQL() {
			var actual = qb.select().where("col1").or("col2").build().toLowerCase();
			var expected = "select * from table where col1 = :col1 or col2 = :col2";
			assertEquals(expected, actual);
		}

		@Test
		void orMultipleParam_IsValidSQL() {
			var actual = qb.select().where("col1").or("col2").or("col3").build().toLowerCase();
			var expected = "select * from table where col1 = :col1 or col2 = :col2 or col3 = :col3";
			assertEquals(expected, actual);
		}

		@Test
		void andNull_ThrowsError() {
			assertThrows(NullPointerException.class, () -> qb.select().where("col1").or((String) null).build());
		}
	}

	@Nested
	class OrderBy {
		@Test
		void orderBySingleParam_IsValidSQL() {
			var actual = qb.select().orderBy("col1").build().toLowerCase();
			var expected = "select * from table order by col1";
			assertEquals(expected, actual);
		}

		@Test
		void orderByDescendingSingleParam_IsValidSQL() {
			var actual = qb.select().orderBy(true, "col1").build().toLowerCase();
			var expected = "select * from table order by col1 desc";
			assertEquals(expected, actual);
		}

		@Test
		void orderByMultipleParam_IsValidSQL() {
			var actual = qb.select().orderBy("col1", "col2").build().toLowerCase();
			var expected = "select * from table order by col1, col2";
			assertEquals(expected, actual);
		}

		@Test
		void orderByDescendingMultipleParam_IsValidSQL() {
			var actual = qb.select().orderBy(true, "col1", "col2").build().toLowerCase();
			var expected = "select * from table order by col1, col2 desc";
			assertEquals(expected, actual);
		}

		@Test
		void orderByNull_ThrowsError() {
			assertThrows(NullPointerException.class, () -> qb.select().orderBy((String) null).build());
		}
	}

	@Nested
	class Limit {
		@Test
		void limit_IsValidSQL() {
			var actual = qb.select().limit(5).build().toLowerCase();
			var expected = "select * from table limit 0, 5";
			assertEquals(expected, actual);
		}

		@Test
		void limitOffset_IsValidSQL() {
			var actual = qb.select().limit(2, 5).build().toLowerCase();
			var expected = "select * from table limit 2, 5";
			assertEquals(expected, actual);
		}

		@Test
		void limitOffset_HandlesNegativeNumbers() {
			var actual = qb.select().limit(-2, -5).build().toLowerCase();
			var expected = "select * from table limit 0, 0";
			assertEquals(expected, actual);
		}
	}

}

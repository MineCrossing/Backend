package xyz.minecrossing.backend.database;

import xyz.minecrossing.backend.database.helpers.QueryBuilder;

import java.util.List;

public class QueryBuilderTests {
	public static void runTests() {
		String selectStar = new QueryBuilder("users")
				.select()
				.build();

		String selectCols = new QueryBuilder("users")
				.select("user_id", "username", "admin")
				.build();

		String insertColsAndVals = new QueryBuilder("users")
				.insert(List.of("user_id", "email", "username"))
				.build();

		String update = new QueryBuilder("users")
				.update(List.of("username", "admin"))
				.build();

		String where = new QueryBuilder("users")
				.select("user_id", "username", "admin")
				.where("user_id")
				.build();

		String customWhere = new QueryBuilder("users")
				.select("user_id", "username", "admin")
				.customWhere("user_id = ?")
				.build();

		String and = new QueryBuilder("users")
				.select("user_id", "username", "admin")
				.where("username")
				.and("admin")
				.build();

		String or = new QueryBuilder("users")
				.select("user_id", "username", "admin")
				.where("username")
				.or("admin")
				.build();

		System.out.printf("Select *: %s\n", selectStar);
		System.out.printf("Select Cols: %s\n", selectCols);
		System.out.printf("Insert Cols and Vals: %s\n", insertColsAndVals);
		System.out.printf("Update: %s\n", update);
		System.out.printf("Where: %s\n", where);
		System.out.printf("CustomWhere: %s\n", customWhere);
		System.out.printf("And: %s\n", and);
		System.out.printf("Or: %s\n", or);
	}
}

package xyz.minecrossing.backend.database.helpers;

import xyz.minecrossing.backend.helpers.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * A class for building SQL queries using NamedParameterStatement SQL placeholders. The class supports...
 * SELECT, INSERT, UPDATE, DELETE, WHERE, AND, OR, ORDERBY and LIMIT. It currently has no IN or JOIN support
 *
 * @author Matthew Dodds W18020972
 */
public class QueryBuilder {
	private String queryStart;
	private String queryWhere;
	private String queryLimit;
	private String queryOrderBy;
	private final String tableName;
	private final String defaultOperator = "=";
	private final int defaultOffset = 0;
	private final int defaultLimit = 0;

	public QueryBuilder(String tableName) {
		this.tableName = tableName;
	}

	private String toCSV(List<String> values) {
		return String.join(", ", Objects.requireNonNull(values));
	}

	private String formatWhere(String where) {
		return String.format("WHERE %s", where.toLowerCase().replace("where", "").trim());
	}

	private String formatPairs(List<String> values) {
		return formatPairs(values, defaultOperator);
	}

	private String formatPairs(String operator, String... values) {
		return formatPairs(List.of(values), operator);
	}

	private String formatPairs(List<String> values, String operator) {
		return values
				.stream()
				.map(v -> String.format("%s %s :%s", v, operator, v))
				.collect(Collectors.joining(", "));
	}

	private String getValuePlaceholder(List<String> columnNames) {
		return columnNames.stream().map(i -> ":" + i).collect(Collectors.joining(", "));
	}

	/**
	 * Select *
	 *
	 * @return The QueryBuilder object
	 */
	public QueryBuilder select() {
		this.queryStart = String.format("SELECT * FROM %s", tableName);
		return this;
	}

	/**
	 * Select a list of column names
	 *
	 * @param columnNames The list of column names
	 * @return The QueryBuilder object
	 */
	public QueryBuilder select(List<String> columnNames) {
		this.queryStart = String.format("SELECT %s FROM %s", toCSV(columnNames), tableName);
		return this;
	}

	/**
	 * Select a list of column names
	 *
	 * @param columnNames The list of column names
	 * @return The QueryBuilder object
	 */
	public QueryBuilder select(String... columnNames) {
		return select(List.of(columnNames));
	}

	/**
	 * Inserts a list of column names
	 *
	 * @param columnNames The list of column names
	 * @return The QueryBuilder object
	 */
	public QueryBuilder insert(List<String> columnNames) {
		this.queryStart = String.format("INSERT INTO %s (%s) VALUES (%s)", tableName, toCSV(columnNames), getValuePlaceholder(columnNames));
		return this;
	}

	/**
	 * Select a list of column names
	 *
	 * @param columnNames The list of column names
	 * @return The QueryBuilder object
	 */
	public QueryBuilder insert(String... columnNames) {
		return insert(List.of(columnNames));
	}

	/**
	 * Delete from
	 *
	 * @return The QueryBuilder object
	 */
	public QueryBuilder delete() {
		this.queryStart = String.format("DELETE FROM %s", tableName);
		return this;
	}

	/**
	 * Updates a list of column names
	 *
	 * @param columnNames The list of column names
	 * @return The QueryBuilder object
	 */
	public QueryBuilder update(List<String> columnNames) {
		this.queryStart = String.format("UPDATE %s SET %s", tableName, formatPairs(columnNames));
		return this;
	}

	/**
	 * Updates a list of column names
	 *
	 * @param columnNames The list of column names
	 * @return The QueryBuilder object
	 */
	public QueryBuilder update(String... columnNames) {
		return update(List.of(columnNames));
	}

	/**
	 * Where statement with the default operator (key = value)
	 *
	 * @param columnName The column name
	 * @return The QueryBuilder object
	 */
	public QueryBuilder where(String columnName) {
		return where(columnName, defaultOperator);
	}

	/**
	 * Where statement with the a custom operator (key ?? value)
	 *
	 * @param columnName The column name
	 * @param operator The SQL operator for the statement
	 * @return The QueryBuilder object
	 */
	public QueryBuilder where(String columnName, String operator) {
		this.queryWhere = formatWhere(formatPairs(operator, columnName));
		return this;
	}

	/**
	 * And statement with the default operator (key = value)
	 *
	 * @param columnName The column name
	 * @return The QueryBuilder object
	 */
	public QueryBuilder and(String columnName) {
		return and(columnName, defaultOperator);
	}

	/**
	 * And statement with the a custom operator (key ?? value)
	 *
	 * @param columnName The column name
	 * @param operator The SQL operator for the statement
	 * @return The QueryBuilder object
	 */
	public QueryBuilder and(String columnName, String operator) {
		this.queryWhere += String.format(" AND %s", formatPairs(operator, columnName));
		return this;
	}

	/**
	 * Or statement with the default operator (key = value)
	 *
	 * @param columnName The column name
	 * @return The QueryBuilder object
	 */
	public QueryBuilder or(String columnName) {
		return or(columnName, defaultOperator);
	}

	/**
	 * Or statement with the a custom operator (key ?? value)
	 *
	 * @param columnName The column name
	 * @param operator The SQL operator for the statement
	 * @return The QueryBuilder object
	 */
	public QueryBuilder or(String columnName, String operator) {
		this.queryWhere += String.format(" OR %s", formatPairs(operator, columnName));
		return this;
	}

	/**
	 * Orderby the specified column names in ascending order
	 *
	 * @param columnNames the list of column names
	 * @return The QueryBuilder object
	 */
	public QueryBuilder orderBy(String... columnNames) {
		return orderBy(false, columnNames);
	}

	/**
	 * Orderby the specified column names in the specified order (false for ascending, true for descending)
	 *
	 * @param descending whether to order the results descending
	 * @param columnNames the list of column names
	 * @return The QueryBuilder object
	 */
	public QueryBuilder orderBy(boolean descending, String... columnNames) {
		// Performs an implicit null check to throw an exception is any element is null
		List.of(columnNames);

		this.queryOrderBy = String.format("ORDER BY %s%s", String.join(", ", columnNames), descending ? " DESC" : "");
		return this;
	}

	/**
	 * Limit by the given value
	 *
	 * @param limit The value to limit by
	 * @return The QueryBuilder object
	 */
	public QueryBuilder limit(int limit) {
		return limit(0, limit);
	}

	/**
	 * Limit by the given offset and value
	 *
	 * @param offset The value to offset by
	 * @param limit The value to limit by
	 * @return The QueryBuilder object
	 */
	public QueryBuilder limit(int offset, int limit) {
		offset = offset < 0 ? defaultOffset : offset;
		limit = limit < 0 ? defaultLimit : limit;

		this.queryLimit = String.format("LIMIT %s, %s", offset, limit);
		return this;
	}

	/**
	 * Builds the query
	 *
	 * @return The built query
	 */
	public String build() {
		return String.format(
				"%s%s%s%s",
				queryStart,
				StringUtils.isNullOrEmpty(queryWhere) ? "" : " " + queryWhere,
				StringUtils.isNullOrEmpty(queryOrderBy) ? "" : " " + queryOrderBy,
				StringUtils.isNullOrEmpty(queryLimit) ? "" : " " + queryLimit
		);
	}
}

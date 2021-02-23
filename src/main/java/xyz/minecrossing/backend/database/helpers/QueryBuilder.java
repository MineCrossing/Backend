package xyz.minecrossing.backend.database.helpers;

import xyz.minecrossing.backend.helpers.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class QueryBuilder {
	private String queryStart;
	private String queryWhere;
	private final String tableName;
	private final String defaultOperator = "=";

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

	public QueryBuilder select() {
		this.queryStart = String.format("SELECT * FROM %s", tableName);
		return this;
	}

	public QueryBuilder select(List<String> columnNames) {
		this.queryStart = String.format("SELECT %s FROM %s", toCSV(columnNames), tableName);
		return this;
	}

	public QueryBuilder select(String... columnNames) {
		return select(List.of(columnNames));
	}

	public QueryBuilder insert(List<String> columnNames) {
		this.queryStart = String.format("INSERT INTO %s (%s) VALUES (%s)", tableName, toCSV(columnNames), getValuePlaceholder(columnNames));
		return this;
	}

	public QueryBuilder insert(String... columnNames) {
		return insert(List.of(columnNames));
	}

	public QueryBuilder delete(String where) {
		this.queryStart = String.format("DELETE FROM %s", tableName);
		this.queryWhere = formatWhere(where);
		return this;
	}

	public QueryBuilder update(List<String> columnNames) {
		this.queryStart = String.format("UPDATE %s SET %s", tableName, formatPairs(columnNames));
		return this;
	}

	public QueryBuilder update(String... columnNames) {
		return update(List.of(columnNames));
	}

	public QueryBuilder customWhere(String where) {
		this.queryWhere = formatWhere(where);
		return this;
	}

	public QueryBuilder where(String columnName) {
		return where(columnName, defaultOperator);
	}

	public QueryBuilder where(String columnName, String operator) {
		this.queryWhere = formatWhere(formatPairs(operator, columnName));
		return this;
	}

	public QueryBuilder and(String columnName) {
		return and(columnName, defaultOperator);
	}

	public QueryBuilder and(String columnName, String operator) {
		this.queryWhere += String.format(" AND %s", formatPairs(operator, columnName));
		return this;
	}

	public QueryBuilder or(String columnName) {
		return or(columnName, defaultOperator);
	}

	public QueryBuilder or(String columnName, String operator) {
		this.queryWhere += String.format(" OR %s", formatPairs(operator, columnName));
		return this;
	}

	public String build() {
		return StringUtils.isNullOrEmpty(queryWhere) ? queryStart : String.format("%s %s", queryStart, queryWhere);
	}
}

package xyz.minecrossing.backend.database.helpers;

public class ParamSpecification<T> {
	private String colName;
	private T colValue;

	public ParamSpecification(String colName, T colValue) {
		this.colName = colName;
		this.colValue = colValue;
	}

	public String getColName() {
		return colName;
	}

	public void setColName(String colName) {
		this.colName = colName;
	}

	public T getColValue() {
		return colValue;
	}

	public void setColValue(T colValue) {
		this.colValue = colValue;
	}
}

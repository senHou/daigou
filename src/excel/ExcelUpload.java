package excel;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import utils.DateUtils;
import utils.StringUtil;

public abstract class ExcelUpload {
	protected List<String> columns;
	protected String errorMessage;
	protected List<Map<String, String>> rowValueList;
	private ExcelFileParser parser;
	private File targetFile;

	public ExcelUpload(File targetFile) {
		columns = new ArrayList<String>();
		this.targetFile = targetFile;
		rowValueList = new ArrayList<Map<String, String>>();
	}

	public abstract void defineColumns();

	public List<String> getColumns() {
		return columns;
	}

	public void setColumns(List<String> columns) {
		this.columns = columns;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public List<Map<String, String>> getRowValueList() {
		return rowValueList;
	}

	public void setRowValueList(List<Map<String, String>> rowValueList) {
		this.rowValueList = rowValueList;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public abstract List convertRowListToObjectList();

	public List upload(int sheetIdx, int startRow) throws Exception {
		defineColumns();
		parser = new ExcelFileParser(columns);
		parser.readSpreadsheetRows(targetFile, sheetIdx, startRow, rowValueList);
		return convertRowListToObjectList();

	}

	public abstract boolean validRowData(Map<String, String> rowData);

	public void convertStringToInt(String value, String columnName, String rowNumber) {
		try {
			Integer.parseInt(value);
		} catch (Exception e) {
			setErrorMessage(columnName + " at row " + rowNumber + " can only be integer.");
		}
	}

	public void convertStringToDate(String value, String columnName, String rowNumber) {
		Date date = DateUtils.parseStringToDate(value, "yyyy-MM-dd");
		if (date == null) {
			setErrorMessage(columnName + " at row " + rowNumber + " can only be the format : yyyy-MM-dd.");
		}

	}

}

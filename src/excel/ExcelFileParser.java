package excel;

import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import utils.StringUtil;

public class ExcelFileParser {

	private List<String> columns;

	public ExcelFileParser(List<String> columns) {
		this.columns = columns;
	}

	public Sheet openSheetFromFile(File targetFile, int sheetIdx) throws Exception {
		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(new FileInputStream(targetFile));
		} catch (Exception e) {
			throw e;
		}
		Sheet sheet = wb.getSheetAt(sheetIdx);
		return sheet;
	}

	public List<Map<String, String>> readSpreadsheetRows(File targetFile, int sheetIdx, int startRow,List<Map<String, String>> rowValueList) throws Exception {
		
		Sheet sheet = openSheetFromFile(targetFile, sheetIdx);
		Row row = null;
		Iterator<Row> rowIterator = sheet.iterator();
		 while (rowIterator.hasNext())  {
			
			 row = rowIterator.next();
			 Map<String,String> rowValue = parseSpreadsheetRow(row);
			 rowValueList.add(rowValue);
		}
		
		return rowValueList;
	}

	private Map<String, String> parseSpreadsheetRow(Row row) throws Exception {
		Map<String, String> rowValue = new HashMap<String, String>();

		for (int i = 0; i < columns.size(); i++) {
			Cell theCell = null;
			theCell = row.getCell(i);
			rowValue.put(columns.get(i), parseSpreadsheetCellAsString(theCell, ""));
		}
		rowValue.put("rowNumber", String.valueOf(row.getRowNum()+1));
		return rowValue;
	}

	private String parseSpreadsheetCellAsString(Cell theCell, String defaultValue) throws Exception {
		String theText = null;
		if (theCell != null) {
			theText = getStringCellValue(theCell);
		}

		if (StringUtil.isEmpty(theText)) {
			theText = defaultValue;
		}

		return theText;
	}

	public static String getStringCellValue(Cell cell) throws Exception {
		if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			double theDoubleValue = cell.getNumericCellValue();
			String tempString = Double.toString(theDoubleValue);
			if (tempString.endsWith(".0")) {
				tempString = tempString.substring(0, tempString.length() - 2);
			} else if (tempString.indexOf("E") >= 0) {
				tempString = new DecimalFormat("####################.#").format(theDoubleValue);
				if (tempString.endsWith(".0")) {
					tempString = tempString.substring(0, tempString.length() - 2);
				}
			}
			return tempString;
		}

		return cell.getStringCellValue();
	}
}

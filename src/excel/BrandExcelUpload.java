package excel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import po.Brand;
import utils.StringUtil;

public class BrandExcelUpload extends ExcelUpload {

	public BrandExcelUpload(File targetFile) {
		super(targetFile);
	}

	@Override
	public void defineColumns() {
		columns.add("name");
	}

	@Override
	public Object convertRowListToObjectList() {
		List<Object> lists = new ArrayList<Object>();
		for (int i = 0; i < rowValueList.size(); i++) {
			Map<String, String> rowMap = rowValueList.get(i);
			if (validRowData(rowMap) == false) {
				continue;
			}
			Brand brand = new Brand();
			brand.setName(rowMap.get("name"));
			lists.add(brand);
		}
		return lists;
	}

	@Override
	public boolean validRowData(Map<String, String> rowData) {
		String name = rowData.get("name");
		if (StringUtil.isEmpty(name)) {
			setErrorMessage("Brand name is missing at row "+rowData.get("rowNumber")+".");
			rowData.put("ErrorMessage", getErrorMessage());
			return false;
		}
		return true;
	}
}

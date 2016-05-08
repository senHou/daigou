package excel;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import po.Customer;
import utils.StringUtil;

public class CustomerExcelUpload extends ExcelUpload {

	public CustomerExcelUpload(File targetFile) {
		super(targetFile);
	}

	public void defineColumns() {
		columns.add("id");
		columns.add("name");
	}
	
	public  List<Object> convertRowListToObjectList(){
		List<Object> lists = new ArrayList<Object>();
		for (int i = 0; i < rowValueList.size(); i++) {
			Map<String, String> rowMap = rowValueList.get(i);
			if (validRowData(rowMap) == false) {
				continue;
			}
			Customer obj = new Customer();
			
			Field[] fields = obj.getClass().getDeclaredFields();
			for (int j = 0; j < fields.length; j++) {
				
				try {
					if (fields[j].getType() == String.class) {
						Method method = obj.getClass().getDeclaredMethod(
								"set" + StringUtil.uppercaseFirstCharacter(fields[j].getName()), fields[j].getType());
						method.invoke(obj, rowMap.get(fields[j].getName()));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			lists.add(obj);
		}
		return lists;
	}

	@Override
	public boolean validRowData(Map<String, String> rowData) {	
		String id = rowData.get("id");
		String name = rowData.get("name");
		boolean noError = true;
		if (StringUtil.isEmpty(id)) {
			setErrorMessage("Customer id is missing at row "+rowData.get("rowNumber")+".");
			noError = false;
		}
		
		if (StringUtil.isEmpty(name)) {
			setErrorMessage("Customer name is missing at row "+rowData.get("rowNumber")+".");
			noError = false;
		}
		
		rowData.put("ErrorMessage", getErrorMessage());
		
		return noError;
	}
}

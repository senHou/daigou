package excel;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import po.WeekOrderDetail;
import utils.DateUtils;
import utils.StringUtil;

public class WeekOrderDetailExcelUpload extends ExcelUpload {

	public WeekOrderDetailExcelUpload(File targetFile) {
		super(targetFile);

	}

	@Override
	public void defineColumns() {
		Class<WeekOrderDetail> clazz = WeekOrderDetail.class;

		Field[] fields = clazz.getDeclaredFields();

		for (Field field : fields) {
			columns.add(field.getName());
		}
	}

	@Override
	public List<Object> convertRowListToObjectList() {
		List<Object> lists = new ArrayList<Object>();
		for (int i = 0; i < rowValueList.size(); i++) {
			Map<String, String> rowMap = rowValueList.get(i);
			if (validRowData(rowMap) == false) {
				continue;
			}
			WeekOrderDetail obj = new WeekOrderDetail();
			
			Field[] fields = obj.getClass().getDeclaredFields();
			for (int j = 0; j < fields.length; j++) {
				
				try {
					Method method = obj.getClass().getDeclaredMethod(
							"set" + StringUtil.uppercaseFirstCharacter(fields[j].getName()), fields[j].getType());
					
					if (fields[j].getType().isAssignableFrom(int.class)) {
						method.invoke(obj, Integer.parseInt(rowMap.get(fields[j].getName())));
					}else if (fields[j].getType().isAssignableFrom(Date.class)){
						method.invoke(obj, DateUtils.parseStringToDate(rowMap.get(fields[j].getName()),"yyyy-MM-dddd"));
					}else{
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
		
		Field[] fields = WeekOrderDetail.class.getDeclaredFields();

		for (Field field : fields) {
			if (StringUtil.isEmpty(rowData.get(field.getName()))) {
				setErrorMessage(field.getName()+" is missing at row "+rowData.get("rowNumber")+".");
				
			}else {
				if (field.getType().isAssignableFrom(int.class)) {
					convertStringToInt(rowData.get(field.getName()),field.getName(),rowData.get("rowNumber"));
				}else if (field.getType().isAssignableFrom(Date.class)) {
					convertStringToDate(rowData.get(field.getName()),field.getName(),rowData.get("rowNumber"));
				}
			}	
		}
		rowData.put("errorMessage", getErrorMessage());

		if (rowData.get(errorMessage) == null) {
			return false;
		} else {
			return true;
		}
	}
}

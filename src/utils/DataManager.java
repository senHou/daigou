package utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataManager {
	
	private static DataManager  instance = null;
	private  Map<String, List> dataMap = new HashMap<String, List>(); 
	private DataManager(){}
	
	public static DataManager getInstance(){
		if (instance == null) {
			instance = new DataManager();
		}
		
		return instance;
	}

	public  Map<String, List> getDataMap() {
		return dataMap;
	}
	
	public  void setDataMap(Map<String, List> dataMap) {
		this.dataMap = dataMap;
	}
	
	
	public void updateData(String type, List list) {
		dataMap.put(type, list);
	}
	
}

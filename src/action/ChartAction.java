package action;

import java.util.Date;
import java.util.List;

import org.jfree.chart.JFreeChart;

import com.opensymphony.xwork2.ActionSupport;

import factory.DaoFactory;
import service.ShippingService;
import utils.ChartGenerator;
import utils.DateUtils;

public class ChartAction extends ActionSupport{
	
	private JFreeChart chart;

	
	public String drawChart(){
		
		ShippingService service = new ShippingService(DaoFactory.SHIPPING);
		List<Date> mondayDate = DateUtils.getPreviousMondayDate(5);
		List<Date> sundayDate = DateUtils.getPreviousSundayDate(5);
		double[][] data = service.getShippingAmountByWeek(mondayDate, sundayDate, 5);
		String[] columnKeys = new String[mondayDate.size()];
		for (int i = 0; i < mondayDate.size(); i++) {
			columnKeys[i] =  DateUtils.parseDateToString(mondayDate.get(i), "yyyy/MM/dd") + "-"
					+ DateUtils.parseDateToString(sundayDate.get(i), "yyyy/MM/dd");
		}
		chart = ChartGenerator.createChart(data, "Weekly Salses", "Weekly Salses", "", "Sales",new String[]{"Week Sales"},columnKeys);
		chart.setBorderVisible(false);
		
		return SUCCESS;
	}
	
	
	public void drawWeekSalesPicture(){
		
	}
	
	public JFreeChart getChart() {
		return chart;
	}
	
	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}
	
}

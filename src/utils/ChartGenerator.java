package utils;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.io.File;
import java.util.Date;
import java.util.List;

import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;

public class ChartGenerator {

	public static JFreeChart createChart(double[][] data, String chartName, String CategoryName,
			String CategoryAxisName, String numberAxisName, String[] rowKey, String[] columnsKey) {
		JFreeChart chart = null;
		BarRenderer renderer = null;
		CategoryPlot plot = null;
		CategoryDataset dataset = DatasetUtilities.createCategoryDataset(rowKey, columnsKey, data);
		CategoryAxis categoryAxis = new CategoryAxis(CategoryAxisName);
		categoryAxis.setMaximumCategoryLabelLines(2);
		ValueAxis valueAxis = new NumberAxis(numberAxisName);

		renderer = new BarRenderer3D();

		plot = new CategoryPlot(dataset, categoryAxis, valueAxis, renderer);
		plot.setOrientation(PlotOrientation.VERTICAL);
		Paint p1 = new GradientPaint(0.0f, 0.0f, Color.red, 0.0f, 0.0f, Color.red);

		renderer.setSeriesPaint(0, p1);


		plot.setRenderer(renderer);
		chart = new JFreeChart(chartName, JFreeChart.DEFAULT_TITLE_FONT, plot, true);

		chart.setBackgroundPaint(new Color(255, 255, 255));

		// try {
		// final ChartRenderingInfo info = new ChartRenderingInfo(new
		// StandardEntityCollection());
		// final File file1 = new File("barchart.png");
		// ChartUtilities.saveChartAsPNG(file1, chart, 600, 400, info);
		// } catch (Exception e) {
		//
		// }

		return chart;
	}

	public static void main(String[] args) {
		double[][] data = new double[][] { { 210, 300, 320, 265, 299 } };
		List<Date> mondayDate = DateUtils.getPreviousMondayDate(5);
		List<Date> sundayDate = DateUtils.getPreviousSundayDate(5);

		String[] columnKeys = new String[mondayDate.size()];
		for (int i = 0; i < mondayDate.size(); i++) {
			columnKeys[i] = DateUtils.parseDateToString(mondayDate.get(i), "yyyy/MM/dd") + "-"
					+ DateUtils.parseDateToString(sundayDate.get(i), "yyyy/MM/dd");

			System.out.println(columnKeys[i]);
		}
		ChartGenerator.createChart(data, "Weekly Salses", "Weekly Salses", "", "Sales", new String[] { "Week Sales" },
				columnKeys);
	}
}

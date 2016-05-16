package utils;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.io.File;

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
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;

public class ChartGenerator {

	final static double[][] data = new double[][] { { 210, 300, 320, 265, 299 }, { 200, 304, 201, 201, 340 } };

	final static CategoryDataset dataset = DatasetUtilities.createCategoryDataset("Team ", "", data);

	public static void createChart() {
		JFreeChart chart = null;
		BarRenderer renderer = null;
		CategoryPlot plot = null;

		final CategoryAxis categoryAxis = new CategoryAxis("Week No.");
		final ValueAxis valueAxis = new NumberAxis("Sales");

		renderer = new BarRenderer();

		plot = new CategoryPlot(dataset, categoryAxis, valueAxis, renderer);
		plot.setOrientation(PlotOrientation.VERTICAL);
		chart = new JFreeChart("Srore Bord", JFreeChart.DEFAULT_TITLE_FONT, plot, true);

		chart.setBackgroundPaint(new Color(249, 231, 236));

		Paint p1 = new GradientPaint(0.0f, 0.0f, new Color(16, 89, 172), 0.0f, 0.0f, new Color(201, 201, 244));

		renderer.setSeriesPaint(1, p1);

		Paint p2 = new GradientPaint(0.0f, 0.0f, new Color(255, 35, 35), 0.0f, 0.0f, new Color(255, 180, 180));

		renderer.setSeriesPaint(2, p2);

		plot.setRenderer(renderer);

		try {
			final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
			final File file1 = new File("barchart.png");
			ChartUtilities.saveChartAsPNG(file1, chart, 600, 400, info);
		} catch (Exception e){

		}
	}
	
	public static void main(String[] args) {
		ChartGenerator.createChart();
	}
}

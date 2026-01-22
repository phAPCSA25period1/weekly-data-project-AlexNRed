import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;
import java.awt.*;

public class GraphPanel extends JPanel {
    public GraphPanel(WeeklyData weeklyData) {
        JFreeChart chart = createChart(createDataset(weeklyData));
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        add(chartPanel);
    }

    private CategoryDataset createDataset(WeeklyData weeklyData) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Week week : weeklyData.getWeeks()) {
            dataset.addValue(week.getData(), "Data", "Week " + week.getWeekNumber());
        }
        return dataset;
    }

    private JFreeChart createChart(CategoryDataset dataset) {
        return ChartFactory.createBarChart(
            "Weekly Data Chart",
            "Week",
            "Data",
            dataset
        );
    }
}
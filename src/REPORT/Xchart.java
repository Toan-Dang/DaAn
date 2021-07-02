package REPORT;

import Data.CoSoDuLieu;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.colors.XChartSeriesColors;
import org.knowm.xchart.style.lines.SeriesLines;
import org.knowm.xchart.style.markers.SeriesMarkers;

import java.awt.*;
import java.sql.SQLException;
import java.util.List;
import java.util.*;

public class Xchart {

    public   Xchart() throws SQLException, ClassNotFoundException {
        List<Date> xData = new ArrayList<>();
        List<Long> yData = new ArrayList<>();
        for (Map.Entry<Date, Long> entry : CoSoDuLieu.getNgay_DoanhThu().entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
            xData.add(entry.getKey());
            yData.add(entry.getValue());

        }
        Long max = Collections.max(yData);
        List<XYChart> charts = new ArrayList<>();

        XYChart chart = new XYChartBuilder().xAxisTitle("Ngày").yAxisTitle("Tiền").title("Doanh Thu Khách Sạn").width(600).height(400).build();
      //  chart.getStyler().setChartBackgroundColor(Color.WHITE); set background all frame
        chart.getStyler().setLegendBackgroundColor(Color.PINK); // mau o chu thich
        //chart.getStyler().setPlotBackgroundColor(ChartColor.getAWTColor(ChartColor.GREY)); set background color chart
        //chart.getStyler().setChartFontColor(Color.MAGENTA); set mau chu
        chart.getStyler().setDatePattern("dd-MM-YYYY");
        chart.getStyler().setDecimalPattern("#0");
        chart.getStyler().setLocale(Locale.GERMAN);
        chart.getStyler().setChartTitleFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
        chart.getStyler().setLegendFont(new Font(Font.SERIF, Font.PLAIN, 18));
       // chart.getStyler().setChartTitleBoxVisible(true);
        chart.getStyler().setLegendSeriesLineLength(12);
        chart.getStyler().setAxisTitleFont(new Font(Font.SANS_SERIF, Font.ITALIC, 18));
        chart.getStyler().setAxisTickLabelsFont(new Font(Font.SERIF, Font.PLAIN, 11));
        chart.getStyler().setYAxisMin(-10.0);
        chart.getStyler().setYAxisMax(Double.valueOf(max));

        // chart.getStyler().setAxisTickPadding(20);
        // chart.getStyler().setAxisTickMarkLength(15);
        //  chart.getStyler().setPlotMargin(20);
        // chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideSE);set chu thich o trong bieu do

        XYSeries series = chart.addSeries("Doanh So", xData, yData);
        series.setMarker(SeriesMarkers.NONE);
        charts.add(chart);
        series.setLineColor(XChartSeriesColors.BLUE);
        series.setMarkerColor(Color.BLACK);
        series.setMarker(SeriesMarkers.CIRCLE);
        series.setLineStyle(SeriesLines.SOLID);

        new SwingWrapper<>(charts).displayChartMatrix();
    }


}

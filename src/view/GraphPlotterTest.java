package view;

import model.CustomPoint;
import view.PlotterPane;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class GraphPlotterTest {

    @Test
    public void createDiagramWithInitialDataPoints() {
        ArrayList<CustomPoint> points = new ArrayList<>();
        points.add(new CustomPoint(10, 23.0));
        points.add(new CustomPoint(20, 13.0));
        points.add(new CustomPoint(22, 9.0));

        new PlotterPane(points,
                800,
                600,
                true,
                "time in seconds",
                "throughput",
                "throughput / time");

        //is not needed. Just to see the result.
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addPoints() {
        ArrayList<CustomPoint> points = new ArrayList<>();

        PlotterPane plotterPane = new PlotterPane(points,
                800,
                600,
                true,
                "time in seconds",
                "throughput",
                "throughput / time");
        try {
            plotterPane.addPoint(new CustomPoint(10, 12.5));
            Thread.sleep(1000);
            plotterPane.addPoint(new CustomPoint(20, 22.0));
            Thread.sleep(1000);
            plotterPane.addPoint(new CustomPoint(30, 25.6));
            Thread.sleep(1000);
            plotterPane.addPoint(new CustomPoint(35, 12.5));
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void combinedSolution() {
        ArrayList<CustomPoint> points = new ArrayList<>();
        points.add(new CustomPoint(10, 23.0));
        points.add(new CustomPoint(20, 13.0));
        points.add(new CustomPoint(22, 9.0));

        PlotterPane plotterPane = new PlotterPane(points,
                800,
                600,
                true,
                "time in seconds",
                "throughput",
                "throughput / time");
        try {
            plotterPane.addPoint(new CustomPoint(10, 12.5));
            Thread.sleep(1000);
            plotterPane.addPoint(new CustomPoint(20, 22.0));
            Thread.sleep(1000);
            plotterPane.addPoint(new CustomPoint(30, 25.6));
            Thread.sleep(1000);
            plotterPane.addPoint(new CustomPoint(35, 12.5));
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

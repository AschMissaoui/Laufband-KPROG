package io;

import model.CustomPoint;
import model.TheObject;
import view.PlotterPane;
import java.util.ArrayList;

/**
 * A class for printing statistics
 * 
 * @author Jaeger, Schmidt , edited by : Team 15
 * @version 2018-11-28
 */
public class Statistics {

	private static String buffer;


	/**
	 * appends the given String to the buffer
	 *
	 * @param message the message to append
	 */
	public static void update(String message) {

		buffer = buffer + message + "\n";
	}

	/**
	 * writes the given String to console
	 *
	 * @param message the message to write to console
	 */
	public static void show(String message) {

		System.out.println(message);
	}

	/**
	 * draws the PlotterPane
	 */
	public static void drawStats() {
		ArrayList<CustomPoint> points = new ArrayList<>();
		int lastX = 0;
		// creates a new PlotterPane
		PlotterPane plotterPane = new PlotterPane(points,
				500,
				400,
				false,
				"time in seconds",
				"number of hammers",
				"hammers / second");
		updateGraph(plotterPane , lastX) ;
	}

	/**
	 * updates graph by drawing a new point
	 * @param p
	 * @param x
	 */
	public static void updateGraph(PlotterPane p, int x){
		try {
			p.addPoint(new CustomPoint(x, TheObject.numHammers));
			Thread.sleep(500);
			x = x + 10 ;
			updateGraph(p , x);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

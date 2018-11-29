package controller;

import view.SimulationView;
import io.Factory;
import io.Statistics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;
import model.Actor;

import static java.lang.Thread.sleep;


/**
 * The main class, controls the flow of the simulation
 * 
 * @author Jaeger, Schmidt , edited by : Team 15
 * @version 2018-11-28
 */
public class Simulation {
	
	/** is the simulation running*/
	public static boolean isRunning = false;  
	
	/** a speed factor for the clock to vary the speed of the clock in a simple way*/
	public static int SPEEDFACTOR = 1;
	
	/**the beat or speed of the clock, e.g. 300 means one beat every 300 milli seconds*/
	public static final int CLOCKBEAT = 100 * SPEEDFACTOR;
	
	/**the global clock */
	//the clock must be thread safe -> AtomicLong. The primitive type long isn't, even if synchronized
	private static AtomicLong clock = new AtomicLong(0); 
	
	
	/**
	 * starts the simulation
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		//use user input to choose a scenario
		ChooseScenario();
		//a new simulation
		Simulation theSimulation = new Simulation();
		theSimulation.init();
		Statistics.drawStats();

		
	}
	
	/**
	 * initialize the simulation
	 * 
	 */
	private void init(){

		//create all stations and objects for the starting scenario out of XML
		Factory.createStartScenario();

		//the view of our simulation
		new SimulationView();
					
		// set up the the heartbeat (clock) of the simulation
		new HeartBeat().start();
		 		
		Statistics.show("---- Simulation gestartet ---\n");
				
		// start all the actor threads
		for (Actor actor : Actor.getAllActors()) {
			actor.start();		
						
		}
		
		/*
		 * Hinweis: wenn nicht über den Startbutton gestartet werden soll oder die Simulation ohne View laufen soll,
		 * den auskommentierten Code unten verwenden 
		 */
				
		/*
		//Zeitpuffer vor Start -> sonst läuft der letzte manchmal nicht los
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		//wake up the start station -> lets the simulation run
		StartStation.getStartStation().wakeUp();
		
		*/
		
	}

	/**
	 * new method by Team 15
	 */
	private static void ChooseScenario(){
		//choosing a scenario
		System.out.println("Please choose a scenario:");
		System.out.println("Options : 1 || 2 || 3");

		Scanner reader = new Scanner(System.in);  // Reading from System.in
		String n = reader.next(); // Scans the next token of the input as a String.


		try {
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}



		if (!n.equals("1") && !n.equals("2") && !n.equals("3")) {
			System.out.println("not found... try again");
			ChooseScenario();

	} else
		Factory.CHOSEN_SCENARIO ="Szenario " +  n ;
		System.out.println("Chosen : " + Factory.CHOSEN_SCENARIO);
		reader.close();
	}
			
	
	/**
	 * The heartbeat (the pulse) of the simulation, controls the clock.
	 * 
	 */
	private class HeartBeat extends Thread {
		
		@Override
		public void run() {
			
			while(true){
				
				try {
				
					sleep(CLOCKBEAT);
					
					//Increase the global clock
					clock.incrementAndGet();
					
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	
	/** Get the global time
	 * 
	 * @return the global time
	 */
	public static long getGlobalTime() {
		return clock.get();
	}
	
}

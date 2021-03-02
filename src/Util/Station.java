package Util;

import java.io.*;
import java.util.*;

import CargoTrain.Train;

public class Station{
	
	private int id;
	private Queue<Cargo> cargoQueue = new LinkedList<Cargo>();
	private PrintStream printStream;
	
	
	public Station(int id, PrintStream printStream) {
		
		this.id = id;
		this.printStream = printStream;
	
	}
	
	public void process(Train train) 
			throws FileNotFoundException{
		
		train.unload(cargoQueue);
		
		Queue<Cargo> cargoRemained = new LinkedList<Cargo>();
		
		while(!cargoQueue.isEmpty()) {
			Cargo current = cargoQueue.poll();
			if(current.targetStation == id) {
				printStream.println(current.toString());
			}
			else {
				cargoRemained.add(current);
			}
		}
	
		train.load(cargoRemained);
		
		printStream.println(id + " " + train.getLength());
		
	}

	public Queue<Cargo> getCargoQueue() {
		
		return cargoQueue;
	
	}
	
}
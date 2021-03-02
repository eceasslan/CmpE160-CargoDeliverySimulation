package Main;

import java.io.*;
import java.util.*;

import CargoTrain.Train;
import Util.Cargo;
import Util.Station;

public class Main{

	public static void main(String[] args) 
			throws FileNotFoundException {
	
		Scanner input = new Scanner(new File(args[0]));
		
		PrintStream printStream = new PrintStream(new File(args[1]));
				
		ArrayList<Station> stations = new ArrayList<Station>();
		
		Train train = readAndInitialize(input, stations, printStream);
		
		execute(stations, train);
		
	}
	
	public static Train readAndInitialize(Scanner file, ArrayList<Station> stations, PrintStream printStream) {
		
		int length = file.nextInt();
		int carCapacity = file.nextInt();
		int stationNumber = file.nextInt();
		
		file.nextLine();
		
		for(int i=0; i<stationNumber; i++) {
			Station station = new Station(i, printStream);
			stations.add(station);
		}
		
		while(file.hasNextLine() && file.hasNext()) {
			int id = file.nextInt();
			int loadingStation = file.nextInt();
			Cargo cargo = new Cargo(id, loadingStation, file.nextInt(), file.nextInt());
			stations.get(loadingStation).getCargoQueue().add(cargo);
		}
		
		return new Train(length, carCapacity);
		
	}
	
	public static void execute(ArrayList<Station> stations, Train train) 
			throws FileNotFoundException {
		
		for(int i=0; i<stations.size(); i++) {
			stations.get(i).process(train);
		}
		
	}
	
}
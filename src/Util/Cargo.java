package Util;

public class Cargo{
	
	private int id;
	private int loadingStation;
	int targetStation;
	private int size;
	
	public Cargo(int id, int loadingStation, int targetStation, int size) {
		
		this.id = id;
		this.loadingStation = loadingStation;
		this.targetStation = targetStation;
		this.size = size;
		
	}
	
	public String toString() {
		
		return id + " " + loadingStation + " " + targetStation + " " + size;
	
	}

	public int getSize() {
	
		return size;
	
	}
	
}
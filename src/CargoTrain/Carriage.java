package CargoTrain;

import java.util.Stack;

import Util.Cargo;

public class Carriage{
	
	int capacity;
	int emptySlot;
	Stack<Cargo> cargos = new Stack<Cargo>();
	Carriage prev;
	Carriage next;
	
	public Carriage(int capacity) {
		
		this.capacity = capacity;
		emptySlot = capacity;
		prev = null;
		next = null;
		
	}
	
	public boolean isFull() {
		
		return emptySlot == 0;
	
	}
	
	public void push(Cargo cargo) {
	
		emptySlot = emptySlot - cargo.getSize();
		cargos.push(cargo);
	
	}
	
	public Cargo pop(){
	
		emptySlot = emptySlot + cargos.peek().getSize();
		return cargos.pop();
	
	}
	
}
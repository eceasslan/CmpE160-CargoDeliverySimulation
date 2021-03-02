package CargoTrain;

import java.util.Queue;

import Util.Cargo;

public class Train{
	
	private int length;
	private int carCapacity;
	private Carriage head;
	private Carriage tail;
	
	public Train(int length, int carCapacity){
		
		this.length = length;
		this.carCapacity = carCapacity;
		head = new Carriage(carCapacity);
		
		Carriage current = head;
		
		for(int i=0; i<(length-1); i++) {
			Carriage newCarriage = new Carriage(carCapacity);
			current.next = newCarriage;
			newCarriage.prev = current;
			current = newCarriage;
		}
		
		tail = current;
	
	}
	
	public void load(Queue<Cargo> cargos) {
		
		while(!cargos.isEmpty()) {
			
			Cargo current = cargos.poll();
			Carriage pointer = head;
			boolean isLoaded = false;
			
			for(int i=0; i<length; i++) {
				if(pointer.emptySlot >= current.getSize()) {
					pointer.push(current);
					isLoaded = true;
					break;
				}
				pointer = pointer.next;
			}
			
			if(!isLoaded) {
				Carriage newCarriage = new Carriage(carCapacity);
				if(length == 0) {
					head = newCarriage;
					tail = newCarriage;
				}
				else {
					tail.next = newCarriage;
					newCarriage.prev = tail;
					tail = newCarriage;
				}
				tail.push(current);
				length++;
			}
			
		}
		
		Carriage current = head;
		
		for(int i=0; i<length; i++) {
			if(current.capacity == current.emptySlot) {
				if(current == head) {
					head = null;
					tail = null;
				}
				else {
					tail = current.prev;
					tail.next = null;
				}	
				length = i;
				break;
			}
			current = current.next;
		}
		
	}
	
	public void unload(Queue<Cargo> cargos) {
		
		Carriage current = head;
		
		while(current != null) {
			while(!current.cargos.empty()) {
				cargos.add(current.pop());
			}
			current = current.next;
		}
		
	}

	public int getLength() {
		
		return length;
	
	}
	
}
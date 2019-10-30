package trabajo;


import java.util.LinkedList;
import java.util.List;

public abstract class Trabajo implements Runnable, Observable{

	protected List<Runnable> trabajos = new LinkedList<>();
	private List<Observer> observers = new LinkedList<>();
	
	public void addTrabajo(Runnable r) {
		this.trabajos.add(r);
	}

	public abstract void run();

	@Override
	public void addObserver(Observer o) {
		this.observers.add(o);
		
	}

	@Override
	public void removeObserver(Observer o) {
		this.observers.remove(o);
		
	}

	@Override
	public void notifyObservers(String state) {
		for(Observer o: observers) {
			o.update(this, state);
		}
		
	}
	

}

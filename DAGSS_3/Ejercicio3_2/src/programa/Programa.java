package programa;

import java.util.LinkedList;
import java.util.List;

import observer.Observer;
import trabajo.Observable;

public abstract class Programa implements Observable{

	protected List<Observer> observers = new LinkedList<>();
	
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
		for (Observer o : observers) {
			o.update(this, state);
		}
	}
	
}

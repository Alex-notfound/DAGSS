package trabajo;

import java.util.LinkedList;
import java.util.List;

import observer.Observer;

public abstract class Trabajo implements Runnable, Observable {

	protected List<Runnable> trabajos = new LinkedList<>();
	protected List<Observer> observers = new LinkedList<>();
	
	public List<Runnable> getTrabajos() {
		return trabajos;
	}

	public void setTrabajos(List<Runnable> trabajos) {
		this.trabajos = trabajos;
	}

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
		for (Observer o : observers) {
			o.update(this, state);
		}
	}

}

package ds.framework;

import java.util.LinkedList;
import java.util.List;

public abstract class Operation implements Observable {

	private String name;
	private List<String> parameters;
	private List<Observer> observers = new LinkedList<>();

	public Operation(String name, List<String> parameters) {
		this.name = name;
		this.parameters = parameters;
	}

	// TODO: Implementar execute (Patron Command)
	public abstract String execute(List<String> paramValues);

	public String getName() {
		// TODO: Devolver nombre operacion
		return this.name;
	}

	public List<String> getParameterNames() {
		// TODO: Devolver lista con los parametros de la operacion
		return parameters;
	}

	@Override
	public void addObserver(Observer o) {
		this.observers.add(o);
	}

	@Override
	public void notifyObservers(String state) {
		for (Observer o : this.observers) {
			o.update(this, state);
		}
	}

}

package ds.framework;

import java.util.List;
import java.util.Observable;

public abstract class Operation extends Observable {
	// TODO Implementar patron Observer.

	private String name;
	private List<String> parameters;

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

}

package ds.calculator;

import java.util.LinkedList;
import java.util.List;

import ds.framework.Operation;

public class Raiz extends Operation {

	private static final List<String> PARAMETERS = new LinkedList<>();

	static {
		PARAMETERS.add("Radicando");
	}

	public Raiz() {
		super("Raiz", PARAMETERS);
	}

	@Override
	public String exectute(List<String> paramValues) {
		return String.valueOf(Math.sqrt(Double.parseDouble(paramValues.get(0))));
	}
}

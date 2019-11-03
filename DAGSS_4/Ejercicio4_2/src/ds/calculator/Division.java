package ds.calculator;

import java.util.LinkedList;
import java.util.List;

import ds.framework.Operation;

public class Division extends Operation {

	private static final List<String> PARAMETERS = new LinkedList<>();

	static {
		PARAMETERS.add("Dividendo");
		PARAMETERS.add("Divisor");
	}

	public Division() {
		super("Division", PARAMETERS);
	}

	@Override
	public String execute(List<String> paramValues) {
		return String.valueOf(Integer.parseInt(paramValues.get(0)) / Integer.parseInt(paramValues.get(1)));
	}

}

package ds.calculator;

import java.util.LinkedList;
import java.util.List;

import ds.framework.Operation;

public class Suma extends Operation {

	private static final List<String> PARAMETERS = new LinkedList<>();

	static {
		PARAMETERS.add("Sumando A");
		PARAMETERS.add("Sumando B");
	}

	public Suma() {
		super("Suma", PARAMETERS);
	}

	@Override
	public String execute(List<String> paramValues) {
		int result = 0;

		for (int i = 0; i < paramValues.size(); i++) {
			result += Integer.parseInt(paramValues.get(i));
		}

		return String.valueOf(result);
	}

}

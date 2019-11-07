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
		int result = 0;
		String toret = null;
		
		// Somos conscientes de que la suma se podia hacer en un linea
		try {	
			Thread.sleep(250);
			this.notifyObservers("50%");
			result = Integer.parseInt(paramValues.get(0)) / Integer.parseInt(paramValues.get(1));
			Thread.sleep(250);
			this.notifyObservers("100%");
			toret = String.valueOf(result);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return toret;
	}

}

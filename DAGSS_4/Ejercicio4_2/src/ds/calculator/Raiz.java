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
	public String execute(List<String> paramValues) {
		double num = 0;
		String toret = null;
		try {
			Thread.sleep(250);
			this.notifyObservers("50%");
			num = Double.parseDouble(paramValues.get(0));
			Thread.sleep(250);
			this.notifyObservers("100%");
			toret = String.valueOf(Math.sqrt(num));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return toret;
	}
}

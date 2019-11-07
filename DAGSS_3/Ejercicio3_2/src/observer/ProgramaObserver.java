package observer;

import trabajo.Observable;

public class ProgramaObserver implements Observer {

	private int numProgramas = 0;

	@Override
	public synchronized void update(Observable o, String state) {
		if (state.equalsIgnoreCase("Start")) {
			numProgramas++;
			System.out.println("Creado un programa. Actualmente hay " + numProgramas + " en curso.");
		} else {
			numProgramas--;
			System.out.println("Acabado un programa. Actualmente hay " + numProgramas + " en curso.");
		}

	}
}

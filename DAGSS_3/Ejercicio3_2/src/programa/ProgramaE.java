package programa;

public class ProgramaE extends Programa implements Runnable {
	public void run() {

		try {
			super.notifyObservers("Start");
			System.out.println("[INICIO] ProgramaE");
			Thread.sleep(10);
			System.out.println("[FIN] ProgramaE");
			super.notifyObservers("Finish");

		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

	}

}
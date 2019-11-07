package programa;

public class ProgramaF extends Programa implements Runnable {
	public void run() {

		try {
			super.notifyObservers("Start");
			System.out.println("[INICIO] ProgramaF");
			Thread.sleep(10);
			super.notifyObservers("Finish");
			System.out.println("[FIN] ProgramaF");

		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

	}

}
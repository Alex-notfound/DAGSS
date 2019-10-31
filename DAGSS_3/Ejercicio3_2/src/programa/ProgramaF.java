package programa;

public class ProgramaF extends Programa implements Runnable {
	public void run() {

		try {
			super.notifyObservers("Start");
			System.out.println("[INICIO] ProgramaF");
			Thread.sleep(10);
			System.out.println("[FIN] ProgramaF");
			super.notifyObservers("Finish");

		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

	}

}
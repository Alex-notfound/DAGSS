package programa;

public class ProgramaB extends Programa implements Runnable {
	public void run() {

		try {
			super.notifyObservers("Start");
			System.out.println("[INICIO] ProgramaB");
			Thread.sleep(10);
			System.out.println("[FIN] ProgramaB");
			super.notifyObservers("Finish");

		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

	}

}
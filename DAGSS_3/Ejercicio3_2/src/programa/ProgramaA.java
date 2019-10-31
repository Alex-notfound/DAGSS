package programa;

public class ProgramaA extends Programa implements Runnable {
	public void run() {

		try {
			super.notifyObservers("Start");
			System.out.println("[INICIO] ProgramaA");
			Thread.sleep(10);
			System.out.println("[FIN] ProgramaA");
			super.notifyObservers("Finish");

		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

	}

}

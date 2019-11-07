package programa;

public class ProgramaB extends Programa implements Runnable {
	public void run() {

		try {
			super.notifyObservers("Start");
			System.out.println("[INICIO] ProgramaB");
			Thread.sleep(20);
			super.notifyObservers("Finish");
			System.out.println("[FIN] ProgramaB");

		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

	}

}
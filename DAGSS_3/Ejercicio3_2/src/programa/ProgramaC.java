package programa;

public class ProgramaC extends Programa implements Runnable {
	public void run() {

		try {
			super.notifyObservers("Start");
			System.out.println("[INICIO] ProgramaC");
			Thread.sleep(10);
			System.out.println("[FIN] ProgramaC");
			super.notifyObservers("Finish");

		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

	}

}
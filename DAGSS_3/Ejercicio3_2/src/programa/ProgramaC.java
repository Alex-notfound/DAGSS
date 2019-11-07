package programa;

public class ProgramaC extends Programa implements Runnable {
	public void run() {

		try {
			super.notifyObservers("Start");
			System.out.println("[INICIO] ProgramaC");
			Thread.sleep(15);
			super.notifyObservers("Finish");
			System.out.println("[FIN] ProgramaC");

		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

	}

}
package programa;

public class ProgramaD extends Programa implements Runnable {
	public void run() {

		try {
			super.notifyObservers("Start");
			System.out.println("[INICIO] ProgramaD");
			Thread.sleep(10);
			System.out.println("[FIN] ProgramaD");
			super.notifyObservers("Finish");

		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

	}

}
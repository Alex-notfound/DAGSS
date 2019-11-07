package programa;

public class ProgramaD extends Programa implements Runnable {
	public void run() {

		try {
			super.notifyObservers("Start");
			System.out.println("[INICIO] ProgramaD");
			Thread.sleep(10);
			super.notifyObservers("Finish");
			System.out.println("[FIN] ProgramaD");

		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

	}

}
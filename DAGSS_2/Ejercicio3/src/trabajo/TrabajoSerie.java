package trabajo;

public class TrabajoSerie extends Trabajo implements Runnable {

	public void run() {
		for (Runnable r : this.trabajos) {
			try {
				Thread miRunnableThread = new Thread(r);
				miRunnableThread.start();
				miRunnableThread.join();
			} catch (InterruptedException e) {
				System.err.println("Interrupted Exception: " + e.getLocalizedMessage());
			}

		}

	}

}

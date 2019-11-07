package trabajo;

public class TrabajoSerie extends Trabajo implements Runnable {

	public void run() {

		Thread miRunnableThread;

		for (Runnable r : this.trabajos) {
			try {
				miRunnableThread = new Thread(r);
				miRunnableThread.start();
				notifyObservers("Start");
				miRunnableThread.join();
				notifyObservers("Finish");
			} catch (InterruptedException e) {
				System.err.println("Interrupted Exception: " + e.getLocalizedMessage());
			}
		}

	}

}

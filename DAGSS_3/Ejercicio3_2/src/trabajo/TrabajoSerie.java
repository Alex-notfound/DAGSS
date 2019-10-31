package trabajo;

import observer.ObservadorTrabajos;

public class TrabajoSerie extends Trabajo implements Runnable {

	public void run() {

		Thread miRunnableThread;
//		ObservadorTrabajos o = new ObservadorTrabajos();
//		addObserver(o);

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

//		removeObserver(o);

	}

}

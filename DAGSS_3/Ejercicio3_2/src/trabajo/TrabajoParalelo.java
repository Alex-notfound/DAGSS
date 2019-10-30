package trabajo;

import java.util.LinkedList;
import java.util.List;

import observer.ObservadorTrabajos;

public class TrabajoParalelo extends Trabajo implements Runnable {

	public void run() {

		List<Thread> threadList = new LinkedList<>();
		ObservadorTrabajos o = new ObservadorTrabajos();
		addObserver(o);

		for (Runnable r : this.trabajos) {
			threadList.add(new Thread(r));
		}

		for (Thread t : threadList) {
			t.start();
			notifyObservers("Start");
		}

		for (Thread t : threadList) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			notifyObservers("Finish");
		}
		removeObserver(o);

	}

}

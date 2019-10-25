package trabajo;

import java.util.LinkedList;
import java.util.List;

public class TrabajoParalelo extends Trabajo implements Runnable {

	public void run() {

		List<Thread> threadList = new LinkedList<>();

		for (Runnable r : this.trabajos) {
			threadList.add(new Thread(r));
		}

		for (Thread t : threadList) {
			t.start();
		}

		for (Thread t : threadList) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

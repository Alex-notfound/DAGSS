package trabajo;

import java.util.ArrayList;
import java.util.List;

public class TrabajoSerie extends Trabajo implements Runnable{
	private List<Runnable> trabajos = new ArrayList<>();
	
	public TrabajoSerie() {}

	@Override
	void addTrabajo(Runnable r) {
		this.trabajos.add(r);
	}
	
	public void run() {
		for(Runnable r: this.trabajos) {
			try {
				Thread miRunnableThread = new Thread(r); 
				miRunnableThread.start();;
				miRunnableThread.join();
			} catch (InterruptedException e) {
				System.err.println("Interrupted Exception: " + e.getLocalizedMessage());
			}

		}

	}
	
	
}

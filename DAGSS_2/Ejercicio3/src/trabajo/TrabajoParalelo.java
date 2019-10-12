package trabajo;

import java.util.ArrayList;
import java.util.List;

public class TrabajoParalelo extends Trabajo implements Runnable{
	private List<Runnable> trabajos = new ArrayList<>();
	
	public TrabajoParalelo() {}

	@Override
	void addTrabajo(Runnable r) {
		this.trabajos.add(r);
	}
	
	public void run() {
		for(Runnable r: this.trabajos) {
			Thread miRunnableThread = new Thread(r); miRunnableThread.setName("Paralelo - " + miRunnableThread.getName()); miRunnableThread.start();
		}

	}
	
	
}

package trabajo;

import java.util.LinkedList;
import java.util.List;

public abstract class Trabajo implements Runnable {

	protected List<Runnable> trabajos = new LinkedList<>();

	public void addTrabajo(Runnable r) {
		this.trabajos.add(r);
	}

	public abstract void run();
}

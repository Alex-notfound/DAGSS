package trabajo;

import java.util.ArrayList;
import java.util.List;

public abstract class Trabajo implements Runnable {

	protected List<Runnable> trabajos = new ArrayList<>();

	public void addTrabajo(Runnable r) {
		this.trabajos.add(r);
	}

	public abstract void run();
}

package trabajo;

public abstract class Trabajo implements Runnable{
	abstract void addTrabajo(Runnable r);
	public abstract void run();
}

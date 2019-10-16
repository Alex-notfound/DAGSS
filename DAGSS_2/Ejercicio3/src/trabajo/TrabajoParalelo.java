package trabajo;

public class TrabajoParalelo extends Trabajo implements Runnable {

	public void run() {
		for (Runnable r : this.trabajos) {
			Thread miRunnableThread = new Thread(r);
			miRunnableThread.setName("Paralelo - " + miRunnableThread.getName());
			miRunnableThread.start();
		}

	}

}

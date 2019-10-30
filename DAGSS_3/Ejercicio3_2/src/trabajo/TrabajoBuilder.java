package trabajo;
import programa.ProgramaA;
import programa.ProgramaB;
import programa.ProgramaC;
import programa.ProgramaD;
import programa.ProgramaE;
import programa.ProgramaF;

public class TrabajoBuilder {
	
	private Trabajo t;
	
	public static TrabajoBuilder esParalelo() {
		return new TrabajoBuilder(true);
	}
	
	public static TrabajoBuilder esSerie() {
		return new TrabajoBuilder(false);
	}
	
	public TrabajoBuilder(boolean esParalelo) {
		t = esParalelo? new TrabajoParalelo() : new TrabajoSerie();
	}
	
	public TrabajoBuilder queEjecuta(Runnable r) {
		this.t.addTrabajo(r);
		return this;
	}
	
	public Trabajo obtener() {
		return t;
	}
	
	public static void main(String[] args) {

		Trabajo t = esSerie()
							.queEjecuta(new ProgramaA())
							.queEjecuta(esParalelo()
													.queEjecuta(new ProgramaB())
													.queEjecuta(new ProgramaC())
													.queEjecuta(esSerie()
																		.queEjecuta(new ProgramaD())
																		.queEjecuta(new ProgramaF())
																		.obtener())
													.obtener())
							.queEjecuta(new ProgramaE())
							.obtener();
		
		t.addObserver(new ObservadorTrabajos());
									
		t.run();

	}
	
}

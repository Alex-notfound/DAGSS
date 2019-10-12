package trabajo;
import java.util.ArrayList;
import java.util.List;

import programa.ProgramaA;
import programa.ProgramaB;
import programa.ProgramaC;
import programa.ProgramaD;
import programa.ProgramaE;
import programa.ProgramaF;



public class TrabajoBuilder {
	
	private boolean esParalelo;
	private List<Runnable> trabajos = new ArrayList<>();
	
	public static TrabajoBuilder esParalelo() {
		return new TrabajoBuilder(true);
	}
	
	public static TrabajoBuilder esSerie() {
		return new TrabajoBuilder(false);
	}
	
	public TrabajoBuilder(boolean esParalelo) {
		this.esParalelo = esParalelo;
	}
	
	public TrabajoBuilder queEjecuta(Runnable r) {
		this.trabajos.add(r);
		return this;
	}
	
	public Trabajo obtener() {
		Trabajo t = this.esParalelo?new TrabajoParalelo(): new TrabajoSerie();
		for(Runnable sub: this.trabajos) {
			t.addTrabajo(sub);
		}
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
									
		t.run();

	}
	
}

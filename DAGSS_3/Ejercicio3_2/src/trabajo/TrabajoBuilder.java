package trabajo;

import observer.ProgramaObserver;
import programa.*;

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
		

		ProgramaObserver pO = new ProgramaObserver();
		
		ProgramaA pA = new ProgramaA();
		pA.addObserver(pO);
		ProgramaB pB = new ProgramaB();
		pB.addObserver(pO);
		ProgramaC pC = new ProgramaC();
		pC.addObserver(pO);
		ProgramaD pD = new ProgramaD();
		pD.addObserver(pO);
		ProgramaE pE = new ProgramaE();
		pE.addObserver(pO);
		ProgramaF pF = new ProgramaF();
		pF.addObserver(pO);
		
		
		Trabajo t = esSerie()
				.queEjecuta(pA)
				.queEjecuta(esParalelo()
										.queEjecuta(pB)
										.queEjecuta(pC)
										.queEjecuta(esSerie()
															.queEjecuta(pD)
															.queEjecuta(pF)
															.obtener())
										.obtener())
				.queEjecuta(pE)
				.obtener();
		
		t.run();

	}
	
}

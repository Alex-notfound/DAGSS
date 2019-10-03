package ejercicio1;

public class Atreides implements FamiliaEjercito {

	@Override
	public Zapador createZapador() {
		return new ZapadorAtreides();
	}

	@Override
	public Artillero createArtillero() {
		return new ArtilleroAtreides();
	}
	
}

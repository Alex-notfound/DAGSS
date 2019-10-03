package ejercicio1;

public class Harkonen implements FamiliaEjercito {

	@Override
	public Zapador createZapador() {
		return new ZapadorHarkonen();
	}

	@Override
	public Artillero createArtillero() {
		return new ArtilleroHarkonen();
	}

}

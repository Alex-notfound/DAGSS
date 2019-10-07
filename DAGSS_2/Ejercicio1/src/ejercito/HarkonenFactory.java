package ejercito;

import ejercicio1.ArtilleroHarkonen;
import ejercicio1.ZapadorHarkonen;
import soldados.Artillero;
import soldados.Zapador;

public class HarkonenFactory implements EjercitoFactory{

	@Override
	public Zapador crearZapador() {
		return new ZapadorHarkonen();
	}

	@Override
	public Artillero crearArtillero() {
		return new ArtilleroHarkonen();
	}
	
}

package ejercito;

import soldados.Artillero;
import soldados.ArtilleroHarkonen;
import soldados.Zapador;
import soldados.ZapadorHarkonen;

public class HarkonenFactory implements EjercitoFactory {

	@Override
	public Zapador crearZapador() {
		return new ZapadorHarkonen();
	}

	@Override
	public Artillero crearArtillero() {
		return new ArtilleroHarkonen();
	}

}

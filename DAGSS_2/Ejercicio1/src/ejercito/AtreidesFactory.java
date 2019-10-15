package ejercito;

import soldados.Artillero;
import soldados.ArtilleroAtreides;
import soldados.Zapador;
import soldados.ZapadorAtreides;

public class AtreidesFactory implements EjercitoFactory {

	@Override
	public Zapador crearZapador() {
		return new ZapadorAtreides();
	}

	@Override
	public Artillero crearArtillero() {
		return new ArtilleroAtreides();
	}

}

package ejercito;

import ejercicio1.ArtilleroAtreides;
import ejercicio1.ZapadorAtreides;
import soldados.Artillero;
import soldados.Zapador;

public class AtreidesFactory implements EjercitoFactory{

	@Override
	public Zapador crearZapador() {
		return new ZapadorAtreides();
	}

	@Override
	public Artillero crearArtillero() {
		return new ArtilleroAtreides();
	}

}

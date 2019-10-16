package ejercito;

import soldados.Artillero;
import soldados.Zapador;

public interface EjercitoFactory {

	public static EjercitoFactory getEjercito(String tipo) {
		if (tipo.equals("Harkonen")) {
			return new HarkonenFactory();
		} else {
			return new AtreidesFactory();
		}
	}

	public Zapador crearZapador();

	public Artillero crearArtillero();

}

package ejercito;

import soldados.Artillero;
import soldados.Zapador;

public interface EjercitoFactory {

	public Zapador crearZapador();

	public Artillero crearArtillero();

}

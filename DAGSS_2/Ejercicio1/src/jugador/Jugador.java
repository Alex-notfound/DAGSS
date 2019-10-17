package jugador;

import java.util.LinkedList;
import java.util.List;

import ejercito.EjercitoFactory;
import soldados.Artillero;
import soldados.Zapador;

public abstract class Jugador {

	protected List<Artillero> artilleros = new LinkedList<Artillero>();
	protected List<Zapador> zapadores = new LinkedList<Zapador>();
	protected EjercitoFactory ejercitoFactory;

	public Jugador(EjercitoFactory ejercitoFactory) {

		// creamos el ejercito inicial (todos de la misma raza, no se pueden mezclar!)
		this.ejercitoFactory = ejercitoFactory;
		
		artilleros.add(this.ejercitoFactory.crearArtillero());
		artilleros.add(this.ejercitoFactory.crearArtillero());
		zapadores.add(this.ejercitoFactory.crearZapador());
		zapadores.add(this.ejercitoFactory.crearZapador());
	}

	public abstract void jugar();
}

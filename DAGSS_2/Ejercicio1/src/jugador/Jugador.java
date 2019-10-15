package jugador;

import java.util.LinkedList;
import java.util.List;

import ejercito.AtreidesFactory;
import ejercito.EjercitoFactory;
import ejercito.HarkonenFactory;
import soldados.Artillero;
import soldados.Zapador;

public abstract class Jugador {

	protected List<Artillero> artilleros = new LinkedList<Artillero>();
	protected List<Zapador> zapadores = new LinkedList<Zapador>();
	protected String tipo;
	protected EjercitoFactory ejercitoFactory;

	public Jugador(String tipo) {
		this.tipo = tipo;

		// creamos el ejercito inicial (todos de la misma raza, no se pueden mezclar!)

		if (tipo.equals("Harkonen")) {
			this.ejercitoFactory = new HarkonenFactory();

		} else if (tipo.equals("Atreides")) {
			this.ejercitoFactory = new AtreidesFactory();
		}

		artilleros.add(this.ejercitoFactory.crearArtillero());
		artilleros.add(this.ejercitoFactory.crearArtillero());
		zapadores.add(this.ejercitoFactory.crearZapador());
		zapadores.add(this.ejercitoFactory.crearZapador());
	}

	public abstract void jugar();
}

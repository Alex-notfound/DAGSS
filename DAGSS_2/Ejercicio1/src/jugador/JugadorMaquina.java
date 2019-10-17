package jugador;

import ejercito.EjercitoFactory;
import soldados.Artillero;
import soldados.Zapador;

public class JugadorMaquina extends Jugador {

	public JugadorMaquina(EjercitoFactory ejercitoFactory) {
		super(ejercitoFactory);
	}

	@Override
	public void jugar() {
		// disparamos!
		for (Artillero artillero : artilleros) {
			artillero.disparar();
		}

		// ponemos bombas!
		for (Zapador zapador : zapadores) {
			zapador.ponerBomba();
		}

	}

}

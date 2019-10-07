package jugador;

import java.util.LinkedList;
import java.util.List;

import ejercicio1.ArtilleroAtreides;
import ejercicio1.ArtilleroHarkonen;
import ejercicio1.ZapadorAtreides;
import ejercicio1.ZapadorHarkonen;
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
	public Jugador(String tipo){
		this.tipo = tipo;
		
		//creamos el ejercito inicial (todos de la misma raza, no se pueden mezclar!)
		
		if(tipo.equals("Harkonen")) {	
//			// Dani:
//			artilleros.add(new ArtilleroHarkonen());
//			artilleros.add(new ArtilleroHarkonen());
//			zapadores.add(new ZapadorHarkonen());
//			zapadores.add(new ZapadorHarkonen());
			this.ejercitoFactory = new HarkonenFactory();
			
			
		}else if (tipo.equals("Atreides")){
			// Dani:
//			artilleros.add(new ArtilleroAtreides());
//			artilleros.add(new ArtilleroAtreides());
//			zapadores.add(new ZapadorAtreides());
//			zapadores.add(new ZapadorAtreides());
			this.ejercitoFactory = new AtreidesFactory();
			
		}
		
		artilleros.add(this.ejercitoFactory.crearArtillero());
		artilleros.add(this.ejercitoFactory.crearArtillero());
		zapadores.add(this.ejercitoFactory.crearZapador());
		zapadores.add(this.ejercitoFactory.crearZapador());
	}
	public abstract void jugar();
}

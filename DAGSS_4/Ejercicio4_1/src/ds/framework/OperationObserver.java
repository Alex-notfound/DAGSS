package ds.framework;

public class OperationObserver implements Observer {

	@Override
	public void update(Observable o, String state) {
		Logger log = Logger.getInstance();
		log.log("Porcentaje realizado de la operacion: " + state, Logger.INFO);

	}

}

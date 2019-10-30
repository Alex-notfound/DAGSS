package trabajo;

public class ObservadorTrabajos implements Observer{

	private int numProgramas;
	
	public ObservadorTrabajos() {
		numProgramas = 0;
	}
	
	@Override
	public void update(Observable o, Object data) {
		if(((String)data).equalsIgnoreCase("Start")) {
			numProgramas++;
			System.out.println("Creado un programa. Actualmente hay " + numProgramas + " en curso");
		}else {
			numProgramas--;
			System.out.println("Acabado un programa. Actualmente hay " + numProgramas + " en curso");
		}
		
	}

}

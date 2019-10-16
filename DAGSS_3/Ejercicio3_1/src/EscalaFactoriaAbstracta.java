
public interface EscalaFactoriaAbstracta{
	
	public static Nomina getNomina(String escala) {
		if(escala.equals("A")) {
			return new EscalaA();
		}else if(escala.equals("B")) {
			return new EscalaB();
		}else {
			return new EscalaC();
		}
	}

}

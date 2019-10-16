
public class Sexenio extends Complemento{

	public Sexenio(Nomina n) {
		super(n);
	}
	
	public double abono() {
		return nomina.sueldoBase() + 50;
	}
	
}

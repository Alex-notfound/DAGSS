
public class Quinquenios extends Complemento{

	public Quinquenios(Nomina n) {
		super(n);
	}
	
	public double abono() {
		return nomina.sueldoBase() + 20;
	}
	
}

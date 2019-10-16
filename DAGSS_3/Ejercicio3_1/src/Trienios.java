
public class Trienios extends Complemento{

	public Trienios(Nomina n) {
		super(n);
	}
	
	public double abono() {
		return nomina.sueldoBase() + 10;
	}
	
}

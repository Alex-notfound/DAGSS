
public class Quinquenios extends Complemento {

	public Quinquenios(Nomina n) {
		super(n);
	}

	@Override
	public double sueldoBase() {
		return nomina.sueldoBase() + 20;
	}

}

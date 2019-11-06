
public class Quinquenio extends Complemento {

	public Quinquenio(Nomina n) {
		super(n);
	}

	@Override
	public double sueldoBase() {
		return nomina.sueldoBase() + 20;
	}

}

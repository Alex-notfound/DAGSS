
public class Interno extends Complemento {

	public Interno(Nomina n) {
		super(n);
	}

	@Override
	public double sueldoBase() {
		return nomina.sueldoBase() + 15;
	}

}

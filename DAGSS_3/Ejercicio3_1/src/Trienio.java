
public class Trienio extends Complemento {

	public Trienio(Nomina n) {
		super(n);
	}

	@Override
	public double sueldoBase() {
		return nomina.sueldoBase() + 10;
	}

}

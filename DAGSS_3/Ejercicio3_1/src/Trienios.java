
public class Trienios extends Complemento {

	public Trienios(Nomina n) {
		super(n);
	}

	@Override
	public double sueldoBase() {
		return nomina.sueldoBase() + 10;
	}

}

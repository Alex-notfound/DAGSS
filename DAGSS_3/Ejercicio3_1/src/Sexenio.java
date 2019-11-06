
public class Sexenio extends Complemento {

	public Sexenio(Nomina n) {
		super(n);
	}

	@Override
	public double sueldoBase() {
		return nomina.sueldoBase() + 50;
	}

}

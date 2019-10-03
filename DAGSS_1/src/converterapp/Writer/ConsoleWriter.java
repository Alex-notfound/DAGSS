package converterapp.Writer;

public class ConsoleWriter implements Writer {
	
	

	@Override
	public void write(String s) {
		if (s != null) {
			System.out.println(s);
		}

	}

}

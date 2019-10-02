package converterapp;

public class ConverterApp {

	public static void main(String args[]) {
		new ConverterApp().run();
	}

	private void run() {

		ConverterAppCLI cli = new ConverterAppCLI();
		try {
			Reader r = new FileReader(cli.getFile("input file: "));
			Writer w = new FileWriter(cli.getFile("output file: "));
			Transformer t = new TABtoXMLTransformer();

			Converter c = new Converter(r, t, w);
			c.convert();
		} catch (Exception e) {
			cli.showError(e);
		}
	}
}
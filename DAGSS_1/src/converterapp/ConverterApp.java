package converterapp;

import converterapp.Reader.FileReader;
import converterapp.Reader.Reader;
import converterapp.Transformer.TABtoXMLTransformer;
import converterapp.Transformer.Transformer;
import converterapp.Writer.ConsoleWriter;
import converterapp.Writer.Writer;

public class ConverterApp {

	public static void main(String args[]) {
		new ConverterApp().run();
	}

	private void run() {

		ConverterAppCLI cli = new ConverterAppCLI();
		try {
			Reader r = new FileReader(cli.getFile("input file: "));
			//Writer w = new FileWriter(cli.getFile("output file: "));
			Writer w = new ConsoleWriter();
			Transformer t = new TABtoXMLTransformer();

			Converter c = new Converter(r, t, w);
			c.convert();
		} catch (Exception e) {
			cli.showError(e);
		}
	}
}
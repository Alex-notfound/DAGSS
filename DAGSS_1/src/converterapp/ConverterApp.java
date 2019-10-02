package converterapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

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

		// File input = getInputFile();
		// File output = getOutputFile();
		// transform(input, output);
	}

	// public static void transform(File input, File output) {
	// Scanner scanner = null;
	// PrintStream out = null;
	//
	// try {
	// out = new PrintStream(new FileOutputStream(output));
	// } catch (FileNotFoundException e1) {
	// System.err.println("the file " + input.getAbsolutePath() + " does cannot
	// be created: " + e1.getMessage());
	// System.exit(1);
	// }
	//
	// out.println("<products>");
	// while (scanner.hasNextLine()) {
	// String xmlString = toXML(scanner.nextLine());
	// out.println(xmlString);
	// }
	// out.println("</products>");
	//
	// out.close();
	// }
	//
	// private static String toXML(String line) {
	// String[] tokens = line.split("\t");
	// if (tokens.length != 2) {
	// throw new IllegalArgumentException("the line does not contain 3 tokens");
	// }
	//
	// return "<product>\n\t<name>" + tokens[0] + "</name>\n\t<price>" +
	// tokens[1] + "</price>\n</product>";
	//
	// }
}

package biblioteca;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LibrosParser {

	File file;
	BibliotecaBuilder bibliotecaBuilder;

	public LibrosParser(File file, BibliotecaBuilder bibliotecaBuilder) {
		this.file = file;
		this.bibliotecaBuilder = bibliotecaBuilder;
	}

	public void parse() {
		Scanner scanner = null;
		try {
			scanner = new Scanner(this.file);
		} catch (FileNotFoundException e) {
			System.err.println("the file does not exist: " + e.getMessage());
			System.exit(1);
		}

		while (scanner.hasNextLine()) {
			String[] tokens = scanner.nextLine().split("\t");
			bibliotecaBuilder.addLibro(tokens[0], tokens[1], tokens[2]);
		}
	}
}

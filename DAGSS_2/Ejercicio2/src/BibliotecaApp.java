import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

	public static void main(String[] args) {

		Biblioteca biblioteca = new Biblioteca();
		Scanner scanner = null;
		PrintStream out = null;

		try {
			scanner = new Scanner(new File("libros.txt"));
		} catch (FileNotFoundException e) {

		}

		while (scanner.hasNextLine()) {
			biblioteca.addLibro(TABtoLibro(scanner.nextLine()));
		}

		try {
			out = new PrintStream(new FileOutputStream(new File("libros.xml")));
		} catch (FileNotFoundException e1) {
			System.err.println("the file does cannot be created: " + e1.getMessage());
			System.exit(1);
		}

		List<Libro> libros = biblioteca.getLibros();
		out.println("<libros>");
		for (Libro libro : libros) {
			out.println("<libro>\n\t<titulo>" + libro.getTitulo() + "</titulo>\n\t<autor>"
					+ libro.getAutor().getNombre() + "</autor>\n\t<isbn>" + libro.getIsbn() + "</isbn>\n</libro>");
		}
		out.println("</libros>");
	}

	private static Libro TABtoLibro(String s) {
		String[] tokens = s.split("\t");
		if (tokens.length != 3) {
			throw new IllegalArgumentException("the line does not contain 3 tokens");
		}
		return new Libro(tokens[0], new Autor(tokens[1]), tokens[2]);
	}

}

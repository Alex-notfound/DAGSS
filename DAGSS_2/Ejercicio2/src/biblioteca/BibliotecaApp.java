package biblioteca;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;

public class BibliotecaApp {

	public static void main(String[] args) {

		BibliotecaBuilder bibliotecaBuilder = new ObjectBibliotecaBuilder();
//		BibliotecaBuilder bibliotecaBuilder = new XMLBibliotecaBuilder();
		LibrosParser parser = new LibrosParser(new File("libros.txt"), bibliotecaBuilder);
		parser.parse();
		
		Biblioteca biblioteca = new Biblioteca();
		PrintStream out = null;
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

}

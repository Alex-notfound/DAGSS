package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

	private List<Libro> libros;

	public Biblioteca() {
		libros = new ArrayList<>();
	}

	public List<Libro> getLibros() {
		return this.libros;
	}

	public void addLibro(Libro libro) {
		libros.add(libro);
	}

}

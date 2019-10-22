package biblioteca;

public class ObjectBibliotecaBuilder implements BibliotecaBuilder {

	private Biblioteca biblioteca = new Biblioteca();

	@Override
	public void addLibro(String titulo, String autor, String isbn) {
		Libro libro = new Libro(titulo, new Autor(autor), isbn);
		biblioteca.addLibro(libro);
	}

	public Biblioteca getResult() {
		return this.biblioteca;
	}

}

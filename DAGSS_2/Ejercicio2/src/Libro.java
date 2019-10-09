
public class Libro {
	
	private String isbn;
	private Autor autor;
	
	public Libro(String isbn, Autor autor) {
		this.isbn = isbn;
		this.autor = autor;
	}
	
	public String getIsbn() {
		return this.isbn;
	}
	
	public Autor getAutor() {
		return this.autor;
	}
	
}

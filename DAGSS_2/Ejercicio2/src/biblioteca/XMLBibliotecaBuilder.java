package biblioteca;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class XMLBibliotecaBuilder implements BibliotecaBuilder {

	private Biblioteca biblio = new Biblioteca();

	@Override
	public void addLibro(String titulo, String autor, String isbn) {
		Libro libro = new Libro(titulo, new Autor(autor), isbn);
		biblio.addLibro(libro);
	}

	public Document getResult() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
        DOMImplementation implementation = builder.getDOMImplementation();
        Document document = implementation.createDocument(null, null, null);
        document.setXmlVersion("1.0");
        
        Element root = document.getDocumentElement();
        
         for(Libro libro: this.biblio.getLibros()) {
        	
        	Element bookNode = document.createElement("Libro");
        	
        	Element titleNode = document.createElement("Titulo");
        	Text valueTitleNode = document.createTextNode(libro.getTitulo());
        	titleNode.appendChild(valueTitleNode);
        	
        	Element authorNode = document.createElement("Autor");
        	Element authorNameNode = document.createElement("Nombre");
        	Text valueAuthorNameNode = document.createTextNode(libro.getAutor().getNombre());
        	authorNameNode.appendChild(valueAuthorNameNode);
        	authorNode.appendChild(authorNameNode);
        	
        	
        	Element isbnNode = document.createElement("ISBN");
        	Text valueIsbnNode = document.createTextNode(libro.getIsbn());
        	isbnNode.appendChild(valueIsbnNode);
        	
        	bookNode.appendChild(titleNode);
        	bookNode.appendChild(authorNode);
        	bookNode.appendChild(isbnNode);
        	
        	root.appendChild(bookNode);
         }
         
         return document;

	}

}

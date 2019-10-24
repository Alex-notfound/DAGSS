package biblioteca;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class XMLBibliotecaBuilder implements BibliotecaBuilder {

	private List<Element> bookNodes = new LinkedList<>();
	Document document;
	
	public XMLBibliotecaBuilder() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		document=builder.newDocument();
//		DOMImplementation implementation = builder.getDOMImplementation();
//		document = implementation.createDocument(null, null, null);
//		document.setXmlVersion("1.0");
		
	}

	
	@Override
	public void addLibro(String titulo, String autor, String isbn) {
		
		Element bookNode = document.createElement("Libro");
		
		Element titleNode = document.createElement("Titulo");
		Text valueTitleNode = document.createTextNode(titulo);
		titleNode.appendChild(valueTitleNode);
		
		Element authorNode = document.createElement("Autor");
		Element authorNameNode = document.createElement("Nombre");
		Text valueAuthorNameNode = document.createTextNode(autor);
		authorNameNode.appendChild(valueAuthorNameNode);
		authorNode.appendChild(authorNameNode);
		
		
		Element isbnNode = document.createElement("ISBN");
		Text valueIsbnNode = document.createTextNode(isbn);
		isbnNode.appendChild(valueIsbnNode);
		
		bookNode.appendChild(titleNode);
		bookNode.appendChild(authorNode);
		bookNode.appendChild(isbnNode);
		
		this.bookNodes.add(bookNode);
		
	}

	public void getResult() {
        
        Element root = document.createElement("Libros");
        document.appendChild(root);
        System.out.println(document.toString());
        for(Element bookNode: this.bookNodes) {
        	root.appendChild(bookNode);
        }
        
        DOMSource source = new DOMSource(document);
        
        Result result = new StreamResult(new File("Libros.xml"));
        Transformer transformer;
        
		try {
			transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, result);
			
		} catch (TransformerConfigurationException | TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
         

	}

}

package biblioteca;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
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
		document = builder.newDocument();
	}

	@Override
	public void addLibro(String titulo, String autor, String isbn) {

		Element bookNode = document.createElement("libro");

		Element titleNode = document.createElement("titulo");
		Text valueTitleNode = document.createTextNode(titulo);
		titleNode.appendChild(valueTitleNode);

		Element authorNode = document.createElement("autor");
		Element authorNameNode = document.createElement("nombre");
		Text valueAuthorNameNode = document.createTextNode(autor);
		authorNameNode.appendChild(valueAuthorNameNode);
		authorNode.appendChild(authorNameNode);

		Element isbnNode = document.createElement("isbn");
		Text valueIsbnNode = document.createTextNode(isbn);
		isbnNode.appendChild(valueIsbnNode);

		bookNode.appendChild(titleNode);
		bookNode.appendChild(authorNode);
		bookNode.appendChild(isbnNode);

		this.bookNodes.add(bookNode);

	}

	public void getResult() {

		Element root = document.createElement("libros");
		document.appendChild(root);
		for (Element bookNode : this.bookNodes) {
			root.appendChild(bookNode);
		}

		DOMSource source = new DOMSource(document);

		Result result = new StreamResult(new File("libros.xml"));
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

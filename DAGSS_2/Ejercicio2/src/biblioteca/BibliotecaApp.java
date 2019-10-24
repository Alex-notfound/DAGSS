package biblioteca;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;

public class BibliotecaApp {

	public static void main(String[] args) {

		ObjectBibliotecaBuilder objetcBibliotecaBuilder = new ObjectBibliotecaBuilder();
//		BibliotecaBuilder bibliotecaBuilder = new XMLBibliotecaBuilder();
		LibrosParser parserObjetc = new LibrosParser(new File("libros.txt"), objetcBibliotecaBuilder);
		parserObjetc.parse();

		Biblioteca biblioteca = objetcBibliotecaBuilder.getResult();

		
		XMLBibliotecaBuilder xmlBibliotecaBuilder = new XMLBibliotecaBuilder();
		LibrosParser parserXml = new LibrosParser(new File("libros.txt"), xmlBibliotecaBuilder);
		parserXml.parse();
		
		xmlBibliotecaBuilder.getResult();
		
		
		
	}

}

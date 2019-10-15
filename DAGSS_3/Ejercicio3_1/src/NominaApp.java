import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class NominaApp {

	public static void main(String[] args) {

		Scanner scanner = null;
		PrintStream out = null;

		try {
			scanner = new Scanner(new File("nomina.txt"));
		} catch (FileNotFoundException e) {
			System.err.println("the file does not exist: " + e.getMessage());
			System.exit(1);
		}

		try {
			out = new PrintStream(new FileOutputStream(new File("libros.xml")));
		} catch (FileNotFoundException e1) {
			System.err.println("the file does cannot be created: " + e1.getMessage());
			System.exit(1);
		}

		while (scanner.hasNextLine()) {
			// TODO: Gestionar
		}

	}

}

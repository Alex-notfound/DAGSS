package converterapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader implements Reader {

	Scanner scanner = null;

	public FileReader(File file) {
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.err.println("the file " + file.getAbsolutePath() + " does not exists: " + e.getMessage());
			System.exit(1);
		}
	}

	public String read() {
		if (scanner.hasNextLine()) {
			return scanner.nextLine();
		}
		return null;
	}
}

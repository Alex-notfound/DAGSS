package converterapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader implements Reader {

	File file;

	public FileReader(File file) {
		this.file = file;
	}

	public String read() {
		try (Scanner scanner = new Scanner(this.file)) {
			if (scanner.hasNextLine()) {
				return scanner.nextLine();
			}
		} catch (FileNotFoundException e) {
			System.err.println("the file " + this.file.getAbsolutePath() + " does not exists: " + e.getMessage());
			System.exit(1);
		}
		return null;
	}
}

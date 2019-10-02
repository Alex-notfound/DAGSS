package converterapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class FileWriter implements Writer {

	private File file;
	PrintStream out = null;

	public FileWriter(File file) {
		this.file = file;
		try {
			out = new PrintStream(new FileOutputStream(this.file));
		} catch (FileNotFoundException e1) {
			System.err
					.println("the file " + this.file.getAbsolutePath() + " does cannot be created: " + e1.getMessage());
			System.exit(1);
		}
	}

	public void write(String s) {
		if (s != null) {
			out.println(s);
		} else {
			out.close();
		}
	}
}
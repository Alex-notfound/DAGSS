package converterapp;

import java.io.File;
import java.util.Scanner;

public class ConverterAppCLI {
	
	public File getFile(String s) {
		System.out.println(s);
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		String name = in.nextLine();
		return new File(name);
	}

	public void showError(Exception e) {
		System.err.println(e);
	}
}

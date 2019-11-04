package ds.framework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileLogger extends Logger {

	private File file;

	public FileLogger(File file, int threshold, Logger next) {
		super(threshold, next);
		this.file = file;
	}
	
//	private static FileLogger _instance;
//
//	public static FileLogger getInstance(File file, int threshold, Logger next) {
//		if (_instance == null) {
//			_instance = new FileLogger(file, threshold, next);
//		}
//		return _instance;
//	}

	@Override
	protected void _log(String msg) {
		try (PrintWriter writer = new PrintWriter(file)) {
			writer.write(msg);

		} catch (FileNotFoundException e) {
			System.err.println("ERROR: File not found.");
			e.printStackTrace();
		}

	}

}

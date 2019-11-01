package logs;

public class ConsoleLogger extends Logger{

	private ConsoleLogger(int threshold, Logger next) {
		super(threshold, next);
	}
	
	private static ConsoleLogger _instance;
	
	public static ConsoleLogger getInstance(int threshold, Logger next) {
		if(_instance == null) {
			_instance = new ConsoleLogger(threshold, next);
		}
		return _instance;
	}

	@Override
	protected void _log(String msg) {
		System.out.println(msg);
		
	}
	
}

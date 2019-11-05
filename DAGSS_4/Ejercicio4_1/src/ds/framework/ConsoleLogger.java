package ds.framework;

public class ConsoleLogger extends Logger {

	public ConsoleLogger(int threshold, Logger next) {
		super(threshold, next);
	}

	@Override
	protected void _log(String msg) {
		System.out.println(msg);
	}

}

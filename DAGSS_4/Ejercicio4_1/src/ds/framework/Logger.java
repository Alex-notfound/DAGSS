package ds.framework;

public abstract class Logger {

	public static final int DEBUG = 1;
	public static final int INFO = 2;
	public static final int ERROR = 3;

	protected Logger next;
	protected int threshold;
	
	private static Logger _instance;

	protected Logger(int threshold, Logger next) {
		this.threshold = threshold;
		this.next = next;
	}
	
	public static Logger getInstance() {
		if (_instance == null) {
			_instance = new ConsoleLogger(INFO, new FileLogger(null, ERROR, null));
		}
		return _instance;
	}

	protected abstract void _log(String msg);

	public void log(String msg, int priority) {
		if (priority >= threshold) {
			_log(msg);
		}

		if (next != null) {
			next.log(msg, priority);
		}
	}
}

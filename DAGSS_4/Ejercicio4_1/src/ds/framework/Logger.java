package ds.framework;

public abstract class Logger {

	public final int DEBUG = 1;
	public final int INFO = 2;
	public final int ERROR = 3;

	protected Logger next;
	protected int threshold;
	
	private static Logger _instance;

	private Logger(int threshold, Logger next) {
		this.threshold = threshold;
		this.next = next;
	}
	
	public Logger getInstance(int threshold, Logger next) {
		if (_instance == null) {
			_instance = new Logger(threshold, next);
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

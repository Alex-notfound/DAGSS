package ds.framework;

public interface Observable {

	public void addObserver(Observer o);

	public void notifyObservers(String state);

}

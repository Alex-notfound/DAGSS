package observer;

import trabajo.Observable;

public interface Observer {

	public void update(Observable o, String state);

}

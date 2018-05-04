package observable;

import java.util.ArrayList;
import java.util.List;
import observer.UserEventListener;

public class UserEventHandler {
	
	private final List<UserEventListener> listenerList= new ArrayList<UserEventListener>();
	
	public boolean add(UserEventListener listener) {
		return this.listenerList.add(listener);
	}
	
	public boolean remove(UserEventListener listener) {
		return this.listenerList.remove(listener);
	}
	
	public void notify(UserEvent event) {
		for (UserEventListener listener : listenerList)
			listener.onInputEvent(event);
	}
}

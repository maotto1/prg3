package observer;

import java.util.EventListener;
import observable.UserEvent;

public interface UserEventListener extends EventListener {

	public void onInputEvent(UserEvent event);

}

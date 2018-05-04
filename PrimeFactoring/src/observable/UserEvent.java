package observable;

import java.util.EventObject;

public abstract class UserEvent  extends EventObject {

	
	private static final long serialVersionUID = 2896447012612915957L;

	public UserEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

}

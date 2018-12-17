package eg.edu.alexu.csd.oop.cs51.objects.states;

import eg.edu.alexu.csd.oop.cs51.objects.Movable;

public class CollectState implements State {

	@Override
	public void doAction(Movable movable) {
		movable.setState(this);	
	}
	

}
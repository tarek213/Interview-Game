package eg.edu.alexu.csd.oop.cs51.objects.states;

import eg.edu.alexu.csd.oop.cs51.flyweight.FlyweightFactory;
import eg.edu.alexu.csd.oop.cs51.objects.Movable;
import eg.edu.alexu.csd.oop.cs51.objects.Skill;

public class VanishState implements State {

    public VanishState(VanishState vanishState) {
    }

    public VanishState() {
    }

    @Override
    public void doAction(Movable movable) {
        movable.setState(this);
        movable.setVisible(false);
        if (Skill.class.isAssignableFrom(movable.getClass())) {
            FlyweightFactory.addVanishedSkill(movable);
        } else {
            FlyweightFactory.addVanishedGift(movable);
        }

    }

    public State clone() {
        return new VanishState(this);
    }
}

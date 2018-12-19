package eg.edu.alexu.csd.oop.cs51.observer;

import eg.edu.alexu.csd.oop.cs51.GameInfo;
import eg.edu.alexu.csd.oop.cs51.iterators.IteratorI;
import eg.edu.alexu.csd.oop.cs51.iterators.LinkedListContainer;
import eg.edu.alexu.csd.oop.cs51.objects.Movable;

public class Collision {
    private static final int GroundY = 10;
    private GameInfo gameInfo;
    private LinkedListContainer<Observer> list;
    private IteratorI iterator;

    public Collision() {
        gameInfo = GameInfo.getInstance();
        list = new LinkedListContainer<Observer>();
    }

    public void addObserver(Observer observer) {
        list.add(observer);
    }

    public void notifyObservers() {
        int leftX = gameInfo.getLeftHand();
        int rightX = gameInfo.getRightHand();
        int leftY = gameInfo.getLeftStackHeight();
        int rightY = gameInfo.getRightStackHeight();
        int handWidth = gameInfo.getPlayerHandWidth();
        iterator = list.createIterator();
        while (iterator.hasNext()) {
            Observer observer = (Observer) iterator.next();
            Movable movable = ((Movable) observer);
            if (movable.getY() == GroundY) {
                movable.update("vanish");
            } else if (movable.getX() >= leftX && movable.getX() <= Math.abs(leftX + handWidth)) {
                if (movable.getY() == leftY) {
                    movable.update("left");
                }
            } else if (movable.getX() <= rightX && movable.getX() >= Math.abs(rightX - handWidth)) {
                if (movable.getY() == rightY) {
                    movable.update("right");
                }
            }

        }
    }
}

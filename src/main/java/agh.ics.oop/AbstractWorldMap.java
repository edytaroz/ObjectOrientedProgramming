package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    //protected List<Animal> animals = new ArrayList<>();
    protected Map<Vector2d,Animal> animals = new HashMap<>();
    protected Vector2d lowerLeft;
    protected Vector2d upperRight;
    public abstract boolean canMoveTo(Vector2d position);

    public abstract boolean place(Animal animal);

    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }
    public abstract Object objectAt(Vector2d position);
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        animals.put(newPosition,animals.get(oldPosition));
        animals.remove(oldPosition);
    }

    public String toString() {
        MapVisualizer map2 = new MapVisualizer(this);
        return map2.draw(lowerLeft,upperRight);
    }
}

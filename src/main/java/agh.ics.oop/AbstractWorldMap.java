package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap {
    protected List<Animal> animals = new ArrayList<>();
    protected Vector2d lowerLeft;
    protected Vector2d upperRight;
    public abstract boolean canMoveTo(Vector2d position);

    public abstract boolean place(Animal animal);

    public abstract boolean isOccupied(Vector2d position);
    public abstract Object objectAt(Vector2d position);

    public String toString() {
        MapVisualizer map2 = new MapVisualizer(this);
        return map2.draw(lowerLeft,upperRight);
    }
}

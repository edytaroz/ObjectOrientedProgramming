package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {

    public RectangularMap(int width, int height) {
        this.lowerLeft = new Vector2d(0,0);
        this.upperRight = new Vector2d(width,height);
    }
    public boolean canMoveTo(Vector2d position) {
        if (isOccupied(position)) {
            return false;
        }
        if (position.x > upperRight.x || position.y > upperRight.y || position.x < 0 || position.y < 0) {
            return false;
        }
        return true;
    }
    public boolean place(Animal animal) {
        if (canMoveTo(animal.vector)) {
            animals.put(animal.vector,animal);
            animal.addObserver(this);
            return true;
        }
        return false;
    }


    public Object objectAt(Vector2d position) {
        if (animals.containsKey(position)) {
            return animals.get(position);
        }
        return null;
    }
}

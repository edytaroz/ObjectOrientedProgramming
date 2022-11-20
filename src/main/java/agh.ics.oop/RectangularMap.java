package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {

    public RectangularMap(int width, int height) {
        this.lowerLeft = new Vector2d(0,0);
        this.upperRight = new Vector2d(width,height);
        this.animals = new ArrayList<>();
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
            animals.add(animal);
            return true;
        }
        return false;
    }

    public boolean isOccupied(Vector2d position) {
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).vector.equals(position)) {
                return true;
            }
        }
        return false;
    }
    public Object objectAt(Vector2d position) {
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).vector.equals(position)) {
                return animals.get(i);
            }
        }
        return null;
    }
}

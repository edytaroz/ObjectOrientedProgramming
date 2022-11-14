package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    int width;
    int height;
    List<Animal> animals;
    Vector2d lowerLeft;
    Vector2d upperRight;

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.lowerLeft = new Vector2d(0,0);
        this.upperRight = new Vector2d(width,height);
        this.animals = new ArrayList<>();
    }
    public boolean canMoveTo(Vector2d position) {
        if (isOccupied(position)) {
            return false;
        }
        if (position.x > width || position.y > height || position.x < 0 || position.y < 0) {
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
    public String toString() {
        MapVisualizer map2 = new MapVisualizer(this);
        return map2.draw(lowerLeft,upperRight);
    }
}

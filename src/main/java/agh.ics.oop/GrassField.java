package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GrassField extends AbstractWorldMap{
    int numberOfGrassFields;
    List<Grass> grassField= new ArrayList<>();

    public GrassField(int grass) {
        this.lowerLeft = new Vector2d(0,0);
        this.upperRight = new Vector2d(0,0);
        this.numberOfGrassFields = grass;
        fillGrassField(this.numberOfGrassFields);
    }
    private void fillGrassField(int numberOfGrass) {
        int x;
        int y;
        Random rand = new Random();
        for (int i = 0; i < numberOfGrass; i++) {
            boolean flag = true;
            while (flag) {
                x = rand.nextInt((int) Math.sqrt(numberOfGrass * 10));
                y = rand.nextInt((int) Math.sqrt(numberOfGrass * 10));
                Vector2d vec = new Vector2d(x, y);
                if (!isOccupied(vec)) {
                    this.grassField.add(new Grass(vec));
                    if (x > upperRight.x) {
                        this.upperRight = new Vector2d(x, upperRight.y);
                    }
                    if (y > upperRight.y) {
                        this.upperRight = new Vector2d(upperRight.x, y);
                    }
                    flag = false;
                }
            }
        }
    }
    public Object objectAt(Vector2d position) {
        if (animals.containsKey(position)) {
            return animals.get(position);
        }
        for (int i = 0; i < grassField.size(); i++) {
            if (grassField.get(i).getPosition().equals(position)) {
                return grassField.get(i);
            }
        }
        return null;
    }
    public boolean place(Animal animal) {
        if (canMoveTo(animal.vector)) {
            if (isOccupiedByGrass(animal.vector)) {
                animals.put(animal.vector,animal);
                fillGrassField(1);
                boolean flag = true;
                int i = 0;
                while (i < this.grassField.size() || flag) {
                    if (animal.vector.equals(this.grassField.get(i).positions)) {
                        flag = false;
                        this.grassField.remove(this.grassField.get(i));
                    }
                    i++;
                }
            }
            else {
                animals.put(animal.vector,animal);
            }
            animal.addObserver(this);
            return true;
        }
        return false;
    }
    public boolean canMoveTo(Vector2d position) {
        if (isOccupied(position) && !isOccupiedByGrass(position)) {
            return false;
        }
        if (isOccupiedByGrass(position)) {
            fillGrassField(1);
            boolean flag = true;
            int i = 0;
            while (i < this.grassField.size() || flag) {
                if (position.equals(this.grassField.get(i).positions)) {
                    flag = false;
                    this.grassField.remove(this.grassField.get(i));
                }
                i++;
            }
        }
        this.lowerLeft = new Vector2d(Math.min(position.x, this.lowerLeft.x),Math.min(position.y, this.lowerLeft.y));
        this.upperRight = new Vector2d(Math.max(position.x, this.upperRight.x),Math.max(position.y, this.upperRight.y));
        return true;
    }
    public boolean isOccupiedByGrass(Vector2d position) {
        for (int i = 0; i < grassField.size(); i++) {
            if (grassField.get(i).positions.equals(position)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean isOccupied(Vector2d position) {
        if (isOccupiedByGrass(position)) {
            return true;
        }
        return super.isOccupied(position);
    }
    public String toString() {
        MapVisualizer map = new MapVisualizer(this);
        return map.draw(lowerLeft, upperRight);
    }
}

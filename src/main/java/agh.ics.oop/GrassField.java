package agh.ics.oop;

import java.util.*;

public class GrassField extends AbstractWorldMap{
    int numberOfGrassFields;
    Map<Vector2d,Grass> grassField= new HashMap();
    MapBoundary boundary = new MapBoundary();
    Vector2d lowerLeft;
    Vector2d upperRight;


    public GrassField(int grass) {
        this.lowerLeft = new Vector2d(0,0);
        this.upperRight = new Vector2d(0,0);
        this.numberOfGrassFields = grass;
        fillGrassField(this.numberOfGrassFields);
        updateBoundary();
    }

    public Vector2d getLowerLeft() {
        return lowerLeft;
    }
    public Vector2d getUpperRight() {
        return upperRight;
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
                    this.grassField.put(vec,new Grass(vec));
                    boundary.addPosition(vec);
                    flag = false;
                }
            }
        }
        updateBoundary();
    }
    public Object objectAt(Vector2d position) {
        if (animals.containsKey(position)) {
            return animals.get(position);
        }
        if (grassField.containsKey(position)) {
            return grassField.get(position);
        }
        return null;
    }
    public boolean place(Animal animal) throws IllegalArgumentException {
        if (canMoveTo(animal.vector)) {
            if (isOccupiedByGrass(animal.vector)) {
                animals.put(animal.vector,animal);
                boundary.xAxis.remove(animal.vector);
                boundary.yAxis.remove(animal.vector);
                fillGrassField(1);
                boolean flag = true;
                int i = 0;
                while (i < this.grassField.size() || flag) {
                    if (this.grassField.containsKey(animal.vector)) {
                        flag = false;
                        this.grassField.remove(animal.vector);
                    }
                    i++;
                }
            }
            else {
                animals.put(animal.vector,animal);
            }
            animal.addObserver(boundary);
            animal.addObserver(this);
            boundary.addPosition(animal.vector);
            return true;
        }
        else {
            throw new IllegalArgumentException(animal.vector + " is not legal move specification");
        }
    }
    public boolean canMoveTo(Vector2d position){
        if (isOccupied(position) && !isOccupiedByGrass(position)) {
            return false;
        }
        if (isOccupiedByGrass(position)) {
            fillGrassField(1);
            boolean flag = true;
            int i = 0;
            while (i < this.grassField.size() || flag) {
                if (this.grassField.containsKey(position)) {
                    flag = false;
                    this.grassField.remove(position);
                }
                i++;
            }
        }
        return true;
    }
    void updateBoundary() {
        this.lowerLeft = boundary.getLowerLeft();
        this.upperRight = boundary.getUpperRight();
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        super.positionChanged(oldPosition, newPosition);
        updateBoundary();
    }

    public boolean isOccupiedByGrass(Vector2d position) {
        for (int i = 0; i < grassField.size(); i++) {
            if (grassField.containsKey(position)) {
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

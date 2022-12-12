package agh.ics.oop;

import javafx.scene.image.Image;
import agh.ics.oop.gui.App;
import javax.swing.*;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class Animal implements IMapElement {
    public MapDirection direction;
    protected List<IPositionChangeObserver> observers = new ArrayList<>();
    public Vector2d vector;
    public IWorldMap map;
    public Animal(IWorldMap map) {
        this(map,new Vector2d(2,2));
    }
    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.direction = MapDirection.NORTH;
        this.vector = initialPosition;
    }
    public Animal() {
        this(new RectangularMap(5,5),new Vector2d(2,2));
    }
    public String toString() {
        return this.direction.toString();
    }
    public Vector2d getPosition() {return this.vector;}
    public String getImagePath() {
        switch (this.direction) {
            case EAST:
                return "src/main/resources/left.png";
            case WEST:
                return "src/main/resources/right.png";
            case NORTH:
                return "src/main/resources/down.png";
            case SOUTH:
                return "src/main/resources/up.png";
        }
        return "";
    }
    public boolean isAT(Vector2d position) {
        return this.vector.equals(position);
    }
    void addObserver(IPositionChangeObserver observer) {
        observers.add(observer);
    }
    void positionChanged(Vector2d oldVector, Vector2d newVector) {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).positionChanged(oldVector,newVector);
        }
    }
    void removeObserver(IPositionChangeObserver observer) {
        int ind = 0;
        for (int i = 0; i < observers.size(); i++) {
            if (observers.get(i).equals(observer)) {
                ind = i;
            }
        }
        observers.remove(ind);
    }
    public void move(MoveDirection direction) {
        switch (direction) {
            case LEFT:
                this.direction = this.direction.previous();
                break;
            case RIGHT:
                this.direction = this.direction.next();
                break;
            case FORWARD:
            case BACKWARD:
                int a = -1;
                Vector2d vec;
                if (direction == MoveDirection.FORWARD) {
                    a = 1;
                }
                if (this.direction == MapDirection.SOUTH || this.direction == MapDirection.WEST) {a *= (-1);}
                if (this.direction == MapDirection.NORTH || this.direction == MapDirection.SOUTH) {
                    vec = new Vector2d(this.vector.x, this.vector.y + a);
                } else {
                    vec = new Vector2d(this.vector.x + a, this.vector.y);
                }
                if (map.canMoveTo(vec)) {
                    positionChanged(this.vector,vec);
                    this.vector = vec;
                }
                break;
        }
        System.out.println(map);
    }
    public static void main(String[] args) {
        Animal cat = new Animal();
        List<MoveDirection> lists = OptionsParser.parse(args);
        for (MoveDirection temp: lists) {
            cat.move(temp);
        }
        System.out.println(cat);
    }
}

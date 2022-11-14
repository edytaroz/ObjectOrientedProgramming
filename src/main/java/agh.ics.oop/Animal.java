package agh.ics.oop;

import javax.swing.*;
import java.util.List;

public class Animal {
    public MapDirection direction;
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
    public boolean isAT(Vector2d position) {
        return this.vector.equals(position);
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
                if (this.direction == MapDirection.NORTH) {
                    Vector2d vec = new Vector2d(this.vector.x, this.vector.y + 1);
                    if (map.canMoveTo(vec)) {
                        this.vector = vec;
                    }
                } else if (this.direction == MapDirection.SOUTH){
                    Vector2d vec = new Vector2d(this.vector.x, this.vector.y - 1);
                    if (map.canMoveTo(vec)) {
                        this.vector = vec;
                    }
                } else if (this.direction == MapDirection.EAST){
                    Vector2d vec = new Vector2d(this.vector.x + 1, this.vector.y);
                    if (map.canMoveTo(vec)) {
                        this.vector = vec;
                    }
                } else if (this.direction == MapDirection.WEST){
                    Vector2d vec = new Vector2d(this.vector.x - 1, this.vector.y);
                    if (map.canMoveTo(vec)) {
                        this.vector = vec;
                    }
                }
                break;
            case BACKWARD:
                if (this.direction == MapDirection.NORTH) {
                    Vector2d vec = new Vector2d(this.vector.x, this.vector.y - 1);
                    if (map.canMoveTo(vec)) {
                        this.vector = vec;
                    }
                } else if (this.direction == MapDirection.SOUTH) {
                    Vector2d vec = new Vector2d(this.vector.x, this.vector.y + 1);
                    if (map.canMoveTo(vec)) {
                        this.vector = vec;
                    }
                } else if (this.direction == MapDirection.EAST){
                    Vector2d vec = new Vector2d(this.vector.x - 1, this.vector.y);
                    if (map.canMoveTo(vec)) {
                        this.vector = vec;
                    }
                } else if (this.direction == MapDirection.WEST){
                    Vector2d vec = new Vector2d(this.vector.x + 1, this.vector.y);
                    if (map.canMoveTo(vec)) {
                        this.vector = vec;
                    }
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

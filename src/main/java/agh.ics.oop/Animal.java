package agh.ics.oop;

import java.util.List;

public class Animal {
    public MapDirection direction;
    public Vector2d vector;
    public Animal() {
        this.direction = MapDirection.NORTH;
        this.vector = new Vector2d(2,2);
    }
    public String toString() {
        return this.direction.toString() + this.vector.toString();
    }
    public boolean isAT(Vector2d position) {
        return equals(position);
    }
    public void move(MoveDirection direction) {
        switch (direction) {
            case LEFT:
                switch (this.direction) {
                    case EAST:
                        this.direction = MapDirection.NORTH;
                        break;
                    case WEST:
                        this.direction = MapDirection.SOUTH;
                        break;
                    case NORTH:
                        this.direction = MapDirection.WEST;
                        break;
                    case SOUTH:
                        this.direction = MapDirection.EAST;
                        break;
                    default:
                        break;
                }
                break;
            case RIGHT:
                switch (this.direction) {
                    case EAST:
                        this.direction = MapDirection.SOUTH;
                        break;
                    case WEST:
                        this.direction = MapDirection.NORTH;
                        break;
                    case NORTH:
                        this.direction = MapDirection.EAST;
                        break;
                    case SOUTH:
                        this.direction = MapDirection.WEST;
                        break;
                    default:
                        break;
                }
                break;
            case FORWARD:
                if (this.direction == MapDirection.NORTH) {
                    if (this.vector.y + 1 != 5) {
                        this.vector = new Vector2d(this.vector.x, this.vector.y + 1);
                    }
                } else if (this.direction == MapDirection.SOUTH){
                    if (this.vector.y - 1 != -1) {
                        this.vector = new Vector2d(this.vector.x, this.vector.y - 1);
                    }
                } else if (this.direction == MapDirection.EAST){
                    if (this.vector.x + 1 != 5) {
                        this.vector = new Vector2d(this.vector.x + 1, this.vector.y);
                    }
                } else if (this.direction == MapDirection.WEST){
                    if (this.vector.x - 1 != -1) {
                        this.vector = new Vector2d(this.vector.x - 1, this.vector.y);
                    }
                }
                break;
            case BACKWARD:
                if (this.direction == MapDirection.NORTH) {
                    if (this.vector.y - 1 != -1) {
                        this.vector = new Vector2d(this.vector.x, this.vector.y - 1);
                    }
                } else if (this.direction == MapDirection.SOUTH) {
                    if (this.vector.y + 1 != 5) {
                        this.vector = new Vector2d(this.vector.x, this.vector.y + 1);
                    }
                } else if (this.direction == MapDirection.EAST){
                if (this.vector.x - 1 != -1) {
                    this.vector = new Vector2d(this.vector.x - 1, this.vector.y);
                }
                } else if (this.direction == MapDirection.WEST){
                    if (this.vector.x + 1 != 5) {
                        this.vector = new Vector2d(this.vector.x + 1, this.vector.y);
                    }
                }
                break;
        }
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

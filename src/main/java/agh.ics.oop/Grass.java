package agh.ics.oop;

public class Grass implements IMapElement {
    public Vector2d vector;
    public Grass(Vector2d position) {
        this.vector = position;
    }
    public Vector2d getPosition() {
        return this.vector;
    }
    public String getImagePath() {return "src/main/resources/grass.png";}

    public String toString() {
        return "*";
    }
}

package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Grass {
    public Vector2d positions;
    public Grass(Vector2d position) {
        this.positions = position;
    }
    Vector2d getPosition() {
        return this.positions;
    }
    @Override
    public String toString() {
        return "*";
    }
}

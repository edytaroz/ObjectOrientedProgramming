package agh.ics.oop;
import java.util.Objects;
public class Vector2d {
    public final int x;
    public final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    boolean precedes(Vector2d other) {
        if (this.x <= other.x && this.y <= other.y) {
            return true;
        } else {
            return false;
        }
    }

    boolean follows(Vector2d other) {
        if (this.x >= other.x && this.y >= other.y) {
            return true;
        } else {
            return false;
        }
    }

    Vector2d add(Vector2d other) {
        int x = other.x + this.x;
        int y = other.y + this.y;
        Vector2d vector_other = new Vector2d(x, y);
        return vector_other;
    }

    Vector2d subtract(Vector2d other) {
        int x = other.x - this.x;
        int y = other.y - this.y;
        Vector2d vector_other = new Vector2d(x, y);
        return vector_other;
    }

    Vector2d upperRight(Vector2d other) {
        int x = Math.max(other.x, this.x);
        int y = Math.max(other.y, this.y);
        Vector2d vector_other = new Vector2d(x, y);
        return vector_other;
    }

    Vector2d lowerLeft(Vector2d other) {
        int x = Math.min(other.x, this.x);
        int y = Math.min(other.y, this.y);
        Vector2d vector_other = new Vector2d(x, y);
        return vector_other;
    }

    Vector2d opposite() {
        Vector2d vector_other = new Vector2d(-this.x, -this.y);
        return vector_other;
    }
    //@Override

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Vector2d)) {
            return false;
        }
        Vector2d that = (Vector2d) other;
        return that.x == this.x && that.y == this.y;
    }
    public static void main (String[] args) {
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.x,this.y);
    }
}



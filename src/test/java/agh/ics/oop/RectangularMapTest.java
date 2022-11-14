package agh.ics.oop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {
    @Test
    public void isOccupiedTest () {
        IWorldMap map = new RectangularMap(10, 5);
        Animal sloth = new Animal(map,new Vector2d(3,4));
        map.place(sloth);
        Animal cat = new Animal(map,new Vector2d(2,2));
        map.place(cat);
        Animal rat = new Animal(map,new Vector2d(1,3));
        map.place(rat);
        assertTrue(map.isOccupied(new Vector2d(2,2)));
        assertTrue(map.isOccupied(new Vector2d(3,4)));
        assertFalse(map.isOccupied(new Vector2d(1,4)));
    }
    @Test
    public void canMoveToTest() {
        IWorldMap map = new RectangularMap(10, 5);
        Animal sloth = new Animal(map,new Vector2d(3,4));
        map.place(sloth);
        Animal cat = new Animal(map,new Vector2d(3,3));
        map.place(cat);
        Animal rat = new Animal(map,new Vector2d(5,5));
        map.place(rat);
        assertFalse(map.canMoveTo(new Vector2d(3,4)));
        assertFalse(map.canMoveTo(new Vector2d(5,6)));
        assertTrue(map.canMoveTo(new Vector2d(1,2)));
    }
    @Test
    public void placeAndObjectAtTest() {
        IWorldMap map = new RectangularMap(10, 5);
        Animal sloth = new Animal(map,new Vector2d(3,4));
        map.place(sloth);
        assertEquals(sloth,map.objectAt(new Vector2d(3,4)));
    }
}

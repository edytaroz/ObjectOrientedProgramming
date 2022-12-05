package agh.ics.oop;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GrassFieldTest {
    @Test
    public void placeAndCanMoveToTest () {
        IWorldMap map = new GrassField(10);
        Animal sloth = new Animal(map,new Vector2d(2,2));
        Animal cat = new Animal(map,new Vector2d(2,2));
        Animal dog = new Animal(map,new Vector2d(3,2));
        map.place(sloth);
        assertTrue(map.place(dog));
        assertThrows(IllegalArgumentException.class,()->map.place(cat));
        //assertFalse(map.place(cat));

    }
    @Test
    public void isOccupiedTest() {
        IWorldMap map = new GrassField(10);
        Animal sloth = new Animal(map,new Vector2d(2,2));
        Animal cat = new Animal(map,new Vector2d(2,2));
        map.place(sloth);
        assertTrue(map.isOccupied(cat.vector));
    }
}

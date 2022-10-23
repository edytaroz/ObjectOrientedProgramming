package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapDirectionTest {
    @Test
    public void nextTest () {
        assertEquals(MapDirection.NORTH.next(),MapDirection.EAST);
        assertEquals(MapDirection.EAST.next(),MapDirection.SOUTH);
        assertEquals(MapDirection.SOUTH.next(),MapDirection.WEST);
        assertEquals(MapDirection.WEST.next(),MapDirection.NORTH);
    }
    @Test
    public void prevoiusTest() {
        assertEquals(MapDirection.NORTH.previous(),MapDirection.WEST);
        assertEquals(MapDirection.EAST.previous(),MapDirection.NORTH);
        assertEquals(MapDirection.SOUTH.previous(),MapDirection.EAST);
        assertEquals(MapDirection.WEST.previous(),MapDirection.SOUTH);
    }
    @Test
    public void toStringTest() {
        assertEquals(MapDirection.NORTH.toString(),"Północ");
        assertEquals(MapDirection.EAST.toString(),"Wschód");
        assertEquals(MapDirection.SOUTH.toString(),"Południe");
        assertEquals(MapDirection.WEST.toString(),"Zachód");
    }
}

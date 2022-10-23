package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Vector2dTest {
    @Test
    public void toStringTest() {
        assertEquals(new Vector2d(2,3).toString(),"(2,3)");
    }
    @Test
    public void equalsTest() {
        Assertions.assertTrue(new Vector2d(1,5).equals(new Vector2d(1,5)));
        Assertions.assertFalse(new Vector2d(2,4).equals(new Vector2d(1,5)));
    }
    @Test
    public void precedesTest() {
        Assertions.assertTrue(new Vector2d(1,5).precedes(new Vector2d(1,5)));
        Assertions.assertFalse(new Vector2d(2,6).precedes(new Vector2d(1,4)));
        Assertions.assertTrue(new Vector2d(1,5).precedes(new Vector2d(2,6)));
    }
    @Test
    public void followsTest() {
        Assertions.assertTrue(new Vector2d(1,5).follows(new Vector2d(1,5)));
        Assertions.assertTrue(new Vector2d(2,6).follows(new Vector2d(1,4)));
        Assertions.assertFalse(new Vector2d(1,5).follows(new Vector2d(2,6)));
    }
    @Test
    public void upperRightTest () {
        assertEquals(new Vector2d(1,5).upperRight(new Vector2d(3,4)),new Vector2d(3,5));
    }
    @Test
    public void lowerLeftTest () {
        assertEquals(new Vector2d(11,2).lowerLeft(new Vector2d(3,4)),new Vector2d(3,2));
    }
    @Test
    public void oppositeTest () {
        assertEquals(new Vector2d(1,2).opposite(),new Vector2d(-1,-2));
    }
    @Test
    public void addTest () {
        assertEquals(new Vector2d(1,2).add(new Vector2d(3,4)),new Vector2d(4,6));
    }
    @Test
    public void subtractTest () {
        assertEquals(new Vector2d(1,2).subtract(new Vector2d(3,4)),new Vector2d(2,2));
    }
}
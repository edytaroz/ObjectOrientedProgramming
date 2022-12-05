package agh.ics.oop;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AnimalTest {
    @Test
    public void toStringTest () {
        Animal cat = new Animal();
        assertEquals(cat.toString(),"N");
    }
    @Test
    public void isATest() {
        Animal sloth = new Animal();
        Animal cat = new Animal();
        assertEquals(sloth.isAT(cat.vector),true);
    }
    @Test
    public void moveTest() {
        String[] str = {"f","f","f","l","b","right"};
        List<MoveDirection> list1 = OptionsParser.parse(str);
        Animal sloth = new Animal();
        sloth.move(list1.get(0));
        assertEquals(sloth.toString(),"N");
        sloth.move(list1.get(1));
        assertEquals(sloth.toString(),"N");
        sloth.move(list1.get(2));
        assertEquals(sloth.toString(),"N");
        sloth.move(list1.get(3));
        assertEquals(sloth.toString(),"W");
        sloth.move(list1.get(4));
        assertEquals(sloth.toString(),"W");
        sloth.move(list1.get(5));
        assertEquals(sloth.toString(),"N");
    }
    @Test
    public void exceptionTest() {
        String[] str1 = {"f","f","f","l","n","b","right"};
        assertThrows(IllegalArgumentException.class,()->OptionsParser.parse(str1));
    }
}

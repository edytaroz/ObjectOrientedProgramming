package agh.ics.oop;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {
    @Test
    public void toStringTest () {
        Animal cat = new Animal();
        assertEquals(cat.toString(),"Północ(2,2)");
    }
    @Test
    public void moveTest() {
        String[] str = {"f","f","f","l","n","b"};
        List<MoveDirection> list1 = OptionsParser.parse(str);
        Animal sloth = new Animal();
        sloth.move(list1.get(0));
        assertEquals(sloth.toString(),"Północ(2,3)");
        sloth.move(list1.get(1));
        assertEquals(sloth.toString(),"Północ(2,4)");
        sloth.move(list1.get(2));
        assertEquals(sloth.toString(),"Północ(2,4)");
        sloth.move(list1.get(3));
        assertEquals(sloth.toString(),"Zachód(2,4)");
        sloth.move(list1.get(4));
        assertEquals(sloth.toString(),"Zachód(3,4)");
    }
}

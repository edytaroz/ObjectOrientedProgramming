package agh.ics.oop;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class World {
    public static void main(String[] args) {
        System.out.println("System started working");
        //Direction[] direction = getData(args);
        //run(direction);
        //Animal sloth = new Animal();
        //System.out.println(sloth);
        JFrame frame = new JFrame("Animals");
        List<MoveDirection> directions = OptionsParser.parse(args);
        //IWorldMap map = new RectangularMap(10, 5);
        IWorldMap map = new GrassField(10);
        System.out.println(map);
        List<Vector2d> positions = new ArrayList<>();
        positions.add(new Vector2d(2,2));
        positions.add(new Vector2d(3,4));
        IEngine engine = new SimulationEngine(directions, map, positions);
        System.out.println(map);
        engine.run();
        System.out.println(map);
        System.out.println("System finished working");
    }
    public static void run(Direction[] direction) {
        for (int i = 0; i < direction.length; i++) {
            Direction arguments = direction[i];
            switch (arguments) {
                case FORWARD:
                    System.out.println("Zwierzak idzie do przodu");
                    break;
                case BACKWARD:
                    System.out.println("Zwierzak idzie do tyłu");
                    break;
                case RIGHT:
                    System.out.println("Zwierzak skręca w prawo");
                    break;
                case LEFT:
                    System.out.println("Zwierzak skręca w lewo");
                    break;
            }
        }
    }
    public static Direction[] getData(String[] args) {
        Direction[] direction = new Direction[args.length];
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "f":
                    direction[i] = Direction.FORWARD;
                    break;
                case "b":
                    direction[i] = Direction.BACKWARD;
                    break;
                case "l":
                    direction[i] = Direction.LEFT;
                    break;
                case "r":
                    direction[i] = Direction.RIGHT;
                    break;
                default:
                    System.out.println("Entered incorrect direction");
                    break;
            }
        }
        return direction;
    }
}

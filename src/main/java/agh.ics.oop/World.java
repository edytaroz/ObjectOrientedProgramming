package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        System.out.println("System started working");
        Direction[] direction = getData(args);
        run(direction);
        Animal sloth = new Animal();
        System.out.println(sloth);
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

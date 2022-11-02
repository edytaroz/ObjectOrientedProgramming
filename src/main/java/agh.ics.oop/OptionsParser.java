package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    public static List<MoveDirection> parse(String[] str) {
        List<MoveDirection> lists = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            switch(str[i]) {
                case "f":
                case "forward":
                    lists.add(MoveDirection.FORWARD);
                    break;
                case "b":
                case "backward":
                    lists.add(MoveDirection.BACKWARD);
                    break;
                case "r":
                case "right":
                    lists.add(MoveDirection.RIGHT);
                    break;
                case "l":
                case "left":
                    lists.add(MoveDirection.LEFT);
                    break;
                default:
                    continue;
            }
        }
        return lists;
    }
}

package agh.ics.oop;

import javax.swing.*;
import javax.swing.text.Position;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine {
    IWorldMap map;
    List<MoveDirection> moves;
    List<Animal> animals;

    public SimulationEngine(List<MoveDirection> moves,IWorldMap map,List<Vector2d> positions) {
        this.map = map;
        this.moves = moves;
        this.animals = new ArrayList<>();
        if (positions.size() > 0) {
            for (int i = 0; i < positions.size(); i++) {
                Animal hedgehog = new Animal(map,positions.get(i));
                if (this.map.place(hedgehog)) {
                    this.animals.add(hedgehog);
                }
            }
        }
    }

    public void run() {
        JFrame frame = new JFrame("Animals");
        frame.setSize(300,300);
        JTextPane t = new JTextPane();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        t.setText(map.toString());
        frame.add(t);
        frame.setVisible(true);
        try {
            Thread.sleep(500);
        }
        catch(Exception InterruptedException) {
            System.out.println("Thread exception");
        }
        for (int i = 0; i < moves.size(); i++) {
            animals.get(i%animals.size()).move(moves.get(i));
            t.setText(map.toString());
            frame.add(t);
            frame.setVisible(true);
            try {
                Thread.sleep(500);
            }
            catch(Exception InterruptedException) {
                System.out.println("Thread exception");
            }
        }
    }
}

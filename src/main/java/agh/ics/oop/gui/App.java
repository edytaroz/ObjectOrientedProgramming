package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class App extends Application {
    Vector2d lowerLeft;
    Vector2d upperRight;
    IWorldMap map;
    List<Vector2d> positions;
    List<MoveDirection> directions;
    IEngine engine;
    GridPane grid;
    public void start(Stage primaryStage) {
        Label label = new Label("Zwierzak");
        grid = new GridPane();
        GridPane.setHalignment(label, HPos.CENTER);
        drawHeader();
        drawObjects();
        set_column_and_row_constrain();
        grid.setGridLinesVisible(true);
        Scene scene = new Scene(grid);
        engine.run();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void init() throws IllegalArgumentException {
        try {
            directions = OptionsParser.parse(getParameters().getRaw());
            map = new GrassField(10);
            positions = new ArrayList<>();
            positions.add(new Vector2d(2, 2));
            positions.add(new Vector2d(3, 4));
            engine = new SimulationEngine(directions, map, positions);

            lowerLeft = map.getLowerLeft();
            upperRight = map.getUpperRight();
        } catch (IllegalArgumentException e) {System.out.println(e.getMessage());}
    }
    void drawHeader() {
        Label label = new Label(" y\\x ");
        int a = 1;
        GridPane.setHalignment(label, HPos.CENTER);
        grid.add(label,0,0);
        for (int j = lowerLeft.x; j < upperRight.x + 1; j++) {
            label = new Label(String.format("%2d", j));
            GridPane.setHalignment(label, HPos.CENTER);
            grid.add(label,a,0);
            a += 1;
        }
        a = 1;
        for (int j = lowerLeft.y; j < upperRight.y + 1; j++) {
            label = new Label(String.format("%2d", j));
            GridPane.setHalignment(label, HPos.CENTER);
            grid.add(label,0,a);
            a += 1;
        }
    }
    void drawObjects() {
        Label label;
        int a = 0;
        int b = 0;
        if (lowerLeft.x == 0) {a = 1;}
        if (lowerLeft.y == 0) {b = 1;}
        for (int i = lowerLeft.x; i < upperRight.x + 1; i++) {
            for(int j = lowerLeft.y; j < upperRight.y + 1; j++) {
                if (map.isOccupied(new Vector2d(i,j))) {
                    label = new Label(map.objectAt(new Vector2d(i,j)).toString());
                    GridPane.setHalignment(label, HPos.CENTER);
                    grid.add(label,i - lowerLeft.x + 1,j - lowerLeft.y + 1);
                }
            }
        }

    }
    void set_column_and_row_constrain() {
        for (int i = lowerLeft.x; i < upperRight.x + 1; i++) {
            grid.getColumnConstraints().add(new ColumnConstraints());
        }
        for (int i = lowerLeft.y; i < upperRight.y + 1; i++) {
            grid.getRowConstraints().add(new RowConstraints());
        }
    }
}

package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class App extends Application{
    public Vector2d lowerLeft;
    public Vector2d upperRight;
    public IWorldMap map;
    public List<Vector2d> positions;
    public List<MoveDirection> directions;
    public IEngine engine;
    public GridPane grid;
    int moveDelay = 300;
    public void start(Stage primaryStage) {
        Label label = new Label("Zwierzak");
        grid = new GridPane();
        Button button = new Button("Start");
        HBox hBox = new HBox(button);
        hBox.setAlignment(Pos.CENTER);
        TextField textField = new TextField();
        VBox vbox = new VBox(textField,grid,hBox);
        GridPane.setHalignment(label, HPos.CENTER);
        engine = new SimulationEngine(map, positions,this);
        button.setOnAction(action -> {
            String[] str = textField.getText().split(" ");
            engine.setDirections(OptionsParser.parse(str));
            Thread thread = new Thread();
            thread.start();
            engine.run();
        });
        drawHeader();
        drawObjects();
        set_column_and_row_constrain();
        grid.setGridLinesVisible(true);
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.show();
        //engine.run();
    }


    @Override
    public void init() throws IllegalArgumentException {
        try {
            directions = OptionsParser.parse(getParameters().getRaw());
            map = new GrassField(10);
            positions = new ArrayList<>();
            positions.add(new Vector2d(2, 2));
            positions.add(new Vector2d(3, 4));
            //engine = new SimulationEngine(map, positions,this);

            lowerLeft = map.getLowerLeft();
            upperRight = map.getUpperRight();
        } catch (IllegalArgumentException e) {System.out.println(e.getMessage());}
    }
    public void update(){
        grid.setGridLinesVisible(false);
        grid.getChildren().clear();
        lowerLeft = map.getLowerLeft();
        upperRight = map.getUpperRight();
        set_column_and_row_constrain();
        drawHeader();
        drawObjects();
        grid.setGridLinesVisible(true);
        Platform.runLater(()->{
            grid.setGridLinesVisible(false);
            grid.getChildren().clear();
            grid.getColumnConstraints().clear();
            grid.getRowConstraints().clear();
            lowerLeft = map.getLowerLeft();
            upperRight = map.getUpperRight();
            set_column_and_row_constrain();
            drawHeader();
            drawObjects();
            grid.setGridLinesVisible(true);
            //app.update();
            try {
                Thread.sleep(moveDelay);
            }
            catch(Exception InterruptedException) {
                System.out.println("Thread exception");
            }
        });

    }
    public void drawHeader() {
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
    public void drawObjects() {
        for (int i = lowerLeft.x; i < upperRight.x + 1; i++) {
            for(int j = lowerLeft.y; j < upperRight.y + 1; j++) {
                if (map.isOccupied(new Vector2d(i,j))) {
                    GuiElementBox elementBox = new GuiElementBox((IMapElement) map.objectAt(new Vector2d(i,j)));
                    GridPane.setHalignment(elementBox.getGui(), HPos.CENTER);
                    grid.add(elementBox.getGui(),i - lowerLeft.x + 1,j - lowerLeft.y + 1);
                }
            }
        }

    }
    public void set_column_and_row_constrain() {
        for (int i = lowerLeft.x; i < upperRight.x + 1; i++) {
            grid.getColumnConstraints().add(new ColumnConstraints(30));
        }
        for (int i = lowerLeft.y; i < upperRight.y + 1; i++) {
            grid.getRowConstraints().add(new RowConstraints(40));
        }
    }
}

package agh.ics.oop;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SimulationEngineTest {
    @Test
    public void runTest() {
        List<MoveDirection> moves = new ArrayList<>();
        List<Vector2d> positions = new ArrayList<>();
        IWorldMap map = new RectangularMap(10, 5);
        moves.add(MoveDirection.FORWARD);
        moves.add(MoveDirection.FORWARD);
        moves.add(MoveDirection.LEFT);
        moves.add(MoveDirection.BACKWARD);
        positions.add(new Vector2d(2,2));
        positions.add(new Vector2d(3,4));
        SimulationEngine simulationEngine = new SimulationEngine(moves,map,positions);
        simulationEngine.run();
        assertTrue(map.isOccupied(new Vector2d(2,3)));
        assertTrue(map.isOccupied(new Vector2d(3,4)));
    }
}

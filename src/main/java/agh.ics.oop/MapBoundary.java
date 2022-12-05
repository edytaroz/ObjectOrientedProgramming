package agh.ics.oop;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.SortedSet;

public class MapBoundary implements IPositionChangeObserver{
    SortedSet<Vector2d> xAxis = new TreeSet<>(Comparator.comparing(Vector2d::getX));
    SortedSet<Vector2d> yAxis = new TreeSet<>(Comparator.comparing(Vector2d::getY));
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        xAxis.add(newPosition);
        yAxis.add(newPosition);
        xAxis.remove(oldPosition);
        yAxis.remove(oldPosition);

    }
    public Vector2d getLowerLeft() {
        return new Vector2d(xAxis.first().x,yAxis.first().y);
    }
    public Vector2d getUpperRight() {
        return new Vector2d(xAxis.last().x,yAxis.last().y);
    }
    public void addPosition(Vector2d position) {
        xAxis.add(position);
        yAxis.add(position);
    }
}

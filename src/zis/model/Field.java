package zis.model;

import zis.model.exceptions.InvalidPointException;
import java.awt.*;

public class Field {
    private static final int FIELDSIZE = 3;
    private static final int MINCOORDINATE = 0;
    private final Figure[][] field = new Figure[FIELDSIZE][FIELDSIZE];

    public int getSize() {
        return FIELDSIZE;
    }
    public Figure getFigure(final Point point) throws InvalidPointException {
        if(checkCoordinate(point)) {
            throw new InvalidPointException();
        }
        return field[point.x][point.y];
    }
    public void setFigure(final Point point, final Figure figure) throws InvalidPointException {
        if(checkCoordinate(point)) {
            throw new InvalidPointException();
        }
        field[point.x][point.y] = figure;
    }
    private boolean checkCoordinate(Point point) {
        return point.x >= FIELDSIZE || point.x < MINCOORDINATE || point.y >= FIELDSIZE || point.y < MINCOORDINATE;
    }
}

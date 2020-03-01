package zis.model;

import zis.model.exceptions.InvalidPointException;
import java.awt.*;

public class Field {
    private static final int MINCOORDINATE = 0;
    private final Figure[][] field;
    private final int fieldSize;

    public Field(final int fieldSize) {
        this.fieldSize = fieldSize;
        field = new Figure[fieldSize][fieldSize];
    }


    public int getSize() {
        return fieldSize;
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
        return point.x >= fieldSize || point.x < MINCOORDINATE || point.y >= fieldSize || point.y < MINCOORDINATE;
    }
}

package zis.model;

import java.awt.*;

public class Field {
    private static final int FIELDSIZE = 3;
    private final Figure[][] field = new Figure[FIELDSIZE][FIELDSIZE];

    public int getSize() {
        return FIELDSIZE;
    }
    public Figure getFigure(final Point point) {
        return field[point.x][point.y];
    }
    public void setFigure(final Point point, final Figure figure) {
        field[point.x][point.y] = figure;
    }
}

package zis.controllers;

import zis.model.Field;
import zis.model.Figure;
import zis.model.exceptions.InvalidPointException;

import java.awt.*;

public class CurrentMoveController {

    public Figure currentMove(final Field field) {
        int countFigure = 0;
        for(int x = 0; x < field.getSize(); x++) {
            countFigure += countFigureInTheRow(field, x);
        }
        if(countFigure == field.getSize() * field.getSize()) return null;
        if(countFigure % 2 == 0) return Figure.X;
        return Figure.O;
    }
    private int countFigureInTheRow(final Field field, final int row) {
        int countFigure = 0;
        for(int x = 0; x < field.getSize(); x++) {
            try {
                if (field.getFigure(new Point(x, row)) != null)
                    countFigure++;
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
        }
        return countFigure;
        }
}
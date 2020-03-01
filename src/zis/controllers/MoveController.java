package zis.controllers;

import zis.model.Field;
import zis.model.Figure;
import zis.model.exceptions.AlreadyOccupiedException;
import zis.model.exceptions.InvalidPointException;

import java.awt.*;

public class MoveController {
    public void applyFigure(final Field field,
                            final Figure figure,
                            final Point point) throws InvalidPointException, AlreadyOccupiedException {
        if(field.getFigure(point) != null) {
            throw new AlreadyOccupiedException();
        }
        field.setFigure(point, figure);
    }
}
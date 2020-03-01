package zis.controllers;

import zis.model.Field;
import zis.model.Figure;
import zis.model.exceptions.InvalidPointException;
import java.awt.*;

public class WinnerController {

    public Figure getWinner(final Field field) {
        try {
            for (int i = 0; i < 3; i++)
                if (checkWinner(field, new Point(i, 0), p -> new Point(p.x, p.y + 1)))
                    return field.getFigure(new Point(i, 0));

            for (int i = 0; i < 3; i++)
                if (checkWinner(field, new Point(0, i), p -> new Point(p.x + 1, p.y)))
                    return field.getFigure(new Point(0, i));

            if (checkWinner(field, new Point(0, 0), p -> new Point(p.x + 1, p.y + 1)))
                return field.getFigure(new Point(0, 0));

            if (checkWinner(field, new Point(0, 2), p -> new Point(p.x + 1, p.y - 1)))
                return field.getFigure(new Point(1, 1));

        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return null;
    }
    private boolean checkWinner(final Field field, final Point currentPoint, final IPointGenerator pointGenerator) {
        final Figure currentFigure;
        final Figure nextFigure;
        final Point nextPoint = pointGenerator.next(currentPoint);
        try {
            currentFigure = field.getFigure(currentPoint);
            if(currentFigure == null) return false;
            nextFigure = field.getFigure(nextPoint);
        } catch (InvalidPointException e) {
            return true;
        }
            if(currentFigure != nextFigure) return false;
        return checkWinner(field, nextPoint, pointGenerator);
    }

    private interface IPointGenerator {
        Point next(final Point point);
    }
}

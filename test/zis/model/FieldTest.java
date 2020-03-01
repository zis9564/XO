package zis.model;

import org.junit.Test;
import zis.model.exceptions.AlreadyOccupiedException;
import zis.model.exceptions.InvalidPointException;

import java.awt.*;

import static org.junit.Assert.*;

public class FieldTest {

    @Test
    public void getSize() {
        final int expectedFieldSize = 3;
        Field field = new Field();
        final int actualFieldSize = field.getSize();
        assertEquals(expectedFieldSize, actualFieldSize);
    }

    @Test
    public void setFigure() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(1, 1);
        final Figure inputFigure = Figure.X;
        field.setFigure(inputPoint, inputFigure);
        assertEquals(inputFigure, field.getFigure(inputPoint));
    }

    @Test
    public void getFigureOfEmptyPoint() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(1, 1);
        final Figure actualFigure = field.getFigure(inputPoint);
        assertNull(actualFigure);
    }

    @Test
    public void getFigureWhenXLessThanZero() {
        final Field field = new Field();
        final Point wrongXPoint = new Point(-1, 1);
        try{
            field.getFigure(wrongXPoint);
            fail();
        } catch (InvalidPointException e) {
            System.out.println("X is less than 0");
        }
    }

    @Test
    public void getFigureWhenXMoreThanFieldSize() {
        final Field field = new Field();
        final Point wrongXPoint = new Point(field.getSize() + 1, 1);
        try {
            field.getFigure(wrongXPoint);
            fail();
        } catch (InvalidPointException e) {
            System.out.println("X is more than field size");
        }
    }

    @Test
    public void getFigureWhenYLessThanZero() {
        final Field field = new Field();
        final Point wrongYPoint = new Point(1, -1);
        try {
            field.getFigure(wrongYPoint);
            fail();
        } catch (InvalidPointException e) {
            System.out.println("Y is less than 0");
        }
    }

    @Test
    public void getFigureWhenYMoreThanFieldSize() {
        final Field field = new Field();
        final Point wrongYPoint = new Point(1, field.getSize() + 1);
        try {
            field.getFigure(wrongYPoint);
            fail();
        } catch (InvalidPointException e) {
            System.out.println("Y is more than field size");
        }
    }

    @Test
    public void setFigureWhenPointAlreadyOccupied() throws Exception {
        final Field field = new Field();
        final Point point = new Point(1,1);
        final Figure figure = Figure.X;
        field.setFigure(point, figure);
        try {
            field.setFigure(point, Figure.O);
            fail();
        } catch (AlreadyOccupiedException e) {
            System.out.printf("point X%d, Y%d is already occupied \n", point.x, point.y);
        }
    }
}
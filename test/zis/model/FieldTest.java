package zis.model;

import org.junit.Test;

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
    public void setFigure() {
        final Field field = new Field();
        final Point inputPoint = new Point(1, 1);
        final Figure inputFigure = Figure.X;
        field.setFigure(inputPoint, inputFigure);
        assertEquals(field.getFigure(inputPoint), inputFigure);
    }
}
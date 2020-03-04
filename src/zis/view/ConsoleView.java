package zis.view;

import zis.controllers.CurrentMoveController;
import zis.controllers.MoveController;
import zis.controllers.WinnerController;
import zis.model.Field;
import zis.model.Figure;
import zis.model.Game;
import zis.model.exceptions.AlreadyOccupiedException;
import zis.model.exceptions.InvalidPointException;
import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {
    private final CurrentMoveController cmc = new CurrentMoveController();
    private final WinnerController wc = new WinnerController();
    private final MoveController mc = new MoveController();

    public void show(final Game game) {
        System.out.format("Game name: %s\n", game.getGameName());
        final Field field = game.getField();
        for (int x = 0; x < field.getSize(); x++) {
            if(x != 0) {
                lineSeparator();
            }
            printLine(field, x);
        }
    }

    public boolean move(final Game game) {
        final Field field = game.getField();
        final Figure winner = wc.getWinner(field);
        if(winner != null) {
            System.out.format("%s won!\n", winner);
            return false;
        }
        final Figure currentFigure = cmc.currentMove(field);
        if(currentFigure == null) {
            System.out.println("No winner for this field!");
            return false;
        }
        System.out.format("Please enter move point for %s\n", currentFigure);
        final Point point = ascPoint();
        try {
            mc.applyFigure(field, currentFigure, point);
        } catch (final InvalidPointException | AlreadyOccupiedException e) {
            System.out.println("Invalid point!");
        }
        return true;
    }

    private Point ascPoint() {
        return new Point(askCoordinate("X") - 1, askCoordinate("Y") - 1);
    }

    private int askCoordinate(final String coordinateName) {
        System.out.format("Please input %s:", coordinateName);
        final Scanner in = new Scanner(System.in);
        try {
            return in.nextInt();
        } catch (final InputMismatchException e) {
            System.out.println("it is not a number!");
            return askCoordinate(coordinateName);
        }
    }

    private void printLine(final Field field, final int x) {
        for (int y = 0; y < field.getSize(); y++) {
            System.out.print(" ");
            final Figure figure;
            try {
                figure = field.getFigure(new Point(y, x));
            } catch (final InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.print(figure != null ? figure : " ");
            System.out.print(" ");
            if(y != field.getSize() - 1) {
                System.out.print("|");
            }
        }
        System.out.println();
    }

    private void lineSeparator() {
        System.out.println("-----------");
    }
}
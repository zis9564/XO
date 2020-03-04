package zis.view;

import zis.model.Field;
import zis.model.Figure;
import zis.model.Game;
import zis.model.Player;

public class XOCLI {

    public static void main(final String[] args) {
        final String name = "Ivan";
        final String name2 = "Max";
        final String gameName = "XO";
        final Player[] players = new Player[2];
        players[0] = new Player(name, Figure.X);
        players[1] = new Player(name2, Figure.O);
        final Game game = new Game(gameName, players, new Field(3));
        ConsoleView consoleView = new ConsoleView();
        consoleView.show(game);
        while(consoleView.move(game)) {
            consoleView.show(game);
        }
    }
}

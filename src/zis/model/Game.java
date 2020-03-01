package zis.model;

public class Game {
    private final String gameName;
    private final Player[] players;
    private final Field field;

    public Game(String gameName, Player[] players, Field field) {
        this.gameName = gameName;
        this.players = players;
        this.field = field;
    }

    public Player[] getPlayers() {
        return players;
    }
    public Field getField() {
        return field;
    }
    public String getGameName() {
        return gameName;
    }
}

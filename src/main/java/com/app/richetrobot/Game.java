package com.app.richetrobot;

import com.app.richetrobot.Token.Color;
import java.util.HashMap;
import java.util.Random;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Game {
    public static Game context;
    public static int SIZE = 6;
    public static Case[][] board;
    private final HashMap<Color, Token> robots;
    private Token target;
    Token selectedRobot;
    private Game.Status status;
    public StringProperty statusToolTipProperty = new SimpleStringProperty();
    public StringProperty playerNameProperty = new SimpleStringProperty();

    public static void setSIZE(int size) {
        SIZE = size;
    }

    public static void start() {
        if (context != null) {
            throw new RuntimeException("Impossible de lancer plusieurs fois la partie...");
        } else {
            context = new Game();
            context.setStatus(com.app.richetrobot.Game.Status.CHOOSE_ROBOT);
        }
    }

    private Game() {
        board = new Case[SIZE][SIZE];

        this.robots = new HashMap<>();
        this.robots.put(Color.BLUE, new Token(Color.BLUE));
        this.robots.put(Color.RED, new Token(Color.RED));
        this.robots.put(Color.GREEN, new Token(Color.GREEN));
        this.robots.put(Color.YELLOW, new Token(Color.YELLOW));

        Color[] colors = Color.values();
        int randomColorIndex = (new Random()).nextInt(colors.length);
        this.target = new Token(colors[randomColorIndex]);
    }

    public HashMap<Color, Token> getRobots() {
        return this.robots;
    }

    public void processSelectRobot(Color color) {
        if (this.status == com.app.richetrobot.Game.Status.CHOOSE_ROBOT) {
            this.selectedRobot = (Token)this.robots.get(color);
        }

    }
    public enum Status {
        CHOOSE_PLAYER("Cliquez sur le bouton [Jouer]"),
        CHOOSE_ROBOT("Cliquez sur le robot à déplacer"),
        CHOOSE_DIR("Cliquez sur la case destination");
        Status(String toolTip) { this.toolTip = toolTip; }
        private String toolTip;
        public String getToolTip() { return this.toolTip; }
    }

    public Game.Status getStatus() {
        return this.status;
    }

    public void setStatus(Game.Status status) {
        this.status = status;
        StringBuilder statusMessage = new StringBuilder();
        if (this.playerNameProperty.get() != null) {
            statusMessage.append((String)this.playerNameProperty.get());
            statusMessage.append(" : ");
        }

        statusMessage.append(status.getToolTip());
        this.statusToolTipProperty.set(statusMessage.toString());
    }
}

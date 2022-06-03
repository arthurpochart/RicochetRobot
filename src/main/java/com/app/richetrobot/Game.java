package com.app.richetrobot;

import com.app.richetrobot.Token.Color;
import java.util.HashMap;
import java.util.Random;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Game {
    public static Game context;
    public static int SIZE = 16;
    public static Case[][] board;
    public static HashMap<Color, Token> robots;
    public static Token target;
    Token selectedRobot;
    private Game.Status status;
    public StringProperty statusToolTipProperty = new SimpleStringProperty();
    public StringProperty playerNameProperty = new SimpleStringProperty();
    private int players;

    public void setPlayers(int number){
        players = number;
    }
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
    
    public Token getTarget(){
        return this.target;
    }

    public HashMap<Color, Token> getRobots() {
        return this.robots;
    }

    public int[] getDestination(Game.Direction direction){
        int startX = selectedRobot.getX();
        int startY = selectedRobot.getY();


        if(direction == Direction.UP){
            for(int i=startY-1;i>=0;i--){
                //if next tile has a north wall return its position
                if(board[startX][i].containsTarget() && Game.context.selectedRobot.getColor()==Game.target.getColor()){
                    System.out.println("You win!");
                    return new int[] {startX,i};
                }
                if(board[startX][i].containsRobot()){
                    return new int[] {startX,i+1};
                }
                if(board[startX][i].NORTH){
                    return new int[] {startX,i};

                }
            }
        }
        else if(direction == Direction.DOWN){
            for(int i=startY+1;i<16;i++){
                if(board[startX][i].containsTarget()&& Game.context.selectedRobot.getColor()==Game.target.getColor()){
                    System.out.println("You win!");
                    return new int[] {startX,i};
                }
                if(board[startX][i].containsRobot()){
                    return new int[] {startX,i-1};
                }
                //if next tile has a north wall return its position
                if(board[startX][i].SOUTH){
                    return new int[] {startX,i};
                }
            }
        }
        else if(direction == Direction.LEFT){
            for(int i=startX-1;i>=0;i--){
                if(board[i][startY].containsTarget()&& Game.context.selectedRobot.getColor()==Game.target.getColor()){
                    System.out.println("You win!");
                    return new int[] {i,startY};
                }
                if(board[i][startY].containsRobot()){
                    return new int[] {i+1,startY};
                }
                //if next tile has a north wall return its position
                if(board[i][startY].WEST){
                    return new int[] {i,startY};
                }
            }
        }
        else if (direction == Direction.RIGHT){
            for(int i=startX+1;i<16;i++){
                if(board[i][startY].containsTarget()&& Game.context.selectedRobot.getColor()==Game.target.getColor()){
                    return new int[] {i,startY};
                }
                if(board[i][startY].containsRobot()){
                    return new int[] {i-1,startY};
                }
                //if next tile has a north wall return its position
                if(board[i][startY].EAST){
                    return new int[] {i,startY};
                }
            }
        }
        return new int[] {0,0};
    }

    public void processSelectRobot(Color color) {
        if (this.status == com.app.richetrobot.Game.Status.CHOOSE_ROBOT) {
            this.selectedRobot = (Token)this.robots.get(color);
        }

    }
    public enum Direction{LEFT,RIGHT,UP,DOWN}
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

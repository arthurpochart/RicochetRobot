package com.app.richetrobot;

import java.util.Random;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class Token {
    private Node image;
    private int x = (new Random()).nextInt(16);
    private int y = (new Random()).nextInt(16);
    private Color color;

    public Color getColor() { return this.color; }

    public Token(Token.Color color) {
        this.color=color;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public Node getImage() {
        return this.image;
    }

    public enum Color {RED, GREEN, BLUE, YELLOW}
}

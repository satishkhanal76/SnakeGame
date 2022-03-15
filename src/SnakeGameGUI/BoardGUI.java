package SnakeGameGUI;

import SnakeGame.Board;
import SnakeGame.BoardItem;
import SnakeGame.Game;
import processing.core.PApplet;

public class BoardGUI {


    private Board board;

    public BoardGUI(Board board) {
        this.board = board;
    }

    public void draw(PApplet p) {
        drawGrid(p);
    }

    private void drawGrid(PApplet p) {
        p.stroke(255);
        p.strokeWeight(1);

        drawRows(p);
        drawCols(p);
    }

    private void drawRows(PApplet p) {
        int x1, y1, x2, y2;

        for (int i = 0; i <= Game.NUM_OF_ROWS; i++) {
            x1 = 0;
            y1 = i * GameGUI.NUM_OF_PIX_ROW;

            x2 = Game.NUM_OF_COLS * GameGUI.NUM_OF_PIX_COL;
            y2 = i * GameGUI.NUM_OF_PIX_ROW;

            p.line(x1, y1, x2, y2);
        }
    }

    private void drawCols(PApplet p) {
        int x1, y1, x2, y2;

        for (int i = 0; i <= Game.NUM_OF_COLS; i++) {
            x1 = i * GameGUI.NUM_OF_PIX_COL;
            y1 = 0;

            x2 = i * GameGUI.NUM_OF_PIX_COL;
            y2 = Game.NUM_OF_ROWS * GameGUI.NUM_OF_PIX_ROW;

            p.line(x1, y1, x2, y2);
        }
    }

}//BoardGUI

package SnakeGameGUI;

import SnakeGame.Body;
import SnakeGame.Head;
import SnakeGame.Snake;
import processing.core.PApplet;

public class SnakeGUI {

    private Snake snake;

    SnakeGUI(Snake s) {
        snake = s;
    }


    public void draw(PApplet p) {
        p.fill(0, 255, 0);

        drawSnake(p);
    }

    private void drawSnake(PApplet p) {
        Body b = snake.getTail();
        int x, y, w, h;
        while (b.getNext() != null) {
            w = GameGUI.NUM_OF_PIX_COL;
            h = GameGUI.NUM_OF_PIX_ROW;

            x = b.getIndex().getCol() * w;
            y = b.getIndex().getRow() * h;

            p.rect(x, y, w, h);
            b = b.getNext();
        }

        Head snakeHead = snake.getHead();
        w = GameGUI.NUM_OF_PIX_COL;
        h = GameGUI.NUM_OF_PIX_ROW;

        x = snakeHead.getIndex().getCol() * w;
        y = snakeHead.getIndex().getRow() * h;

        p.fill(255, 0, 0);
        p.rect(x, y, w, h);
    }

    public void setSnake(Snake s) {
        snake = s;
    }
}//SnakeGUI

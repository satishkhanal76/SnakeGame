package SnakeGameGUI;

import SnakeGame.Food;
import SnakeGame.Game;
import processing.core.PApplet;

public class FoodGUI {

    private Food food;

    FoodGUI(Food f) {
        food = f;
    }

    public void draw(PApplet p) {
        p.fill(95,0,237);
        int x, y, w, h;
        x = food.currentIndex().getCol() * GameGUI.NUM_OF_PIX_COL;
        y = food.currentIndex().getRow() * GameGUI.NUM_OF_PIX_ROW;
        w = GameGUI.NUM_OF_PIX_COL;
        h = GameGUI.NUM_OF_PIX_ROW;

        p.rect(x, y, w, h);
    }

    public void setFood(Food f) {
        food = f;
    }
}//FoodGUI

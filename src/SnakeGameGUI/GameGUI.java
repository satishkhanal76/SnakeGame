package SnakeGameGUI;

import processing.core.PApplet;

import SnakeGame.Game;

public class GameGUI extends PApplet {
    //Number of pixel for each row
    //to change the number of rows and cols use the Game class
    public static final int NUM_OF_PIX_ROW = 30;
    public static final int NUM_OF_PIX_COL = 30;

    //local variables
    private Game game;

    //GUI variables
    BoardGUI boardGUI;
    SnakeGUI snakeGUI;
    FoodGUI foodGUI;

    public GameGUI() {
        game = new Game();
        boardGUI = new BoardGUI(game.getBoard());
        snakeGUI = new SnakeGUI(game.getSnake());
        foodGUI = new FoodGUI(game.getFood());
    }

    public void resetGame() {
        game.setupGame();
        snakeGUI.setSnake(game.getSnake());
        foodGUI.setFood(game.getFood());
    }

    @Override
    public void settings() {
        size(Game.NUM_OF_COLS * NUM_OF_PIX_COL, Game.NUM_OF_ROWS * NUM_OF_PIX_ROW);
    }

    @Override
    public void draw() {
        background(10);
        boardGUI.draw(this);
        foodGUI.draw(this);
        snakeGUI.draw(this);

        if(game.isGameOver()) {
            textSize(50);
            fill(255, 255, 0);
            textAlign(CENTER);
            text("Game Over!", 0, 0, NUM_OF_PIX_COL * Game.NUM_OF_COLS, NUM_OF_PIX_ROW * Game.NUM_OF_ROWS);
        }
        if(!game.isRunning()) {
            textSize(50);
            fill(255, 255, 0);
            textAlign(CENTER);
            text("Press 'Spacebar' to begin!", 0, 0, NUM_OF_PIX_COL * Game.NUM_OF_COLS, NUM_OF_PIX_ROW * Game.NUM_OF_ROWS);
        }
    }

    @Override
    public void keyPressed() {
        switch (keyCode) {
            case 37:
                game.getSnake().getHead().setDirection(-1, 0);
                break;
            case 38:
                game.getSnake().getHead().setDirection(0,-1);
                break;
            case 39:
                game.getSnake().getHead().setDirection(1, 0);
                break;
            case 40:
                game.getSnake().getHead().setDirection(0,1);
                break;
            default:
                if(!game.isRunning()) {
                    game.start();
                }
                if(game.isGameOver()) {
                    resetGame();
                }
        }
    }

    public static void main(String[] args) {
        PApplet.main("SnakeGameGUI.GameGUI", args);
    }
}//SnakeGame

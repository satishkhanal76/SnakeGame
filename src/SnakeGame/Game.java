package SnakeGame;


public class Game extends GameLoop{
    public static final int NUM_OF_ROWS = 20;
    public static final int NUM_OF_COLS = 30;

    private Board board;
    private Snake snake;
    private Food food;

    private boolean isGameOver;

    public Game() {
        setupGame();
        setUpdatePerSeconds(10);
    }

    public void setupGame() {
        isGameOver = false;
        snake = new Snake(new Index(NUM_OF_ROWS / 3, NUM_OF_COLS / 2));
        food = new Food(new Index(NUM_OF_ROWS / 2, NUM_OF_COLS / 2));
    }

    @Override
    public void update() {
        snake.update(this);
        food.update(this);
    }

    public Board getBoard() {
        return board;
    }
    public Snake getSnake() { return snake; }
    public Food getFood() { return food; }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean b) {
        isGameOver = b;
    }
}//Game

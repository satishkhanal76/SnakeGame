package SnakeGame;


public class Game extends GameLoop{
    public static final int NUM_OF_ROWS = 40;
    public static final int NUM_OF_COLS = 40;

    private Board board;
    private Snake snake;
    private Food food;

    private boolean isGameOver;

    public Game() {
        board = new Board(NUM_OF_ROWS, NUM_OF_COLS);
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

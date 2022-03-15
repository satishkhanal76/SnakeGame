package SnakeGame;

public class Snake {

    private static final int NUM_OF_STARTING_BODY = 2;

    //stores the snake location as a linked-list
    private Body tail; //tail of the snakes body
    private Head head;


    /**
     *
     * @param i The starting index of the snake on the board
     */
    public Snake(Index i) {
        setupSnake(i);
    }

    /**
     * Sets up the Snake
     */
    private void setupSnake(Index i) {
        createHead(i);
        tail = head; //point the head to the tail at the beginning

        for (int j = 0; j < NUM_OF_STARTING_BODY; j++) {
            addBody();
        }
    }

    /**
     * Creates the head of the snake
     * @param i
     */
    private void createHead(Index i) {
        head = new Head(i, null, 1, 0);

    }

    /**
     * Moves the snake
     */
    private void move() {
        //update the head direction
        head.updateCurrentDirection();
        moveBodiesForward(); //move the bodies
    }

    /**
     * Moves the snake by changing the indexes of its bodies and head
     * sets the current body index to the one in front (Starts from the tail of the snake)
     */
    private void moveBodiesForward() {
        Body p = tail;
        Body q = null;

        while (p.getNext() != null) {
            q = p.getNext();

            p.getIndex().setRow(q.getIndex().getRow());
            p.getIndex().setCol(q.getIndex().getCol());
            p = q;
        }

        head.getIndex().setRow(head.getIndex().getRow() + head.getY());
        head.getIndex().setCol(head.getIndex().getCol() + head.getX());
    }

    /**
     * Adds a body to the snake
     */
    public void addBody() {
        int row, col;
        row = tail.getIndex().getRow() - head.getY();
        col = tail.getIndex().getCol() - head.getX();
        tail = new Body(new Index(row, col), tail);
    }

    /**
     * Updates the snake
     * @param game the game object
     */
    public void update(Game game) {
        if(game.isGameOver()) return;

        move();

        if(canEat(game.getFood())) {
            addBody();
            game.getFood().setConsumed(true);
        }

        if(head.isOutOfBounds()) {
            System.out.println("Game Over!!");
            game.setGameOver(true);
        }

        if(head.bitesSelf(tail)) {
            System.out.println("Self Bite");
            game.setGameOver(true);
        }
    }

    private boolean canEat(Food food) {
        return ((head.getIndex().getCol() == food.currentIndex().getCol()) &&
                (head.getIndex().getRow() == food.currentIndex().getRow()));
    }

    /**
     * the tail of the snake
     * @return the tail of the snake
     */
    public Body getTail() {
        return tail;
    }

    /**
     * Head of the snake
     * @return the head of the snake
     */
    public Head getHead() {
        return head;
    }
}//Snake

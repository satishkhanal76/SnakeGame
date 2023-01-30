package SnakeGame;

public class Head extends Body{

    private int x;
    private int y;

    private int nextX;
    private int nextY;

    Head(Index i, Body next, int x, int y) {
        super(i, next);
        nextX = x;
        nextY = y;

        this.x = nextX;
        this.y = nextY;
    }

    public void updateCurrentDirection() {
        x = nextX;
        y = nextY;
    }

    /**
     * Checks if the head of the snake is out of bound
     * @return if the head is out of the board
     */
    public boolean isOutOfBounds() {
        int boardRow, boardCol;

        boardCol = Game.NUM_OF_COLS;
        boardRow = Game.NUM_OF_ROWS;

        if((getCol() > boardCol)
                || (getCol() < 0)
                || (getRow() > boardRow)
                || (getRow() < 0)) {
            return true;
        }
        return false;
    }


    public void setDirection(int x, int y) {
        //if the current direction is the opposite of the one passed in, ignore it
        if((this.x == -(x)) || (this.y == -(y))) return;
        nextX = x;
        nextY = y;
    }
    /**
     * Checks if the snake is biting its body
     * @return if the snake's head overlaps a body part
     *
     */
    public boolean bitesSelf(Body tail) {
        Body p = tail;

        int otherRow, otherCol;

        while (p.getNext() != null) {
            otherCol = p.getIndex().getCol();
            otherRow = p.getIndex().getRow();

            if((getCol() == otherCol) && (getRow() == otherRow)) return true;
            p = p.getNext();
        }

        return false;
    }




    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private void setX(int x) {
        if(this.x == -(x)) return;
        this.x = x;
    }

    private void setY(int y) {
        if(this.y == -(y)) return;
        this.y = y;
    }
}//Head

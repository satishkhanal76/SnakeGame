package SnakeGame;

public class Body {

    private Index at;
    private Body next;


    Body(Index i, Body next) {
        at = i;
        this.next = next;
    }


    public Index getIndex() {
        return at;
    }

    public int getRow() {
        return at.getRow();
    }
    public int getCol() {
        return at.getCol();
    }
    public Body getNext() {
        return next;
    }
}//Body

package SnakeGame;

public class Index {

    private int row;
    private int col;

    Index(int r, int c) {
        row = r;
        col = c;
    }

    public void setRow(int r) {
        row = r;
    }

    public void setCol(int c) {
        col = c;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

}//Index

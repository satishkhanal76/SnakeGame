package SnakeGame;

public class Board {

    private BoardItem[][] grid;


    public Board(int numOfRows, int numOfCols) {
        grid = new BoardItem[numOfRows][numOfCols];
    }

    public void update(Game game) {
    }


    public void placeItem(Index at, BoardItem b) {
        grid[at.getRow()][at.getCol()] = b;
    }

    public BoardItem getItem(Index at) {
        return grid[at.getRow()][at.getCol()];
    }

    public BoardItem[][] getGrid() {
        return grid;
    }

}//Board

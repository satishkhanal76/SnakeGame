package SnakeGame;

public class Food implements BoardItem{

    private Index location;
    private boolean consumed;

    Food(Index i) {
        location = i;
        consumed = false;
    }

    public void update(Game game) {
        if(consumed) {
            consumed = false;
            relocate();
        }
    }

    private void relocate() {
        location = new Index(random(0, Game.NUM_OF_ROWS), random(0, Game.NUM_OF_COLS));
    }

    private int random(int min, int max) {
        return (int) Math.floor((Math.random() * (max - min)) + min);
    }

    @Override
    public Index currentIndex() {
        return location;
    }

    public void setConsumed(boolean b) {
        consumed = b;
    }

    public boolean getConsumed() {
        return consumed;
    }
}//Food

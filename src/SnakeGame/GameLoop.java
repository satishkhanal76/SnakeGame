package SnakeGame;

public class GameLoop implements Runnable {

    private boolean running;
    private double updateRate = 1.0d/60.0d;
    private int frameCount = 0;
    private long nextStatTime;

    private Thread thread;
    private GameLoop parent;

    GameLoop() {
        thread = new Thread(this);
    }

    public void start() {
        thread.start();
    }


    @Override
    public void run() {
        running = true;

        double accumulator = 0;
        long currentTime;
        long lastUpdate = System.currentTimeMillis();

        nextStatTime = System.currentTimeMillis() + 1000;

        double lastRenderTimeSeconds;

        while (running) {
            currentTime = System.currentTimeMillis();
            lastRenderTimeSeconds = (currentTime -  lastUpdate) / 1000d;

            accumulator += lastRenderTimeSeconds;
            lastUpdate = currentTime;

            while (accumulator > updateRate) {
                updateSeconds();
                update();
                accumulator -= updateRate;
            }

            updateStat();
        }

    }

    private void updateSeconds() {
        frameCount++;
    }

    private void updateStat() {
        if(System.currentTimeMillis() > nextStatTime) {
            frameCount = 0;
            nextStatTime = System.currentTimeMillis() + 1000;
        }
    }

    public void update() {}

    public int getFrameCount() {
        return frameCount;
    }

    public boolean isRunning() {
        return running;
    }

    public void setUpdatePerSeconds(double perSeconds) {
        updateRate = 1.0d/perSeconds;
    }
}//GameLoop

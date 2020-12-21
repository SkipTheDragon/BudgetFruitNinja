package FruitNinja.GameEngine;

import FruitNinja.Scenes.Scene;

import java.util.Random;

public abstract class GameLoop {

    protected volatile Status status;

    private Thread gameThread;

    protected Scene scene;

    public GameLoop() {
        status = Status.STOPPED;
    }

    public GameLoop(Scene scene) {
        this();
        this.scene = scene;
    }

    public void run() {
        status = Status.RUNNING;
        gameThread = new Thread(this::process);
        gameThread.start();
    }

    public void stop() {
        status = Status.STOPPED;
    }

    public boolean isGameRunning() {
        return status == Status.RUNNING;
    }

    protected void processInput() {
        try {
            var lag = new Random().nextInt(100) + 50;
            Thread.sleep(lag);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void refreshScene() {
        scene.repaint();
        scene.revalidate();
    }

    protected void process() {
        scene.buildScene();
    }


    enum Status {
        RUNNING, STOPPED
    }

}

package FruitNinja.GameEngine;

import FruitNinja.Scenes.Scene;

public class GameLoop {

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
        scene.buildScene();

        status = Status.RUNNING;
        gameThread = new Thread(this::process);
        gameThread.start();

        scene.handleInput();

    }

    public void stop() {
        status = Status.STOPPED;
    }

    public boolean isGameRunning() {
        return status == Status.RUNNING;
    }

    protected void refreshScene() {
        scene.repaint();
        scene.revalidate();
    }

    protected void process() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while(isGameRunning()) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1) {
                scene.update();
                delta--;
            }
            if(isGameRunning())
                refreshScene();
            frames++;

            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }

        stop();
    };

    enum Status {
        RUNNING, STOPPED
    }

}

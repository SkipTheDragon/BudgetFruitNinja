package FruitNinja.Scenes;

import FruitNinja.Models.Fruit;
import FruitNinja.Models.MovingObject;
import FruitNinja.Models.NeutralMovingObject;

import javax.swing.*;
import java.util.Random;

public abstract class Scene extends JPanel {

    protected volatile Status status;

    private Thread gameThread;

    public Scene() {
        status = Status.STOPPED;
    }

    public void run() {
        status = Status.RUNNING;
        gameThread = new Thread(this::update);
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
            var lag = new Random().nextInt(200) + 50;
            Thread.sleep(lag);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected abstract void update();

    protected void render() {
        repaint();
        revalidate();
    }

    protected void process() {
        while (isGameRunning()) {
            processInput();
            update();
            render();
        }
    }

    public MovingObject getModel(String object) throws NullPointerException {
        if (object.equals("Fruit")) {
            return new Fruit(); // TODO: 16/12/2020 change later
        }
        return null;
    }

    enum Status {
        RUNNING, STOPPED
    }
}

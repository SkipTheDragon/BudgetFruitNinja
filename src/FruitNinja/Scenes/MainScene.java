package FruitNinja.Scenes;

import FruitNinja.Assets.AbstractFactory;
import FruitNinja.Assets.HUD.Elements.StatusBar;
import FruitNinja.Assets.Model.Elements.Fruit;
import FruitNinja.Assets.Model.Elements.MotionElement;
import FruitNinja.Events.MouseInput;
import FruitNinja.Game;
import FruitNinja.GameEngine.GameObject;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.concurrent.ThreadLocalRandom;

// handler
public class MainScene extends Scene {
    public MainScene() {
        this.requestFocus();
    }

    @Override
    public void buildScene() {
        AbstractFactory factory = getFactory("HUD");
        StatusBar statusBar = (StatusBar) factory.create("StatusBar");
        statusBar.setSpawnPoint(new Point(50,50));
        addToScene(statusBar);
        addToScene(MouseInput.swordTrail);
    }


    public void spawner() {
        if (ThreadLocalRandom.current().nextInt(Fruit.spawnProbability + 1) == 0) {
            spawnFruit();
        }
    }

    @Override
    public void update() {
        super.update();
        spawner();
        removeOutsideSceneObjects();

        if (Game.getStatus().getLives() == 0) {
            eventManager.notify("gameEnded");
        }

    }

    public void removeOutsideSceneObjects() {
        objects.removeIf(e -> e instanceof MotionElement && !e.isInsideScene());
    }

    public Point spawnZone(GameObject object) {
        int bound = this.getWidth() - (this.getWidth() / 3);
        int spawn = ThreadLocalRandom.current().nextInt(this.getWidth() / 3, bound);

        return new Point(spawn, (int) (this.getHeight()- object.getHeight()));
    }

    public void spawnFruit() {
        AbstractFactory factory = getFactory("Model");
        Fruit fruit = (Fruit) factory.create("Fruit");

        fruit.setSpawnPoint(spawnZone(fruit));
        fruit.setDecliningSideBySpawnPoint();

        addToScene(fruit);
    }

    @Override
    public void setInput() {
        MouseListener mouseListener = new MouseInput(this);
        this.addMouseListener(mouseListener);
        this.addMouseMotionListener((MouseMotionListener) mouseListener);
    }

    public void handleInput(InputEvent e) {
        for (GameObject object : objects) {
            object.handleInput(e);
        }
    }

}

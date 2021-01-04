package FruitNinja.Scenes;

import FruitNinja.Assets.AbstractFactory;
import FruitNinja.Assets.HUD.Elements.StatusBar;
import FruitNinja.Assets.Model.Elements.Bomb;
import FruitNinja.Assets.Model.Elements.Fruit;
import FruitNinja.Assets.Model.Elements.MotionElement;
import FruitNinja.Events.MouseInput;
import FruitNinja.Game;
import FruitNinja.GameEngine.GameObject;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

// handler
public class MainScene extends Scene {
    ArrayList<MotionElement> spawnableModels = new ArrayList<>(Arrays.asList(new Fruit(), new Bomb()));

    public MainScene() {
        this.requestFocus();
    }

    public void spawner() {
        MotionElement objectToSpawn = spawnableModels.get(ThreadLocalRandom.current().nextInt(0,spawnableModels.size()));
        if (ThreadLocalRandom.current().nextInt(objectToSpawn.getSpawnProbability() + 1) == 0) {
            MotionElement spawnElement = spawnObject(objectToSpawn.toString());
            addToScene(spawnElement);
        }
    }

    public void removeOutsideSceneObjects() {
        objects.removeIf(e -> e instanceof MotionElement && !e.isInsideScene());
    }

    public MotionElement spawnObject(String objectName) {
        AbstractFactory factory = getFactory("Model");
        MotionElement object =(MotionElement) factory.create(objectName);

        object.setSpawnPoint(spawnZone(object));
        object.setDecliningSideBySpawnPoint();

        return object;
    }

    public void handleInput(InputEvent e) {
        for (GameObject object : objects) {
            object.handleInput(e);
        }
    }

    private Point spawnZone(GameObject object) {
        int bound = this.getWidth() - (this.getWidth() / 3);
        int spawn = ThreadLocalRandom.current().nextInt(this.getWidth() / 3, bound);

        return new Point(spawn, (int) (this.getHeight() - object.getHeight()));
    }

    @Override
    public void buildScene() {
        AbstractFactory factory = getFactory("HUD");
        StatusBar statusBar = (StatusBar) factory.create("StatusBar");
        statusBar.setSpawnPoint(new Point(50,50));
        addToScene(statusBar);
        addToScene(MouseInput.swordTrail);
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

    @Override
    public void setInput() {
        MouseListener mouseListener = new MouseInput(this);
        this.addMouseListener(mouseListener);
        this.addMouseMotionListener((MouseMotionListener) mouseListener);
    }
}

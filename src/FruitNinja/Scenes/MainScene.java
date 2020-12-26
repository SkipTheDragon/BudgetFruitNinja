package FruitNinja.Scenes;

import FruitNinja.Assets.AbstractFactory;
import FruitNinja.Assets.Model.Elements.Fruit;
import FruitNinja.Assets.Model.Elements.SwordTrail;
import FruitNinja.GameEngine.GameObject;

import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.concurrent.ThreadLocalRandom;

// handler
public class MainScene extends Scene {
    public MainScene() {
        this.requestFocus();
    }
    //create objects

    @Override
    public void buildScene() {

    }

    public void spawnObject() {
        if (ThreadLocalRandom.current().nextInt(1,howManyIterations) == Fruit.spawnProbability) {
            spawnFruit();
        }
    }

    public void spawner() {
        for (int i = 0; i < howManyIterations + 1; i++) {
            if (i == howManyIterations) {
                spawnObject();
            }
        }
    }

    @Override
    public void update() {
        super.update();
        spawner();

        removeOutsideSceneObjects();
    }

    public void removeOutsideSceneObjects() {
        objects.removeIf(e -> !((Fruit)e).isInsideScene());
    }

    public void spawnFruit() {
        AbstractFactory factory = getFactory("Model");
        Fruit fruit = (Fruit) factory.create("Fruit");
        fruit.setX(ThreadLocalRandom.current().nextInt(this.getWidth()));
        fruit.setY(this.getHeight()- fruit.getHeight());
        addToScene(fruit);
    }

    @Override
    public void handleInput() {
        MouseListener mouseListener = new MouseInput(this);
        this.addMouseListener(mouseListener);
        this.addMouseMotionListener((MouseMotionListener) mouseListener);
    }

    private static class MouseInput extends MouseInputAdapter implements MouseMotionListener {
        Scene scene;
        public static SwordTrail swordTrail = (SwordTrail) getFactory("Model").create("SwordTrail");

        public MouseInput(Scene scene) {
            this.scene = scene;
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if(scene.objects.contains(swordTrail)) {
                swordTrail.clearTrail();
                swordTrail.setX(0);
                swordTrail.setY(0);
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if(!scene.objects.contains(swordTrail)) {
                scene.addToScene(swordTrail);
            }

            swordTrail.setX(e.getX());
            swordTrail.setY(e.getY());

            if(scene.objects.contains(swordTrail)) {
                for (GameObject object : scene.objects) {
                    if (object instanceof Fruit) {
                        Point[] point = MouseInput.swordTrail.getState();
                        if (point[point.length / 2] != null) {
                            Point lastPoint = point[point.length /2];
                            if (object.getBounds().intersects(new Rectangle(lastPoint.x, lastPoint.y, 1, 1))) {
                                ((Fruit) object).cut();
                            }
                        }
                    }
                }
            }

        }

    }

}

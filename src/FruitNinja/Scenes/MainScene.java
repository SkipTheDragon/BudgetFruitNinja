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
        AbstractFactory factory = getFactory("Model");

        for (int i = 0; i < 10; i++) {
            Fruit fruit = (Fruit) factory.create("Fruit");
            fruit.setHeight(50);
            fruit.setWidth(50);
            fruit.setX(ThreadLocalRandom.current().nextInt(this.getWidth()));
            fruit.setY(0);
            fruit.setVelX(ThreadLocalRandom.current().nextInt(5));
            fruit.setVelY(ThreadLocalRandom.current().nextInt(5));
            addToScene(fruit);

        }

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
        public void mousePressed(MouseEvent e) {
            Point pressed = e.getPoint();

          //  scene.objects.removeIf(object -> object.getBounds().intersects(pressed.x, pressed.y,100, 20));

       }

        @Override
        public void mouseReleased(MouseEvent e) {
            if(scene.array.contains(swordTrail)) {
                swordTrail.clearTrail();
                swordTrail.setX(0);
                swordTrail.setY(0);
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if(!scene.array.contains(swordTrail)) {
                scene.addToScene(swordTrail);
            }

            swordTrail.setX(e.getX());
            swordTrail.setY(e.getY());

            if(scene.array.contains(swordTrail)) {
                for (GameObject object : scene.array) {
                    if (object instanceof Fruit) {
                        for (Point point : MouseInput.swordTrail.getState()) {
                            if (point != null) {
                                if (object.getBounds().intersects(new Rectangle(point.x, point.y, 1, 1))) {
                                    ((Fruit) object).cut();
                                }
                            }
                        }
                    }
                }
            }

        }

    }

}

package FruitNinja.Scenes;

import FruitNinja.Assets.AbstractFactory;
import FruitNinja.Assets.Model.Elements.Fruit;
import FruitNinja.Assets.Model.ModelFactory;
import FruitNinja.GameEngine.GameObject;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// handler
public class MainScene extends Scene {

    public MainScene() {
    }
    //create objects
    @Override
    public void buildScene() {
        AbstractFactory factory = getFactory("Model");
        Fruit fruit = (Fruit) factory.create("Fruit");
        fruit.setHeight(50);
        fruit.setWidth(50);
        fruit.setX(20);
        fruit.setY(20);
        fruit.setVelX(5);
        fruit.setVelY(5);

        addToScene(fruit);
    }

    @Override
    public void handleInput() {
        this.addMouseListener(new MouseInput(this));
    }

    private static class MouseInput implements MouseListener {
        Scene scene;

        public MouseInput(Scene scene) {
            this.scene = scene;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("MouseClicked at" + e.getPoint());
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

}

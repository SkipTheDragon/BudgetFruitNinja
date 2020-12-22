package FruitNinja.Scenes;

import FruitNinja.Assets.AbstractFactory;
import FruitNinja.Assets.HUD.HUDFactory;
import FruitNinja.Assets.Model.Elements.Fruit;
import FruitNinja.Assets.Model.ModelFactory;
import FruitNinja.Game;
import FruitNinja.GameEngine.GameObject;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Scene extends JPanel {
    protected final ArrayList<GameObject> objects = new ArrayList<>();

    protected void addToScene(GameObject object) {
        objects.add(object);
    }

    protected void removeFromScene(GameObject object) {
        objects.remove(object);
    }

    public static AbstractFactory getFactory(String choice){

        if("HUD".equalsIgnoreCase(choice)){
            return new HUDFactory();
        }
        else if("Model".equalsIgnoreCase(choice)){
            return new ModelFactory();
        }

        return null;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for (GameObject object : objects) {
            object.draw(g2d);
        }
    }

    public void update() {
        for (GameObject object : objects) {
            object.update();
        }
    }
    public abstract void buildScene();
    public abstract void handleInput();
}

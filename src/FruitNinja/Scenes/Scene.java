package FruitNinja.Scenes;

import FruitNinja.Models.Fruit;
import FruitNinja.Models.MovingObject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class Scene extends JPanel {
    public ArrayList<MovingObject> objects = new ArrayList<>();

    public void addToScene(MovingObject object) {
        objects.add(object);
    }

    // Factory method for MovingObjects
    public MovingObject getModel(String object) throws NullPointerException {
        if (object.equals("Fruit")) {
            return new Fruit();
        }
        return null;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for (MovingObject object : objects) {
            object.draw(g2d);
        }
    }

    abstract public void update(long elapsedTime);
    abstract public void updateAtFixedRate();
    abstract public void buildScene();
}

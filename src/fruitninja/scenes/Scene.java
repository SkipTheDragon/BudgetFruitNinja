package fruitninja.scenes;

import fruitninja.assets.AbstractFactory;
import fruitninja.assets.hud.HUDFactory;
import fruitninja.assets.model.ModelFactory;
import fruitninja.events.EventListener;
import fruitninja.events.EventManager;
import fruitninja.engine.GameObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Scene extends JPanel {
    protected final CopyOnWriteArrayList<GameObject> objects = new CopyOnWriteArrayList<>();
    private int updates = 0;
    protected int minChance = 100;
    protected EventManager<EventListener> eventManager;

    public void addToScene(GameObject object) {
        objects.add(object);
    }

    public void removeFromScene(GameObject object) {
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
        try {
            g.drawImage(ImageIO.read(getClass().getResourceAsStream("/fruitninja/assets/images/bg.png")), 0, 0, getWidth(),getHeight(),null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (GameObject object : objects) {
            object.draw(g2d);
        }
    }

    public void updateCounter() {
        updates++;
        if (updates == 100)
            updates = 0;
    }


    public void update() {
        updateCounter();
        for (GameObject object : objects) {
            if (updates % object.updateRate == 0)
                object.update();
        }
    }

    public abstract void buildScene();
    public abstract void setInput();

    public void passEventManager(EventManager eventManager) {
        this.eventManager = eventManager;
    }
}

package FruitNinja.GameEngine;

import FruitNinja.Window;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class GameObject {
    protected Map<String,Image> textures = new ConcurrentHashMap<>();
    protected float x, y;
    protected float width=50,height=50;
    protected float velX = 1, velY = 1;
    protected Point spawnPoint;
    public int updateRate = 1;
    protected boolean texturesLoaded;
    public void setSpawnPoint(Point spawnPoint) {
        this.spawnPoint = spawnPoint;
        this.x = spawnPoint.x;
        this.y = spawnPoint.y;
    }

    public Point getSpawnPoint() {
        return spawnPoint;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getVelX() {
        return velX;
    }

    public void setVelX(float velX) {
        this.velX = velX;
    }

    public float getVelY() {
        return velY;
    }

    public void setVelY(float velY) {
        this.velY = velY;
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, (int) width, (int)height);
    }

    public boolean isInsideScene() {
        return x <= Window.windowSize.width - width && x >= 0 && y <= Window.windowSize.height + height && y >= 0;
    }

    public Map<String, Image> getTextures() {
        return textures;
    }

    public abstract void setTextures() throws IOException;
    public abstract void draw(Graphics2D g);
    public abstract void update();
    public abstract void handleInput(InputEvent e);

    @Override
    public String toString() {
        String className = this.getClass().toString();
        return className.substring(className.lastIndexOf(".") + 1);
    }
}


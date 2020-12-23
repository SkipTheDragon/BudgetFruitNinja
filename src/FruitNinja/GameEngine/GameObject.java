package FruitNinja.GameEngine;

import java.awt.*;
import java.io.IOException;

public abstract class GameObject {
    protected Image texture = null;
    protected float x, y;
    protected float width,height;
    protected float velX, velY;
    public int updateRate = 1;

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

    public abstract Image getTexture() throws IOException;
    public abstract void draw(Graphics2D g);
    public abstract void update();
}


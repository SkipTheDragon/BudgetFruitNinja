package FruitNinja.Models;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public abstract class MovingObject extends JLabel {
    // object's image representation
    Image img = null;
    // maximum height allowed for the object until it needs to drop back down
    int maxHeight = 0;
    // ration for the object's movement on the X axis
    int declineRation = 0;
    // object's spawn point
    Point spawnPoint;

    private Point location = new Point(30, 50);

    private Dimension proportions = new Dimension(100,100);

    @Override
    public Point getLocation() {
        return location;
    }

    @Override
    public void setLocation(Point location) {
        this.location = location;
    }

    public Dimension getProportions() {
        return proportions;
    }

    public void setProportions(Dimension proportions) {
        this.proportions = proportions;
    }

    @Override
    public int getX() {
        return location.x;
    }

    public void setX(int x) {
        this.setLocation(new Point(x, getLocation().y));
    }

    @Override
    public int getY() {
        return location.y;
    }

    public void setY(int y) {
        this.setLocation(new Point(getLocation().x, y));
    }

    @Override
    public int getWidth() {
        return proportions.width;
    }

    public void setWidth(int width) {
        this.setProportions(new Dimension(width, getProportions().height));
    }

    @Override
    public int getHeight() {
        return proportions.height;
    }

    public void setHeight(int height) {
        this.setProportions(new Dimension(getProportions().width, height));
    }

    public void startMoving() {
        if (getY() < maxHeight) {
            propel();
        } else {
            fall();
        }
    }

    public void propel() {

    }

    public void fall() {

    }

    public void loadImage(String imagePath) throws IOException {
        this.img = ImageIO.read(new File(imagePath));
    }

    public abstract void draw(Graphics2D g);
}


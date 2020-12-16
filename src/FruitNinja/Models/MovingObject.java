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

    void loadImage(String imagePath) throws IOException {
        this.img = ImageIO.read(new File(imagePath));
    }

    public abstract void paint(Graphics g);
}


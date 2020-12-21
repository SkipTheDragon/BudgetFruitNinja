package FruitNinja.Models;

import java.awt.*;

public class Fruit extends NeutralMovingObject {

    public Fruit() {
        System.out.println("Fruit bro");
    }


    // todo delete
    public void move(int x) {
        if (getLocation().x < 100) {
            setX(getX() + 1);
            System.out.println(getLocation());
        }
    }

    @Override
    public void draw(Graphics2D g) {
        super.paintComponent(g);
        g.drawImage(img, getX(), getY(), getWidth(), getHeight(), null);
    }
}

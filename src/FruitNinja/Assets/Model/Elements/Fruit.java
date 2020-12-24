package FruitNinja.Assets.Model.Elements;

import FruitNinja.Assets.Model.ModelFamily;
import FruitNinja.GameEngine.GameObject;
import FruitNinja.Window;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Fruit extends GameObject implements ModelFamily {
    protected boolean isCut = false;

    public Fruit() throws IOException {
        this.texture = getTexture();
    }

    @Override
    public Image getTexture() throws IOException {
        return ImageIO.read(new File("/Users/leonard/Documents/Teme/IP/FruitNinja/src/FruitNinja/Assets/Images/banana.png"));
    }

    @Override
    public void draw(Graphics2D g)  {
        g.drawImage(texture, (int)getX(), (int)getY(), (int)getWidth(), (int)getHeight(), null);
    }

    @Override
    public void update() {
        if (this.isCut || y <= Window.windowSize.height / 2) {
            fall();

        } else {
            propel();
        }
    }

    public void propel() {
       // x += velX;
        y += velY;
        velY += -0.25;
    }

    public void fall() {
        y += velY;
        velY += 0.25;
    }

    public void cut() {
        this.isCut = true;
    }
}

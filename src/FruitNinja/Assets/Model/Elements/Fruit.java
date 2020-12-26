package FruitNinja.Assets.Model.Elements;

import FruitNinja.Assets.Model.ModelFamily;
import FruitNinja.GameEngine.GameObject;
import FruitNinja.Window;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Fruit extends GameObject implements ModelFamily {
    protected boolean isCut = false;
    protected boolean decliningSide = ThreadLocalRandom.current().nextBoolean();
    public static int spawnProbability = 30;
    public States state;

    public enum States {
        FALLING,PROPELING
    }

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
            fall(0.25);
        } else {
            propel(0.25);
        }
    }

    public void propel(double velocityY) {
        y += velY;
        velY += -velocityY;
        if (isInsideScene()) {
            decline(0.005);
        }
        state = States.PROPELING;
    }

    public void fall(double velocityY) {
        y += velY;
        velY += velocityY;

        if (isInsideScene()) {
            decline(0.02);
        }
        state = States.FALLING;
    }

    public void decline(double velocityX) {
        if (decliningSide) {
            x += velX;
        } else {
            x -= velX;
        }
        velX += velocityX;
    }

    public void cut() {
        this.isCut = true;
    }

    public boolean isInsideScene() {
        return x <= Window.windowSize.width - getWidth() && x >= 0 && y <= Window.windowSize.height + getHeight() * 10 && y >= 0;
    }
}

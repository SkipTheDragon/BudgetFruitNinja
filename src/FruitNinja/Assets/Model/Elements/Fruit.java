package FruitNinja.Assets.Model.Elements;

import FruitNinja.GameEngine.GameObject;
import FruitNinja.Assets.Model.ModelFamily;
import FruitNinja.Window;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Fruit extends GameObject implements ModelFamily {

    public Fruit() throws IOException {
        this.texture = getTexture();
        System.out.println("Fruit bro");
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
    public Type getGameObjectType() {
        return null;
    }

    @Override
    public void update() {
        x += velX;
        y += velY;

        if(y <= 0 || y >= Window.windowSize.height/2 - getHeight()) velY *= -1;
        if(x <= 0 || x >= Window.windowSize.width - getWidth()) velX *= -1;
    }
}

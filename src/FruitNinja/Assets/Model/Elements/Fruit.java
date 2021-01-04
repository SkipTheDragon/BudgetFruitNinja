package FruitNinja.Assets.Model.Elements;

import FruitNinja.Assets.Model.ModelFamily;
import FruitNinja.Game;
import FruitNinja.Window;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Fruit extends MotionElement implements ModelFamily {

    public Fruit() throws IOException {
        setTextures();
    }

    @Override
    public void setTextures() throws IOException {
        textures.put("default", ImageIO.read(new File("src/FruitNinja/Assets/Images/banana.png")));
        textures.put("cut", ImageIO.read(new File("src/FruitNinja/Assets/Images/cutBanana.png")));
    }

    @Override
    public void draw(Graphics2D g)  {
        g.drawImage(isCut ? textures.get("cut") : textures.get("default"), (int)getX(), (int)getY(), (int)getWidth(), (int)getHeight(), null);
    }

    @Override
    public void update() {
        if (this.isCut || y <= Window.windowSize.height / 2) {
            fall(0.25);
        } else {
            propel(0.25);
        }

        if (!isInsideScene() && !isCut) {
            Game.getStatus().setLives(Game.getStatus().getLives() - 1);
        }
    }
}

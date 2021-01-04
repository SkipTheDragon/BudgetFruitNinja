package FruitNinja.Assets.Model.Elements;

import FruitNinja.Assets.Model.ModelFamily;
import FruitNinja.Window;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Fruit extends MotionElement implements ModelFamily {

    @Override
    public void setTextures() throws IOException {
        textures.put("default", ImageIO.read(new File("src/FruitNinja/Assets/Images/banana.png")));
        textures.put("cut", ImageIO.read(new File("src/FruitNinja/Assets/Images/cutBanana.png")));
        texturesLoaded = true;
    }

    @Override
    public void update() {
        super.update();
//        if (!isInsideScene() && !isCut) {
//            Game.getStatus().setLives(Game.getStatus().getLives() - 1);
//        }

        if (y >= Window.windowSize.height / 2 + height && state != States.FALLING) {
            propel(0.25);
        } else {
            fall(0.35);
        }
    }
}

package fruitninja.assets.model.elements;

import fruitninja.assets.model.ModelFamily;
import fruitninja.Window;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Fruit extends MotionElement implements ModelFamily {

    @Override
    public void setTextures() throws IOException {
        textures.put("default", ImageIO.read(getClass().getResourceAsStream("/fruitninja/assets/images/banana.png")));
        textures.put("cut", ImageIO.read(getClass().getResourceAsStream("/fruitninja/assets/images/cutBanana.png")));
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

package fruitninja.assets.model.elements;

import fruitninja.assets.model.ModelFamily;
import fruitninja.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Bomb extends MotionElement implements ModelFamily {
    public int spawnProbability = 150;
    protected int rotation = 180;

    @Override
    public void setTextures() throws IOException {
        textures.put("default", ImageIO.read(getClass().getResourceAsStream("/fruitninja/assets/images/bomb.png")));
        textures.put("cut", ImageIO.read(getClass().getResourceAsStream("/fruitninja/assets/images/cutBanana.png")));
        texturesLoaded = true;
    }

    public int getSpawnProbability() {
        return spawnProbability;
    }

    @Override
    public void draw(Graphics2D g) {
        super.draw(g);
    }

    @Override
    public void update() {
        super.update();
        if (isInsideScene() && isCut) {
            Game.getStatus().setLives(0);
        }
    }
}

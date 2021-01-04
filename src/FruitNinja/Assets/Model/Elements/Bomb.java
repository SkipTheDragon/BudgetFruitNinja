package FruitNinja.Assets.Model.Elements;

import FruitNinja.Assets.Model.ModelFamily;
import FruitNinja.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Bomb extends MotionElement implements ModelFamily {
    public int spawnProbability = 150;
    protected int rotation = 180;

    @Override
    public void setTextures() throws IOException {
        textures.put("default", ImageIO.read(new File("src/FruitNinja/Assets/Images/bomb.png")));
        textures.put("cut", ImageIO.read(new File("src/FruitNinja/Assets/Images/cutBanana.png")));
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

package FruitNinja.Assets.HUD.Elements;

import FruitNinja.GameEngine.GameObject;
import FruitNinja.Assets.HUD.HUDFamily;

import java.awt.*;

public class StatusBar extends GameObject implements HUDFamily {
    protected Image texture = null;
    protected float x, y;
    protected float width,height;

    @Override
    public Image getTexture() {
        return null;
    }

    @Override
    public void draw(Graphics2D g) {

    }

    @Override
    public void update() {

    }
}

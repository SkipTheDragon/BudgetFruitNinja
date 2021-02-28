package fruitninja.assets.hud.elements;

import fruitninja.assets.hud.HUDFamily;
import fruitninja.Game;
import fruitninja.engine.GameObject;

import java.awt.*;
import java.awt.event.InputEvent;

public class StatusBar extends GameObject implements HUDFamily {
    Game status = Game.getStatus();
    @Override
    public void setTextures() {
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.white);
        Font font = new Font("Arial", Font.BOLD, 20);
        g.setFont(font);

        g.drawString("Score: " + status.getScore() , x, y);
        g.drawString("Combo: X " + status.getComboBonus() , x, y + 20);
        g.drawString("Level: " + status.getLevel() , x, y + 40);
        g.drawString("Lives left: " + status.getLives() , x, y + 60);
    }

    @Override
    public void update() {

    }

    @Override
    public void handleInput(InputEvent e) {

    }
}

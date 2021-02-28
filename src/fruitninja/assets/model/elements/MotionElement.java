package fruitninja.assets.model.elements;

import fruitninja.events.MouseInput;
import fruitninja.Game;
import fruitninja.engine.GameObject;
import fruitninja.Window;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.geom.AffineTransform;
import java.io.IOException;

public class MotionElement extends GameObject {
    protected boolean isCut = false;
    protected boolean canBeCut = true;
    protected boolean decliningSide;
    protected int spawnProbability = 30;
    protected int rotation = 50;
    public States state;

    public enum States {
        FALLING,PROPELLING
    }

    public void propel(double velocityY) {
        y += velY;
        velY += -velocityY;
        if (isInsideScene()) {
            decline(0.005);
        }
        state = States.PROPELLING;
    }

    public int getSpawnProbability() {
        return spawnProbability;
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

    public boolean isCut() {
        return isCut;
    }

    public void cut() {
        this.isCut = true;
    }

    public void setDecliningSideBySpawnPoint() {
        this.decliningSide = spawnPoint.x <= Window.windowSize.width / 2;
    }

    @Override
    public void setTextures() throws IOException {

    }

    @Override
    public void draw(Graphics2D g) {
        if (!texturesLoaded) {
            try {
                setTextures();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        AffineTransform old = g.getTransform();
        if (decliningSide) {
            g.rotate(Math.toRadians((velX) / 2) * + rotation, x, y);
        } else {
            g.rotate(Math.toRadians((velX) / 2) * - rotation, x, y);
        }
        g.drawImage(isCut ? textures.get("cut") : textures.get("default"), (int) getX(), (int) getY(), (int) getWidth(), (int) getHeight(), null);
        g.setTransform(old);
    }

    @Override
    public void update() {
        if (y >= Window.windowSize.height / 2 + height && state != States.FALLING) {
            propel(0.05);
        } else {
            fall(0.10);
        }
    }

    public void collision() {
        Game game = Game.getStatus();
        game.setScore(game.getScore() + 1);

        if (game.getScore() > game.getScoreForLevelUp() * game.getLevel()) {
            game.setLevel(game.getLevel() + 1);
        }
    }

    @Override
    public void handleInput(InputEvent e) {
        if (canBeCut) {
            if (MouseInput.mouseStatus == MouseInput.MouseStatus.DRAGGED) {
                Point[] point = MouseInput.swordTrail.getState();
                if (point[point.length / 2] != null) {
                    Point lastPoint = point[point.length / 2];
                    if (getBounds().intersects(new Rectangle(lastPoint.x, lastPoint.y, 1, 1))) {
                        if (!isCut()) {
                            cut();
                            collision();
                        }
                    }
                }
            }
        }
    }
}

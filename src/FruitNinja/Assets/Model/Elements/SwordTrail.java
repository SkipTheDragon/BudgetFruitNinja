package FruitNinja.Assets.Model.Elements;

import FruitNinja.Assets.Model.ModelFamily;
import FruitNinja.GameEngine.GameObject;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.io.IOException;

public class SwordTrail extends GameObject implements ModelFamily {
    protected Point[] state = new Point[5];
    public int updateRate = 1;
    public int maxDistanceBetweenStates = 100;
    @Override
    public Image getTexture() throws IOException {
        return null;
    }

    public Point[] getState() {
        return state;
    }

    @Override
    public void draw(Graphics2D g) {
        if (state[0] != null && state[1] != null) {
            g.setColor(Color.BLACK);
            GeneralPath polyline = new GeneralPath(GeneralPath.WIND_EVEN_ODD, state.length);
            polyline.moveTo(state[0].x, state[0].y);

            for (int index = 1; index < state.length; index++) {
                if (state[index] != null)
                polyline.lineTo(state[index].x, state[index].y);
            }

            g.draw(polyline);
        }
    }

    public void clearTrail() {
        for (int j = state.length-1; j > 0; j--) {
            state[j] = null;
        }
    }

    @Override
    public void update() {
        for (int i = 0; i < state.length; i++) {
            Point currentPos = new Point((int) getX(), (int) getY());

            if (state[i] != null) {
                if (i > 0) {
                    double distance = Math.hypot(state[i].x - currentPos.x, state[i].y - currentPos.y);
                    if (distance > maxDistanceBetweenStates) {
                        clearTrail();
                    }
                }
                if (i == state.length - 1) { // there can be only n-1 elements
                    state[i] = currentPos;
                }
                else {
                    state[i] = state[i + 1];
                }
            } else {
                state[i] = currentPos;
            }
        }
    }

}

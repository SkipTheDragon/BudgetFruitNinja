package FruitNinja.Assets.Model.Elements;

import FruitNinja.Assets.Model.ModelFamily;
import FruitNinja.GameEngine.GameObject;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.io.IOException;

public class SwordTrail extends GameObject implements ModelFamily {

    protected Point[] state = new Point[20];
    @Override
    public Image getTexture() throws IOException {
        return null;
    }

    @Override
    public void draw(Graphics2D g) {
        if (state[0] != null) {
            g.setColor(Color.BLACK);
            GeneralPath polyline = new GeneralPath(GeneralPath.WIND_EVEN_ODD, state.length);
            polyline.moveTo(state[0].x, state[0].y);

            for (int index = 1; index < state.length; index++) {
                polyline.lineTo(state[index].x, state[index].y);
            }

            g.draw(polyline);
        }
    }

    @Override
    public void update() {
        for (int i = 0; i < state.length; i++) {

            if (state[i] != null) {
                if (i>0) {
                    double distance = Math.hypot(state[i].x - state[i-1].x, state[i].y-state[i-1].y);
                    System.out.println(state[i-1].x);
                    System.out.println(state[i].x);
                    if (distance > 100)
                        break;
                }
                if (i == state.length - 1)
                    state[i] = new Point((int) getX(), (int) getY());
                else
                    state[i] = state[i + 1];

            } else {
                state[i] = new Point((int) getX(), (int) getY());
            }
        }
    }
}

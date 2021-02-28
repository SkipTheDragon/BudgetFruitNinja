package fruitninja.assets.hud;

import fruitninja.assets.AbstractFactory;
import fruitninja.assets.hud.elements.StatusBar;

public class HUDFactory implements AbstractFactory<HUDFamily> {
    @Override
    public HUDFamily create(String asset) {
        if ("StatusBar".equalsIgnoreCase(asset)) {
           return new StatusBar();
        }

        return null;
    }
}

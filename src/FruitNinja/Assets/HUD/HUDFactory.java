package FruitNinja.Assets.HUD;

import FruitNinja.Assets.AbstractFactory;
import FruitNinja.Assets.HUD.Elements.StatusBar;

public class HUDFactory implements AbstractFactory<HUDFamily> {
    @Override
    public HUDFamily create(String asset) {
        if ("StatusBar".equalsIgnoreCase(asset)) {
           return new StatusBar();
        }

        return null;
    }
}

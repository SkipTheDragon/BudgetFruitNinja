package fruitninja.assets.model;

import fruitninja.assets.AbstractFactory;
import fruitninja.assets.model.elements.Bomb;
import fruitninja.assets.model.elements.Fruit;
import fruitninja.assets.model.elements.SwordTrail;

public class ModelFactory implements AbstractFactory<ModelFamily> {
    @Override
    public ModelFamily create(String asset) {

        if ("Fruit".equalsIgnoreCase(asset)) {
            return new Fruit();
        } else if ("SwordTrail".equalsIgnoreCase(asset)) {
            return new SwordTrail();
        } else if ("Bomb".equalsIgnoreCase(asset)) {
            return new Bomb();
        }

        return null;
    }
}
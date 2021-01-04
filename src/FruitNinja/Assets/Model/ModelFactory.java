package FruitNinja.Assets.Model;

import FruitNinja.Assets.AbstractFactory;
import FruitNinja.Assets.Model.Elements.Bomb;
import FruitNinja.Assets.Model.Elements.Fruit;
import FruitNinja.Assets.Model.Elements.SwordTrail;

import java.io.IOException;

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
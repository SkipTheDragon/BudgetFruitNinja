package FruitNinja.Assets.Model;

import FruitNinja.Assets.AbstractFactory;
import FruitNinja.Assets.Model.Elements.Fruit;
import FruitNinja.Assets.Model.Elements.SwordTrail;

import java.io.IOException;

public class ModelFactory implements AbstractFactory<ModelFamily> {
    @Override
    public ModelFamily create(String asset) {
        if ("Fruit".equalsIgnoreCase(asset)) {
            try {
                return new Fruit();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else  if("SwordTrail".equalsIgnoreCase(asset)) {
            return new SwordTrail();
        }
        return null;
    }
}
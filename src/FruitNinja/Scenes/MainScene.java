package FruitNinja.Scenes;

import FruitNinja.Models.MovingObject;
import java.io.IOException;

public class MainScene extends Scene {

    public MainScene() {

    }

    @Override
    public void update(long elapsedTime) {

    }

    @Override
    public void updateAtFixedRate() {

    }

    @Override
    public void buildScene() {
        MovingObject fruit = getModel("Fruit");

        try {
            fruit.loadImage("/Users/leonard/Documents/Teme/IP/FruitNinja/src/FruitNinja/Models/Images/banana.png");
        } catch (IOException e) {
            e.printStackTrace();
        }

        addToScene(fruit);
    }

}

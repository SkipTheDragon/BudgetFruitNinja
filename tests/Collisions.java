import FruitNinja.Assets.Model.Elements.Fruit;
import FruitNinja.GameEngine.GameLoop;
import FruitNinja.GameEngine.GameObject;
import FruitNinja.Scenes.MainScene;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.IOException;

public class Collisions {
    @Test
    public void collisionsBetweenObjects() {
        Fruit fruit = new Fruit();
        fruit.setSpawnPoint(new Point(1,1));
        fruit.setHeight(50);
        fruit.setWidth(50);

        Fruit fruit2 = new Fruit();
        fruit2.setSpawnPoint(new Point(50,50));
        fruit2.setHeight(50);
        fruit2.setWidth(50);

        Assertions.assertTrue(fruit.getBounds().intersects(fruit2.getBounds()));
    }

    @Test
    public void failCollisionsBetweenObjects() {
        Fruit fruit = new Fruit();
        fruit.setSpawnPoint(new Point(1,1));
        fruit.setHeight(50);
        fruit.setWidth(50);

        Fruit fruit2 = new Fruit();
        fruit2.setSpawnPoint(new Point(100,100));
        fruit2.setHeight(50);
        fruit2.setWidth(50);

        Assertions.assertFalse(fruit.getBounds().intersects(fruit2.getBounds()));
    }

}

// documentatia trimisa pana vineri
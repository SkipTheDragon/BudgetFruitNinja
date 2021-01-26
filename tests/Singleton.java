import FruitNinja.Assets.Model.Elements.Fruit;
import FruitNinja.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.IOException;

public class Singleton {
    @Test
    public void implementedCorrectly() {
        Assertions.assertEquals( Game.getStatus(),  Game.getStatus());
    }

    @Test
    public void implementedCorrectlyAndThreadSafe() {
        Game.getStatus().setLives(100);

        Thread treahd = new Thread(() -> Game.getStatus().setLives(50));
        treahd.run();
        Assertions.assertEquals( 50,  Game.getStatus().getLives());
    }

}

// documentatia trimisa pana vineri
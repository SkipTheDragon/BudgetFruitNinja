import fruitninja.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
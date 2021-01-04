package FruitNinja.Events.Game;

import FruitNinja.Events.EventListener;

import javax.swing.*;
import java.awt.*;

public interface GameEventListener extends EventListener {
    void update(Container container, JPanel content);
}

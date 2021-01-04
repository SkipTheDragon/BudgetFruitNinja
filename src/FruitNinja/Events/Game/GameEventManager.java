package FruitNinja.Events.Game;

import FruitNinja.Events.EventManager;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GameEventManager extends EventManager<GameEventListener> {
    public GameEventManager(String... operations) {
        super(operations);
    }

    public void notify(String eventType, Container container, JPanel content) {
        List<GameEventListener> users = listeners.get(eventType);
        for (GameEventListener listener : users) {
            listener.update(container, content);
        }
    }
}

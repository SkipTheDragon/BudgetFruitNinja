package fruitninja.menus;

import fruitninja.events.EventListener;
import fruitninja.events.EventManager;

import javax.swing.*;
import java.awt.*;

public abstract class Menu extends JPanel {
    protected final EventManager<EventListener> eventManager;
    protected final Container container;

    public Menu(EventManager<EventListener> eventManager, Container container) {
        this.eventManager = eventManager;
        this.container = container;
    }

    public abstract void buildUi();
}

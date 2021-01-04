package FruitNinja.Menus;

import FruitNinja.Events.EventListener;
import FruitNinja.Events.EventManager;
import FruitNinja.Events.StartGameAction;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends Menu {
    private Container container;

    public MainMenu(EventManager<EventListener> eventManager,Container container) {
        super(eventManager, container);
        this.container = container;
    }

    public void buildUi() {
        setPreferredSize(new Dimension(750,750));
        setBackground(Color.BLACK);
        JButton button = new JButton("Start Game");

        button.addActionListener(new StartGameAction(container,eventManager));

        add(button);
    }
}

package FruitNinja.Menus;

import FruitNinja.Events.EventListener;
import FruitNinja.Events.EventManager;
import FruitNinja.Events.StartGameAction;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

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

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        try {
            g.drawImage(ImageIO.read(new File("src/FruitNinja/Assets/Images/bg.png")), 0, 0, getWidth(),getHeight(),null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

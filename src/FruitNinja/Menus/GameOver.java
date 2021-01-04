package FruitNinja.Menus;


import FruitNinja.Events.EventListener;
import FruitNinja.Events.EventManager;
import FruitNinja.Events.StartGameAction;
import FruitNinja.Game;
import FruitNinja.Window;

import javax.swing.*;
import java.awt.*;

public class GameOver extends Menu {

    private final String text;
    private String pointsText = "test";
    private JButton jButton = new JButton("Play again");

    public GameOver(EventManager<EventListener> eventManager, Container container) {
        super(eventManager, container);
        text = "Game Over ";
        this.pointsText = "You scored " + Game.getStatus().getScore() + " points";
        Game.getStatus().setLives(3);
    }

    @Override
    public Dimension getPreferredSize() {
        return Window.windowSize;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setColor(Color.RED);
        Font font = new Font("Arial", Font.BOLD, 48);
        g2d.setFont(font);
        FontMetrics fm = g2d.getFontMetrics();
        int x = ((getWidth() - fm.stringWidth(text)) / 2);
        int xPoints = ((getWidth() - fm.stringWidth(pointsText)) / 2);
        int y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();

        g2d.setColor(Color.BLACK);
        g2d.drawString(text, x, y - 25);
        g2d.drawString(pointsText, xPoints, y + 25);
        g2d.dispose();
    }

    @Override
    public void buildUi() {
        jButton.addActionListener(new StartGameAction(container,eventManager));
        add(jButton);
    }
}

package FruitNinja;

import FruitNinja.Events.EventListener;
import FruitNinja.Events.EventManager;
import FruitNinja.Menus.MainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Window extends JFrame {
    public static Dimension windowSize = new Dimension(800, 800);

    public Window(String title) throws HeadlessException {
        super(title);
    }

    public static void main(String[] args) {
        EventManager<EventListener> gameEventManager = new EventManager<>("gameEnded");

        Window Window = new Window("Fruit Ninja");
        Game.getStatus().setContentPane(Window.getContentPane());

        MainMenu mainMenu = new MainMenu(gameEventManager, Window.getContentPane());
        mainMenu.buildUi();

        Window.add(mainMenu);
        Window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if(JOptionPane.showConfirmDialog(Window, "Are you sure ?") == JOptionPane.OK_OPTION){
                    Window.setVisible(false);
                    Window.dispose();
                    System.exit(0);
                }
            }
        });
       // Main.windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        Window.setResizable(false);
        Window.setPreferredSize(windowSize);
        Window.setVisible(true);
        Window.pack();
    }
}


// Patterns chosen and their purposes

// Abstract Factory for creating Assets (fruits,bombs, etc.)-- implemented
// Singleton for having access to game ongoing events  -- implemented
// Game Loop -- implemented
// Update Method -- implemented
// FlyWeight -- implemented

/*
        Access Modifier	within class	within package	outside package by subclass only	outside package
        Private	    Y	N	N	N
        Default	    Y	Y	N	N
        Protected	Y	Y	Y	N
        Public	    Y	Y	Y	Y
*/

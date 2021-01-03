package FruitNinja;

import FruitNinja.Menus.MainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Window {
    public static Dimension windowSize = new Dimension(800, 800);
    public static Container contentPane;

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Fruit Ninja");
        Game.getStatus().setContentPane(jFrame.getContentPane());

        MainMenu mainMenu = new MainMenu();
        mainMenu.buildUi();

        jFrame.add(mainMenu);
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if(JOptionPane.showConfirmDialog(jFrame, "Are you sure ?") == JOptionPane.OK_OPTION){
                    jFrame.setVisible(false);
                    jFrame.dispose();
                    System.exit(0);
                }
            }
        });
       // Main.windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        jFrame.setResizable(false);
        jFrame.setPreferredSize(Window.windowSize);
        jFrame.setVisible(true);
        jFrame.pack();
    }
}


// Patterns chosen and their purposes

// Abstract Factory for creating Assets (fruits,bombs, etc.)-- implemented
// Singleton for having access to game ongoing events  -- implemented
// Game Loop -- implemented
// Update Method -- implemented
// FlyWeight -- implemented
// Observer

/*
        Access Modifier	within class	within package	outside package by subclass only	outside package
        Private	    Y	N	N	N
        Default	    Y	Y	N	N
        Protected	Y	Y	Y	N
        Public	    Y	Y	Y	Y
*/

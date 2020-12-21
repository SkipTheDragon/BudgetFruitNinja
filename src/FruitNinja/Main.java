package FruitNinja;

import FruitNinja.Menus.MainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static Dimension windowSize = new Dimension(500, 500);
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
        jFrame.setPreferredSize(Main.windowSize);
        jFrame.setVisible(true);
        jFrame.pack();
    }
}


// Patterns chosen and their purposes

// Factory Method for creating models(fruits,bombs, etc.) -- partial implementation
// Singleton for having access to game ongoing events  -- implemented
// Game Loop -- implemented

// State for MovingObjects moving animations
// Observer
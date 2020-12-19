package FruitNinja.Menus;

import FruitNinja.Game;
import FruitNinja.Scenes.MainScene;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel {

    public MainMenu() {

    }

    public void buildUi() {
        setPreferredSize(new Dimension(500,500));
        setBackground(Color.BLACK);
        JButton button = new JButton("StartGame");
        MainMenu mainMenu = this;

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Container gamePane = Game.getStatus().getContentPane();
                MainScene mainScene = new MainScene();
                mainScene.run();
                gamePane.add(mainScene);
                gamePane.remove(mainMenu);
                gamePane.revalidate();
            }
        });
        add(button);
    }
}

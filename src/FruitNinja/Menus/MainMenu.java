package FruitNinja.Menus;

import FruitNinja.Game;
import FruitNinja.GameEngine.FixedStepGameLoop;
import FruitNinja.GameEngine.VariableStepGameLoop;
import FruitNinja.Scenes.MainScene;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel {

    public MainMenu() {

    }

    public void buildUi() {
        setPreferredSize(new Dimension(750,750));
        setBackground(Color.BLACK);
        JButton button = new JButton("StartGame");
        MainMenu mainMenu = this;

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Container gamePane = Game.getStatus().getContentPane();

                MainScene mainScene = new MainScene();
                mainScene.setSize(gamePane.getSize());
                VariableStepGameLoop variableStepGameLoop = new VariableStepGameLoop(mainScene);
                FixedStepGameLoop fixedStepGameLoop = new FixedStepGameLoop(mainScene);

                // show game
                gamePane.add(mainScene);
                gamePane.remove(mainMenu);
                gamePane.revalidate();

                // start thread / start game
                variableStepGameLoop.run();
                fixedStepGameLoop.run();
            }
        });
        add(button);
    }
}

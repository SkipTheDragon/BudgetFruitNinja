package FruitNinja.Events;

import FruitNinja.Events.EventListener;
import FruitNinja.Events.EventManager;
import FruitNinja.Game;
import FruitNinja.GameEngine.GameLoop;
import FruitNinja.Menus.GameOver;
import FruitNinja.Scenes.MainScene;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartGameAction implements ActionListener {
    private final Container container;
    private final EventManager<EventListener> eventManager;

    public StartGameAction(Container container, EventManager<EventListener> eventManager) {
        this.container = container;
        this.eventManager = eventManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainScene mainScene = new MainScene();
        mainScene.passEventManager(eventManager);
        mainScene.setSize(container.getSize());

        GameLoop gameLoop = new GameLoop(mainScene);
        container.removeAll();
        container.add(mainScene);
        container.revalidate();
        gameLoop.run();

        eventManager.subscribe("gameEnded", new EventListener() {
            @Override
            public void update(String event) {
                container.removeAll();
                GameOver gameOver = new GameOver(eventManager,container);
                gameOver.buildUi();
                container.add(gameOver);

                container.revalidate();
                container.repaint();

                eventManager.unsubscribe("gameEnded", this);
                gameLoop.stop();
            }
        });
    }
}

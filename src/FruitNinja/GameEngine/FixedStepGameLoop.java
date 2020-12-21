package FruitNinja.GameEngine;

import FruitNinja.Scenes.Scene;

public class FixedStepGameLoop extends GameLoop {

    /**
     * 20 ms per frame = 50 FPS.
     */
    private static final long MS_PER_FRAME = 20;

    public FixedStepGameLoop(Scene scene) {
        this.scene = scene;
    }

    @Override
    protected void process() {
        var previousTime = System.currentTimeMillis();
        var lag = 0L;
        while (isGameRunning()) {
            var currentTime = System.currentTimeMillis();
            var elapsedTime = currentTime - previousTime;
            previousTime = currentTime;
            lag += elapsedTime;

            processInput();

            while (lag >= MS_PER_FRAME) {
                scene.updateAtFixedRate();
                lag -= MS_PER_FRAME;
            }

            refreshScene();
        }
    }
}

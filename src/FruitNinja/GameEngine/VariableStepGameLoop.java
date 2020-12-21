package FruitNinja.GameEngine;

import FruitNinja.Scenes.Scene;

public class VariableStepGameLoop extends GameLoop {

    public VariableStepGameLoop(Scene scene) {
        this.scene = scene;
    }

    @Override
    public void process() {
        scene.buildScene();
        var lastFrameTime = System.currentTimeMillis();
        while (isGameRunning()) {
            processInput();
            var currentFrameTime = System.currentTimeMillis();
            var elapsedTime = currentFrameTime - lastFrameTime;
            scene.update(elapsedTime);
            lastFrameTime = currentFrameTime;
            refreshScene();
        }
    }
}

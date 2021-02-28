package fruitninja.events;

import fruitninja.assets.model.elements.SwordTrail;
import fruitninja.scenes.MainScene;
import fruitninja.scenes.Scene;

import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Objects;

public class MouseInput extends MouseInputAdapter implements MouseMotionListener {

    private final MainScene scene;
    public MouseInput(MainScene scene) {
        this.scene = scene;
    }
    public static SwordTrail swordTrail = (SwordTrail) Objects.requireNonNull(Scene.getFactory("Model")).create("SwordTrail");

    public static MouseStatus mouseStatus = MouseStatus.RELEASED;

    public enum MouseStatus {
        PRESSED,RELEASED,CLICKED,DRAGGED
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseStatus = MouseStatus.RELEASED;
        scene.handleInput(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseStatus = MouseStatus.DRAGGED;
        scene.handleInput(e);
    }

}
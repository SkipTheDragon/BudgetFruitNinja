package FruitNinja;

import java.awt.*;

public final class Game {

    private int score = 0;
    private int mistakesAllowed = 3;
    private int level = 0;
    private int comboBonus = 0;
    private Container contentPane;

    // The field must be declared volatile (the value might change between accesses)
    // so that double check lock would work
    // correctly.
    private static volatile Game instance;

    private Game() {
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getComboBonus() {
        return comboBonus;
    }

    public void setComboBonus(int comboBonus) {
        this.comboBonus = comboBonus;
    }

    public int getMistakesAllowed() {
        return mistakesAllowed;
    }

    public void setMistakesAllowed(int mistakesAllowed) {
        this.mistakesAllowed = mistakesAllowed;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Container getContentPane() {
        return contentPane;
    }

    public void setContentPane(Container contentPane) {
        this.contentPane = contentPane;
    }

    public static Game getStatus() {
        // The approach taken here is called double-checked locking (DCL). It
        // exists to prevent race condition between multiple threads that may
        // attempt to get singleton instance at the same time, creating separate
        // instances as a result.
        //
        // It may seem that having the `result` variable here is completely
        // pointless. There is, however, a very important caveat when
        // implementing double-checked locking in Java, which is solved by
        // introducing this local variable.

        Game result = instance;
        if (result != null) {
            return result;
        }
        synchronized(Game.class) {
            if (instance == null) {
                instance = new Game();
            }
            return instance;
        }
    }

}
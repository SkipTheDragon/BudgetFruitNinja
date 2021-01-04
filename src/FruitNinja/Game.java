package FruitNinja;

import java.awt.*;

public final class Game {

    private int score = 0;
    private int lives = 80000;
    private int level = 0;
    private int comboBonus = 0;
    private int scoreForLevelUp = 60;

    private Container contentPane;

    // The field must be declared volatile (the value might change between accesses)
    // so that double check lock would work
    // correctly.
    private static volatile Game instance;

    private Game() {
    }

    public void resetGame() {
        this.score = 0;
        this.lives = 3;
        this.level = 0;
        this.comboBonus = 0;
        this.scoreForLevelUp = 60;
    }

    public int getScoreForLevelUp() {
        return scoreForLevelUp;
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

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
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
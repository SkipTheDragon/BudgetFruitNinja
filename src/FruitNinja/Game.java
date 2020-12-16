package FruitNinja;

public final class Game {

    private boolean ongoing = true;
    private int score = 0;
    private int mistakesAllowed = 3;
    private int level = 0;
    private int comboBonus = 0;

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

    public static Game getInstance() {
        return instance;
    }

    public static void setInstance(Game instance) {
        Game.instance = instance;
    }

    public int getMistakesAllowed() {
        return mistakesAllowed;
    }

    public void setMistakesAllowed(int mistakesAllowed) {
        this.mistakesAllowed = mistakesAllowed;
    }

    public boolean isOngoing() {
        return ongoing;
    }

    public void setOngoing(boolean ongoing) {
        this.ongoing = ongoing;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    // The field must be declared volatile (the value might change between accesses)
    // so that double check lock would work
    // correctly.
    private static volatile Game instance;

    private Game() {
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
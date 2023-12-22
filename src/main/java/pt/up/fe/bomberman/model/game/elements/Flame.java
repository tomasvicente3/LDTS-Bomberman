package pt.up.fe.bomberman.model.game.elements;

public class Flame extends Element {
    private final long time;
    private final char type;

    public Flame(int x, int y, long time, char type) {
        super(x, y);
        this.time = time;
        this.type = type;
    }

    public long getTime() {
        return time;
    }
    public char getType() {
        return type;
    }
}

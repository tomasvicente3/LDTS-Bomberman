package pt.up.fe.bomberman.model.game.elements;

public class Enemy extends Element {
    public enum TYPE {BALLOOM, ONEAL, DOLL, MINVO, KONDORIA, OVAPI, PASS, PONTAM}
    private final TYPE type;
    private final int speed;
    private final int smart;
    private final boolean wallpass;
    private char direction;
    private long lastMovementTime;

    public Enemy(int x, int y, TYPE type) {
        super(x, y);
        this.type = type;
        if (type == TYPE.BALLOOM) {speed = 2; smart = 1; wallpass = false;}
        else if (type == TYPE.ONEAL) {speed = 3; smart = 2; wallpass = false;}
        else if (type == TYPE.DOLL) {speed = 3; smart = 1; wallpass = false;}
        else if (type == TYPE.MINVO) {speed = 4; smart = 2; wallpass = false;}
        else if (type == TYPE.KONDORIA) {speed = 1; smart = 3; wallpass = true;}
        else if (type == TYPE.OVAPI) {speed = 2; smart = 2; wallpass = true;}
        else if (type == TYPE.PASS) {speed = 4; smart = 3; wallpass = false;}
        else if (type == TYPE.PONTAM) {speed = 4; smart = 3; wallpass = true;}
        else {speed = 1; smart = 1; wallpass = false;}

        this.direction = generateRandomDirection();
        this.lastMovementTime = 0;
    }

    private char generateRandomDirection() {
        int n = (int) (Math.random() * 4);
        switch (n) {
            case 0:
                return 'U';
            case 1:
                return 'D';
            case 2:
                return 'L';
            default:
                return 'R';
        }
    }

    public TYPE getType() {
        return type;
    }
    public int getSpeed() {
        return speed;
    }
    public int getSmart() {
        return smart;
    }
    public boolean canWallpass() {
        return wallpass;
    }
    public char getDirection() {
        return direction;
    }
    public long getLastMovementTime() {
        return lastMovementTime;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }
    public void setLastMovementTime(long time) {
        this.lastMovementTime = time;
    }
}

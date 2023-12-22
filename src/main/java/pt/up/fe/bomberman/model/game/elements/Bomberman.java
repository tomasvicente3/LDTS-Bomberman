package pt.up.fe.bomberman.model.game.elements;

public class Bomberman extends Element {
    private char direction;
    private int hp;
    private int bombs;
    private int flames;
    private int speed;
    private boolean wallpass;
    private boolean bombpass;
    private boolean flamepass;

    public Bomberman(int x, int y) {
        super(x, y);
        direction = 'D';
        hp = 1;
        bombs = 1;
        flames = 1;
        speed = 1;
        wallpass = false;
        bombpass = false;
        flamepass = false;
    }

    public char getDirection() {
        return direction;
    }
    public int getHp() {
        return hp;
    }
    public int getBombs() {
        return bombs;
    }
    public int getFlames() {
        return flames;
    }
    public int getSpeed() {
        return speed;
    }

    public boolean canWallpass() {
        return wallpass;
    }
    public boolean canBombpass() {
        return bombpass;
    }
    public boolean canFlamepass() {
        return flamepass;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public void setBombs(int bombs) {
        this.bombs = bombs;
    }
    public void setFlames(int flames) {
        this.flames = flames;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void setWallpass(boolean wallpass) {
        this.wallpass = wallpass;
    }
    public void setBombpass(boolean bombpass) {
        this.bombpass = bombpass;
    }
    public void setFlamepass(boolean flamepass) {
        this.flamepass = flamepass;
    }
}

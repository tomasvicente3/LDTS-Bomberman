package pt.up.fe.bomberman.controller.game;

import pt.up.fe.bomberman.Game;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.game.arena.Arena;
import pt.up.fe.bomberman.model.game.elements.Bomb;
import pt.up.fe.bomberman.model.game.elements.Powerup;

public class BombermanController extends GameController {
    private long lastMovementTime = 0;
    public BombermanController(Arena arena) {
        super(arena);
    }

    public void moveBombermanUp() {
        getModel().getBomberman().setDirection('U');
        moveBomberman(getModel().getBomberman().getPosition().getUp());
    }

    public void moveBombermanDown() {
        getModel().getBomberman().setDirection('D');
        moveBomberman(getModel().getBomberman().getPosition().getDown());
    }

    public void moveBombermanLeft() {
        getModel().getBomberman().setDirection('L');
        moveBomberman(getModel().getBomberman().getPosition().getLeft());
    }

    public void moveBombermanRight() {
        getModel().getBomberman().setDirection('R');
        moveBomberman(getModel().getBomberman().getPosition().getRight());
    }

    private boolean canMove(Position position) {
        return getModel().inArena(position)
                && (!getModel().isBomb(position) || getModel().getBomberman().canBombpass())
                && (!getModel().isObstacle(position) || getModel().getBomberman().canWallpass())
                && !getModel().isWall(position);
    }

    private void moveBomberman(Position position) {
        if (canMove(position)) {
            getModel().getBomberman().setPosition(position);
            if (getModel().isEnemy(position) || (getModel().isFlame(position) && !getModel().getBomberman().canFlamepass()))
                getModel().getBomberman().setHp(getModel().getBomberman().getHp() - 1);
            if (getModel().isPowerup(position) && !getModel().isObstacle(position)) {
                applyEffect(getModel().getPowerup(position));
                getModel().removePowerup(position);
            }
        }
    }

    private void applyEffect(Powerup powerup) {
        if (powerup.getEffect() == Powerup.EFFECT.BOMBS)
            getModel().getBomberman().setBombs(getModel().getBomberman().getBombs() + 1);
        else if (powerup.getEffect() == Powerup.EFFECT.FLAMES)
            getModel().getBomberman().setFlames(getModel().getBomberman().getFlames() + 1);
        else if (powerup.getEffect() == Powerup.EFFECT.SPEED)
            getModel().getBomberman().setSpeed(getModel().getBomberman().getSpeed() + 1);
        else if (powerup.getEffect() == Powerup.EFFECT.WALLPASS)
            getModel().getBomberman().setWallpass(true);
        else if (powerup.getEffect() == Powerup.EFFECT.HEALTH)
            getModel().getBomberman().setHp(getModel().getBomberman().getHp() + 1);
        else if (powerup.getEffect() == Powerup.EFFECT.BOMBPASS)
            getModel().getBomberman().setBombpass(true);
        else if (powerup.getEffect() == Powerup.EFFECT.FLAMEPASS)
            getModel().getBomberman().setFlamepass(true);
    }

    private boolean canCreateBomb() {
        return getModel().getBomberman().getBombs() - getModel().getBombs().size() > 0
                && !getModel().isBomb(getModel().getBomberman().getPosition())
                && !getModel().isObstacle(getModel().getBomberman().getPosition())
                && !getModel().isWall(getModel().getBomberman().getPosition())
                && !getModel().isPowerup(getModel().getBomberman().getPosition());
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (time - lastMovementTime > 100/getModel().getBomberman().getSpeed()) {
            if (action != GUI.ACTION.NONE)
                lastMovementTime = time;
            if (action == GUI.ACTION.UP)
                moveBombermanUp();
            else if (action == GUI.ACTION.RIGHT)
                moveBombermanRight();
            else if (action == GUI.ACTION.DOWN)
                moveBombermanDown();
            else if (action == GUI.ACTION.LEFT)
                moveBombermanLeft();
        }
        if (action == GUI.ACTION.SPACE && canCreateBomb())
            getModel().addBomb(new Bomb(getModel().getBomberman().getPosition().getX(), getModel().getBomberman().getPosition().getY(), time, getModel().getBomberman().getFlames()));
    }
}

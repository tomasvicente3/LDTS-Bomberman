package pt.up.fe.bomberman.controller.game;

import pt.up.fe.bomberman.Game;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.game.arena.Arena;
import pt.up.fe.bomberman.model.game.elements.Bomb;
import pt.up.fe.bomberman.model.game.elements.Flame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BombController extends GameController {
    public BombController(Arena arena) {
        super(arena);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        List<Bomb> bombs = new ArrayList<>();
        for (Bomb bomb : getModel().getBombs())
            if (time - bomb.getTime() < 2000)
                bombs.add(bomb);
            else
                explodeBomb(bomb, time);
        getModel().setBombs(bombs);
    }

    private void explodeBomb(Bomb bomb, long time) {
        getModel().addFlame(new Flame(bomb.getPosition().getX(), bomb.getPosition().getY(), time, 'C'));
        explodeBombUp(bomb, time);
        explodeBombDown(bomb, time);
        explodeBombLeft(bomb, time);
        explodeBombRight(bomb, time);
    }

    private boolean stopExplosion(Position position) {
        return getModel().isWall(position)
                || !getModel().inArena(position)
                || getModel().isBomb(position)
                || (getModel().isPowerup(position) && !getModel().isObstacle(position));
    }

    private void explodeBombUp(Bomb bomb, long time) {
        for (int up = 1; up <= bomb.getFlames(); up++) {
            Position position = new Position(bomb.getPosition().getX(), bomb.getPosition().getY() - up);
            if (stopExplosion(position))
                break;
            getModel().addFlame(new Flame(position.getX(), position.getY(), time, 'V'));
            if (getModel().isObstacle(position))
                break;
        }
    }

    private void explodeBombDown(Bomb bomb, long time) {
        for (int down = 1; down <= bomb.getFlames(); down++) {
            Position position = new Position(bomb.getPosition().getX(), bomb.getPosition().getY() + down);
            if (stopExplosion(position))
                break;
            getModel().addFlame(new Flame(position.getX(), position.getY(), time, 'V'));
            if (getModel().isObstacle(position))
                break;
        }
    }

    private void explodeBombLeft(Bomb bomb, long time) {
        for (int left = 1; left <= bomb.getFlames(); left++) {
            Position position = new Position(bomb.getPosition().getX() - left, bomb.getPosition().getY());
            if (stopExplosion(position))
                break;
            getModel().addFlame(new Flame(position.getX(), position.getY(), time, 'H'));
            if (getModel().isObstacle(position))
                break;
        }
    }

    private void explodeBombRight(Bomb bomb, long time) {
        for (int right = 1; right <= bomb.getFlames(); right++) {
            Position position = new Position(bomb.getPosition().getX() + right, bomb.getPosition().getY());
            if (stopExplosion(position))
                break;
            getModel().addFlame(new Flame(position.getX(), position.getY(), time, 'H'));
            if (getModel().isObstacle(position))
                break;
        }
    }
}

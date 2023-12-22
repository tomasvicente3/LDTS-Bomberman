package pt.up.fe.bomberman.controller.game;

import pt.up.fe.bomberman.Game;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.game.arena.Arena;
import pt.up.fe.bomberman.model.game.elements.Enemy;

import java.io.IOException;

public class EnemyController extends GameController {
    public EnemyController(Arena arena) {
        super(arena);
    }

    private boolean canMove(Enemy enemy, Position position) {
        return getModel().inArena(position)
                && (!getModel().isBomb(position) || getModel().getBomberman().getPosition().equals(position))
                && (!getModel().isObstacle(position) || enemy.canWallpass())
                && !getModel().isWall(position)
                && !getModel().isEnemy(position)
                && !getModel().isPowerup(position);
    }

    private void moveEnemy(Enemy enemy, Position position) {
        if (canMove(enemy, position)) {
            enemy.setPosition(position);
            if (getModel().getBomberman().getPosition().equals(position))
                getModel().getBomberman().setHp(getModel().getBomberman().getHp() - 1);
        }
    }

    private void invertDirection(Enemy enemy) {
        switch (enemy.getDirection()) {
            case 'U':
                enemy.setDirection('D');
                break;
            case 'D':
                enemy.setDirection('U');
                break;
            case 'L':
                enemy.setDirection('R');
                break;
            case 'R':
                enemy.setDirection('L');
                break;
        }
    }

    private void rotateDirection(Enemy enemy) {
        switch (enemy.getDirection()) {
            case 'U':
                enemy.setDirection('R');
                break;
            case 'R':
                enemy.setDirection('D');
                break;
            case 'D':
                enemy.setDirection('L');
                break;
            case 'L':
                enemy.setDirection('U');
                break;
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        for (Enemy enemy : getModel().getEnemies()) {
            if (time - enemy.getLastMovementTime() > 500/enemy.getSpeed()) {
                if (enemy.getSmart() == 1) {
                    if (!canMove(enemy, enemy.getPosition().getDirectionalNeighbour(enemy.getDirection())))
                        invertDirection(enemy);
                    if (!canMove(enemy, enemy.getPosition().getDirectionalNeighbour(enemy.getDirection())))
                        rotateDirection(enemy);
                    moveEnemy(enemy, enemy.getPosition().getDirectionalNeighbour(enemy.getDirection()));
                }
                if (enemy.getSmart() == 2) {
                    Position position = enemy.getPosition().getRandomDirectionalNeighbour(enemy.getDirection());
                    if (!canMove(enemy, position))
                        rotateDirection(enemy);
                    moveEnemy(enemy, enemy.getPosition().getRandomDirectionalNeighbour(enemy.getDirection()));
                }
                if (enemy.getSmart() == 3)
                    moveEnemy(enemy, enemy.getPosition().getRandomNeighbour());
                enemy.setLastMovementTime(time);
            }
        }
    }
}

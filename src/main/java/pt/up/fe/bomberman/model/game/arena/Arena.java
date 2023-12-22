package pt.up.fe.bomberman.model.game.arena;

import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.game.elements.*;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    private final int width;
    private final int height;
    private Bomberman bomberman;
    private List<Bomb> bombs = new ArrayList<>();
    private List<Flame> flames = new ArrayList<>();
    private List<Obstacle> obstacles = new ArrayList<>();
    private List<Wall> walls = new ArrayList<>();
    private List<Enemy> enemies = new ArrayList<>();
    private List<Powerup> powerups = new ArrayList<>();

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Bomberman getBomberman() {
        return bomberman;
    }

    public List<Bomb> getBombs() {
        return bombs;
    }

    public List<Flame> getFlames() {
        return flames;
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public List<Powerup> getPowerups() {
        return powerups;
    }

    public void setBomberman(Bomberman bomberman) {
        this.bomberman = bomberman;
    }

    public void setBombs(List<Bomb> bombs) {
        this.bombs = bombs;
    }

    public void setFlames(List<Flame> flames) {
        this.flames = flames;
    }

    public void setObstacles(List<Obstacle> obstacles) {
        this.obstacles = obstacles;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }

    public void setPowerups(List<Powerup> powerups) {
        this.powerups = powerups;
    }

    public void addBomb(Bomb bomb) {
        bombs.add(bomb);
    }

    public void addFlame(Flame flame) {
        flames.add(flame);
    }

    public boolean isBomb(Position position) {
        for (Bomb bomb : bombs)
            if (bomb.getPosition().equals(position))
                return true;
        return false;
    }

    public boolean isFlame(Position position) {
        for (Flame flame : flames)
            if (flame.getPosition().equals(position))
                return true;
        return false;
    }

    public boolean isObstacle(Position position) {
        for (Obstacle obstacle : obstacles)
            if (obstacle.getPosition().equals(position))
                return true;
        return false;
    }

    public boolean isWall(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return true;
        return false;
    }

    public boolean isEnemy(Position position) {
        for (Enemy enemy : enemies)
            if (enemy.getPosition().equals(position))
                return true;
        return false;
    }

    public boolean isPowerup(Position position) {
        for (Powerup powerup : powerups)
            if (powerup.getPosition().equals(position))
                return true;
        return false;
    }

    public Powerup getPowerup(Position position) {
        for (Powerup powerup : powerups)
            if (powerup.getPosition().equals(position))
                return powerup;
        return null;
    }

    public void removeObstacle(Position position) {
        for (Obstacle obstacle : obstacles)
            if (obstacle.getPosition().equals(position)) {
                obstacles.remove(obstacle);
                break;
            }
    }

    public void removeEnemy(Position position) {
        for (Enemy enemy : enemies)
            if (enemy.getPosition().equals(position)) {
                enemies.remove(enemy);
                break;
            }
    }

    public void removePowerup(Position position) {
        for (Powerup powerup : powerups)
            if (powerup.getPosition().equals(position)) {
                powerups.remove(powerup);
                break;
            }
    }

    public boolean inArena(Position position) {
        return 0 <= position.getX() && position.getX() < width && 0 <= position.getY() && position.getY() < height;
    }
}

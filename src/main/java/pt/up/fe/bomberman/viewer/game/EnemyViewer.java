package pt.up.fe.bomberman.viewer.game;

import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.game.elements.Enemy;

public class EnemyViewer implements ElementViewer<Enemy> {
    @Override
    public void draw(Enemy enemy, GUI gui) {
        if (enemy.getType() == Enemy.TYPE.BALLOOM) gui.drawElement(enemy.getPosition(), ':', "#FA732C");
        else if (enemy.getType() == Enemy.TYPE.ONEAL) gui.drawElement(enemy.getPosition(), 'n', "#0000FF");
        else if (enemy.getType() == Enemy.TYPE.DOLL) gui.drawElement(enemy.getPosition(), 'o', "#FF0000");
        else if (enemy.getType() == Enemy.TYPE.MINVO) gui.drawElement(enemy.getPosition(), 'u', "#FA732C");
        else if (enemy.getType() == Enemy.TYPE.KONDORIA) gui.drawElement(enemy.getPosition(), 't', "#0000FF");
        else if (enemy.getType() == Enemy.TYPE.OVAPI) gui.drawElement(enemy.getPosition(), 'v', "#FF0000");
        else if (enemy.getType() == Enemy.TYPE.PASS) gui.drawElement(enemy.getPosition(), 'w', "#FA732C");
        else if (enemy.getType() == Enemy.TYPE.PONTAM) gui.drawElement(enemy.getPosition(), 'x', "#FF0000");
    }

}

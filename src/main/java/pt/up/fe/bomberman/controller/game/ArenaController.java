package pt.up.fe.bomberman.controller.game;

import pt.up.fe.bomberman.Game;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.game.arena.Arena;
import pt.up.fe.bomberman.model.menu.Menu;
import pt.up.fe.bomberman.states.MenuState;

import java.io.IOException;

public class ArenaController extends GameController {
    private final BombermanController bombermanController;
    private final BombController bombController;
    private final FlameController flameController;
    private final EnemyController enemyController;

    public ArenaController(Arena arena) {
        super(arena);
        this.bombermanController = new BombermanController(arena);
        this.bombController= new BombController(arena);
        this.flameController = new FlameController(arena);
        this.enemyController = new EnemyController(arena);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT || getModel().getBomberman().getHp() == 0 || getModel().getEnemies().isEmpty())
            game.setState(new MenuState(new Menu()));
        else {
            bombermanController.step(game, action, time);
            bombController.step(game,action,time);
            flameController.step(game,action,time);
            enemyController.step(game, action, time);
        }
    }
}

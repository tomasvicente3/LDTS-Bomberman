package pt.up.fe.bomberman.controller.game;

import pt.up.fe.bomberman.controller.Controller;
import pt.up.fe.bomberman.model.game.arena.Arena;

public abstract class GameController extends Controller<Arena> {
    public GameController(Arena arena) {
        super(arena);
    }
}

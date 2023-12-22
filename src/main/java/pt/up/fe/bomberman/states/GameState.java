package pt.up.fe.bomberman.states;

import pt.up.fe.bomberman.controller.Controller;
import pt.up.fe.bomberman.controller.game.ArenaController;
import pt.up.fe.bomberman.model.game.arena.Arena;
import pt.up.fe.bomberman.viewer.Viewer;
import pt.up.fe.bomberman.viewer.game.GameViewer;

public class GameState extends State<Arena> {
    public GameState(Arena arena) {
        super(arena);
    }

    @Override
    protected Viewer<Arena> getViewer() {
        return new GameViewer(getModel());
    }
    @Override
    protected Controller<Arena> getController() {
        return new ArenaController(getModel());
    }
}

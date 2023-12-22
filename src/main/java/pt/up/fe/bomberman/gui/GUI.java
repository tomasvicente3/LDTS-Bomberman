package pt.up.fe.bomberman.gui;

import pt.up.fe.bomberman.model.Position;

import java.io.IOException;

public interface GUI {
    enum ACTION {UP, DOWN, RIGHT, LEFT, ENTER, NONE, QUIT, SPACE}
    ACTION getNextAction() throws IOException;
    void paintBackground(int width, int height);
    void drawElement(Position position, char c, String color);
    void drawText(Position position, String text, String color);
    void clear();
    void refresh() throws IOException;
    void close() throws IOException;
}

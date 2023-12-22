package pt.up.fe.bomberman.gui;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.bomberman.model.Position;

class LaternaGUITest {
    private LanternaGUI gui;
    private TextGraphics textGraphics;

    @BeforeEach
    void setUp() {
        Screen screen = Mockito.mock(Screen.class);
        textGraphics = Mockito.mock(TextGraphics.class);

        Mockito.when(screen.newTextGraphics()).thenReturn(textGraphics);

        gui = new LanternaGUI(screen);
    }

    @Test
    void paintBackground() {
        gui.paintBackground(20, 20);

        Mockito.verify(textGraphics, Mockito.times(1)).setBackgroundColor(new TextColor.RGB(57, 124, 0));
        Mockito.verify(textGraphics, Mockito.times(1)).fillRectangle(new TerminalPosition(0, 0), new TerminalSize(20, 20), ' ');
    }

    @Test
    void drawElement() {
        gui.drawElement(new Position(10, 10), 'E', "#FA732C");

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(250, 115, 44)); //#FA732C
        Mockito.verify(textGraphics, Mockito.times(1)).setBackgroundColor(new TextColor.RGB(57, 124, 0)); //#397C00
        Mockito.verify(textGraphics, Mockito.times(1)).putString(10, 10, "E");
    }

    @Test
    void drawText() {
        gui.drawText(new Position(5, 5), "Some Text", "#336699");

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(51, 102, 153)); //#336699
        Mockito.verify(textGraphics, Mockito.times(1)).putString(5, 5, "Some Text");
    }
}

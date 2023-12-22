package pt.up.fe.bomberman.model.menu;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuTest {
    @Property
    public void nextLevel(@ForAll @IntRange(max = 100) int n) {
        Menu menu = new Menu();
        for (int i = 0; i < n; i++)
            menu.nextLevel();
        assertEquals(n % menu.getNumberLevels(), menu.getCurrentLevel());
    }

    @Property
    public void previousLevel(@ForAll @IntRange(max = 100) int n) {
        Menu menu = new Menu();
        for (int i = 0; i < n; i++)
            menu.previousLevel();
        assertEquals((menu.getNumberLevels() - n % menu.getNumberLevels()) % menu.getNumberLevels(), menu.getCurrentLevel());
    }

    @Property
    public void nextOption(@ForAll @IntRange(max = 100) int n) {
        Menu menu = new Menu();
        for (int i = 0; i < n; i++)
            menu.nextOption();
        assertEquals(n % menu.getNumberOptions(), menu.getCurrentOption());
    }

    @Property
    public void previousOption(@ForAll @IntRange(max = 100) int n) {
        Menu menu = new Menu();
        for (int i = 0; i < n; i++)
            menu.previousOption();
        assertEquals((menu.getNumberOptions() - n % menu.getNumberOptions()) % menu.getNumberOptions(), menu.getCurrentOption());
    }

}

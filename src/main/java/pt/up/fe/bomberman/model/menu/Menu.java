package pt.up.fe.bomberman.model.menu;

import java.util.Arrays;
import java.util.List;

public class Menu {
    private final List<String> levels;
    private final List<String> options;

    private int currentLevel = 0;
    private int currentOption = 0;

    public Menu() {
        this.levels = Arrays.asList("EASY", "MEDIUM", "HARD", "CHALLENGE");
        this.options = Arrays.asList("START", levels.get(currentLevel), "EXIT");
    }

    public void nextLevel() {
        currentLevel++;
        if (currentLevel > this.levels.size() - 1)
            currentLevel = 0;
        options.set(1, levels.get(currentLevel));
    }

    public void previousLevel() {
        currentLevel--;
        if (currentLevel < 0)
            currentLevel = this.levels.size() - 1;
        options.set(1, levels.get(currentLevel));
    }

    public void nextOption() {
        currentOption++;
        if (currentOption > this.options.size() - 1)
            currentOption = 0;
    }

    public void previousOption() {
        currentOption--;
        if (currentOption < 0)
            currentOption = this.options.size() - 1;
    }

    public int getCurrentLevel(){
        return currentLevel;
    }
    public int getCurrentOption() {
        return currentOption;
    }
    public String getOption(int i) {
        return options.get(i);
    }

    public boolean isSelected(int i) {
        return currentOption == i;
    }
    public boolean isSelectedStart() {
        return isSelected(0);
    }
    public boolean isSelectedLevel() {
        return isSelected(1);
    }
    public boolean isSelectedExit() {
        return isSelected(2);
    }

    public int getNumberLevels() {
        return this.levels.size();
    }
    public int getNumberOptions() {
        return this.options.size();
    }
}

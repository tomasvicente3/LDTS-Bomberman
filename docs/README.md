## LDTS_L08GR07 - BOMBERMAN

In this remake of the NES classic, Bomberman, you will be able to help again the robot Bomberman find his way through a maze, while avoiding enemies that try to stop you.
The maze is composed of several levels with variable difficulty that you can complete by successfully killing all enemies. 

This project was developed by *Diogo Sarmento* (*up202109663*@fe.up.pt), *Manuel Neto* (*up202108744*@fe.up.pt) and *Tomás Vicente* (*up202108717*@fe.up.pt) for LDTS 2022⁄23.

### IMPLEMENTED FEATURES

- **Load level from a file** - The level to be played is loaded from a file that contains the "map" of that level.
- **Place bombs** - Bomberman will place a bomb when the SPACE key is pressed.
- **Explode obstacles** - When the bomb's flame reaches an obstacle, it will disappear and there is a chance that it was hiding a powerup.
- **Upgrade your character** - After collecting a powerup, your character will be upgraded, either itself (higher speed, ability to pass through bombs or walls, ...) or the bombs it drops (higher flame area, more bombs to drop, ...).
- **Kill enemies** - When the bomb's flame reaches an enemy, it will kill it.
- **Die** - The player can lose the game if they lose all their health, either by exploding themselves with a bomb or by getting caught by an enemy.


##### PLACE BOMBS #####
![Alt text](images/bomb.png?raw=true "Place bombs")

##### EXPLODE OBSTACLES #####
![Alt text](images/flames.png?raw=true "Explode obstacles")

##### UPGRADE YOUR CHARACTER #####
![Alt text](images/powerups.png?raw=true "Upgrading your character")

### PLANNED FEATURES

- All the planned features were successfully implemented.

### DESIGN

#### ARENA BUILDER

**Problem in Context**

An arena is made of a huge variety of elements: a bomberman - that can drop bombs, that can explode and produce flames -, obstacles, walls, enemies and powerups.
Besides this, the game has many levels and each one has its own arena, which creates the need to have an arena loader that is able to read the layout/map of a level from a file and insert into its super class (arena builder) the read elements, as well as their respective positions.
This way, not only we can create specific elements in specific positions for each level, but we also can easily add new levels whenever we want. 
Otherwise, if we had a specific builder to each level, we would not be following the **Open-Closed Principle (OCP)**.

**The Pattern**

We have applied the **Factory Method** pattern.
This creational design pattern allowed us to provide an interface for creating objects in a superclass, but at the same letting subclasses decide the type of objects that should be created.
So, as we had a class that could not anticipate the class of objects it must create, and it wanted the subclasses to specify the objects it creates, this pattern was a good fit for the problem.

**Implementation**

In the code, the ArenaBuilder class represents the 'factory' and the LoaderArenaBuilder class represents the 'worker'.
As can be seen, the ArenaBuilder is an abstract class that knows how to build an arena, but only the LoaderArenaBuilder class provides the elements of the arena.
As explained, we implemented a LoaderArenaBuilder which reads levels from files, but, for example, there could also have been implemented a RandomArenaBuilder that would be able to generate random arenas.

The following UML class diagram shows how the pattern roles, operations and associations were mapped to the concrete design classes.

![Alt text](images/arena-UML.png?raw=true "ArenaBuilder UML")

These classes can be found in the following files:

- [ArenaBuilder](../src/main/java/pt/up/fe/bomberman/model/game/arena/ArenaBuilder.java)
- [LoaderArenaBuilder](../src/main/java/pt/up/fe/bomberman/model/game/arena/LoaderArenaBuilder.java)

**Consequences**

The use of the Factory Method Pattern in the current design allows the following benefits:

- It eliminates the need to bind level-specific classes into the code, which, as explained, would violate the **Open-Closed Principle**.
- The code only needs to deal with the ArenaBuilder abstract class, therefore it can work with the concrete class ArenaBuilder, or, eventually, with the RandomArenaBuilder class.
- It avoids tight coupling between the creator and the concrete objects it creates.

#### MENU AND GAME

**Problem in Context**

The application can be divided in two different states: the 'game' itself (when someone is playing a level, the bomberman in inside the arena trying to kill all the enemies) and the menu (where the player can select the desired level, based on the difficulty).
So, we had an object (the application, including the menu and the game) whose behavior should depend on its state - either the menu or the playable part of the game - and it should be able to change between states in run-time.
For example, when in the menu and START is pressed, the application should go from the menu to the game itself, and when in play and the bomberman dies, or when it kills all the enemies, or when the player wants to quit, it should go on the opposite way, from the game itself to menu, allowing the user to select a different level (or end the application definitively).
We could have gathered together these two states in a single class, but it would violate the **Single Responsibility Principle (SRP)**.

**The Pattern**

We have applied the **State** pattern.
This behavioral design pattern allowed us to represent the two different states with two different subclasses and switch to a different state of the application by simply switching from one subclass/implementation to another.
So, we could make an object alter its behavior when its internal state changed, which is exactly what we wanted.

**Implementation**

In the code, the State class represents the abstract state, and the GameState and MenuState classes represent the different behavior that the application can assume.
As can be seen, both classes have the same functions signatures, but they allow the application to behave differently based on its state, as explained.

The following UML class diagram shows how the pattern roles, operations and associations were mapped to the concrete design classes.

![Alt text](images/states-UML.png?raw=true "States UML")

These classes can be found in the following files:

- [State](../src/main/java/pt/up/fe/bomberman/states/State.java)
- [GameState](../src/main/java/pt/up/fe/bomberman/states/GameState.java)
- [MenuState](../src/main/java/pt/up/fe/bomberman/states/MenuState.java)

**Consequences**

The use of the State Pattern in the current design allows the following benefits:

- It localizes and partitions behavior for different states, and it makes state transitions explicit.
- The two states that represent the application behavior become explicit in the code, instead of being a series of conditional statements.
- The number of classes to manage is bigger than if it was only one representing both states, but it is still a reasonable amount.

#### GUI

**Problem in Context**

We had to develop a text-based game and use 'lanterna' as its GUI framework.
However, the vast majority of the 'lanterna' library functions weren't necessary at all, since we only needed to use a few of the available capabilities of 'lanterna'.
So, if we did nothing, we would end up depending on a general purpose interface, instead of a client specific interface, which goes against the **Interface Segregation Principle (ISP)**.
Beyond this, by using the raw library, our game - which is a high-level module - would depend on a low-level module; this does not obey to the **Dependcy Inversion Principle (DIP)**.

**The Pattern**

We have applied the **Facade** pattern.
This structural design pattern allowed us to provide a simple interface to a complex library that contains a lot of unneeded parts.
So, this way we could only include the 'lanterna' features that we really wanted and needed to use.

**Implementation**

In the code, the GUI interface contains the signatures of the functions from the 'lanterna' framework that will be used on the program, and the LanternaGUI class implements this interface.
As the code makes it clear, we were able to significantly remove the unwanted dependencies and focus only on what we should focus.

The following UML class diagram shows how the pattern roles, operations and associations were mapped to the concrete design classes.

![Alt text](images/gui-UML.png?raw=true "GUI UML")

These classes can be found in the following files:

- [GUI](../src/main/java/pt/up/fe/bomberman/gui/GUI.java)
- [LanternaGUI](../src/main/java/pt/up/fe/bomberman/gui/LanternaGUI.java)

**Consequences**

The use of the Facade Pattern in the current design allows the following benefits:

- It makes the framework easy to use by removing needlessly complexity.
- It promotes and facilitates testability.
- It allows us to truly specify the functions we need for our program.

#### MODEL, VIEW AND CONTROLLER - ARCHITECTURAL PATTERN

**Problem in Context**

Behind all the code and the design patterns, there must be at least one architectural pattern that organizes the code.
As we were developing a user interface that uses a GUI, we had to choose a pattern that fitted our needs.
We also wanted to comply with the **Single Responsibility Principle (SRP)**, by having a program on which each software module had one and only one reason to change.

**The Pattern**

We have applied the **Model-View-Controller (MVC)** pattern.
This architectural pattern divides the application into three parts:
1. Model: only represents the data, does not know the 'rules' of the game and does not depend on anything else
2. View: displays the model data and sends user actions to the controller
3. Controller: provides model data to the view, and interprets user actions, following the game 'rules'

**Implementation**

In the code, we have three packages (besides the GUI and the States ones, already described): the Model, the View and the Controller.
As the pattern states, the classes which belong to the model only store data, the ones which are part of the view are responsible for the visual of the game, and the remaining constitute the controller, therefore they are in charge of the logic behind the game.

The following UML class diagram shows how the pattern roles, operations and associations were mapped to the concrete design classes.

![Alt text](images/mvc-UML.png?raw=true "MVC UML")

These classes can be found in the following packages:

- [Model](../src/main/java/pt/up/fe/bomberman/model)
- [View](../src/main/java/pt/up/fe/bomberman/viewer)
- [Controller](../src/main/java/pt/up/fe/bomberman/controller)

**Consequences**

The use of the Model-View-Controller Pattern in the current design allows the following benefits:

- It makes the code well-organized.
- It facilitates the addition of new features.
- It improves code testability and readability.

### KNOWN CODE SMELLS AND REFACTORING SUGGESTIONS

#### SWITCH STATEMENTS

The `Enemy` and `Powerup` classes have an extensive enum and following complex switch statements related to it.
This is problematic because it isn't just suboptimal, but also turns readability worse and might be an incorrect application of object-oriented programming.

A way to improve the code would be to create separate classes for each type of Enemy and Powerup, making them subclasses extending the Enemy and Powerup abstract classes, respectively.
However, it would create another code smell (Lazy Class), as the code doesn't change much for each particular subclass.
So, we decided to leave the code it as it is, as a way to not harm the code's structure and readability.


#### LARGE CLASS

Some classes, like `Arena`, contain many fields, and others, like `LanternaGUI`, contain many methods.
This is problematic because it can turn these classes hard to work and interact with.

A way to improve the code would be to move those fields/methods to another classes, splitting the existing ones.
However, that would not make much sense according to the Model-View-Controller architectural pattern, since the referred classes require the fields and the methods that they have.
So, we decided to leave the code as it is, in order to respect the Model-View-Controller architectural pattern and keep the code well-structured.

#### DATA CLASS

When using the Model-View-Controller pattern, the model classes fall into the Data Classes smell, as they only contain data about the model and close to little methods.
This might be problematic because it would make the code cleaner if those classes didn't exist.

A way to improve the code would be to not strictly follow the Model-View-Controller architectural pattern, moving the data to another classes.
However, that would not help on the code organization, and it would neither promote testability, nor readability.
So, we decided to leave the code as it is, because we believe that this doesn't need to be corrected, as it only happens because we chose to use this architectural pattern.


#### FEATURE ENVY

By using the Model-View-Controller pattern on our game, we end up falling in some code smells that we can't avoid, if we want to use this pattern.
Therefore, the Controller classes end up envying their respective model, which means there is excessive coupling between classes.

A way to improve the code would, once again, lead us to a path where we could not follow the architectural pattern we chose.
However, we believe that we made the best possible choice regarding the possible architectural patterns.
So, we decided to leave the code as it is, for all the already cited reasons.


#### MESSAGE CHAINS

Additionally, the methods to get data from the models get chained one after another with methods that alter the model's behaviour.
This is problematic, between other reasons, because the code gets hard to read after a certain length of chained calls, and it is a symptom of excessive coupling between classes.

A way to improve the code and avoid this code smell would be extracting those chains to an auxiliary method.
However, it would create a middleman method smell and the lazy method smell, as those chains aren't used as often.
So, we decided to leave the code as it is, because we think we get more good than bad out of the Model-View-Controller pattern.

### TESTING

- Screenshot of coverage report.

![Alt text](images/coverage.png?raw=true "Coverage Report")

- [Link to mutation testing report](reports/pitest/202212240426/index.html)

### SELF-EVALUATION

- Diogo Sarmento: 33%
- Manuel Neto: 33%
- Tomás Vicente: 33%

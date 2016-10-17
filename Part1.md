# Part 1. Creating the project and JavaFX manager class.

## Creating the project in Eclipse that works with JavaFX
You will need the Eclipse IDE which can be found at [eclipse.org](http://eclipse.org).
Once you have it downloaded and set up, create a new JavaFX project called "platformer".

You will need to inform Eclipse that you will be using JavaFX for this project.
By default, it will not allow you to access JavaFX API. (For more information, see the second answer [of this StackOverflow post](http://stackoverflow.com/questions/33383248/eclipse-mars-wont-auto-import-javafx)

1. Go to Project ▸ Properties and select Java Build Path in the sidebar of the Properties Window.
2. Go to the Libraries tab and click the disclosure triangle next to JRE System Library.
3. Double click "Access Rules" and then "Add" a new access rule with Resolution: Accessible and Rule Pattern: javafx/**

You should now be able to use JavaFX in the Eclipse project.

## Creating the Main class
The Main class that you will create in this part will do all of the interfacing with JavaFX necessary to create a window, run a frame loop, and respond to keyboard input. Once you create this class, you can use it as the foundation for any JavaFX game you make.

If you don't want to set up this class yourself, you can add [this starter file](Main.java) to your project and skip straight to part 2 of the tutorial series. Otherwise, read on.

### Creating the class
To create the new class, go to File ▸ New ▸ Class and name it Main. Have Main extend the Application class (javafx.application.Application). This is the main JavaFX class. It has methods for displaying a new window and setting up all of the JavaFX classes within the window.

### Main method
The static method that the Application class uses to create a new Main object with its own window is called `launch(String[] args)`. But the static method that Eclipse uses to run your class is called `public static void main(String[] args)`. To link these two together, so that you can use Eclipse to run your JavaFX project directly, add the following method to your Main class:

```java
public static void Main(String[] args)
{
  launch(args);
}
```

### Imports and variables
Now we're going to add a bunch of imports to make sure we can use all of the classes we will need. If you ever use a JavaFX class that you haven't imported, Eclipse will ask you what to import. Make sure that in those cases you choose the `javafx.something` version of the class so that you aren't importing from, say, `java.awt`. For this part, we will just import everything upfront so that we don't have to deal with that.
So add the following statements before your class declaration in Main.java:
```java
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.event.EventType;
```
Now

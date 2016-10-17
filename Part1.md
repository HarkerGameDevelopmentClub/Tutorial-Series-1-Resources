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

### Importing JavaFX classes
If you use a JavaFX class that you haven't imported, Eclipse will ask you what to import. In some cases, it will present classes that have the same name but are not from JavaFX. If this happens, find the `javafx.` class and import that.

To avoid this import process for this part, you can import all of the classes that will be used directly:
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

### Variables
The following variables will be used in the Main class. They are provided here to simplify the writing of the remainder of the class.
```java
private Canvas canvas;
private GraphicsContext context;
private AnimationTimer timer;
private int frameNumber = 0;

private static int WINDOW_WIDTH = 800;
private static int WINDOW_HEIGHT = 600;
```
`canvas` is the JavaFX canvas on which each frame is drawn. Actual drawing calls are made to the `context` object, which has methods like `drawImage(x, y, width, height)`. The `timer` object will periodically tell the Main class to draw a new frame, and the `frameNumber` can be used to set periodic events to occur in the following fashion:
```java
if (frameNumber % 600 == 0) {doSomething();}
```
The above, if called every frame, would only perform `doSomething()` about once every 10 seconds (assuming 60 frames per second).

The static variables `WINDOW_WIDTH` and `WINDOW_HEIGHT` will be used in the window configuration in the `start(Stage stage)` method, which you will create next.

### The `start` method
This is the last method you will need to write before your class compiles and runs correctly. The method signature is
```java
@Override
public void Start(Stage stage)
```
`stage` is the class that manages the window of the application. You can change the title of the `stage` and prevent users from resizing it (I don't think that the canvas will resize with the stage either way, so it's best to keep the stage size immutable).
```java
stage.setTitle("platformer");
stage.setResizable(false);
```
In the `start` method, you will assign the `canvas` object to a new `Canvas` that has the dimensions you specified in static variables. Then you will assign the `context` object to the `GraphicsContext` of the canvas.
```java
canvas = new Canvas(WINDOW_WIDTH, WINDOW_HEIGHT);
context = canvas.getGraphicsContext2D();
```
The `canvas` needs to be assigned to the `stage`, but the `stage` will only take a `Scene`.
As in an actual theater, the `Scene` controls what `Group` of objects are currently on the `stage`. It could contain buttons and other JavaFX UI elements, but in games, all that is necessary is the `canvas`.
With that in mind, create a new `Scene` with the `canvas` and assign it to the `stage`:
```java
Scene scene = new Scene(new Group(canvas));
stage.setScene(scene);
```
You can now `show` the `stage` to display it:
```java
stage.show();
```
For now, the `start` method is complete. Later, you will add set-up code for keyboard input and the frame loop to this method. For now, run the application in Eclipse to make sure that it displays a window with the title you specified. You can try adding drawing code to the `start` method to draw text on the canvas:
```java
context.setFill(Color.BLACK);
context.fillText("Hello, world!, 200, 200);
```

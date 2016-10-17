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

To create the new class, go to File ▸ New ▸ Class and name it Main. Have Main extend the Application class (javafx.application.Application). This is the main JavaFX class. It has methods for displaying a new window and setting up all of the JavaFX classes within the window.

## Main method
The static method that the Application class uses to create a new Main object with its own window is called `launch(String[] args)`. But the static method that Eclipse uses to run your class is called `public static void main(String[] args)`. To link these two together, so that you can use Eclipse to run your JavaFX project directly, add the following method to your Main class:

```java
public static void Main(String[] args)
{
  launch(args);
}
```

## Importing JavaFX classes
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

## Variables
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

## The `start` method
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
Congratulations! You've created a working JavaFX project!

For the remainder of this part, you will be dealing with more game architecting, not just JavaFX library calls. Make sure that you understand the ideas behind the frame loop and the keyboard input handling system.

## The frame loop
You will now learn how to add a frame loop to the Main class. The frame loop is an essential component of any game. It manages the process of updating the game state and re-drawing the entire game every frame, 60 times a second.
The first method that you will create is the `nextFrame()` method, which will be called every frame:
```java
public void nextFrame() {
	updateGameState();
	renderFrame();
}
```
The `nextFrame()` method just calls two other methods, one to update the game data (e.g. change the position of a moving character) and the other to draw the frame based on the newly updated game state.
You will now create these two methods. The `updateGameState()` method will update the `frameNumber`, while the `renderFrame()` method will clear the canvas at the start of each frame.
```java
public void updateGameState() {
	frameNumber++;
}
	
public void renderFrame() {
	context.clearRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
}
```
You can also add the following to the `renderFrame()` method to make sure that it is working properly:
```java
context.fillText(
	"Hello, frame " + frameNumber,
	WINDOW_WIDTH / 2,
	WINDOW_HEIGHT / 2
	);
}
```
Now that you have the frame loop methods, they need to be called every frame. To do this, you can use the `AnimationTimer` class.

Add the following code to the `start` method:
```java
timer = new AnimationTimer() {
	@Override
	public void handle(long now) {
		nextFrame();
	}	
};
timer.start();
```
This is a very fascinating piece of code. Essentially, you have defined an entirely new subclass of `AnimationTimer` that, when prompted to handle a new frame, calls its enclosing class (i.e. the Main class)'s `nextFrame()` method. You have then assigned this timer to the instance variable created earlier in this part and started it.

Now, if you run the project, it should display the current frame.
Another bold step forward! The last thing that you will write in this part is keyboard input functionality.

## Keyboard input
Keyboard input is fairly complicated. It follows the JavaFX event handling model: a class which is a designated `EventHandle`r receives and `Event` and processes it.

In this case, you will make the `Main` class the `EventHandler` for `KeyEvent`s. First, add the following to the `Main` class signature, after `extends Application`:
```java
implements EventHandler<KeyEvent>
```
To make `Main` comply with the requirements of this interface, create a new method, `public void handle(KeyEvent event)`.

This method will eventually receive both events for a key being pressed and events for a key being released. To distinguish between the two, use the `event.getEventType()`. It will either have the value of `KeyEvent.KEY_PRESSED` or `KeyEvent.KEY_RELEASED`.

You can retrive which key was pressed with `event.getCode().toString()`. Note that for some keys, like "A" and "a", the string value is the same as the actual key. But for some, like numbers, it's unusual: "DIGIT8" is provided for the number "8". When in doubt, log the value of the pressed key to the console.

In any case, to simplify key event handling, you could use two separate methods, `keyPressed(String key)` and `keyReleased(String key)`, and have `handle(KeyEvent event)` call one of them, depending on the kind of key event it was passed. A sample implementation of these three methods is provided below.
```java
@Override
public void handle(KeyEvent event) {
	EventType<KeyEvent> eventType = event.getEventType();
	String key = event.getCode().toString();
	if (eventType == KeyEvent.KEY_PRESSED) {
		keyPressed(key);
	}
	else if (eventType == KeyEvent.KEY_RELEASED) {
		keyReleased(key);
	}
}

public void keyPressed(String key) {
	System.out.println(key + " pressed");
}

public void keyReleased(String key) {
	System.out.println(key + " released");
}
```
The implementations of `keyPressed` and `keyReleased` here are dummy implementations that print out the value of the key being pressed or released.

If you ran the project now . . . nothing would happen. The `Main` class needs to be assigned to receive key events. Add the following code to the `start` method:
```java
scene.setOnKeyPressed(this);
scene.setOnKeyReleased(this);
```

*Now* when you run the project, it should respond to keyboard input.

That's it! You've completed Part 1 of the platformer tutorial, and you've created a Main class that can be used to create any kind of game.

## Next steps
Try [Part 2](

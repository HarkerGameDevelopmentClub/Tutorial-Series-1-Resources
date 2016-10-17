package platformer;

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

public class Main extends Application implements EventHandler<KeyEvent> {

	private Canvas canvas;
	private GraphicsContext context;
	private AnimationTimer timer;
	private int frameNumber = 0;
	
	private static int WINDOW_WIDTH = 800;
	private static int WINDOW_HEIGHT = 600;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		canvas = new Canvas(WINDOW_WIDTH, WINDOW_HEIGHT);
		context = canvas.getGraphicsContext2D();
		
		timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				nextFrame();
			}	
		};
		timer.start();
		
		Scene scene = new Scene(new Group(canvas));
		scene.setOnKeyPressed(this);
		scene.setOnKeyReleased(this);
		
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	public void nextFrame() {
		updateGameState();
		renderFrame();
	}
	
	public void updateGameState() {
		frameNumber++;
	}
	
	public void renderFrame() {
		context.clearRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
		context.setFill(Color.BLACK);
		context.fillText(
				"Hello, frame " + frameNumber,
				WINDOW_WIDTH / 2,
				WINDOW_HEIGHT / 2
				);
	}
	
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
}

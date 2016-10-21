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

public class Main extends Application {

	private Canvas canvas;
	private GraphicsContext context;
	
	private static int WINDOW_WIDTH = 800;
	private static int WINDOW_HEIGHT = 600;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		canvas = new Canvas(WINDOW_WIDTH, WINDOW_HEIGHT);
		context = canvas.getGraphicsContext2D();
		
		Scene scene = new Scene(new Group(canvas));
		stage.setWidth(WINDOW_WIDTH);
		stage.setHeight(WINDOW_HEIGHT);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
}

package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage ps) {
        ps.setTitle("Animation example");
        Group root = new Group();
        Scene myScene = new Scene(root);
        ps.setScene(myScene);

        Canvas canvas = new Canvas(512, 512);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Image road = new Image("road.png");
        Image car = new Image("car.png");

        final long startTime = System.nanoTime();

        new AnimationTimer() {
            @Override
            public void handle(long t) {
                double diff = (t - startTime) / 1000000000.0;

                gc.drawImage(road, 0, Math.sqrt(Math.exp(diff)));
                gc.drawImage(car, 256, 256);
            }
        }.start();
        ps.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
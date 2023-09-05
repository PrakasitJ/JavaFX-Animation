package my.animation.animation.controllers;

import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class PunchController {
    @FXML private VBox parent;
    Image image = new Image("file:src/main/resources/Images/jump.png");
    private int currentFrame = 0;
    private GridPane grid;
    private int rows = 11;
    private int cols = 16;
    private double cellWidth = image.getWidth() / cols;
    private double cellHeight = image.getHeight() / rows;

    public void initialize() {
        Image image = new Image("file:src/main/resources/Images/jump.png");
        grid = new GridPane();

        loadFirstAnimation();

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                parent.getChildren().clear();
                ImageView currentImageView = (ImageView) grid.getChildren().get(currentFrame);
                ImageView newView = new ImageView(currentImageView.getImage());
                parent.getChildren().add(newView);

                currentFrame++;

                if (currentFrame >= grid.getChildren().size()) {
                    stop();
                    currentFrame = 0;
                    loadFirstAnimation();
                }
            }
        };

        PauseTransition delay = new PauseTransition(Duration.millis(100));
        delay.setOnFinished(e -> {
            animationTimer.handle(0);
            delay.play();
        });
        delay.play();

        parent.setOnMouseClicked(click -> {
            currentFrame = 0;
            loadSecondAnimation();
            delay.play();
        });

        Platform.runLater(() -> {
            Scene scene = parent.getScene();
            scene.addEventFilter(KeyEvent.KEY_PRESSED, keyEvent -> {
                if(keyEvent.getCode() == KeyCode.SPACE){
                    currentFrame = 0;
                    jump();
                    delay.play();
                }
            });
        });

    }

    private Image crop(Image image, double x, double y, double width, double height) {
        PixelReader reader = image.getPixelReader();
        WritableImage newImage = new WritableImage(reader, (int) x, (int) y, (int) width, (int) height);
        return newImage;
    }

    private void loadFirstAnimation() {
        grid.getChildren().clear();
        for (int y = 0; y < 1; y++) {
            for (int x = 0; x < 5; x++) {
                ImageView imageView = new ImageView(crop(image, x * cellWidth, y * cellHeight, cellWidth, cellHeight));
                grid.add(imageView, x, y);
            }
        }
    }

    private void loadSecondAnimation() {
        grid.getChildren().clear();
        for (int x = 9; x < 16; x++) {
            ImageView imageView = new ImageView(crop(image, x * cellWidth, 6 * cellHeight, cellWidth, cellHeight));
            grid.add(imageView, x, 0);
        }
    }

    private void jump(){
        grid.getChildren().clear();
        for (int x = 0; x < 7; x++) {
            ImageView imageView = new ImageView(crop(image, x * cellWidth, 4 * cellHeight, cellWidth, cellHeight));
            grid.add(imageView, x, 0);
        }
        ImageView imageView = new ImageView(crop(image, 0 * cellWidth, 4 * cellHeight, cellWidth, cellHeight));
        grid.add(imageView,8,0);
    }

}


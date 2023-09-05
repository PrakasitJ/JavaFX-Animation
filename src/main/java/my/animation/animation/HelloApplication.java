package my.animation.animation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        File file = new File("src/main/resources/my/animation/views/hello-view.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(file.toURL());
        Scene scene = new Scene(fxmlLoader.load(), 900, 1000);
        stage.setTitle("Animation");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
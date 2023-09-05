package my.animation.animation.controllers;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;
import my.animation.animation.services.MyAnimation;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class HelloController {
    @FXML private VBox parent;

    @FXML
    public void initialize(){
        parent.setStyle("-fx-font-size: 14;");

        Button linear = new Button("LINEAR");
        MyAnimation.InterpolatorLINEAR(linear);

        Button discrete = new Button("DISCRETE");
        MyAnimation.InterpolatorDISCRETE(discrete);

        Button ease_in = new Button("EASE_IN");
        MyAnimation.InterpolatorEASE_IN(ease_in);

        Button ease_out = new Button("EASE_OUT");
        MyAnimation.InterpolatorEASE_OUT(ease_out);

        Button ease_both = new Button("EASE_BOTH");
        MyAnimation.InterpolatorEASE_BOTH(ease_both);

        Button spline = new Button("SPLINE");
        MyAnimation.InterpolatorSPLINE(spline);

        Label fade = new Label("FADE");
        MyAnimation.FadeTransition(fade);

        Circle fill = new Circle(25);
        MyAnimation.FillTransition(fill);

        Label path = new Label("PATH");
        MyAnimation.PathTransition(path);

        Label pause = new Label("PAUSE");
        MyAnimation.PauseTransition(pause);

        Label rotate = new Label("ROTATE");
        MyAnimation.RotateTransition(rotate);

        Label scale = new Label("SCALE");
        MyAnimation.ScaleTransition(scale);

        Label sequential = new Label("SEQUENTIAL");
        MyAnimation.SequentialTransition(sequential);

        Circle stroke = new Circle(25);
        MyAnimation.StrokeTransition(stroke);

        Label translate = new Label("TRANSLATE");
        MyAnimation.TranslateTransition(translate);

        Label timeline = new Label("TIMELINE");
        MyAnimation.Timeline(timeline);

        Circle animationTimer = new Circle(25);
        MyAnimation.AnimationTimer(animationTimer);

        Label parallel = new Label("PARALLEL");
        MyAnimation.ParallelTransition(parallel);

        Button next = new Button("Next");
        next.setOnMouseClicked(click -> {
            URL url = getClass().getResource("/my/animation/views/punch.fxml");
            if (url == null) {
                throw new RuntimeException("Resource not found: /my/animation/views/punch.fxml");
            }
            FXMLLoader fxmlLoader = new FXMLLoader(url);
            try {
                Parent newRoot = fxmlLoader.load();
                Scene currentScene = parent.getScene();
                Stage stage = (Stage) currentScene.getWindow();
                stage.close();
                Scene newScene = new Scene(newRoot, 100, 100);
                stage.setScene(newScene);
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        parent.getChildren().addAll(linear,discrete,ease_in,ease_out,ease_both,spline,fade,fill,path,pause,rotate,scale,sequential,stroke,translate,timeline,animationTimer,parallel,next);
    }

}
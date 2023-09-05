package my.animation.animation.services;

import javafx.animation.*;
import javafx.geometry.Insets;
import javafx.scene.control.Control;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.util.concurrent.atomic.DoubleAdder;

public class MyAnimation {
    public static void InterpolatorLINEAR(Control control){
        control.setStyle("-fx-border-color: GREEN");

        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1), control);
        scaleTransition.setToX(1.25);
        scaleTransition.setToY(1.25);
        scaleTransition.setAutoReverse(true);
        scaleTransition.setCycleCount(Animation.INDEFINITE);
        scaleTransition.setInterpolator(Interpolator.LINEAR);
        scaleTransition.play();
    }

    public static void InterpolatorDISCRETE(Control control){
        control.setStyle("-fx-border-color: GREEN");

        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1), control);
        scaleTransition.setToX(1.25);
        scaleTransition.setToY(1.25);
        scaleTransition.setAutoReverse(true);
        scaleTransition.setCycleCount(Animation.INDEFINITE);
        scaleTransition.setInterpolator(Interpolator.DISCRETE);
        scaleTransition.play();
    }

    public static void InterpolatorEASE_IN(Control control){
        control.setStyle("-fx-border-color: GREEN");

        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1), control);
        scaleTransition.setToX(1.25);
        scaleTransition.setToY(1.25);
        scaleTransition.setAutoReverse(true);
        scaleTransition.setCycleCount(Animation.INDEFINITE);
        scaleTransition.setInterpolator(Interpolator.EASE_IN);
        scaleTransition.play();
    }

    public static void InterpolatorEASE_OUT(Control control){
        control.setStyle("-fx-border-color: GREEN");

        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1), control);
        scaleTransition.setToX(1.25);
        scaleTransition.setToY(1.25);
        scaleTransition.setAutoReverse(true);
        scaleTransition.setCycleCount(Animation.INDEFINITE);
        scaleTransition.setInterpolator(Interpolator.EASE_OUT);
        scaleTransition.play();
    }

    public static void InterpolatorEASE_BOTH(Control control){
        control.setStyle("-fx-border-color: GREEN");

        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1), control);
        scaleTransition.setToX(1.25);
        scaleTransition.setToY(1.25);
        scaleTransition.setAutoReverse(true);
        scaleTransition.setCycleCount(Animation.INDEFINITE);
        scaleTransition.setInterpolator(Interpolator.EASE_BOTH);
        scaleTransition.play();
    }

    public static void InterpolatorSPLINE(Control control){
        control.setStyle("-fx-border-color: GREEN");

        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1), control);
        scaleTransition.setToX(1.25);
        scaleTransition.setToY(1.25);
        scaleTransition.setAutoReverse(true);
        scaleTransition.setCycleCount(Animation.INDEFINITE);
        scaleTransition.setInterpolator(Interpolator.SPLINE(0.1,0.1,1,1));
        scaleTransition.play();
    }

    public static void FadeTransition(Control control){
        FadeTransition fade = new FadeTransition(Duration.seconds(2), control);
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.setAutoReverse(true);
        fade.setCycleCount(Animation.INDEFINITE);
        fade.play();
    }

    public static void FillTransition(Shape shape){
        FillTransition fill = new FillTransition(Duration.seconds(2), shape);
        fill.setToValue(javafx.scene.paint.Color.RED);
        fill.setAutoReverse(true);
        fill.setCycleCount(Animation.INDEFINITE);
        fill.play();
    }

    public static void PathTransition(Control control){
        Path path = new Path();
        path.getElements().add(new MoveTo(-200, -200));
        path.getElements().add(new LineTo(0, 0));
        path.getElements().add(new LineTo(200, -200));
        path.getElements().add(new LineTo(-200, -200));

        PathTransition pathTransition = new PathTransition(Duration.seconds(2), path, control);
        pathTransition.setAutoReverse(true);
        pathTransition.setCycleCount(Animation.INDEFINITE);
        pathTransition.play();
    }

    public static void PauseTransition(Control control){
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(event -> control.setStyle("-fx-text-fill: GREEN"));
        pause.play();
    }

    public static void RotateTransition(Control control){
        RotateTransition rotate = new RotateTransition(Duration.seconds(2), control);
        rotate.setByAngle(360);
        rotate.setAutoReverse(true);
        rotate.setCycleCount(Animation.INDEFINITE);
        rotate.play();
    }

    public static void ScaleTransition(Control control){
        ScaleTransition scale = new ScaleTransition(Duration.seconds(2), control);
        scale.setToX(2);
        scale.setToY(2);
        scale.setAutoReverse(true);
        scale.setCycleCount(Animation.INDEFINITE);
        scale.play();
    }

    public static void SequentialTransition(Control control){
        ScaleTransition scale = new ScaleTransition(Duration.seconds(2), control);
        scale.setToX(2);
        scale.setToY(2);
        scale.setAutoReverse(true);
        scale.setCycleCount(2);

        RotateTransition rotate = new RotateTransition(Duration.seconds(2), control);
        rotate.setByAngle(360);
        rotate.setAutoReverse(true);
        rotate.setCycleCount(2);

        FadeTransition fade = new FadeTransition(Duration.seconds(2), control);
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.setAutoReverse(true);
        fade.setCycleCount(2);


        SequentialTransition seq = new SequentialTransition(scale,rotate,fade);
        seq.setAutoReverse(true);
        seq.setCycleCount(Animation.INDEFINITE);
        seq.play();
    }

    public static void StrokeTransition(Shape shape){
        shape.setStrokeWidth(5);
        StrokeTransition stroke = new StrokeTransition(Duration.seconds(2), shape);
        stroke.setFromValue(Color.BLACK);
        stroke.setToValue(Color.GREEN);
        stroke.setAutoReverse(true);
        stroke.setCycleCount(Animation.INDEFINITE);
        stroke.play();
    }

    public static void TranslateTransition(Control control){
        TranslateTransition translate = new TranslateTransition(Duration.seconds(2), control);
        translate.setByX(200);
        translate.setAutoReverse(true);
        translate.setCycleCount(Animation.INDEFINITE);
        translate.play();
    }

    public static void Timeline(Control control){
        KeyFrame keyFrame1 = new KeyFrame(Duration.seconds(1),new KeyValue(control.prefWidthProperty(),100));
        KeyFrame keyFrame2 = new KeyFrame(Duration.seconds(2),new KeyValue(control.rotateProperty(), 360));
        KeyFrame keyFrame3 = new KeyFrame(Duration.seconds(3),new KeyValue(control.prefWidthProperty(),-100));

        Timeline timeline = new Timeline(keyFrame1,keyFrame2,keyFrame3);
        timeline.setAutoReverse(true);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public static void AnimationTimer(Shape shape){
        final double[] move = {3};

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                shape.setTranslateX(shape.getTranslateX()+ move[0]);
                if (shape.getTranslateX() >= 360 || shape.getTranslateX() <= -360) {
                    move[0] *= -1;
                }
            }
        };
        timer.start();
    }

    public static void ParallelTransition(Control control){
        ScaleTransition scale = new ScaleTransition(Duration.seconds(2), control);
        scale.setToX(2);
        scale.setToY(2);
        scale.setAutoReverse(true);
        scale.setCycleCount(2);

        RotateTransition rotate = new RotateTransition(Duration.seconds(2), control);
        rotate.setByAngle(360);
        rotate.setAutoReverse(true);
        rotate.setCycleCount(2);

        FadeTransition fade = new FadeTransition(Duration.seconds(2), control);
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.setAutoReverse(true);
        fade.setCycleCount(2);


        ParallelTransition parallelTransition = new ParallelTransition(scale,rotate,fade);
        parallelTransition.setAutoReverse(true);
        parallelTransition.setCycleCount(Animation.INDEFINITE);
        parallelTransition.play();

    }









}

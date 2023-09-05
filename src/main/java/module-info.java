module my.animation.animation {
    requires javafx.controls;
    requires javafx.fxml;


    opens my.animation.animation to javafx.fxml;
    exports my.animation.animation;

    exports my.animation.animation.controllers;
    opens my.animation.animation.controllers to javafx.fxml;
}
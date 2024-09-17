package com.op_test.service;

import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class ButtonService {

//    public static void onButtonClick(MouseEvent event, String pressedImagePath, String normalImagePath, Player) {}

    public static void onButtonPressed(MouseEvent event, String pressedImagePath) {
        StackPane stackPane = (StackPane) event.getSource();
        ImageView button = (ImageView) stackPane.getChildren().get(0);
        button.setImage(new Image(pressedImagePath));

        Text buttonText = (Text) stackPane.getChildren().get(1);
        buttonText.setTranslateY(5);

        ColorAdjust textEffect = new ColorAdjust();
        textEffect.setBrightness(-0.5);
        buttonText.setEffect(textEffect);
    }

    public static void onButtonReleased(MouseEvent event, String normalImagePath) {

        StackPane stackPane = (StackPane) event.getSource();
        ImageView button = (ImageView) stackPane.getChildren().get(0);
        button.setImage(new Image(normalImagePath));

        Text buttonText = (Text) stackPane.getChildren().get(1);
        buttonText.setTranslateY(-5);
        buttonText.setEffect(null);
    }
}

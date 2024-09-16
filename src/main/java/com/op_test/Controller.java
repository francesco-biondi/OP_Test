package com.op_test;

import com.op_test.enemy.Enemy;
import com.op_test.player.Player;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ImageView background;

    @FXML
    private ProgressBar health_bar;

    @FXML
    private ImageView enemy, pistol;

    @FXML
    private StackPane button_1, button_2, button_3, button_4;

    // Mapa de imágenes de los botones presionados y normales
    private final String normalImagePath = "file:src/main/resources/assets/common/button_normal.png";
    private final String pressedImagePath = "file:src/main/resources/assets/common/button_pressed.png";

    protected boolean isAnimating = false;

    Player player = new Player("Fran", enemy);
    Enemy en = new Enemy("Rob Lucci", 100, enemy);

    @FXML
    void attack(MouseEvent event) {

        System.out.println(en.dealDamage(player.getAbility(0).use()));
        System.out.println(player.getAbility(0).getName());
        health_bar.setProgress(en.getHealth() / en.maxHealth);
        player.getAbility(0).animation(null, enemy);
    }


    @FXML
    void fist_cursor(MouseEvent event) {

        // Ruta de la imagen del cursor (asegúrate de que esté en tu carpeta de recursos)
        Image cursorImage = new Image("file:src/main/resources/com/op_test/fist_cursor.png");

        // Crear un ImageCursor con la imagen y los puntos de anclaje (hotspot)
        ImageCursor customCursor = new ImageCursor(cursorImage, cursorImage.getWidth() / 2, cursorImage.getHeight() / 2);

        // Obtener la escena principal (asume que tienes acceso al Stage principal)
        Scene scene = Stage.getWindows().get(0).getScene();

        // Establecer el cursor personalizado en la escena
        scene.setCursor(customCursor);

    }

    @FXML
    void reset_cursor(MouseEvent event) {
        // Obtener la escena principal
        Scene scene = Stage.getWindows().get(0).getScene();

        // Restablecer el cursor al predeterminado
        scene.setCursor(Cursor.DEFAULT);
    }

    @FXML
    void button_pressed(MouseEvent event) {
        StackPane stackPane = (StackPane) event.getSource(); // Identificar cuál botón fue presionado
        ImageView button = (ImageView) stackPane.getChildren().get(0);
        button.setImage(new Image(pressedImagePath));

        Text buttonText = (Text) stackPane.getChildren().get(1);
        buttonText.setTranslateY(5);

        ColorAdjust textEffect = new ColorAdjust();
        textEffect.setBrightness(-0.5);
        buttonText.setEffect(textEffect);

        System.out.println(en.dealDamage(player.getAbility(1).use()));
        System.out.println(player.getAbility(1).getName());
        health_bar.setProgress(en.getHealth() / en.maxHealth);
        player.getAbility(1).animation(pistol, enemy);
    }

    @FXML
    void button_released(MouseEvent event) {
        StackPane stackPane = (StackPane) event.getSource(); // Identificar cuál botón fue presionado
        ImageView button = (ImageView) stackPane.getChildren().get(0);
        button.setImage(new Image(normalImagePath));

        Text buttonText = (Text) stackPane.getChildren().get(1);
        buttonText.setTranslateY(-5);

        buttonText.setEffect(null);
    }

}

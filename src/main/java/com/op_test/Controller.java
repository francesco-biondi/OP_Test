package com.op_test;

import com.op_test.characters.Enemy;
import com.op_test.characters.Player;
import com.op_test.service.CursorService;
import com.op_test.service.PlayerService;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ImageView background;

    @FXML
    private ProgressBar health_bar;

    @FXML
    private ImageView enemyImage, pistolImage;

    @FXML
    private StackPane button_1, button_2, button_3, button_4;

    private Player player;
    private Enemy enemy;

    @FXML
    public void initialize() {
        this.player = new Player("Fran");
        this.enemy = new Enemy("Rob Lucci", 100, enemyImage);
    }

    @FXML
    void attack(MouseEvent event) {
        PlayerService.performBasicAttack(player, enemy, health_bar);
    }

    @FXML
    void fist_cursor(MouseEvent event) {
        CursorService.setCursorToFist(Stage.getWindows().get(0).getScene());
    }

    @FXML
    void reset_cursor(MouseEvent event) {
        CursorService.resetCursor(Stage.getWindows().get(0).getScene());
    }

    @FXML
    void button_pressed(MouseEvent event) {
        PlayerService.onAbilityUse(event, player, enemy, health_bar, pistolImage);
    }

}

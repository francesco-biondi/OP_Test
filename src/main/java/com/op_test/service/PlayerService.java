package com.op_test.service;

import com.op_test.characters.Enemy;
import com.op_test.characters.Player;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class PlayerService {

    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public static void performAttack(Player player, Enemy enemy, ProgressBar health_bar) {
        System.out.println(player.getAbility(0).use(enemy));
        System.out.println(player.getAbility(0).getName());

        health_bar.setProgress(enemy.getHealth() / enemy.MAX_HEALTH);
    }

    public static void onAbilityUse(MouseEvent event, Player player, Enemy enemy, ProgressBar health_bar, ImageView abilityImage)
    {
        StackPane stackPane = (StackPane) event.getSource();

        switch (stackPane.getId()){
            case "button_1":
                if(player.getAbility(1).isAvailable()) {
                    ability1(player, enemy, health_bar, abilityImage);
                }
                break;
            case "button_2":
                if(player.getAbility(2).isAvailable()) {
                    ability2(player, abilityImage);
                }
                break;
            case "button_3":

                break;
            case "button_4":

        }
    }

    private static void ability1(Player player, Enemy enemy, ProgressBar health_bar, ImageView abilityImage){

        System.out.println(player.getAbility(1).use(enemy, abilityImage));
        System.out.println(player.getAbility(1).getName());

        health_bar.setProgress(enemy.getHealth() / enemy.MAX_HEALTH);
    }

    private static void ability2(Player player, ImageView abilityImage){
        System.out.println(player.getAbility(2).use(player, abilityImage));
        System.out.println(player.getAbility(2).getName());
    }


}

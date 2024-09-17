package com.op_test.service;

import com.op_test.abilities.Ability;
import com.op_test.characters.Enemy;
import com.op_test.characters.Player;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PlayerService {

    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public static void performAttack(Player player, Enemy enemy, ProgressBar healthBar) {
        System.out.println(enemy.dealDamage(player.getAbility(0).use()));
        System.out.println(player.getAbility(0).getName());
        healthBar.setProgress(enemy.getHealth() / enemy.maxHealth);
        player.getAbility(0).animation(enemy.getImage(), null);
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
                    ability2(player, enemy, health_bar, abilityImage);
                }
                break;
            case "button_3":

                break;
            case "button_4":

                break;
        }
    }

    private static void cooldown(Ability ability){
        // Make ability unavailable
        ability.setAvailable(false);

        // Schedule to make ability available after cooldown
        scheduler.schedule(() -> {
            ability.setAvailable(true);
        },  ability.getCoolDownTime(), TimeUnit.SECONDS);
    }

    private static void ability1(Player player, Enemy enemy, ProgressBar health_bar, ImageView abilityImage){
        System.out.println(enemy.dealDamage(player.getAbility(1).use()));
        System.out.println(player.getAbility(1).getName());
        health_bar.setProgress(enemy.getHealth() / enemy.maxHealth);
        player.getAbility(1).animation(enemy.getImage(), abilityImage);

        cooldown(player.getAbility(1));
    }

    private static void ability2(Player player, Enemy enemy, ProgressBar health_bar, ImageView abilityImage){
        System.out.println(enemy.dealDamage(player.getAbility(2).use()));
        System.out.println(player.getAbility(2).getName());
        health_bar.setProgress(enemy.getHealth() / enemy.maxHealth);
        player.getAbility(2).animation(enemy.getImage(), abilityImage);

        cooldown(player.getAbility(2));
    }


}

package com.op_test.service;

import com.op_test.characters.Enemy;
import com.op_test.player.Player;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class PlayerService {

    public static void performAttack(Player player, Enemy enemy, ProgressBar healthBar) {
        System.out.println(enemy.dealDamage(player.getAbility(0).use()));
        System.out.println(player.getAbility(0).getName());
        healthBar.setProgress(enemy.getHealth() / enemy.maxHealth);
        player.getAbility(0).animation(null, enemy.getImage());
    }

    public static void onAbilityUse(MouseEvent event,
                                    Player player,
                                    Enemy enemy,
                                    ProgressBar health_bar,
                                    ImageView abilityImage)
    {
        System.out.println(enemy.dealDamage(player.getAbility(1).use()));
        System.out.println(player.getAbility(1).getName());
        health_bar.setProgress(enemy.getHealth() / enemy.maxHealth);
        player.getAbility(1).animation(abilityImage, enemy.getImage());
    }

}

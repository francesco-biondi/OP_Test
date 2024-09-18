package com.op_test.abilities;

import com.op_test.characters.Enemy;
import com.op_test.characters.Target;
import javafx.animation.TranslateTransition;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AttackAbility extends Ability {

    private final double BASE_STRENGTH;
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public AttackAbility(AbilityNames name, double BASE_STRENGTH, double increment, int coolDownTime) {
        type = AbilityTypes.ATTACK;
        this.name = name;
        this.BASE_STRENGTH = BASE_STRENGTH;
        this.strength = BASE_STRENGTH;
        this.increment = increment;
        this.coolDownTime = coolDownTime;
    }

    public void cooldown(){
        isAvailable = false;

        scheduler.schedule(() -> {
            isAvailable = true;
        },  coolDownTime, TimeUnit.SECONDS);
    }

    @Override
    public double use(Target target, ImageView attackImage) {
        return useAbility(target, attackImage);
    }

    @Override
    public double use(Target target) {
        return useAbility(target, null);
    }

    public double useAbility(Target target, ImageView attackImage) {
        if(target instanceof Enemy enemy){
            enemy.setHealth(enemy.getHealth() - strength);
            if(attackImage != null) animation(enemy.getImage(), attackImage);
            cooldown();
            return strength;
        } else {
            throw new IllegalStateException("Target must be an instance of Enemy");
        }
    }

    @Override
    public void upgrade() {
        level++;
        strength += level * increment;
    }

    @Override
    public void animation(ImageView enemy, ImageView attackImage) {

        if(!isAnimating){

            isAnimating = true;

            if(attackImage != null){
                attackImage.setVisible(true);
            }

            // Crear un ajuste de color para el filtro rojo
            ColorAdjust hitEffect = new ColorAdjust();
            hitEffect.setBrightness(0.5);  // Ajuste de color para aplicar un tinte rojizo
            enemy.setEffect(hitEffect);


            TranslateTransition shake = new TranslateTransition(Duration.millis(30), enemy);

            shake.setByX((int)BASE_STRENGTH); // Movimiento hacia la derecha
            shake.setCycleCount((int)BASE_STRENGTH); // Número de ciclos de movimiento hacia la derecha e izquierda

            shake.setAutoReverse(true);
            shake.play();

            shake.setOnFinished(e -> {
                enemy.setEffect(null);
                if(attackImage != null){
                    attackImage.setVisible(false);
                }
                isAnimating = false;
            });

        }

    }
}

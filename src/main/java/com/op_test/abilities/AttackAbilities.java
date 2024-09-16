package com.op_test.abilities;

import javafx.animation.TranslateTransition;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class AttackAbilities extends Abilities {

    protected final int BASE_STRENGTH;

    public AttackAbilities(AbilityNames name, int BASE_STRENGTH, float increment, float coolDownTime) {
        type = AbilityTypes.ATTACK;
        this.name = name;
        this.BASE_STRENGTH = BASE_STRENGTH;
        this.strength = BASE_STRENGTH;
        this.increment = increment;
        this.coolDownTime = coolDownTime;
    }

    @Override
    public float use() {
        return strength;
    }

    @Override
    public void upgrade() {
        level++;
        strength += (int) (level * increment);
    }

    @Override
    public void animation(ImageView attackImage, ImageView enemy) {

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

            shake.setByX(BASE_STRENGTH); // Movimiento hacia la derecha
            shake.setCycleCount(BASE_STRENGTH); // Número de ciclos de movimiento hacia la derecha e izquierda

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

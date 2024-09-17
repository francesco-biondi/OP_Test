package com.op_test.abilities;

import javafx.scene.image.ImageView;

public class BuffAbility extends Ability{

    private final double BASE_STRENGTH;

    public BuffAbility(AbilityNames name, double BASE_STRENGTH, double increment, int coolDownTime) {
        type = AbilityTypes.BUFF;
        this.name = name;
        this.BASE_STRENGTH = BASE_STRENGTH;
        this.strength = BASE_STRENGTH;
        this.increment = increment;
        this.coolDownTime = coolDownTime;
    }

    @Override
    public void animation(ImageView attackImage, ImageView enemy) {

    }

    @Override
    public double use() {
        return strength;
    }

    @Override
    public void upgrade() {
        level++;
        strength += increment;
    }

    public double getBASE_STRENGTH() {
        return BASE_STRENGTH;
    }
}

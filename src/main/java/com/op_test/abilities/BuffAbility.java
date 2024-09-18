package com.op_test.abilities;

import com.op_test.characters.Player;
import com.op_test.characters.Target;
import javafx.scene.image.ImageView;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class BuffAbility extends Ability{

    private final double BASE_STRENGTH;
    private final int duration;
    private Ability buffedAbility;
    double buffedStrength;
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public BuffAbility(AbilityNames name, double BASE_STRENGTH, double increment, int coolDownTime, int duration) {
        type = AbilityTypes.BUFF;
        this.name = name;
        this.BASE_STRENGTH = BASE_STRENGTH;
        this.strength = BASE_STRENGTH;
        this.increment = increment;
        this.coolDownTime = coolDownTime;
        this.duration = duration;
    }

    public void cooldown(){
        isAvailable = false;

        scheduler.schedule(() -> {
            isAvailable = true;
        },  coolDownTime, TimeUnit.SECONDS);
    }

    @Override
    public double use(Target target, ImageView attackImage) {
        return useAbility(target);
    }

    @Override
    public double use(Target target) {
        return useAbility(target);
    }

    private double useAbility(Target target) {
        if (target instanceof Player player) {
            buffedAbility = player.getAbility(0);
            if (buffedAbility != null) {
                applyBuff(buffedAbility);
                scheduler.schedule(() -> {
                    removeBuff(buffedAbility);
                },  duration, TimeUnit.SECONDS);
                cooldown();
                return strength;
            } else {
                throw new IllegalStateException("Player's ability is null");
            }
        } else {
            throw new IllegalArgumentException("Target must be an instance of Player");
        }
    }

    private void applyBuff(Ability buffedAbility) {
        buffedStrength = buffedAbility.getStrength() * strength;
        buffedAbility.setStrength(buffedAbility.getStrength() + buffedStrength);
    }

    private void removeBuff(Ability buffedAbility) {
        buffedAbility.setStrength(buffedAbility.getStrength() - buffedStrength);
    }

    @Override
    public void upgrade() {
        level++;
        strength += increment;
    }

    @Override
    public void animation(ImageView attackImage, ImageView enemy) {

    }

    public double getBASE_STRENGTH() {
        return BASE_STRENGTH;
    }
}

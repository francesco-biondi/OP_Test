package com.op_test.abilities;

import com.op_test.service.SchedulerService;

import java.util.concurrent.TimeUnit;

public abstract class Ability implements I_Ability {

    protected AbilityNames name;
    protected AbilityTypes type;
    protected String description;
    protected int level = 0;
    protected double strength;
    protected double increment;
    protected int coolDownTime;
    protected boolean isAnimating = false;
    protected boolean isAvailable = true;

    public void cooldown(){
        isAvailable = false;

        SchedulerService.getScheduler().schedule(() -> {
            isAvailable = true;
        },  coolDownTime, TimeUnit.SECONDS);

    }

    public AbilityNames getName() {
        return name;
    }

    public void setName(AbilityNames name) {
        this.name = name;
    }

    public AbilityTypes getType() {
        return type;
    }

    public void setType(AbilityTypes type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getIncrement() {
        return increment;
    }

    public void setIncrement(double increment) {
        this.increment = increment;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public int getCoolDownTime() {
        return coolDownTime;
    }

    public void setCoolDownTime(int coolDownTime) {
        this.coolDownTime = coolDownTime;
    }

    public boolean isAnimating() {
        return isAnimating;
    }

    public void setAnimating(boolean animating) {
        this.isAnimating = animating;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

}

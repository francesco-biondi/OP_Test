package com.op_test.abilities;

public abstract class Abilities implements I_Abilities {

    protected AbilityNames name;
    protected AbilityTypes type;
    protected String description;
    protected int level = 0;
    protected int strength;
    protected float increment;
    protected float coolDownTime;
    protected static boolean isAnimating = false;
    protected boolean isAvailable = false;

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

    public float getIncrement() {
        return increment;
    }

    public void setIncrement(float increment) {
        this.increment = increment;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public float getCoolDownTime() {
        return coolDownTime;
    }

    public void setCoolDownTime(float coolDownTime) {
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

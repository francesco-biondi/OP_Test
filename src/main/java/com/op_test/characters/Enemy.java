package com.op_test.characters;

import javafx.scene.image.ImageView;

public class Enemy {
    public final float maxHealth;

    private String name;
    private double health;
    private ImageView image;

    public Enemy(String name, float maxHealth, ImageView image) {
        this.name = name;
        this.maxHealth = maxHealth;
        health = maxHealth;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public double dealDamage(double damage) {
        health -= damage;
        return damage;
    }


}

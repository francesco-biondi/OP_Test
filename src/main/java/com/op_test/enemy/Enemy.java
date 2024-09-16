package com.op_test.enemy;

import javafx.scene.image.ImageView;

public class Enemy {
    public final float maxHealth;

    private String name;
    private float health;
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

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public float dealDamage(float damage) {
        health -= damage;
        return damage;
    }


}

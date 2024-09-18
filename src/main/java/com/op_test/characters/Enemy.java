package com.op_test.characters;

import javafx.scene.image.ImageView;

public class Enemy extends Target {
    private static int idCount = 0;
    public final double MAX_HEALTH;
    public final double GOLD_BY_DAMAGE;

    private double health;
    private ImageView image;

    public Enemy(String name, double MAX_HEALTH, double GOLD_BY_DAMAGE, ImageView image) {
        super(++idCount, name);
        this.MAX_HEALTH = MAX_HEALTH;
        this.GOLD_BY_DAMAGE = GOLD_BY_DAMAGE;
        this.health = MAX_HEALTH;
        this.image = image;
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


}

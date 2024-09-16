package com.op_test.abilities;

import javafx.scene.image.ImageView;

public interface I_Ability {
    void animation(ImageView attackImage, ImageView enemy);
    float use();
    void upgrade();
}

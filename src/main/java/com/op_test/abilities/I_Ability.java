package com.op_test.abilities;

import com.op_test.characters.Target;
import javafx.scene.image.ImageView;

public interface I_Ability {
    void animation(ImageView enemy, ImageView attackImage);
    double use(Target target, ImageView attackImage);
    double use(Target target);
    void cooldown();
    void upgrade();
}

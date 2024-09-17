package com.op_test.characters;

import com.op_test.abilities.Ability;
import com.op_test.abilities.AbilityNames;
import com.op_test.abilities.AttackAbility;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private static int id = 0;
    private String name;
    private int bounty;
    List<Ability> abilities = new ArrayList<Ability>();

    public Player(String name, ImageView enemy) {
        id = ++id;
        this.name = name;

        abilities.add(new AttackAbility(AbilityNames.PUNCH, 2, 2, 0));
        abilities.add(new AttackAbility(AbilityNames.GUM_GUM_PISTOL, 10, 2, 2));
        abilities.add(new AttackAbility(AbilityNames.GEAR_2, 0.2, 0.1, 5));
        abilities.add(new AttackAbility(AbilityNames.GEAR_3, 0.2, 0.1, 2));
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Player.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBounty() {
        return bounty;
    }

    public void setBounty(int bounty) {
        this.bounty = bounty;
    }

    public Ability getAbility(int index) {
        return abilities.get(index);
    }
}

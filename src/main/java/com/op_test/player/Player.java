package com.op_test.player;

import com.op_test.abilities.Abilities;
import com.op_test.abilities.AbilityNames;
import com.op_test.abilities.AttackAbilities;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private static int id = 0;
    private String name;
    private int bounty;
    List<Abilities> abilities = new ArrayList<Abilities>();

    public Player(String name, ImageView enemy) {
        id = ++id;
        this.name = name;

        abilities.add(new AttackAbilities(AbilityNames.PUNCH, 2, 2, 0));
        abilities.add(new AttackAbilities(AbilityNames.GUM_GUM_PISTOL, 10, 2, 2));

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

    public Abilities getAbility(int index) {
        return abilities.get(index);
    }
}

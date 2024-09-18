package com.op_test.characters;

import com.op_test.abilities.Ability;
import com.op_test.abilities.AbilityNames;
import com.op_test.abilities.AttackAbility;
import com.op_test.abilities.BuffAbility;

import java.util.ArrayList;
import java.util.List;

public class Player extends Target{
    private static int idCount = 0;

    List<Ability> abilities = new ArrayList<Ability>();

    public Player(String name) {
        super(++idCount, name);

        abilities.add(new AttackAbility(AbilityNames.PUNCH, 2, 2, 0));
        abilities.add(new AttackAbility(AbilityNames.GUM_GUM_PISTOL, 10, 2, 2));
        abilities.add(new BuffAbility(AbilityNames.GEAR_2, 0.2, 2, 10, 5));
        abilities.add(new AttackAbility(AbilityNames.GEAR_3, 0.2, 0.1, 2));
    }

    public void addAbility(Ability ability) {
        abilities.add(ability);
    }

    public void removeAbility(Ability ability) {
        abilities.remove(ability);
    }

    public Ability getAbility(int index) {
        return abilities.get(index);
    }
}

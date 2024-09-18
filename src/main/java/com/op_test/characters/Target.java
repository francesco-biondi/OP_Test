package com.op_test.characters;

public class Target {
    protected final int id;
    private String name;
    private int bounty;

    public Target(int id, String name) {
        this.id = id;
        this.name = name;
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

    public int getId() {
        return id;
    }
}

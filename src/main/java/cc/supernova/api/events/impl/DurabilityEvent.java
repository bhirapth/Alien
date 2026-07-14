package cc.supernova.api.events.impl;

import cc.supernova.api.events.Event;

public class DurabilityEvent extends Event {
    private int damage;

    public DurabilityEvent(int damage) {
        super(Stage.Pre);
        this.damage = damage;
    }

    public int getItemDamage() {
        return Math.max(0, damage);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}

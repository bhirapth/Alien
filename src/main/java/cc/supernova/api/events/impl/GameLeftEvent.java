package cc.supernova.api.events.impl;

import cc.supernova.api.events.Event;

public class GameLeftEvent extends Event {
    public GameLeftEvent() {
        super(Stage.Post);
    }
}

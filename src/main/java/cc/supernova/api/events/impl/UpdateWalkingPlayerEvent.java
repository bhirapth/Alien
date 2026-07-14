package cc.supernova.api.events.impl;

import cc.supernova.api.events.Event;

public class UpdateWalkingPlayerEvent extends Event {
    public UpdateWalkingPlayerEvent(Stage stage) {
        super(stage);
    }
}

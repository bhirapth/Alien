package cc.supernova.api.events.impl;

import cc.supernova.api.events.Event;

public class KeyboardInputEvent extends Event {
    public KeyboardInputEvent() {
        super(Stage.Pre);
    }
}

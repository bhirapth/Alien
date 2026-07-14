package cc.supernova.mod.modules.impl.combat;

import cc.supernova.api.events.eventbus.EventHandler;
import cc.supernova.api.events.impl.UpdateWalkingPlayerEvent;
import cc.supernova.mod.modules.Module;
import cc.supernova.mod.modules.settings.impl.BooleanSetting;

public class SilentDouble extends Module {
    public static SilentDouble INSTANCE;

    private final BooleanSetting onlyKill =
            add(new BooleanSetting("OnlyKill", false));

    public SilentDouble() {
        super("SilentDouble", Category.Combat);
        setChinese("静默双持");
        INSTANCE = this;
    }

    @EventHandler
    public void onUpdateWalking(UpdateWalkingPlayerEvent event) {
        if (nullCheck()) return;
        // Silent double hand logic
    }
}

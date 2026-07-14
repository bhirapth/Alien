package cc.supernova.mod.modules.impl.player;

import cc.supernova.api.events.eventbus.EventHandler;
import cc.supernova.api.events.impl.TickEvent;
import cc.supernova.mod.modules.Module;
import cc.supernova.mod.modules.impl.exploit.PortalGod;
import net.minecraft.client.gui.screen.DownloadingTerrainScreen;

public class NoTerrainScreen extends Module {
    public NoTerrainScreen() {
        super("NoTerrainScreen", Category.Player);
        setChinese("没有加载界面");
    }

    @EventHandler
    public void onEvent(TickEvent event) {
        if (PortalGod.INSTANCE.isOn()) return;
        if (mc.currentScreen instanceof DownloadingTerrainScreen) {
            mc.currentScreen = null;
        }
    }
}

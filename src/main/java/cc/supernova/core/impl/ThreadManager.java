package cc.supernova.core.impl;

import cc.supernova.api.utils.world.BlockUtil;
import cc.supernova.Supernova;
import cc.supernova.api.events.eventbus.EventHandler;
import cc.supernova.api.events.eventbus.EventPriority;
import cc.supernova.api.events.impl.TickEvent;
import cc.supernova.mod.modules.impl.render.PlaceRender;

public class ThreadManager {
    public static ClientService clientService;

    public ThreadManager() {
        Supernova.EVENT_BUS.subscribe(this);
        clientService = new ClientService();
        clientService.setName("SupernovaClientService");
        clientService.setDaemon(true);
        clientService.start();
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEvent(TickEvent event) {
        if (event.isPre()) {
            if (!clientService.isAlive()) {
                clientService = new ClientService();
                clientService.setName("SupernovaClientService");
                clientService.setDaemon(true);
                clientService.start();
            }
            BlockUtil.placedPos.forEach(pos -> PlaceRender.renderMap.put(pos, PlaceRender.INSTANCE.create(pos)));
            BlockUtil.placedPos.clear();
            Supernova.SERVER.onUpdate();
            Supernova.PLAYER.onUpdate();
            Supernova.MODULE.onUpdate();
            Supernova.GUI.onUpdate();
            Supernova.POP.onUpdate();
        }
    }

    public static class ClientService extends Thread {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    if (Supernova.MODULE != null) {
                        Supernova.MODULE.onThread();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

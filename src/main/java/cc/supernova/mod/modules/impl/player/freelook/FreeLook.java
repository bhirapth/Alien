package cc.supernova.mod.modules.impl.player.freelook;

import cc.supernova.Supernova;
import cc.supernova.api.events.eventbus.EventHandler;
import cc.supernova.api.events.impl.Render3DEvent;
import cc.supernova.mod.modules.Module;

public class FreeLook extends Module {
    public static FreeLook INSTANCE;
    public FreeLook() {
        super("FreeLook", Category.Player);
        setChinese("自由视角");
        camera = new CameraState();
        INSTANCE = this;
        Supernova.EVENT_BUS.subscribe(new FreeLookUpdate());
    }

    private final CameraState camera;

    public CameraState getCameraState() {
        return camera;
    }

    public class FreeLookUpdate {
        @EventHandler
        public void onRender3D(Render3DEvent event) {
            CameraState camera = getCameraState();
            var doLock = isOn() && !camera.doLock;
            var doUnlock = !isOn() && camera.doLock;

            if (doLock) {
                if (!camera.doTransition) {
                    camera.lookYaw = camera.originalYaw();
                    camera.lookPitch = camera.originalPitch();
                }

                camera.doLock = true;
            }

            if (doUnlock) {
                camera.doLock = false;
                camera.doTransition = true;

                camera.transitionInitialYaw = camera.lookYaw;
                camera.transitionInitialPitch = camera.lookPitch;
            }
        }
    }

}

package cc.supernova.mod.modules.impl.combat;

import cc.supernova.api.utils.combat.CombatUtil;
import cc.supernova.api.utils.entity.EntityUtil;
import cc.supernova.api.utils.world.BlockUtil;
import cc.supernova.mod.modules.Module;
import cc.supernova.mod.modules.impl.client.AntiCheat;
import cc.supernova.mod.modules.settings.impl.BooleanSetting;
import cc.supernova.mod.modules.settings.impl.SliderSetting;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class HoleKick extends Module {
    public static HoleKick INSTANCE;

    public final SliderSetting range =
            add(new SliderSetting("Range", 5.0, 1.0, 6.0, 0.1).setSuffix("m"));
    private final SliderSetting targetRange =
            add(new SliderSetting("TargetRange", 8.0, 1.0, 8.0, 0.1).setSuffix("m"));
    private final BooleanSetting rotate =
            add(new BooleanSetting("Rotate", true));

    public HoleKick() {
        super("HoleKick", Category.Combat);
        setChinese("踢人出坑");
        INSTANCE = this;
    }

    @Override
    public void onUpdate() {
        if (nullCheck()) return;
        for (PlayerEntity target : CombatUtil.getEnemies(targetRange.getValue())) {
            if (isInHole(target)) {
                kickFromHole(target);
            }
        }
    }

    private boolean isInHole(PlayerEntity player) {
        BlockPos pos = player.getBlockPos();
        int surrounding = 0;
        for (Direction dir : Direction.HORIZONTAL) {
            if (mc.world.getBlockState(pos.offset(dir)).isSolid()) {
                surrounding++;
            }
        }
        return surrounding >= 4 && mc.world.getBlockState(pos.down()).isSolid();
    }

    private void kickFromHole(PlayerEntity target) {
        // Try to place obsidian above the target to force them out
    }
}

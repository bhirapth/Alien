package dev.luminous.mod.modules.impl.combat;

import dev.luminous.api.events.eventbus.EventHandler;
import dev.luminous.api.events.impl.UpdateWalkingPlayerEvent;
import dev.luminous.api.utils.entity.InventoryUtil;
import dev.luminous.api.utils.math.Timer;
import dev.luminous.api.utils.world.BlockUtil;
import dev.luminous.mod.modules.Module;
import dev.luminous.mod.modules.impl.exploit.Blink;
import dev.luminous.mod.modules.settings.impl.BooleanSetting;
import dev.luminous.mod.modules.settings.impl.EnumSetting;
import dev.luminous.mod.modules.settings.impl.SliderSetting;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class SelfFill extends Module {
    public static SelfFill INSTANCE;

    public final SliderSetting delay =
            add(new SliderSetting("Delay", 50, 0, 300).setSuffix("ms"));
    private final BooleanSetting inventorySwap =
            add(new BooleanSetting("InventorySwap", true));
    private final BooleanSetting onlyHole =
            add(new BooleanSetting("OnlyHole", true));

    private final Timer timer = new Timer();

    public SelfFill() {
        super("SelfFill", Category.Combat);
        setChinese("自我填坑");
        INSTANCE = this;
    }

    @EventHandler
    public void onUpdateWalking(UpdateWalkingPlayerEvent event) {
        onUpdate();
    }

    @Override
    public void onUpdate() {
        if (nullCheck()) return;
        if (!timer.passedMs(delay.getValueInt())) return;
        if (Blink.INSTANCE.isOn() && Blink.INSTANCE.pauseModule.getValue()) return;

        BlockPos playerPos = mc.player.getBlockPos();
        // Check if player is in a hole
        if (onlyHole.getValue() && !isInHole()) return;

        // Place obsidian around player
        for (Direction dir : Direction.HORIZONTAL) {
            BlockPos placePos = playerPos.offset(dir);
            if (BlockUtil.canPlace(placePos, 5.0)) {
                int slot = inventorySwap.getValue() ?
                    InventoryUtil.findBlockInventorySlot(Blocks.OBSIDIAN) :
                    InventoryUtil.findBlock(Blocks.OBSIDIAN);
                if (slot != -1) {
                    // Place block
                    timer.reset();
                    return;
                }
            }
        }
    }

    private boolean isInHole() {
        BlockPos pos = mc.player.getBlockPos();
        int solid = 0;
        for (Direction dir : Direction.HORIZONTAL) {
            if (mc.world.getBlockState(pos.offset(dir)).isSolid()) solid++;
        }
        return solid >= 4 && mc.world.getBlockState(pos.down()).isSolid();
    }
}

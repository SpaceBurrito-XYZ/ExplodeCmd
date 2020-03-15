package xyz.spaceburrito.mc.explodecmd.common.handlers;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraftforge.event.world.ExplosionEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.jetbrains.annotations.NotNull;

public class ExplosionHandler {
    @SubscribeEvent
    public void onExplosion(final ExplosionEvent.Detonate event) {
        final World world = event.getWorld();
        if(world.isRemote) { return; }
        event.getAffectedBlocks().clear();
    }

    // todo:
}
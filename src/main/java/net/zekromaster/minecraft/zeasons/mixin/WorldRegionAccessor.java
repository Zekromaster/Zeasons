package net.zekromaster.minecraft.zeasons.mixin;

import net.minecraft.world.World;
import net.minecraft.world.WorldRegion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(WorldRegion.class)
public interface WorldRegionAccessor {
    @Accessor("world")
    World getWorld();
}

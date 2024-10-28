package net.zekromaster.minecraft.zeasons;

import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldRegion;
import net.zekromaster.minecraft.zeasons.mixin.WorldRegionAccessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public record TimeOfYear(@NotNull Season season, long day) {

    public static TimeOfYear of(World world) {
        return SeasonCycle.of(world.dimension).dayToTimeOfYear(world.getTime() / 24000);
    }

    @Nullable
    public static TimeOfYear of(BlockView view) {
        if (view instanceof WorldRegion region) {
            return TimeOfYear.of(((WorldRegionAccessor)region).getWorld());
        }
        if (view instanceof World world) {
            return TimeOfYear.of(world);
        }
        return null;
    }

}

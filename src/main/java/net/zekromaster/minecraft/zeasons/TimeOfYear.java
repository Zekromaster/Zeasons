package net.zekromaster.minecraft.zeasons;

import net.minecraft.world.World;

public record TimeOfYear(Season season, long day) {

    public static TimeOfYear of(World world) {
        return SeasonCycle.of(world.dimension).dayToTimeOfYear(world.getTime() / 24000);
    }

}

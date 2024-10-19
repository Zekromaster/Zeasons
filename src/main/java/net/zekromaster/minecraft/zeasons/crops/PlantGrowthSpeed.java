package net.zekromaster.minecraft.zeasons.crops;

import net.zekromaster.minecraft.zeasons.Zeasons;
import net.zekromaster.minecraft.zeasons.properties.SeasonPropertyKey;

public enum PlantGrowthSpeed {

    NO_GROWTH(0d),
    SLOW(0.3d),
    NORMAL(1d),
    FAST(1d);

    public final double chanceModifier;

    PlantGrowthSpeed(double chanceModifier) {
        this.chanceModifier = chanceModifier;
    }

    public interface PropertyKeys {
        SeasonPropertyKey<PlantGrowthSpeed> WHEAT = SeasonPropertyKey.withDefault(
            Zeasons.NAMESPACE.id("growth/wheat"),
            NORMAL
        );

        SeasonPropertyKey<PlantGrowthSpeed> OAK = SeasonPropertyKey.withDefault(
            Zeasons.NAMESPACE.id("growth/sapling/oak"),
            NORMAL
        );

        SeasonPropertyKey<PlantGrowthSpeed> BIRCH = SeasonPropertyKey.withDefault(
            Zeasons.NAMESPACE.id("growth/sapling/birch"),
            NORMAL
        );

        SeasonPropertyKey<PlantGrowthSpeed> SPRUCE = SeasonPropertyKey.withDefault(
            Zeasons.NAMESPACE.id("growth/sapling/spruce"),
            NORMAL
        );

    }


}

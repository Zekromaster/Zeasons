package net.zekromaster.minecraft.zeasons.decorations;

import net.zekromaster.minecraft.zeasons.Zeasons;
import net.zekromaster.minecraft.zeasons.properties.SeasonPropertyKey;

public enum DecaySpeed {
    NO_DECAY(0),
    SLOW(40),
    FAST(80);

    public final int decayChance;

    DecaySpeed(int decayChance) {
        this.decayChance = decayChance;
    }

    public interface PropertyKeys {

        SeasonPropertyKey<DecaySpeed> LEAF_PILES = SeasonPropertyKey.withDefault(
            Zeasons.NAMESPACE.id("decay/leaf_piles"),
            NO_DECAY
        );

        SeasonPropertyKey<DecaySpeed> SNOW_PILES = SeasonPropertyKey.withDefault(
            Zeasons.NAMESPACE.id("decay/snow_piles"),
            NO_DECAY
        );

    }

}

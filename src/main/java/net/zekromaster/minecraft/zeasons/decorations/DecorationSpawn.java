package net.zekromaster.minecraft.zeasons.decorations;

import net.zekromaster.minecraft.zeasons.Zeasons;
import net.zekromaster.minecraft.zeasons.properties.SeasonPropertyKey;

public enum DecorationSpawn {
    NEVER(0),
    INFREQUENT(15),
    FREQUENT(40);

    public final int spawnChance;

    DecorationSpawn(int spawnChance) {
        this.spawnChance = spawnChance;
    }

    public interface PropertyKeys {
        SeasonPropertyKey<DecorationSpawn> LEAF_PILES = SeasonPropertyKey.withDefault(
            Zeasons.NAMESPACE.id("decorations/leaf_piles"),
            NEVER
        );
    }

}

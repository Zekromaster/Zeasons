package net.zekromaster.minecraft.zeasons.decorations;

import net.zekromaster.minecraft.zeasons.Zeasons;
import net.zekromaster.minecraft.zeasons.properties.SeasonPropertyKey;

public enum DecorationSpawn {
    NEVER,
    INFREQUENT,
    FREQUENT;

    public interface PropertyKeys {
        SeasonPropertyKey<DecorationSpawn> LEAF_PILES = SeasonPropertyKey.withDefault(
            Zeasons.NAMESPACE.id("decorations/leaf_piles"),
            NEVER
        );
    }

}

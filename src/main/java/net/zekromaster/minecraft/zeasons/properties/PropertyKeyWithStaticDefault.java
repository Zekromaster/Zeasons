package net.zekromaster.minecraft.zeasons.properties;

import net.modificationstation.stationapi.api.util.Identifier;
import org.jetbrains.annotations.NotNull;

record PropertyKeyWithStaticDefault<T>(
    @NotNull Identifier id,
    @NotNull T defaultValue
) implements SeasonPropertyKey<T> { }

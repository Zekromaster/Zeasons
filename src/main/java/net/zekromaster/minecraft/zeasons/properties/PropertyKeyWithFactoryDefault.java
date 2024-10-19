package net.zekromaster.minecraft.zeasons.properties;

import net.modificationstation.stationapi.api.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

record PropertyKeyWithFactoryDefault<T>(
    @NotNull Identifier id,
    @NotNull Supplier<T> factory
) implements SeasonPropertyKey<T> {

    @Override
    public @NotNull T defaultValue() {
        return factory.get();
    }

}

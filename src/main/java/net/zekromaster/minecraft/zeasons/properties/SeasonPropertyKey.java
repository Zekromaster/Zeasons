package net.zekromaster.minecraft.zeasons.properties;

import net.modificationstation.stationapi.api.util.Identifier;
import org.jetbrains.annotations.NotNull;
import java.util.function.Supplier;

public interface SeasonPropertyKey<T> {

    @NotNull Identifier id();
    @NotNull T defaultValue();

    /**
     * Creates a property key with a static default value. CAREFUL: The value is always the same reference, no cloning
     * involved. Meant for stateless stuff.
     *
     * @param defaultValue The default value
     * @return A PropertyKey with the given default value
     * @param <T> The type associated with this PropertyKey
     */
    static <T> SeasonPropertyKey<T> withDefault(Identifier id, T defaultValue) {
        return new PropertyKeyWithStaticDefault<>(id, defaultValue);
    }

    static <T> SeasonPropertyKey<T> withFactory(Identifier id, Supplier<T> defaultValue) {
        return new PropertyKeyWithFactoryDefault<>(id, defaultValue);
    }

}

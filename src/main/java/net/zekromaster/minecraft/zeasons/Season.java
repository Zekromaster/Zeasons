package net.zekromaster.minecraft.zeasons;

import net.modificationstation.stationapi.api.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class Season {

    public interface PropertyKey<T> {
        @NotNull T defaultValue();

        /**
         * Creates a property key with a static default value. CAREFUL: The value is always the same reference, no cloning
         * involved. Meant for stateless stuff.
         *
         * @param defaultValue The default value
         * @return A PropertyKey with the given default value
         * @param <T> The type associated with this PropertyKey
         */
        static <T> PropertyKey<T> withDefault(T defaultValue) {
            return () -> defaultValue;
        }
    }

    public final Identifier id;
    private final Map<PropertyKey<?>, Object> properties = new HashMap<>();

    public Season(Identifier id) {
        this.id = id;
    }

    public <T> void addHandler(PropertyKey<T> key, T object) {
        this.properties.put(key, object);
    }

    @NotNull
    public <T> T getHandler(PropertyKey<T> key) {
        return (T) this.properties.computeIfAbsent(key, (season) -> key.defaultValue());
    }

    public String toString() {
        return String.format("Season[id=%s]", this.id.toString());
    }

}

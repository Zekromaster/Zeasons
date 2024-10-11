package net.zekromaster.minecraft.zeasons;

import net.modificationstation.stationapi.api.util.Identifier;

import java.util.HashMap;
import java.util.Map;

public class Season {

    public record PropertyKey<T>(Identifier id, T defaultValue) { }

    public final Identifier id;
    private final Map<PropertyKey<?>, Object> properties = new HashMap<>();

    public Season(Identifier id) {
        this.id = id;
    }

    public <T> void addHandler(PropertyKey<T> key, T object) {
        this.properties.put(key, object);
    }

    public <T> T getHandler(PropertyKey<T> key) {
        return (T) this.properties.getOrDefault(key, key.defaultValue());
    }

    public String toString() {
        return String.format("Season[id=%s]", this.id.toString());
    }

}

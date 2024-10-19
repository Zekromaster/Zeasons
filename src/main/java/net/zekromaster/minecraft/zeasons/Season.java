package net.zekromaster.minecraft.zeasons;

import net.modificationstation.stationapi.api.util.Identifier;
import net.zekromaster.minecraft.zeasons.properties.SeasonPropertyKey;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class Season {

    public final Identifier id;
    private final Map<Identifier, Object> properties = new HashMap<>();

    public Season(Identifier id) {
        this.id = id;
    }

    public <T> void setProperty(SeasonPropertyKey<T> key, T object) {
        this.properties.put(key.id(), object);
    }

    @NotNull
    public <T> T getProperty(SeasonPropertyKey<T> key) {
        return (T) this.properties.computeIfAbsent(key.id(), (season) -> key.defaultValue());
    }

    public String toString() {
        return String.format("Season[id=%s]", this.id.toString());
    }

}

package net.zekromaster.minecraft.zeasons;

import com.mojang.serialization.Lifecycle;
import net.modificationstation.stationapi.api.event.registry.RegistryAttribute;
import net.modificationstation.stationapi.api.event.registry.RegistryAttributeHolder;
import net.modificationstation.stationapi.api.registry.*;

import static net.modificationstation.stationapi.api.StationAPI.NAMESPACE;

public final class SeasonRegistry extends SimpleRegistry<Season> {
    public static final RegistryKey<Registry<Season>> KEY = RegistryKey.ofRegistry(NAMESPACE.id("seasons"));
    public static final SeasonRegistry INSTANCE = Registries.create(KEY, new SeasonRegistry(), registry -> Zeasons.NO_SEASON, Lifecycle.experimental());

    private SeasonRegistry() {
        super(KEY, Lifecycle.experimental(), false);
        RegistryAttributeHolder.get(this).addAttribute(RegistryAttribute.SYNCED);
    }
}

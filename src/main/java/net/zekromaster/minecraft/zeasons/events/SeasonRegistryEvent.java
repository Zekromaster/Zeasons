package net.zekromaster.minecraft.zeasons.events;

import net.mine_diver.unsafeevents.Event;
import net.modificationstation.stationapi.api.registry.Registry;
import net.zekromaster.minecraft.zeasons.Season;
import net.zekromaster.minecraft.zeasons.SeasonRegistry;

public class SeasonRegistryEvent extends Event {

    private final SeasonRegistry registry = SeasonRegistry.INSTANCE;

    public void addSeason(Season season) {
        Registry.register(registry, season.id, season);
    }
}

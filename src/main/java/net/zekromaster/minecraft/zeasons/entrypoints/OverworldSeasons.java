package net.zekromaster.minecraft.zeasons.entrypoints;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.world.dimension.VanillaDimensions;
import net.zekromaster.minecraft.zeasons.events.SeasonCyclesEvent;
import net.zekromaster.minecraft.zeasons.events.SeasonRegistryEvent;

import static net.zekromaster.minecraft.zeasons.Zeasons.*;

public class OverworldSeasons {

    @EventListener
    private void registerSeasons(SeasonRegistryEvent event) {
        event.addSeason(SPRING);
        event.addSeason(SUMMER);
        event.addSeason(AUTUMN);
        event.addSeason(WINTER);
    }

    @EventListener
    private void registerSeasonCycles(SeasonCyclesEvent event) {
        event.addSeasons(
            VanillaDimensions.OVERWORLD,
            7,
            SPRING, SUMMER, AUTUMN, WINTER
        );
    }
}

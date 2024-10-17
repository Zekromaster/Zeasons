package net.zekromaster.minecraft.zeasons.entrypoints;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.world.dimension.VanillaDimensions;
import net.zekromaster.minecraft.zeasons.events.SeasonCyclesEvent;
import net.zekromaster.minecraft.zeasons.events.SeasonRegistryEvent;

import static net.zekromaster.minecraft.zeasons.Zeasons.*;

public class NetherSeasons {

    @EventListener
    private void registerSeasons(SeasonRegistryEvent event) {
        event.addSeason(HELL);
    }

    @EventListener
    private void registerSeasonCycles(SeasonCyclesEvent event) {
        event.addSeasons(
            VanillaDimensions.THE_NETHER,
            1,
            HELL
        );
    }
}

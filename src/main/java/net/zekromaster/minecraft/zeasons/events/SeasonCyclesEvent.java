package net.zekromaster.minecraft.zeasons.events;

import net.mine_diver.unsafeevents.Event;
import net.modificationstation.stationapi.api.util.Identifier;
import net.zekromaster.minecraft.zeasons.Season;
import net.zekromaster.minecraft.zeasons.SeasonCycle;

import java.util.Arrays;

public class SeasonCyclesEvent extends Event {

    public void addSeasons(Identifier id, int seasonLength, Season...seasons) {
        SeasonCycle.seasonCycleMap.put(id, new SeasonCycle(seasonLength, Arrays.asList(seasons)));
    }

}

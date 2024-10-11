package net.zekromaster.minecraft.zeasons.entrypoints;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.zekromaster.minecraft.zeasons.events.SeasonRegistryEvent;

import static net.zekromaster.minecraft.zeasons.Zeasons.NO_SEASON;

public class NoneSeason {

    @EventListener
    void registerNoneSeason(SeasonRegistryEvent event) {
        event.addSeason(NO_SEASON);
    }

}

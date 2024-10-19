package net.zekromaster.minecraft.zeasons.events;

import net.mine_diver.unsafeevents.Event;
import net.zekromaster.minecraft.zeasons.SeasonRegistry;

public class AttachSeasonPropertiesEvent extends Event {

    public final SeasonRegistry registry = SeasonRegistry.INSTANCE;

}

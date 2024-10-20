package net.zekromaster.minecraft.zeasons.entrypoints;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.zekromaster.minecraft.zeasons.Zeasons;
import net.zekromaster.minecraft.zeasons.decorations.DecaySpeed;
import net.zekromaster.minecraft.zeasons.decorations.DecorationSpawn;
import net.zekromaster.minecraft.zeasons.decorations.LeafPileBlock;
import net.zekromaster.minecraft.zeasons.events.AttachSeasonPropertiesEvent;

import static net.zekromaster.minecraft.zeasons.Zeasons.NAMESPACE;

public class SeasonalDecorations {

    @EventListener
    public void registerBlocks(BlockRegistryEvent event) {
        Zeasons.LEAF_PILE = new LeafPileBlock(
            NAMESPACE.id("leaf_pile"),
            0xad8557
        ).setTranslationKey(NAMESPACE.id("leaf_pile"));
    }

    @EventListener
    public void decayProperties(AttachSeasonPropertiesEvent event) {

        Zeasons.AUTUMN.setProperty(DecorationSpawn.PropertyKeys.LEAF_PILES, DecorationSpawn.FREQUENT);
        Zeasons.WINTER.setProperty(DecorationSpawn.PropertyKeys.LEAF_PILES, DecorationSpawn.INFREQUENT);

        Zeasons.WINTER.setProperty(DecaySpeed.PropertyKeys.LEAF_PILES, DecaySpeed.SLOW);
        Zeasons.SPRING.setProperty(DecaySpeed.PropertyKeys.LEAF_PILES, DecaySpeed.FAST);
        Zeasons.SUMMER.setProperty(DecaySpeed.PropertyKeys.LEAF_PILES, DecaySpeed.FAST);

        Zeasons.SPRING.setProperty(DecaySpeed.PropertyKeys.SNOW_PILES, DecaySpeed.FAST);
        Zeasons.SUMMER.setProperty(DecaySpeed.PropertyKeys.SNOW_PILES, DecaySpeed.FAST);
        Zeasons.AUTUMN.setProperty(DecaySpeed.PropertyKeys.SNOW_PILES, DecaySpeed.SLOW);

    }
}

package net.zekromaster.minecraft.zeasons.entrypoints;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.zekromaster.minecraft.zeasons.colour.SeasonalColourProvider;
import net.zekromaster.minecraft.zeasons.events.AttachSeasonPropertiesEvent;

import static net.zekromaster.minecraft.zeasons.Zeasons.*;

public class SeasonalColours {

    @EventListener
    private void addColourProviders(AttachSeasonPropertiesEvent event) {
        SUMMER.setProperty(SeasonalColourProvider.PropertyKeys.OAK, (view, state) -> 0x4fc022);
        AUTUMN.setProperty(SeasonalColourProvider.PropertyKeys.OAK, (view, state) -> 0xcc8014);
        WINTER.setProperty(SeasonalColourProvider.PropertyKeys.OAK, (view, state) -> 0xad8557);

        SUMMER.setProperty(SeasonalColourProvider.PropertyKeys.BIRCH, (view, state) -> 0xd5ffb5);
        AUTUMN.setProperty(SeasonalColourProvider.PropertyKeys.BIRCH, (view, state) -> 0xe2a231);
        WINTER.setProperty(SeasonalColourProvider.PropertyKeys.BIRCH, (view, state) -> 0xa0824d);

        WINTER.setProperty(SeasonalColourProvider.PropertyKeys.SPRUCE, (view, state) -> 0x1a281a);

        SUMMER.setProperty(SeasonalColourProvider.PropertyKeys.GRASS, (view, state) -> 0x57eb63);
        AUTUMN.setProperty(SeasonalColourProvider.PropertyKeys.GRASS, (view, state) -> 0x8f4d41);
        WINTER.setProperty(SeasonalColourProvider.PropertyKeys.GRASS, (view, state) -> 0x9dB89d);

        SUMMER.setProperty(SeasonalColourProvider.PropertyKeys.TALL_GRASS, (view, state) -> 0x7ff052);
        AUTUMN.setProperty(SeasonalColourProvider.PropertyKeys.TALL_GRASS, (view, state) -> 0xbf7d41);
        WINTER.setProperty(SeasonalColourProvider.PropertyKeys.TALL_GRASS, (view, state) -> 0x9dB89d);

    }
}

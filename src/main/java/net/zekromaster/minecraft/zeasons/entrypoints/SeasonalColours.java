package net.zekromaster.minecraft.zeasons.entrypoints;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.zekromaster.minecraft.zeasons.colour.SeasonalColourProvider;
import net.zekromaster.minecraft.zeasons.events.AttachSeasonHandlersEvent;

import static net.zekromaster.minecraft.zeasons.Zeasons.*;

public class SeasonalColours {

    @EventListener
    private void addColourProviders(AttachSeasonHandlersEvent event) {
        SUMMER.addHandler(
            SeasonalColourProvider.OAK_LEAVES_COLOUR_PROVIDER_KEY,
            (view, state) -> 0x4fc022
        );
        AUTUMN.addHandler(
            SeasonalColourProvider.OAK_LEAVES_COLOUR_PROVIDER_KEY,
            (view, state) -> 0xcc8014
        );
        WINTER.addHandler(
            SeasonalColourProvider.OAK_LEAVES_COLOUR_PROVIDER_KEY,
            (view, state) -> 0xad8557
        );

        SUMMER.addHandler(
            SeasonalColourProvider.BIRCH_LEAVES_COLOUR_PROVIDER_KEY,
            (view, state) -> 0xd5ffb5
        );
        AUTUMN.addHandler(
            SeasonalColourProvider.BIRCH_LEAVES_COLOUR_PROVIDER_KEY,
            (view, state) -> 0xe2a231
        );
        WINTER.addHandler(
            SeasonalColourProvider.BIRCH_LEAVES_COLOUR_PROVIDER_KEY,
            (view, state) -> 0xa0824d
        );

        WINTER.addHandler(
            SeasonalColourProvider.SPRUCE_LEAVES_COLOUR_PROVIDER_KEY,
            (view, state) -> 0x1a281a
        );

        SUMMER.addHandler(
            SeasonalColourProvider.GRASS_COLOUR_PROVIDER_KEY,
            (view, state) -> 0x57eb63
        );
        AUTUMN.addHandler(
            SeasonalColourProvider.GRASS_COLOUR_PROVIDER_KEY,
            (view, state) -> 0x8f4d41
        );
        WINTER.addHandler(
            SeasonalColourProvider.GRASS_COLOUR_PROVIDER_KEY,
            (view, state) -> 0x9dB89d
        );

        SUMMER.addHandler(
            SeasonalColourProvider.TALL_GRASS_COLOUR_PROVIDER_KEY,
            (view, state) -> 0x7ff052
        );
        AUTUMN.addHandler(
            SeasonalColourProvider.TALL_GRASS_COLOUR_PROVIDER_KEY,
            (view, state) -> 0xbf7d41
        );
        WINTER.addHandler(
            SeasonalColourProvider.TALL_GRASS_COLOUR_PROVIDER_KEY,
            (view, state) -> 0x9dB89d
        );

    }
}

package net.zekromaster.minecraft.zeasons.colour;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.zekromaster.minecraft.zeasons.Season;

@Environment(EnvType.CLIENT)
public interface SeasonalColourProvider {

    Season.PropertyKey<SeasonalColourProvider> OAK_LEAVES_COLOUR_PROVIDER_KEY = Season.PropertyKey.withDefault(
        (view, state) -> {
            view.method_1781().getBiomesInArea(state.x, state.z, 1, 1);
            double var6 = view.method_1781().temperatureMap[0];
            double var8 = view.method_1781().downfallMap[0];
            return FoliageColors.getColor(var6, var8);
        }
    );

    Season.PropertyKey<SeasonalColourProvider> SPRUCE_LEAVES_COLOUR_PROVIDER_KEY = Season.PropertyKey.withDefault(
        (view, state) -> FoliageColors.getSpruceColor()
    );

    Season.PropertyKey<SeasonalColourProvider> BIRCH_LEAVES_COLOUR_PROVIDER_KEY = Season.PropertyKey.withDefault(
        (view, state) -> FoliageColors.getBirchColor()
    );

    Season.PropertyKey<SeasonalColourProvider> GRASS_COLOUR_PROVIDER_KEY = Season.PropertyKey.withDefault(
        (view, state) -> {
            view.method_1781().getBiomesInArea(state.x, state.z, 1, 1);
            double var5 = view.method_1781().temperatureMap[0];
            double var7 = view.method_1781().downfallMap[0];
            return GrassColors.getColor(var5, var7);
        }
    );

    Season.PropertyKey<SeasonalColourProvider> TALL_GRASS_COLOUR_PROVIDER_KEY = Season.PropertyKey.withDefault(
        (view, state) -> {
            view.method_1781().getBiomesInArea(state.x, state.z, 1, 1);
            double var5 = view.method_1781().temperatureMap[0];
            double var7 = view.method_1781().downfallMap[0];
            return GrassColors.getColor(var5, var7);
        }
    );

    int colour(BlockView world, BlockPos state);
}

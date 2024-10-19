package net.zekromaster.minecraft.zeasons.colour;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.zekromaster.minecraft.zeasons.Zeasons;
import net.zekromaster.minecraft.zeasons.properties.SeasonPropertyKey;

@Environment(EnvType.CLIENT)
public interface SeasonalColourProvider {

    interface PropertyKeys {
        SeasonPropertyKey<SeasonalColourProvider> OAK = SeasonPropertyKey.withDefault(
            Zeasons.NAMESPACE.id("colour/leaves/oak"),
            (view, state) -> {
                view.method_1781().getBiomesInArea(state.x, state.z, 1, 1);
                double var6 = view.method_1781().temperatureMap[0];
                double var8 = view.method_1781().downfallMap[0];
                return FoliageColors.getColor(var6, var8);
            }
        );

        SeasonPropertyKey<SeasonalColourProvider> SPRUCE = SeasonPropertyKey.withDefault(
            Zeasons.NAMESPACE.id("colour/leaves/spruce"),
            (view, state) -> FoliageColors.getSpruceColor()
        );

        SeasonPropertyKey<SeasonalColourProvider> BIRCH = SeasonPropertyKey.withDefault(
            Zeasons.NAMESPACE.id("colour/leaves/birch"),
            (view, state) -> FoliageColors.getBirchColor()
        );

        SeasonPropertyKey<SeasonalColourProvider> GRASS = SeasonPropertyKey.withDefault(
            Zeasons.NAMESPACE.id("colour/grass"),
            (view, state) -> {
                view.method_1781().getBiomesInArea(state.x, state.z, 1, 1);
                double var5 = view.method_1781().temperatureMap[0];
                double var7 = view.method_1781().downfallMap[0];
                return GrassColors.getColor(var5, var7);
            }
        );

        SeasonPropertyKey<SeasonalColourProvider> TALL_GRASS = SeasonPropertyKey.withDefault(
            Zeasons.NAMESPACE.id("colour/grass/tall"),
            (view, state) -> {
                view.method_1781().getBiomesInArea(state.x, state.z, 1, 1);
                double var5 = view.method_1781().temperatureMap[0];
                double var7 = view.method_1781().downfallMap[0];
                return GrassColors.getColor(var5, var7);
            }
        );
    }

    int colour(BlockView world, BlockPos state);
}

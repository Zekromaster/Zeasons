package net.zekromaster.minecraft.zeasons.mixin;

import net.minecraft.block.LeavesBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.zekromaster.minecraft.zeasons.Season;
import net.zekromaster.minecraft.zeasons.TimeOfYear;
import net.zekromaster.minecraft.zeasons.colour.InterpolateColourUtils;
import net.zekromaster.minecraft.zeasons.colour.SeasonalColourProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = LeavesBlock.class, priority = 999)
public abstract class LeavesBlockMixin {

    @Inject(
        method = "getColorMultiplier",
        at = @At("HEAD"),
        cancellable = true)
    public void getColorMultiplier(BlockView blockView, int x, int y, int z, CallbackInfoReturnable<Integer> cir) {
        var toy = TimeOfYear.of(blockView);
        if (toy != null) {

            var meta = blockView.getBlockMeta(x, y, z);

            Season.PropertyKey<SeasonalColourProvider> colourProvider;

            if ((meta & 1) == 1) {
                colourProvider = SeasonalColourProvider.SPRUCE_LEAVES_COLOUR_PROVIDER_KEY;
            } else if ((meta & 2) == 2) {
                colourProvider = SeasonalColourProvider.BIRCH_LEAVES_COLOUR_PROVIDER_KEY;
            } else {
                colourProvider = SeasonalColourProvider.OAK_LEAVES_COLOUR_PROVIDER_KEY;
            }

            cir.setReturnValue(
                InterpolateColourUtils.getColourForTimeOfYear(
                    colourProvider,
                    toy,
                    blockView,
                    new BlockPos(x, y, z)
                )
            );
        }
    }

}

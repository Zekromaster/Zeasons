package net.zekromaster.minecraft.zeasons.mixin.colour;

import net.minecraft.block.LeavesBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.zekromaster.minecraft.zeasons.TimeOfYear;
import net.zekromaster.minecraft.zeasons.colour.InterpolateColourUtils;
import net.zekromaster.minecraft.zeasons.colour.SeasonalColourProvider;
import net.zekromaster.minecraft.zeasons.properties.SeasonPropertyKey;
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

            SeasonPropertyKey<SeasonalColourProvider> colourProvider;

            if ((meta & 1) == 1) {
                colourProvider = SeasonalColourProvider.PropertyKeys.SPRUCE;
            } else if ((meta & 2) == 2) {
                colourProvider = SeasonalColourProvider.PropertyKeys.BIRCH;
            } else {
                colourProvider = SeasonalColourProvider.PropertyKeys.OAK;
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

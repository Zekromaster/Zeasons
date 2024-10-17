package net.zekromaster.minecraft.zeasons.mixin;

import net.minecraft.block.GrassBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.zekromaster.minecraft.zeasons.TimeOfYear;
import net.zekromaster.minecraft.zeasons.colour.InterpolateColourUtils;
import net.zekromaster.minecraft.zeasons.colour.SeasonalColourProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = GrassBlock.class, priority = 999)
public class GrassBlockMixin {

    @Inject(
        method = "getColorMultiplier",
        at = @At("HEAD"),
        cancellable = true
    )
    public void getColorMultiplier(BlockView blockView, int x, int y, int z, CallbackInfoReturnable<Integer> cir) {
        var toy = TimeOfYear.of(blockView);
        if (toy != null) {
            cir.setReturnValue(
                InterpolateColourUtils.getColourForTimeOfYear(
                    SeasonalColourProvider.GRASS_COLOUR_PROVIDER_KEY,
                    toy,
                    blockView,
                    new BlockPos(x, y, z)
                )
            );
        }
    }

}

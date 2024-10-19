package net.zekromaster.minecraft.zeasons.mixin.crops;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.block.Block;
import net.minecraft.block.CropBlock;
import net.minecraft.world.World;
import net.zekromaster.minecraft.zeasons.TimeOfYear;
import net.zekromaster.minecraft.zeasons.crops.PlantGrowthSpeed;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(CropBlock.class)
public class CropBlockMixin {

    @Unique
    private PlantGrowthSpeed getGrowthSpeed(World world) {
        return TimeOfYear.of(world).season().getProperty(PlantGrowthSpeed.PropertyKeys.WHEAT);
    }

    @Inject(
        method = "onTick",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;getBlockMeta(III)I", shift = At.Shift.AFTER),
        cancellable = true
    )
    public void reducedChances(World world, int x, int y, int z, Random random, CallbackInfo ci) {
        //noinspection EqualsBetweenInconvertibleTypes
        if (Block.WHEAT.equals(this)) {
            var growthChance = getGrowthSpeed(world).chanceModifier;
            var possibility = random.nextDouble(0.0, 1.0);
            if (possibility > growthChance) {
                ci.cancel();
            }
        }
    }

    @WrapOperation(
        method = "onTick",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;setBlockMeta(IIII)V")
    )
    public void increasedChances(World world, int x, int y, int z, int meta, Operation<Void> original) {
        if (
            getGrowthSpeed(world).equals(PlantGrowthSpeed.FAST)
            && new Random().nextBoolean()
            && new Random().nextBoolean()
        ) {
            original.call(world, x, y, z, meta + 1);
        } else {
            original.call(world, x, y, z, meta);
        }
    }

}

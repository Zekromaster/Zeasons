package net.zekromaster.minecraft.zeasons.mixin.crops;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.Block;
import net.minecraft.block.SaplingBlock;
import net.minecraft.world.World;
import net.zekromaster.minecraft.zeasons.TimeOfYear;
import net.zekromaster.minecraft.zeasons.crops.PlantGrowthSpeed;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(SaplingBlock.class)
public class SaplingMixin {

    @Unique
    private PlantGrowthSpeed getGrowthSpeed(World world, int meta) {
        return TimeOfYear
            .of(world)
            .season()
            .getProperty(switch (meta & 0b11) {
                case 1 -> PlantGrowthSpeed.PropertyKeys.SPRUCE;
                case 2 -> PlantGrowthSpeed.PropertyKeys.BIRCH;
                default -> PlantGrowthSpeed.PropertyKeys.OAK;
            });
    }

    @Inject(
        method = "onTick",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;getBlockMeta(III)I", shift = At.Shift.AFTER),
        cancellable = true
    )
    public void onTick(World world, int x, int y, int z, Random random, CallbackInfo ci) {
        //noinspection EqualsBetweenInconvertibleTypes
        if (Block.SAPLING.equals(this)) {
            var growthChance = getGrowthSpeed(world, world.getBlockMeta(x, y, z)).chanceModifier;
            var possibility = random.nextDouble(0.0, 1.0);
            if (possibility > growthChance) {
                ci.cancel();
            }
        }
    }

    @ModifyConstant(
        method = "onTick",
        constant = @Constant(intValue = 30)
    )
    public int increasedChances(
        int bound,
        @Local(argsOnly = true) World world,
        @Local(name = "x") int x,
        @Local(name = "y") int y,
        @Local(name = "z") int z
    ) {
        //noinspection EqualsBetweenInconvertibleTypes
        if (Block.SAPLING.equals(this)) {
            var growthSpeed = getGrowthSpeed(world, world.getBlockMeta(x, y, z));
            if (growthSpeed.equals(PlantGrowthSpeed.FAST)) {
                return 15;
            }
        }
        return bound;
    }

}

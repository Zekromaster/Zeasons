package net.zekromaster.minecraft.zeasons.mixin.decorations;

import it.unimi.dsi.fastutil.ints.IntIntPair;
import net.minecraft.block.LeavesBlock;
import net.minecraft.world.World;
import net.zekromaster.minecraft.zeasons.TimeOfYear;
import net.zekromaster.minecraft.zeasons.Zeasons;
import net.zekromaster.minecraft.zeasons.decorations.DecorationSpawn;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Mixin(LeavesBlock.class)
public class LeavesBlockMixin {

    @Unique
    private final static int MAX_DISTANCE_FROM_LEAF = 3;
    @Unique
    private final static int MAX_LEAF_PILES = 12;

    @Unique
    private boolean isTooCrowded(World world, int x, int y, int z) {
        List<Integer> xAxis = IntStream.rangeClosed(x - MAX_DISTANCE_FROM_LEAF, x + MAX_DISTANCE_FROM_LEAF).boxed().toList();
        List<Integer> zAxis = IntStream.rangeClosed(z - MAX_DISTANCE_FROM_LEAF, z + MAX_DISTANCE_FROM_LEAF).boxed().toList();

        List<IntIntPair> coords = xAxis.stream().flatMap(xC -> zAxis.stream().map(zC -> IntIntPair.of(xC, zC))).toList();

        return coords.stream().filter(p -> world.getBlockState(p.leftInt(), y, p.rightInt()).isIn(Zeasons.LEAF_PILE_TAG)).count() >= MAX_LEAF_PILES;
    }

    @Inject(
        method = "onTick",
        at = @At("TAIL")
    )
    public void createLeafPiles(World world, int x, int y, int z, Random random, CallbackInfo ci) {
        if (!world.isRemote) {
            var frequency = TimeOfYear.of(world).season().getProperty(DecorationSpawn.PropertyKeys.LEAF_PILES);
            if (random.nextInt(100) < frequency.spawnChance) {
                var spawnX = random.nextInt(x - MAX_DISTANCE_FROM_LEAF, x + MAX_DISTANCE_FROM_LEAF);
                var spawnZ = random.nextInt(z - MAX_DISTANCE_FROM_LEAF, z + MAX_DISTANCE_FROM_LEAF);
                var spawnY = y;
                if (world.getBlockId(spawnX, spawnY, spawnZ) != 0) {
                    spawnY--;
                }
                while (world.getBlockId(spawnX, spawnY, spawnZ) == 0 && spawnY > 0) {
                    spawnY--;
                }
                spawnY++;
                if (Zeasons.LEAF_PILE.canPlaceAt(world, spawnX, spawnY, spawnZ) && !isTooCrowded(world, spawnX, spawnY, spawnZ)) {
                    Zeasons.LEAF_PILE.withRandomMeta(world, spawnX, spawnY, spawnZ, random);
                }
            }
        }
    }

}

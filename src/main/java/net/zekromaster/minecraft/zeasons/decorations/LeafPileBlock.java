package net.zekromaster.minecraft.zeasons.decorations;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.Box;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;
import net.zekromaster.minecraft.zeasons.TimeOfYear;
import net.zekromaster.minecraft.zeasons.Zeasons;

import java.util.Random;


public class LeafPileBlock extends TemplateBlock {

    private final int[] colours;

    public LeafPileBlock(Identifier identifier, int colour) {
        this(identifier, new int[] { colour });
    }

    public LeafPileBlock(Identifier identifier, int[] colours) {
        super(identifier, Material.LEAVES);
        this.colours = colours;
        setBoundingBox(
            0F, 0F, 0F,
            1f, 0.1f, 1f
        );
        setSoundGroup(Block.DIRT_SOUND_GROUP);
        setHardness(0.2F);
        setOpacity(1);
        setTickRandomly(true);
    }

    @Override
    public Box getCollisionShape(World world, int x, int y, int z) {
        return null;
    }

    @Environment(EnvType.CLIENT)
    @Override
    public int getColor(int meta) {
        return colours[meta];
    }

    @Environment(EnvType.CLIENT)
    @Override
    public int getColorMultiplier(BlockView blockView, int x, int y, int z) {
        return colours[blockView.getBlockMeta(x, y, z)];
    }

    @Environment(EnvType.CLIENT)
    @Override
    public int getTexture(int side, int meta) {
        return Block.LEAVES.getTexture(side, 0b00);
    }

    @Override
    public boolean canPlaceAt(World world, int x, int y, int z) {
        return world.getBlockState(x, y - 1, z).isIn(Zeasons.ALLOWS_LEAF_PILES);
    }

    @Override
    public boolean isOpaque() {
        return false;
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public int getDroppedItemCount(Random random) {
        return 0;
    }

    @Override
    public void onTick(World world, int x, int y, int z, Random random) {
        super.onTick(world, x, y, z, random);
        var decaySpeed = TimeOfYear.of(world).season().getProperty(DecaySpeed.PropertyKeys.LEAF_PILES);
        if (random.nextInt(100) < decaySpeed.decayChance) {
            world.setBlock(x, y, z, 0);
        }
    }

    public void withRandomMeta(World world, int x, int y, int z, Random random) {
        world.setBlockStateWithMetadataWithNotify(
            x, y, z,
            this.getDefaultState(),
            random.nextInt(colours.length)
        );
    }
}

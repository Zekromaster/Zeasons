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
import net.zekromaster.minecraft.zeasons.Zeasons;

import java.util.Random;


public class LeafPileBlock extends TemplateBlock {

    private final int colour;

    public LeafPileBlock(Identifier identifier, int colour) {
        super(identifier, Material.LEAVES);
        this.colour = colour;
        setBoundingBox(
            0F, 0F, 0F,
            1f, 0.1f, 1f
        );
        setSoundGroup(Block.DIRT_SOUND_GROUP);
        setHardness(0.2F);
        setOpacity(1);
    }

    @Override
    public Box getCollisionShape(World world, int x, int y, int z) {
        return null;
    }

    @Environment(EnvType.CLIENT)
    @Override
    public int getColor(int meta) {
        return colour;
    }

    @Environment(EnvType.CLIENT)
    @Override
    public int getColorMultiplier(BlockView blockView, int x, int y, int z) {
        return colour;
    }

    @Environment(EnvType.CLIENT)
    @Override
    public int getTexture(int side, int meta) {
        return Block.LEAVES.getTexture(side, 0b00);
    }

    @Override
    public boolean canPlaceAt(World world, int x, int y, int z) {
        return world.getBlockState(x, y - 1, z).isIn(Zeasons.PLACE_LEAF_PILES_TAG);
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
}

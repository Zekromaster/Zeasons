package net.zekromaster.minecraft.zeasons.mixin;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;
import net.zekromaster.minecraft.zeasons.TimeOfYear;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PickaxeItem.class)
public abstract class TestMixin extends ToolItem {

    private TestMixin(int id, int damageBoost, ToolMaterial toolMaterial, Block[] effectiveOn) {
        super(id, damageBoost, toolMaterial, effectiveOn);
    }

    @Override
    public ItemStack use(ItemStack stack, World world, PlayerEntity user) {
        System.out.println(TimeOfYear.of(world));
        return super.use(stack, world, user);
    }

}

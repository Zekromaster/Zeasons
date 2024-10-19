package net.zekromaster.minecraft.zeasons.mixin.colour;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.world.StationFlatteningWorld;
import net.zekromaster.minecraft.zeasons.TimeOfYear;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(World.class)
public abstract class WorldMixin implements StationFlatteningWorld {

    @Shadow public abstract void setBlocksDirty(int minX, int minY, int minZ, int maxX, int maxY, int maxZ);

    @Unique
    private TimeOfYear currentlyRenderedTimeOfYear = null;

    @Inject(
        method = "tick",
        at = @At("TAIL")
    )
    public void onTick(CallbackInfo ci) {
        var currentTimeOfYear = TimeOfYear.of((World) (Object) this);
        if (!Objects.equals(currentTimeOfYear, currentlyRenderedTimeOfYear)) {
            var theMinecraft = (Minecraft) FabricLoader.getInstance().getGameInstance();
            var currentPos = theMinecraft.player.getPosition(0.0f);

            this.setBlocksDirty(
                Double.valueOf(Math.floor(currentPos.x)).intValue() - 256,
                this.getBottomY(),
                Double.valueOf(Math.floor(currentPos.z)).intValue() - 256,
                Double.valueOf(Math.ceil(currentPos.x)).intValue() + 256,
                this.getTopY(),
                Double.valueOf(Math.ceil(currentPos.z)).intValue() + 256
            );
            this.currentlyRenderedTimeOfYear = currentTimeOfYear;
        }
    }
}

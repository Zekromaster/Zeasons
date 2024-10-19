package net.zekromaster.minecraft.zeasons.mixin;

import net.minecraft.client.Minecraft;
import net.modificationstation.stationapi.api.StationAPI;
import net.zekromaster.minecraft.zeasons.events.AttachSeasonPropertiesEvent;
import net.zekromaster.minecraft.zeasons.events.PolishSeasonsEvent;
import net.zekromaster.minecraft.zeasons.events.SeasonCyclesEvent;
import net.zekromaster.minecraft.zeasons.events.SeasonRegistryEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class InitSeasonsClientMixin {

    @Inject(
        method = "init",
        at = @At("TAIL")
    )
    public void zeasons_initSeasons(CallbackInfo ci) {
        StationAPI.EVENT_BUS.post(new SeasonRegistryEvent());
        StationAPI.EVENT_BUS.post(new AttachSeasonPropertiesEvent());
        StationAPI.EVENT_BUS.post(new PolishSeasonsEvent());
        StationAPI.EVENT_BUS.post(new SeasonCyclesEvent());
    }
}

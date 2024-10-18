package net.zekromaster.minecraft.zeasons.entrypoints;

import net.fabricmc.loader.api.FabricLoader;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.event.mod.InitEvent;
import net.zekromaster.minecraft.zeasons.commands.RetroCommandsInit;

public class InitCompat {

    @EventListener
    public void init(InitEvent event) {
        if (FabricLoader.getInstance().isModLoaded("retrocommands")) {
            RetroCommandsInit.init();
        }
    }

}

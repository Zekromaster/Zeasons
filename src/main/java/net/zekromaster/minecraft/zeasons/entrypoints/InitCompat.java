package net.zekromaster.minecraft.zeasons.entrypoints;

import net.fabricmc.loader.api.FabricLoader;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.mine_diver.unsafeevents.listener.ListenerPriority;
import net.modificationstation.stationapi.api.event.mod.InitEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.EntrypointManager;
import net.zekromaster.minecraft.zeasons.Zeasons;
import net.zekromaster.minecraft.zeasons.commands.RetroCommandsInit;

public class InitCompat {

    @EventListener(priority = ListenerPriority.HIGHEST)
    public void preInit(InitEvent event) {
        FabricLoader.getInstance().getEntrypointContainers(Zeasons.NAMESPACE.id("event_bus").toString(), Object.class).forEach(EntrypointManager::setup);
        FabricLoader.getInstance().getEntrypointContainers(
            Zeasons.NAMESPACE.id("event_bus/" + switch (FabricLoader.getInstance().getEnvironmentType()) {
                case CLIENT -> "client";
                case SERVER -> "server";
            }).toString(),
            Object.class
        ).forEach(EntrypointManager::setup);
    }

    @EventListener
    public void init(InitEvent event) {
        if (FabricLoader.getInstance().isModLoaded("retrocommands")) {
            RetroCommandsInit.init();
        }
    }

}

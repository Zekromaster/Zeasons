package net.zekromaster.minecraft.zeasons.commands;

import com.matthewperiut.retrocommands.api.CommandRegistry;

public class RetroCommandsInit {

    public static void init() {
        CommandRegistry.add(new GetSeasonCommand());
    }

}

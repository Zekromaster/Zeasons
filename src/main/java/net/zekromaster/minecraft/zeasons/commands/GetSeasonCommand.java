package net.zekromaster.minecraft.zeasons.commands;

import com.matthewperiut.retrocommands.api.Command;
import com.matthewperiut.retrocommands.util.SharedCommandSource;
import net.zekromaster.minecraft.zeasons.TimeOfYear;

class GetSeasonCommand implements Command {
    @Override
    public void command(SharedCommandSource sharedCommandSource, String[] strings) {
        if (sharedCommandSource.getPlayer() == null) {
            return;
        }

        var world = sharedCommandSource.getPlayer().world;
        var toy = TimeOfYear.of(world);

        if (strings.length > 1) {
            manual(sharedCommandSource);
        }

        sharedCommandSource.sendFeedback(
            String.format(
                "Day %d of season %s",
                toy.day(),
                toy.season().id
            )
        );
    }

    @Override
    public String name() {
        return "season";
    }

    @Override
    public void manual(SharedCommandSource sharedCommandSource) {
        sharedCommandSource.sendFeedback(
            "Usage: /season"
        );
        sharedCommandSource.sendFeedback(
            "Info: reports current season"
        );
    }
}

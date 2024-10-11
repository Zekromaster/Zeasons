package net.zekromaster.minecraft.zeasons;

import net.minecraft.world.dimension.Dimension;
import net.modificationstation.stationapi.api.registry.DimensionRegistry;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public record SeasonCycle(int seasonLength, List<Season> seasons) {

    public static Map<Identifier, SeasonCycle> seasonCycleMap = new HashMap<>();

    public static SeasonCycle of(Dimension dimension) {
        return DimensionRegistry.INSTANCE
            .getIdByLegacyId(dimension.id)
            .map(seasonCycleMap::get)
            .orElseGet(SeasonCycle::empty);
    }

    public SeasonCycle {
        if (seasonLength < 1) {
            throw new IllegalArgumentException("SeasonCycle initialised with seasonLength <= 0. How is this possible?");
        }
        if (seasons.isEmpty()) {
            throw new IllegalArgumentException("SeasonCycle initialised with no seasons.");
        }
    }

    public static SeasonCycle empty() {
        return new SeasonCycle(1, List.of(Zeasons.NO_SEASON));
    }

    public int yearLength() {
        return seasonLength * seasons.size();
    }

    public TimeOfYear dayToTimeOfYear(long dayOfWorld) {
        var dayOfYear = dayOfWorld % yearLength();
        return new TimeOfYear(seasons.get((int) (dayOfYear / seasonLength)), dayOfYear % seasonLength);

    }
}

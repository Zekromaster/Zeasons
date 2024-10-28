package net.zekromaster.minecraft.zeasons;

import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldRegion;
import net.minecraft.world.dimension.Dimension;
import net.modificationstation.stationapi.api.registry.DimensionRegistry;
import net.modificationstation.stationapi.api.util.Identifier;
import net.zekromaster.minecraft.zeasons.mixin.WorldRegionAccessor;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static net.zekromaster.minecraft.zeasons.Zeasons.NO_SEASON;

public record SeasonCycle(int seasonLength, List<Season> seasons) {

    public static final Map<Identifier, SeasonCycle> seasonCycleMap = new HashMap<>();

    @NotNull
    public static SeasonCycle of(BlockView view) {
        if (view instanceof WorldRegion region) {
            return of(((WorldRegionAccessor)region).getWorld().dimension);
        }
        if (view instanceof World world) {
            return of(world.dimension);
        }
        return empty();
    }

    @NotNull
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
        if (Set.copyOf(seasons).size() != seasons.size()) {
            throw new IllegalArgumentException("SeasonCycle initialised with duplicate seasons.");
        }
    }

    @NotNull
    public static SeasonCycle empty() {
        return new SeasonCycle(1, List.of(Zeasons.NO_SEASON));
    }

    public int yearLength() {
        return seasonLength * seasons.size();
    }

    @NotNull
    public TimeOfYear dayToTimeOfYear(long dayOfWorld) {
        var dayOfYear = dayOfWorld % yearLength();
        return new TimeOfYear(seasons.get((int) (dayOfYear / seasonLength)), dayOfYear % seasonLength);
    }

    @NotNull
    public Season previousSeason(Season season) {
        var index = this.seasons.indexOf(season);
        if (index < 0) {
            return NO_SEASON;
        }
        return this.seasons.get((this.seasons.size() + index - 1) % this.seasons.size());
    }

    @NotNull
    public Season nextSeason(Season season) {
        var index = this.seasons.indexOf(season);
        if (index < 0) {
            return NO_SEASON;
        }
        return this.seasons.get((index + 1) % this.seasons.size());
    }

}

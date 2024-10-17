package net.zekromaster.minecraft.zeasons.colour;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.zekromaster.minecraft.zeasons.Season;
import net.zekromaster.minecraft.zeasons.SeasonCycle;
import net.zekromaster.minecraft.zeasons.TimeOfYear;

@Environment(EnvType.CLIENT)
public final class InterpolateColourUtils {

    private static final int RED_MASK = 0x00FF0000;
    private static final int GREEN_MASK = 0x0000FF00;
    private static final int BLUE_MASK = 0x000000FF;

    private InterpolateColourUtils() {
        throw new IllegalStateException("Utility Class");
    }

    public static int getColourForTimeOfYear(
        Season.PropertyKey<SeasonalColourProvider> handler,
        TimeOfYear timeOfYear,
        BlockView blockView,
        BlockPos blockPos
    ) {
        var currentDay = timeOfYear.day();
        var currentSeason = timeOfYear.season();

        var seasons = SeasonCycle.of(blockView);

        var currentSeasonColour = currentSeason.getHandler(handler).colour(blockView, blockPos);
        var middleOfSeason = ((double) seasons.seasonLength() / 2) - 0.5;

        if (currentDay == middleOfSeason) {
            return currentSeasonColour;
        }

        var otherSeason = (currentDay < middleOfSeason) ?
            seasons.previousSeason(currentSeason) : seasons.nextSeason(currentSeason);

        var otherColour = otherSeason.getHandler(handler).colour(blockView, blockPos);

        if (currentSeasonColour == otherColour) {
            return currentSeasonColour;
        }

        var howFarFromMiddle = (currentDay < middleOfSeason) ?
            currentDay / middleOfSeason : (seasons.seasonLength() - currentDay) / middleOfSeason;

        var percentageOfCurrent = 0.5 * (1 + howFarFromMiddle);
        var percentageOfOther = 1d - percentageOfCurrent;

        return interpolate(
            percentageOfCurrent,
            currentSeasonColour,
            percentageOfOther,
            otherColour
        );
    }

    private static int getRed(int colour) {
        return (colour & RED_MASK) >> 16;
    }

    private static int getGreen(int colour) {
        return (colour & GREEN_MASK) >> 8;
    }

    private static int getBlue(int colour) {
        return colour & BLUE_MASK;
    }

    private static int interpolate(double weight1, int colour1, double weight2, int colour2) {
        var red = Double.valueOf((getRed(colour1) * weight1) + (getRed(colour2)  * weight2)).intValue();
        var green = Double.valueOf((getGreen(colour1) * weight1) + (getGreen(colour2)  * weight2)).intValue();
        var blue = Double.valueOf((getBlue(colour1) * weight1) + (getBlue(colour2)  * weight2)).intValue();

        return (red << 16) + (green << 8) + blue;
    }


}

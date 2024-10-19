package net.zekromaster.minecraft.zeasons.entrypoints;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.zekromaster.minecraft.zeasons.Zeasons;
import net.zekromaster.minecraft.zeasons.crops.PlantGrowthSpeed;
import net.zekromaster.minecraft.zeasons.events.AttachSeasonPropertiesEvent;

public class SeasonalCrops {

    @EventListener
    private void addCropProviders(AttachSeasonPropertiesEvent event) {
        Zeasons.SPRING.setProperty(PlantGrowthSpeed.PropertyKeys.WHEAT, PlantGrowthSpeed.NORMAL);
        Zeasons.SUMMER.setProperty(PlantGrowthSpeed.PropertyKeys.WHEAT, PlantGrowthSpeed.FAST);
        Zeasons.AUTUMN.setProperty(PlantGrowthSpeed.PropertyKeys.WHEAT, PlantGrowthSpeed.SLOW);
        Zeasons.WINTER.setProperty(PlantGrowthSpeed.PropertyKeys.WHEAT, PlantGrowthSpeed.SLOW);

        Zeasons.SPRING.setProperty(PlantGrowthSpeed.PropertyKeys.OAK, PlantGrowthSpeed.NORMAL);
        Zeasons.SUMMER.setProperty(PlantGrowthSpeed.PropertyKeys.OAK, PlantGrowthSpeed.FAST);
        Zeasons.AUTUMN.setProperty(PlantGrowthSpeed.PropertyKeys.OAK, PlantGrowthSpeed.SLOW);
        Zeasons.WINTER.setProperty(PlantGrowthSpeed.PropertyKeys.OAK, PlantGrowthSpeed.NO_GROWTH);

        Zeasons.SPRING.setProperty(PlantGrowthSpeed.PropertyKeys.BIRCH, PlantGrowthSpeed.NORMAL);
        Zeasons.SUMMER.setProperty(PlantGrowthSpeed.PropertyKeys.BIRCH, PlantGrowthSpeed.SLOW);
        Zeasons.AUTUMN.setProperty(PlantGrowthSpeed.PropertyKeys.BIRCH, PlantGrowthSpeed.NO_GROWTH);
        Zeasons.WINTER.setProperty(PlantGrowthSpeed.PropertyKeys.BIRCH, PlantGrowthSpeed.NORMAL);

        Zeasons.SPRING.setProperty(PlantGrowthSpeed.PropertyKeys.SPRUCE, PlantGrowthSpeed.NORMAL);
        Zeasons.SUMMER.setProperty(PlantGrowthSpeed.PropertyKeys.SPRUCE, PlantGrowthSpeed.NORMAL);
        Zeasons.AUTUMN.setProperty(PlantGrowthSpeed.PropertyKeys.SPRUCE, PlantGrowthSpeed.SLOW);
        Zeasons.WINTER.setProperty(PlantGrowthSpeed.PropertyKeys.SPRUCE, PlantGrowthSpeed.FAST);
    }

}

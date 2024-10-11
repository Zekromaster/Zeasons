package net.zekromaster.minecraft.zeasons;

import net.modificationstation.stationapi.api.util.Namespace;

public final class Zeasons {
    public static final Namespace NAMESPACE = Namespace.of("zeasons");

    public static Season SPRING = new Season(NAMESPACE.id("spring"));
    public static Season SUMMER = new Season(NAMESPACE.id("summer"));
    public static Season AUTUMN = new Season(NAMESPACE.id("autumn"));
    public static Season WINTER = new Season(NAMESPACE.id("winter"));

    public static Season HELL;

    public static Season NO_SEASON = new Season(NAMESPACE.id("no_season"));

}

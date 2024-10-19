package net.zekromaster.minecraft.zeasons;

import net.modificationstation.stationapi.api.util.Namespace;

public final class Zeasons {

    public static final Namespace NAMESPACE = Namespace.of("zeasons");

    public static final Season SPRING = new Season(NAMESPACE.id("spring"));
    public static final Season SUMMER = new Season(NAMESPACE.id("summer"));
    public static final Season AUTUMN = new Season(NAMESPACE.id("autumn"));
    public static final Season WINTER = new Season(NAMESPACE.id("winter"));

    public static final Season HELL = new Season(NAMESPACE.id("hell"));

    public static final Season NO_SEASON = new Season(NAMESPACE.id("no_season"));

}

package net.zekromaster.minecraft.zeasons;

import net.minecraft.block.Block;
import net.modificationstation.stationapi.api.registry.BlockRegistry;
import net.modificationstation.stationapi.api.tag.TagKey;
import net.modificationstation.stationapi.api.util.Namespace;
import net.zekromaster.minecraft.zeasons.decorations.LeafPileBlock;

public final class Zeasons {

    public static final Namespace NAMESPACE = Namespace.of("zeasons");

    public static final Season SPRING = new Season(NAMESPACE.id("spring"));
    public static final Season SUMMER = new Season(NAMESPACE.id("summer"));
    public static final Season AUTUMN = new Season(NAMESPACE.id("autumn"));
    public static final Season WINTER = new Season(NAMESPACE.id("winter"));

    public static final Season HELL = new Season(NAMESPACE.id("hell"));

    public static final Season NO_SEASON = new Season(NAMESPACE.id("no_season"));

    public static LeafPileBlock LEAF_PILE;

    public static TagKey<Block> ALLOWS_LEAF_PILES = TagKey.of(BlockRegistry.KEY, NAMESPACE.id("allows_leaf_piles"));
    public static TagKey<Block> LEAF_PILE_TAG = TagKey.of(BlockRegistry.KEY, NAMESPACE.id("leaf_pile"));
}

package com.joppebijlsma.rustingiron.blocks;

import com.joppebijlsma.rustingiron.RustingIron;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.SlabBlock;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;

public class RustedIronBlocks {
    public static Block
            EXPOSED_IRON,
            WEATHERED_IRON,
            RUSTED_IRON,
            IRON_STAIRS,
            EXPOSED_IRON_STAIRS,
            WEATHERED_IRON_STAIRS,
            RUSTED_IRON_STAIRS,
            IRON_SLAB,
            EXPOSED_IRON_SLAB,
            WEATHERED_IRON_SLAB,
            RUSTED_IRON_SLAB,
            WAXED_IRON_BLOCK,
            WAXED_EXPOSED_IRON,
            WAXED_WEATHERED_IRON,
            WAXED_RUSTED_IRON,
            WAXED_IRON_STAIRS,
            WAXED_EXPOSED_IRON_STAIRS,
            WAXED_WEATHERED_IRON_STAIRS,
            WAXED_RUSTED_IRON_STAIRS,
            WAXED_IRON_SLAB,
            WAXED_EXPOSED_IRON_SLAB,
            WAXED_WEATHERED_IRON_SLAB,
            WAXED_RUSTED_IRON_SLAB
                    ;

    public static void init() {
        EXPOSED_IRON = registerRustableBlock("exposed_iron", Rustable.RustLevel.EXPOSED);
        WEATHERED_IRON = registerRustableBlock("weathered_iron", Rustable.RustLevel.WEATHERED);
        RUSTED_IRON = registerRustableBlock("rusted_iron", Rustable.RustLevel.RUSTED);

        IRON_STAIRS = registerRustableStairsBlock("iron_stairs", Blocks.IRON_BLOCK, Rustable.RustLevel.UNAFFECTED);
        EXPOSED_IRON_STAIRS = registerRustableStairsBlock("exposed_iron_stairs", EXPOSED_IRON, Rustable.RustLevel.EXPOSED);
        WEATHERED_IRON_STAIRS = registerRustableStairsBlock("weathered_iron_stairs", WEATHERED_IRON, Rustable.RustLevel.WEATHERED);
        RUSTED_IRON_STAIRS = registerRustableStairsBlock("rusted_iron_stairs", RUSTED_IRON, Rustable.RustLevel.RUSTED);

        IRON_SLAB = registerRustableSlabBlock("iron_slab", Rustable.RustLevel.UNAFFECTED);
        EXPOSED_IRON_SLAB = registerRustableSlabBlock("exposed_iron_slab", Rustable.RustLevel.EXPOSED);
        WEATHERED_IRON_SLAB = registerRustableSlabBlock("weathered_iron_slab", Rustable.RustLevel.WEATHERED);
        RUSTED_IRON_SLAB = registerRustableSlabBlock("rusted_iron_slab", Rustable.RustLevel.RUSTED);

        WAXED_IRON_BLOCK = registerWaxedBlock("waxed_iron_block", Rustable.RustLevel.UNAFFECTED);
        WAXED_EXPOSED_IRON = registerWaxedBlock("waxed_exposed_iron", Rustable.RustLevel.EXPOSED);
        WAXED_WEATHERED_IRON = registerWaxedBlock("waxed_weathered_iron", Rustable.RustLevel.WEATHERED);
        WAXED_RUSTED_IRON = registerWaxedBlock("waxed_rusted_iron", Rustable.RustLevel.RUSTED);

        WAXED_IRON_STAIRS = registerWaxedStairsBlock("waxed_iron_stairs", Blocks.IRON_BLOCK, Rustable.RustLevel.UNAFFECTED);
        WAXED_EXPOSED_IRON_STAIRS = registerWaxedStairsBlock("waxed_exposed_iron_stairs", EXPOSED_IRON, Rustable.RustLevel.EXPOSED);
        WAXED_WEATHERED_IRON_STAIRS = registerWaxedStairsBlock("waxed_weathered_iron_stairs", WEATHERED_IRON, Rustable.RustLevel.WEATHERED);
        WAXED_RUSTED_IRON_STAIRS = registerWaxedStairsBlock("waxed_rusted_iron_stairs", RUSTED_IRON, Rustable.RustLevel.RUSTED);

        WAXED_IRON_SLAB = registerWaxedSlabBlock("waxed_iron_slab", Rustable.RustLevel.UNAFFECTED);
        WAXED_EXPOSED_IRON_SLAB = registerWaxedSlabBlock("waxed_exposed_iron_slab", Rustable.RustLevel.EXPOSED);
        WAXED_WEATHERED_IRON_SLAB = registerWaxedSlabBlock("waxed_weathered_iron_slab", Rustable.RustLevel.WEATHERED);
        WAXED_RUSTED_IRON_SLAB = registerWaxedSlabBlock("waxed_rusted_iron_slab", Rustable.RustLevel.RUSTED);
    }

    private static Block register(String id, Block block) {
        return Registry.register(Registries.BLOCK, RustingIron.id(id), block);
    }

    private static MapColor getMapColorFromRustLevel(Rustable.RustLevel rustLevel) {
        if (rustLevel.equals(Rustable.RustLevel.UNAFFECTED)) {
            return MapColor.IRON_GRAY;
        } else if (rustLevel.equals(Rustable.RustLevel.EXPOSED)) {
            return MapColor.TERRACOTTA_WHITE;
        } else if (rustLevel.equals(Rustable.RustLevel.WEATHERED)) {
            return MapColor.ORANGE;
        }

        return MapColor.TERRACOTTA_ORANGE;
    }

    private static Block registerRustableBlock(String id, Rustable.RustLevel rustLevel) {
        return register(id,
                new RustableBlock(rustLevel,
                        AbstractBlock.Settings.create().mapColor(getMapColorFromRustLevel(rustLevel))
                                .requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL)));
    }

    private static Block registerRustableStairsBlock(String id, Block baseBlock, Rustable.RustLevel rustLevel) {
        return register(id,
                new RustableStairsBlock(rustLevel, baseBlock.getDefaultState(),
                        AbstractBlock.Settings.create().mapColor(getMapColorFromRustLevel(rustLevel))
                                .requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL)));
    }

    private static Block registerRustableSlabBlock(String id, Rustable.RustLevel rustLevel) {
        return register(id,
                new RustableSlabBlock(rustLevel,
                        AbstractBlock.Settings.create().mapColor(getMapColorFromRustLevel(rustLevel))
                                .requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL)));
    }

    private static Block registerWaxedBlock(String id, Rustable.RustLevel rustLevel) {
        return register(id,
                new Block(AbstractBlock.Settings.create().mapColor(getMapColorFromRustLevel(rustLevel))
                        .requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL)));
    }

    private static Block registerWaxedStairsBlock(String id, Block baseBlock, Rustable.RustLevel rustLevel) {
        return register(id,
                new ModStairsBlock(baseBlock.getDefaultState(),
                        AbstractBlock.Settings.create().mapColor(getMapColorFromRustLevel(rustLevel))
                                .requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL)));
    }

    private static Block registerWaxedSlabBlock(String id, Rustable.RustLevel rustLevel) {
        return register(id,
                new SlabBlock(AbstractBlock.Settings.create().mapColor(getMapColorFromRustLevel(rustLevel))
                        .requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL)));
    }
}
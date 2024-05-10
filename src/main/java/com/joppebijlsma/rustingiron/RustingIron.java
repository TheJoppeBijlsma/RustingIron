package com.joppebijlsma.rustingiron;

import com.joppebijlsma.rustingiron.blocks.RustedIronBlocks;
import com.joppebijlsma.rustingiron.items.RustedIronItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class RustingIron implements ModInitializer {
    public static final String MODID = "rustingiron";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public static Identifier id(String id) {
        return new Identifier(MODID, id);
    }

    @Override
    public void onInitialize() {
        RustedIronBlocks.init();
        RustedIronItems.init();
    }
}
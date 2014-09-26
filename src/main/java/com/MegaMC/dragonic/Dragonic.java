package com.MegaMC.dragonic;

import net.minecraftforge.common.MinecraftForge;

import com.MegaMC.dragonic.client.handler.DamageSourcer;
import com.MegaMC.dragonic.client.handler.KeyInputEventHandler;
import com.MegaMC.dragonic.handler.ConfigurationHandler;
import com.MegaMC.dragonic.init.ModBlocks;
import com.MegaMC.dragonic.init.ModItems;
import com.MegaMC.dragonic.init.Recipes;
import com.MegaMC.dragonic.proxy.IProxy;
import com.MegaMC.dragonic.reference.Reference;
import com.MegaMC.dragonic.utility.LogHelper;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class Dragonic
{
    @Mod.Instance(Reference.MOD_ID)
    public static Dragonic instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

        proxy.registerKeyBindings();

        ModItems.init();
        ModBlocks.init();
        //ModTileEntity.init();

        LogHelper.info("Pre Initialization Complete!");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        FMLCommonHandler.instance().bus().register(new KeyInputEventHandler());
        Recipes.init();
        FMLCommonHandler.instance().bus().register(new DamageSourcer());
        LogHelper.info("Initialization Complete!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        LogHelper.info("Post Initialization Complete!");
    }
}

package com.MegaMC.dragonic.init;

import com.MegaMC.dragonic.block.DragonicBlock;
import com.MegaMC.dragonic.block.TestBlock;
import com.MegaMC.dragonic.reference.Names;
import com.MegaMC.dragonic.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
    public static final DragonicBlock testBlock = new TestBlock();

    public static void init()
    {
    	GameRegistry.registerBlock(testBlock, Names.Blocks.Test_Block);
    }
}

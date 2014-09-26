package com.MegaMC.dragonic.init;

import net.minecraft.tileentity.TileEntity;

import com.MegaMC.dragonic.reference.Names;
import com.MegaMC.dragonic.reference.Reference;
import com.MegaMC.dragonic.tileentity.testStructure;

import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModTileEntity 
{
	public static final TileEntity testStructure = new testStructure();

	public static void init()
	{
		//GameRegistry.registerTileEntity(testStructure, Names.Tile.TEST_STRUCTURE);
	}
}


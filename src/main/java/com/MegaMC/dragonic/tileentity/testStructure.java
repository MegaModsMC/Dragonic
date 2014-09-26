package com.MegaMC.dragonic.tileentity;

import com.MegaMC.dragonic.init.ModBlocks;
import com.MegaMC.dragonic.utility.LogHelper;

import multiblock.api.DimensionalPattern;
import multiblock.api.DimensionalPattern.BlockState;
import multiblock.api.DimensionalPattern.Layer;
import multiblock.api.DimensionalPattern.Row;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;

public class testStructure extends TileEntity
{	
	DimensionalPattern dimensionalPattern;
	
	public testStructure()
	{
		Row row1 = DimensionalPattern.createRow("@");
		Row row2 = DimensionalPattern.createRow("#");
		
		Layer layer1 = DimensionalPattern.createLayer(row1);
		Layer layer2 = DimensionalPattern.createLayer(row2);
		
		BlockState sandstone = DimensionalPattern.createBlockState('#', Blocks.sandstone, 0);
		BlockState testBlock = DimensionalPattern.createBlockState('@', ModBlocks.testBlock, 0);
		
		dimensionalPattern = DimensionalPattern.createPattern("test", layer1, layer1, layer1, layer2, sandstone, testBlock);
	}

	public void scanBelow()
	{
		if(dimensionalPattern.hasFormed(worldObj, xCoord, yCoord - 3, zCoord))
		{
			worldObj.setBlockToAir(xCoord, yCoord + 1, zCoord);
			LogHelper.info("formed");
		}
	}
}

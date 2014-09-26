package com.MegaMC.dragonic.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.item.ItemStack;

import com.MegaMC.dragonic.creativetab.CreativeTab;
import com.MegaMC.dragonic.reference.Names;

public class thorHammer extends DragonicItem
{
	public thorHammer()
	{
		super();
		this.setUnlocalizedName(Names.Items.THOR_HAMMER);
		this.setCreativeTab(CreativeTab.Dragonic_TAB);
		this.setMaxStackSize(1);
	}
	
		@Override
		public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase owner) {
		    Entity bolt = new EntityLightningBolt(owner.worldObj, target.posX, target.posY, target.posZ);
		    owner.worldObj.addWeatherEffect(bolt);
		    return true;
	}
}

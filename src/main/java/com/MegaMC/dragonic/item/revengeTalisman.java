package com.MegaMC.dragonic.item;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import com.MegaMC.dragonic.creativetab.CreativeTab;
import com.MegaMC.dragonic.reference.Names;
import com.MegaMC.dragonic.utility.LogHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class revengeTalisman extends DragonicItem 
{
	boolean isActive = false;
	
	public revengeTalisman()
	{
		super();
		this.setUnlocalizedName(Names.Items.REVENGE_TALISMAN);
		this.setCreativeTab(CreativeTab.Dragonic_TAB);
		this.setMaxStackSize(1);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		if(isActive)
		{
			list.add("Active");
		}
		
		if(!isActive)
		{
			list.add("Inactive");
		}
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if(!par2World.isRemote)
		{
			isActive = !isActive;
			LogHelper.info(this.isActive);
		}
	
		return par1ItemStack;
	}
	
	@SubscribeEvent
	public void onPlayerHurt(LivingHurtEvent event) 
	{
		if (event.entityLiving instanceof EntityPlayer && event.entityLiving.getHealth() - event.ammount <= 0) {
			EntityPlayer killed = (EntityPlayer) event.entity;
			Entity killer = event.source.getEntity();
			
			if(this.isActive)
			{
				if(killer instanceof EntityPlayer)
				{
					event.setCanceled(true);
					killed.setHealth(((EntityPlayer) killer).getHealth());
					killer.setDead();
					LogHelper.info("killer = " + killer);
					LogHelper.info("killed = " + killed);
				}
			}
		}
	}
	
	@Override
	public boolean hasEffect(ItemStack par1ItemStack)
	{
		if(isActive)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}


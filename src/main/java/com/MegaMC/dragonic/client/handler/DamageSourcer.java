package com.MegaMC.dragonic.client.handler;

import com.MegaMC.dragonic.utility.LogHelper;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class DamageSourcer 
{
	@SubscribeEvent
	public void onPlayerHurt(LivingHurtEvent event) {
		if (event.entityLiving instanceof EntityPlayer && event.entityLiving.getHealth() - event.ammount <= 0) {
			EntityPlayer killed = (EntityPlayer) event.entity;
			Entity killer = event.source.getEntity();
			event.setCanceled(true);
			killed.setHealth(1);
			killer.setDead();
			LogHelper.info("killer = " + killer);
			LogHelper.info("killed = " + killed);
		}
	}
}

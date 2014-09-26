package com.MegaMC.dragonic.utility;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.input.Keyboard;

public class UtilMethods {
    public static void damageEntityWith(EntityLivingBase target, DamageSource damageSource, int amount, String damageString) {
        String name = damageSource.damageType;
        damageSource.damageType = damageString;
        target.attackEntityFrom(damageSource, amount);
        damageSource.damageType = name;
    }

    public static void addChatMessage(EntityPlayer player, String string) {
        if (player == null)
            return;
        player.addChatMessage(new ChatComponentText(string));
    }

    public static int getTimeInTicks(int hours, int minutes, int seconds, int ticks) {
        int tempHours = hours * 60;
        minutes += tempHours;
        int tempMinutes = minutes * 60;
        seconds += tempMinutes;
        int tempSeconds = seconds * 20;
        ticks += tempSeconds;

        return ticks;
    }

    public static boolean hasPressedShift() {
        return Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
    }

    public static boolean isRenderType(Block block, int type) {
        return block != null && block.getRenderType() == type;
    }
}
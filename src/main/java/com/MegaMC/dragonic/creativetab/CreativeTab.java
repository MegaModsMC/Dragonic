package com.MegaMC.dragonic.creativetab;

import com.MegaMC.dragonic.init.ModItems;
import com.MegaMC.dragonic.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTab
{
    public static final CreativeTabs Dragonic_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase())
    {
        @Override
        public Item getTabIconItem()
        {
            return ModItems.testScale;
        }
    };
}

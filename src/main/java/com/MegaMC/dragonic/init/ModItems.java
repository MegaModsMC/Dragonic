package com.MegaMC.dragonic.init;

import com.MegaMC.dragonic.item.DragonicItem;
import com.MegaMC.dragonic.item.revengeTalisman;
import com.MegaMC.dragonic.item.testScale;
import com.MegaMC.dragonic.reference.Names;
import com.MegaMC.dragonic.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
    public static final DragonicItem testScale = new testScale();
    public static final DragonicItem revengeTalisman = new revengeTalisman();

    public static void init()
    {
        GameRegistry.registerItem(testScale, Names.Items.TEST_SCALE);
        GameRegistry.registerItem(revengeTalisman, Names.Items.REVENGE_TALISMAN);
    }
}

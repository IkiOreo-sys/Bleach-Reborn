package littlebreadloaf.bleachreborn.items;

import net.minecraft.item.*;
import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;

public class ItemSoulQuartz extends Item
{
    public ItemSoulQuartz() {
        this.setCreativeTab(BleachItems.tabBleach);
        this.setUnlocalizedName("soul_quartz");
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister icon) {
        this.itemIcon = icon.registerIcon("bleachreborn".toLowerCase() + ":soul_quartz");
    }
}

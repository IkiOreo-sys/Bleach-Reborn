package littlebreadloaf.bleachreborn.items;

import net.minecraft.item.*;
import net.minecraft.creativetab.*;
import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;

public class ItemHeart extends Item
{
    public ItemHeart() {
        this.setCreativeTab((CreativeTabs)null);
        this.setUnlocalizedName("heart");
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister icon) {
        this.itemIcon = icon.registerIcon("bleachreborn".toLowerCase() + ":heart");
    }
}

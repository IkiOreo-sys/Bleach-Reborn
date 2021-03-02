package littlebreadloaf.bleachreborn.items;

import net.minecraft.item.*;
import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;

public class ItemMaskShard extends Item
{
    public ItemMaskShard() {
        this.setCreativeTab(BleachItems.tabBleach);
        this.setUnlocalizedName("mask_shard");
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister icon) {
        this.itemIcon = icon.registerIcon("bleachreborn".toLowerCase() + ":mask_shard");
    }
}

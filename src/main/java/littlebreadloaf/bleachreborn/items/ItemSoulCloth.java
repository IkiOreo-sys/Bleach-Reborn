package littlebreadloaf.bleachreborn.items;

import net.minecraft.item.*;
import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;

public class ItemSoulCloth extends Item
{
    public ItemSoulCloth() {
        this.setCreativeTab(BleachItems.tabBleach);
        this.setUnlocalizedName("soulcloth");
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister icon) {
        this.itemIcon = icon.registerIcon("bleachreborn".toLowerCase() + ":soulcloth");
    }
}

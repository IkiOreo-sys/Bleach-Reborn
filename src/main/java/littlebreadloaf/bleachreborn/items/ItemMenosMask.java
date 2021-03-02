package littlebreadloaf.bleachreborn.items;

import net.minecraft.item.*;
import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;

public class ItemMenosMask extends Item
{
    public ItemMenosMask() {
        this.setCreativeTab(BleachItems.tabBleach);
        this.setUnlocalizedName("menosmask");
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister icon) {
        this.itemIcon = icon.registerIcon("bleachreborn".toLowerCase() + ":menosmask");
    }
}

package littlebreadloaf.bleachreborn.items;

import net.minecraft.item.*;
import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;

public class ItemOreMask extends Item
{
    public ItemOreMask() {
        this.setCreativeTab(BleachItems.tabBleach);
        this.setUnlocalizedName("oremask");
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister icon) {
        this.itemIcon = icon.registerIcon("bleachreborn".toLowerCase() + ":oremask");
    }
}

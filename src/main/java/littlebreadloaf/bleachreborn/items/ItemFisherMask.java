package littlebreadloaf.bleachreborn.items;

import net.minecraft.item.*;
import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;

public class ItemFisherMask extends Item
{
    public ItemFisherMask() {
        this.setCreativeTab(BleachItems.tabBleach);
        this.setUnlocalizedName("fishermask");
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister icon) {
        this.itemIcon = icon.registerIcon("bleachreborn".toLowerCase() + ":fishermask");
    }
}

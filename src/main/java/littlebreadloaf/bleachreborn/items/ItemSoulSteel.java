package littlebreadloaf.bleachreborn.items;

import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.item.*;

public class ItemSoulSteel extends Item
{
    public final int itemUseDuration;
    
    public ItemSoulSteel() {
        this.setCreativeTab(BleachItems.tabBleach);
        this.setUnlocalizedName("soul_steel");
        this.itemUseDuration = 32;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister icon) {
        this.itemIcon = icon.registerIcon("bleachreborn".toLowerCase() + ":soul_steel");
    }
    
    public int getMaxItemUseDuration(final ItemStack par1ItemStack) {
        return 32;
    }
    
    public EnumAction getItemUseAction(final ItemStack par1ItemStack) {
        return null;
    }
}

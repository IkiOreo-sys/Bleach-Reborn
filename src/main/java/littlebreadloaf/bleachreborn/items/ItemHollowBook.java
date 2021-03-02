package littlebreadloaf.bleachreborn.items;

import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import littlebreadloaf.bleachreborn.*;
import cpw.mods.fml.common.network.internal.*;

public class ItemHollowBook extends Item
{
    public final int itemUseDuration;
    
    public ItemHollowBook() {
        this.setCreativeTab(BleachItems.tabBleach);
        this.setUnlocalizedName("hollow_book");
        this.itemUseDuration = 32;
        this.maxStackSize = 1;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister icon) {
        this.itemIcon = icon.registerIcon("bleachreborn".toLowerCase() + ":hollow_book");
    }
    
    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        FMLNetworkHandler.openGui(par3EntityPlayer, (Object)BleachMod.instance, 1, par2World, (int)par3EntityPlayer.posX, (int)par3EntityPlayer.posY, (int)par3EntityPlayer.posZ);
        return par1ItemStack;
    }
}

package littlebreadloaf.bleachreborn.items;

import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import littlebreadloaf.bleachreborn.events.*;
import littlebreadloaf.bleachreborn.*;
import cpw.mods.fml.common.network.internal.*;

public class ItemFactionSelector extends Item
{
    public final int itemUseDuration;
    
    public ItemFactionSelector() {
        this.setCreativeTab(BleachItems.tabBleach);
        this.setUnlocalizedName("faction_selector");
        this.itemUseDuration = 32;
        this.maxStackSize = 1;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister icon) {
        this.itemIcon = icon.registerIcon("bleachreborn".toLowerCase() + ":faction_selector");
    }
    
    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        if (((ExtendedPlayer)par3EntityPlayer.getExtendedProperties("BleachPlayer")).getFaction() == 0) {
            FMLNetworkHandler.openGui(par3EntityPlayer, (Object)BleachMod.instance, 2, par2World, (int)par3EntityPlayer.posX, (int)par3EntityPlayer.posY, (int)par3EntityPlayer.posZ);
            --par1ItemStack.stackSize;
        }
        return par1ItemStack;
    }
}

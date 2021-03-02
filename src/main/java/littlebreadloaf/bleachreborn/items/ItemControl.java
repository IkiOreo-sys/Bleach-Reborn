package littlebreadloaf.bleachreborn.items;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import littlebreadloaf.bleachreborn.BleachMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemControl extends Item{
	
    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
    	
        FMLNetworkHandler.openGui(par3EntityPlayer, (Object)BleachMod.instance, 11, par2World, (int)par3EntityPlayer.posX, (int)par3EntityPlayer.posY, (int)par3EntityPlayer.posZ);

		return par1ItemStack;
    	
    }

}

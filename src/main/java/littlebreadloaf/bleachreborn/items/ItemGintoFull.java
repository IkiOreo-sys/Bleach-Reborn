package littlebreadloaf.bleachreborn.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import littlebreadloaf.bleachreborn.events.ExtendedPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ItemGintoFull extends Item {
	
	
	
	@SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack itemStack, final EntityPlayer player, final List data, final boolean b) {
		ExtendedPlayer props = ExtendedPlayer.get(player);
		NBTTagCompound nbt;
	    if (itemStack.hasTagCompound())
	    {
	        nbt = itemStack.getTagCompound();
	    }
	    else
	    {
	        nbt = new NBTTagCompound();
	    }
	    nbt.setInteger("reiatsuStore", 100);
	    itemStack.setTagCompound(nbt);
	    if (itemStack.hasTagCompound() && itemStack.getTagCompound().hasKey("reiatsuStore"))
	    {
	        data.add("Stored Reiatsu: " + Integer.toString(itemStack.getTagCompound().getInteger("reiatsuStore")));
	    }
    }

}

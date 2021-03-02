package littlebreadloaf.bleachreborn.items;

import littlebreadloaf.bleachreborn.BleachMod;
import littlebreadloaf.bleachreborn.entities.EntityGigai;
import littlebreadloaf.bleachreborn.events.ExtendedPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ItemGigai extends Item{
	

    public ItemStack onItemRightClick(final ItemStack stack, final World world, final EntityPlayer player) {
		if (!world.isRemote) {
			ExtendedPlayer props = ExtendedPlayer.get(player);
			if (player.isPotionActive(BleachMod.soulDisconnect.id)) {
				if (props.getBodyID().equals("")) {
					EntityGigai gigai = new EntityGigai(world);
					gigai.setTamed(true);
					gigai.func_152115_b(player.getUniqueID().toString());
					gigai.setLocationAndAngles(player.posX, player.posY, player.posZ, 0f, 0f);
					world.spawnEntityInWorld(gigai);
					props.setBodyID(gigai.getUniqueID().toString());
					player.addChatComponentMessage(new ChatComponentText("New gigai has been created."));
				}
				else {
					player.addChatComponentMessage(new ChatComponentText("You already have a gigai."));
				}
			}
			--stack.stackSize;
			player.inventoryContainer.detectAndSendChanges();
		}
		return stack;
    }

}

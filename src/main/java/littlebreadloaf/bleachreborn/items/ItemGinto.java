package littlebreadloaf.bleachreborn.items;

import littlebreadloaf.bleachreborn.events.ExtendedPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGinto extends Item {
	
	public static int maxStore = 100;
	
	public ItemStack onItemRightClick(final ItemStack stack, final World par2World, final EntityPlayer player) {
		if (!par2World.isRemote) {
			ExtendedPlayer props = ExtendedPlayer.get(player);
			if (player.isSneaking() && props.getFaction() == 2 && props.getCurrentCap() >= 100) {
				props.consumeEnergy(maxStore);
				player.setCurrentItemOrArmor(0, new ItemStack(BleachItems.ginto_full));
			}
		}
		return stack;
		
	}

}

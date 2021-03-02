package littlebreadloaf.bleachreborn.items.qglove;

import littlebreadloaf.bleachreborn.events.ExtendedPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemVollstandig  extends Item {
	
	public ItemStack onItemRightClick(final ItemStack stack, final World world, final EntityPlayer player) {
		if (!world.isRemote) {
			if (player.isSneaking()) {
				
			}
			else {
				ExtendedPlayer props = ExtendedPlayer.get(player);
				if (props.getCurrentCap() >= 1000 && props.getVUnlock() == true) {
					
				}
			}
		}
		return stack;
	}

}

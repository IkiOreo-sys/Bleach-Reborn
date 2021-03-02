package littlebreadloaf.bleachreborn.items;

import littlebreadloaf.bleachreborn.BleachMod;
import littlebreadloaf.bleachreborn.entities.EntityGigai;
import littlebreadloaf.bleachreborn.events.ExtendedPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemSoulCandy extends ItemFood {

	public ItemSoulCandy(int p_i45339_1_, float p_i45339_2_, boolean p_i45339_3_) {
		super(p_i45339_1_, p_i45339_2_, p_i45339_3_);
	}
	
	@Override
    public ItemStack onItemRightClick(final ItemStack stack, final World world, final EntityPlayer player) {
	super.onFoodEaten(stack, world, player);
		if (!world.isRemote) {
			if (!player.isPotionActive(BleachMod.soulDisconnect.id)) {
				ExtendedPlayer props = ExtendedPlayer.get(player);
				player.addPotionEffect(new PotionEffect(BleachMod.soulDisconnect.id, 999999999, 0));
				EntityGigai gigai = new EntityGigai(world);
				gigai.setLocationAndAngles(player.posX, player.posY, player.posZ, 0f, 0f);
				gigai.func_152115_b(player.getUniqueID().toString());
				gigai.setTamed(true);
				world.spawnEntityInWorld(gigai);
				player.setInvisible(true);
				props.setBodyID(gigai.getUniqueID().toString());
				player.inventory.addItemStackToInventory(new ItemStack(BleachItems.control));
				player.inventoryContainer.detectAndSendChanges();
			}
			--stack.stackSize;
			player.inventoryContainer.detectAndSendChanges();
		}
		return stack;
	}
	
}

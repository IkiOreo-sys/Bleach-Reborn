package littlebreadloaf.bleachreborn.items;

import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import littlebreadloaf.bleachreborn.armor.*;

public class ItemMaleUni extends Item
{
    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer player) {
        if (!par2World.isRemote) {
            player.inventory.addItemStackToInventory(new ItemStack(Armor.MaleAcademyTop));
            player.inventory.addItemStackToInventory(new ItemStack(Armor.MaleAcademyBottom));
            if (player.inventory.hasItem(BleachItems.maleuni) || player.inventory.hasItem(BleachItems.femaleuni)) {
                player.inventory.consumeInventoryItem(BleachItems.femaleuni);
                player.inventory.consumeInventoryItem(BleachItems.maleuni);
            }
            player.inventoryContainer.detectAndSendChanges();
        }
        return par1ItemStack;
    }
}

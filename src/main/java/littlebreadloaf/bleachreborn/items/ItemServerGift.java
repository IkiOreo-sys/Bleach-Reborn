package littlebreadloaf.bleachreborn.items;

import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import littlebreadloaf.bleachreborn.blocks.*;
import net.minecraft.util.*;

public class ItemServerGift extends Item
{
    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer player) {
        if (!par2World.isRemote) {
            player.inventory.addItemStackToInventory(new ItemStack(BleachItems.shinai));
            player.inventory.addItemStackToInventory(new ItemStack(BleachBlocks.reiatsuBlock, 5));
            player.inventory.addItemStackToInventory(new ItemStack(BleachBlocks.hollowBait));
            player.inventory.addItemStackToInventory(new ItemStack(BleachItems.maleuni));
            player.inventory.addItemStackToInventory(new ItemStack(BleachItems.femaleuni));
            player.inventoryContainer.detectAndSendChanges();
            player.inventory.consumeInventoryItem(BleachItems.servergift);
            player.inventoryContainer.detectAndSendChanges();
            player.addChatComponentMessage((IChatComponent)new ChatComponentText("Thank you all for your support in this server, sorry about the restart, here is compensation from me, AkumaKasai109"));
        }
        return par1ItemStack;
    }
}

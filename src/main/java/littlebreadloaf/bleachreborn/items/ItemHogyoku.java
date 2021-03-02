package littlebreadloaf.bleachreborn.items;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import littlebreadloaf.bleachreborn.armor.Armor;
import littlebreadloaf.bleachreborn.events.ExtendedPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ItemHogyoku extends Item {
	
	public ItemHogyoku() {
		this.setMaxDamage(150);
		this.setMaxStackSize(1);
		this.setNoRepair();
	}
	
	 public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer player) {
		 if (!par2World.isRemote) {
			 ExtendedPlayer props = ExtendedPlayer.get(player);
			 Random rand = new Random();
			 if (player.isSneaking() && this.getDamage(par1ItemStack) == 0 && props.getFaction() == 1) {
				 if (props.getCurrentCap() == 1000) {
					 int chance = (int) (Math.random() * 100);
					 if (chance < 98) {
						props.setMaxCap(props.getCurrentCap() - 1000);  
						player.addChatComponentMessage(new ChatComponentText("You have been set back to the minimum soul cap for failing to fuse with the hogyoku."));	
						par1ItemStack.damageItem(150, player);
					 }
					 else {
						 props.setFaction(11);
						 player.addChatComponentMessage(new ChatComponentText("You have successfully merged with the hogyoku."));
						 List<EntityPlayer> playersConnected = new ArrayList<EntityPlayer>();
						 playersConnected= player.worldObj.playerEntities;
						 for (EntityPlayer plr : playersConnected) {
							 plr.worldObj.playSoundAtEntity(plr, "bleachreborn:treachery", 0.4f, 1.0f);
						 }
						 player.inventory.addItemStackToInventory(new ItemStack(Armor.HogyokuJacket));
						 player.inventory.addItemStackToInventory(new ItemStack(Armor.HogyokuPants));
						 player.inventory.addItemStackToInventory(new ItemStack(Armor.HogyokuShoes));
						 player.inventoryContainer.detectAndSendChanges();
					 }
				 }
				 else if (props.getCurrentCap() == 2000) {
					 int chance = (int) (Math.random() * 100);
					 if (chance < 96) {
						props.setMaxCap(props.getCurrentCap() - 1000); 
						player.addChatComponentMessage(new ChatComponentText("You have been set back to the minimum soul cap for failing to fuse with the hogyoku."));	
						par1ItemStack.damageItem(150, player);
					 }
					 else {
						 props.setFaction(11);
						 player.addChatComponentMessage(new ChatComponentText("You have successfully merged with the hogyoku."));
						 List<EntityPlayer> playersConnected = new ArrayList<EntityPlayer>();
						 playersConnected= player.worldObj.playerEntities;
						 for (EntityPlayer plr : playersConnected) {
							 plr.worldObj.playSoundAtEntity(plr, "bleachreborn:treachery", 0.4f, 1.0f);
						 }
						 player.inventory.addItemStackToInventory(new ItemStack(Armor.HogyokuJacket));
						 player.inventory.addItemStackToInventory(new ItemStack(Armor.HogyokuPants));
						 player.inventory.addItemStackToInventory(new ItemStack(Armor.HogyokuShoes));
						 player.inventoryContainer.detectAndSendChanges();
					 }
				 }
				 else if (props.getCurrentCap() == 3000) {
					 int chance = (int) (Math.random() * 100);
					 if (chance < 94) {
						props.setMaxCap(props.getCurrentCap() - 1000); 
						player.addChatComponentMessage(new ChatComponentText("You have been set back to the minimum soul cap for failing to fuse with the hogyoku."));
						par1ItemStack.damageItem(150, player);
					 }
					 else {
						 props.setFaction(11);
						 player.addChatComponentMessage(new ChatComponentText("You have successfully merged with the hogyoku."));
						 List<EntityPlayer> playersConnected = new ArrayList<EntityPlayer>();
						 playersConnected= player.worldObj.playerEntities;
						 for (EntityPlayer plr : playersConnected) {
							 plr.worldObj.playSoundAtEntity(plr, "bleachreborn:treachery", 0.4f, 1.0f);
						 }
						 player.inventory.addItemStackToInventory(new ItemStack(Armor.HogyokuJacket));
						 player.inventory.addItemStackToInventory(new ItemStack(Armor.HogyokuPants));
						 player.inventory.addItemStackToInventory(new ItemStack(Armor.HogyokuShoes));
						 player.inventoryContainer.detectAndSendChanges();
					 }
				 }
				 else if (props.getCurrentCap() == 4000) {
					 int chance = (int) (Math.random() * 100);
					 if (chance < 92) {
						props.setMaxCap(props.getCurrentCap() - 1000); 
						player.addChatComponentMessage(new ChatComponentText("You have been set back to the minimum soul cap for failing to fuse with the hogyoku."));	
						par1ItemStack.damageItem(150, player);
					 }
					 else {
						 props.setFaction(11);
						 player.addChatComponentMessage(new ChatComponentText("You have successfully merged with the hogyoku."));
						 List<EntityPlayer> playersConnected = new ArrayList<EntityPlayer>();
						 playersConnected= player.worldObj.playerEntities;
						 for (EntityPlayer plr : playersConnected) {
							 plr.worldObj.playSoundAtEntity(plr, "bleachreborn:treachery", 0.4f, 1.0f);
						 }
						 player.inventory.addItemStackToInventory(new ItemStack(Armor.HogyokuJacket));
						 player.inventory.addItemStackToInventory(new ItemStack(Armor.HogyokuPants));
						 player.inventory.addItemStackToInventory(new ItemStack(Armor.HogyokuShoes));
						 player.inventoryContainer.detectAndSendChanges();
					 }
				 }
				 else if (props.getCurrentCap() == 5000) {
					 int chance = (int) (Math.random() * 100);
					 if (chance < 90) {
						props.setMaxCap(props.getCurrentCap() - 1000); 
						player.addChatComponentMessage(new ChatComponentText("You have been set back to the minimum soul cap for failing to fuse with the hogyoku."));	
						par1ItemStack.damageItem(150, player);
					 }
					 else {
						 props.setFaction(11);
						 player.addChatComponentMessage(new ChatComponentText("You have successfully merged with the hogyoku."));
						 List<EntityPlayer> playersConnected = new ArrayList<EntityPlayer>();
						 playersConnected= player.worldObj.playerEntities;
						 for (EntityPlayer plr : playersConnected) {
							 plr.worldObj.playSoundAtEntity(plr, "bleachreborn:treachery", 0.4f, 1.0f);
						 }
						 player.inventory.addItemStackToInventory(new ItemStack(Armor.HogyokuJacket));
						 player.inventory.addItemStackToInventory(new ItemStack(Armor.HogyokuPants));
						 player.inventory.addItemStackToInventory(new ItemStack(Armor.HogyokuShoes));
						 player.inventoryContainer.detectAndSendChanges();
					 }
				 }
				 else if (props.getCurrentCap() == 6000) {
					 int chance = (int) (Math.random() * 100);
					 if (chance < 88) {
						props.setMaxCap(props.getCurrentCap() - 1000); 
						player.addChatComponentMessage(new ChatComponentText("You have been set back to the minimum soul cap for failing to fuse with the hogyoku."));	
						par1ItemStack.damageItem(150, player);
					 }
					 else {
						 props.setFaction(11);
						 player.addChatComponentMessage(new ChatComponentText("You have successfully merged with the hogyoku."));
						 List<EntityPlayer> playersConnected = new ArrayList<EntityPlayer>();
						 playersConnected= player.worldObj.playerEntities;
						 for (EntityPlayer plr : playersConnected) {
							 plr.worldObj.playSoundAtEntity(plr, "bleachreborn:treachery", 0.4f, 1.0f);
						 }
						 player.inventory.addItemStackToInventory(new ItemStack(Armor.HogyokuJacket));
						 player.inventory.addItemStackToInventory(new ItemStack(Armor.HogyokuPants));
						 player.inventory.addItemStackToInventory(new ItemStack(Armor.HogyokuShoes));
						 player.inventoryContainer.detectAndSendChanges();
					 }
				 }
				 else if (props.getCurrentCap() == 7000) {
					 int chance = (int) (Math.random() * 100);
					 if (chance < 86) {
						props.setMaxCap(props.getCurrentCap() - 1000); 
						player.addChatComponentMessage(new ChatComponentText("You have been set back to the minimum soul cap for failing to fuse with the hogyoku."));	 
						par1ItemStack.damageItem(150, player);
					 }
					 else {
						 props.setFaction(11);
						 player.addChatComponentMessage(new ChatComponentText("You have successfully merged with the hogyoku."));
						 List<EntityPlayer> playersConnected = new ArrayList<EntityPlayer>();
						 playersConnected= player.worldObj.playerEntities;
						 for (EntityPlayer plr : playersConnected) {
							 plr.worldObj.playSoundAtEntity(plr, "bleachreborn:treachery", 0.4f, 1.0f);
						 }
						 player.inventory.addItemStackToInventory(new ItemStack(Armor.HogyokuJacket));
						 player.inventory.addItemStackToInventory(new ItemStack(Armor.HogyokuPants));
						 player.inventory.addItemStackToInventory(new ItemStack(Armor.HogyokuShoes));
						 player.inventoryContainer.detectAndSendChanges();
					 }
				 }
				 else if (props.getCurrentCap() == 8000) {
					 int chance = (int) (Math.random() * 100);
					 if (chance < 84) {
						props.setMaxCap(props.getCurrentCap() - 1000); 
						player.addChatComponentMessage(new ChatComponentText("You have been set back to the minimum soul cap for failing to fuse with the hogyoku."));	
						par1ItemStack.damageItem(150, player);
					 }
					 else {
						 props.setFaction(11);
						 player.addChatComponentMessage(new ChatComponentText("You have successfully merged with the hogyoku."));
						 List<EntityPlayer> playersConnected = new ArrayList<EntityPlayer>();
						 playersConnected= player.worldObj.playerEntities;
						 for (EntityPlayer plr : playersConnected) {
							 plr.worldObj.playSoundAtEntity(plr, "bleachreborn:treachery", 0.4f, 1.0f);
						 }
						 player.inventory.addItemStackToInventory(new ItemStack(Armor.HogyokuJacket));
						 player.inventory.addItemStackToInventory(new ItemStack(Armor.HogyokuPants));
						 player.inventory.addItemStackToInventory(new ItemStack(Armor.HogyokuShoes));
						 player.inventoryContainer.detectAndSendChanges();
					 }
				 }
				 else if (props.getCurrentCap() == 9000) {
					 int chance = (int) (Math.random() * 100);
					 if (chance < 82) {
						props.setMaxCap(props.getCurrentCap() - 1000); 
						player.addChatComponentMessage(new ChatComponentText("You have been set back to the minimum soul cap for failing to fuse with the hogyoku."));
						par1ItemStack.damageItem(150, player);
					 }
					 else {
						 props.setFaction(11);
						 player.addChatComponentMessage(new ChatComponentText("You have successfully merged with the hogyoku."));
						 List<EntityPlayer> playersConnected = new ArrayList<EntityPlayer>();
						 playersConnected= player.worldObj.playerEntities;
						 for (EntityPlayer plr : playersConnected) {
							 plr.worldObj.playSoundAtEntity(plr, "bleachreborn:treachery", 0.4f, 1.0f);
						 }
						 player.inventory.addItemStackToInventory(new ItemStack(Armor.HogyokuJacket));
						 player.inventory.addItemStackToInventory(new ItemStack(Armor.HogyokuPants));
						 player.inventory.addItemStackToInventory(new ItemStack(Armor.HogyokuShoes));
						 player.inventoryContainer.detectAndSendChanges();
					 }
				 }
				 else if (props.getCurrentCap() == 10000) {
					 int chance = (int) (Math.random() * 100);
					 if (chance < 80) {
						props.setMaxCap(props.getCurrentCap() - 1000); 
						player.addChatComponentMessage(new ChatComponentText("You have been set back to the minimum soul cap for failing to fuse with the hogyoku."));	
						par1ItemStack.damageItem(150, player);
					 }
					 else {
						 props.setFaction(11);
						 player.addChatComponentMessage(new ChatComponentText("You have successfully merged with the hogyoku."));
						 List<EntityPlayer> playersConnected = new ArrayList<EntityPlayer>();
						 playersConnected= player.worldObj.playerEntities;
						 for (EntityPlayer plr : playersConnected) {
							 plr.worldObj.playSoundAtEntity(plr, "bleachreborn:treachery", 0.4f, 1.0f);
						 }
						 player.inventory.addItemStackToInventory(new ItemStack(Armor.HogyokuJacket));
						 player.inventory.addItemStackToInventory(new ItemStack(Armor.HogyokuPants));
						 player.inventory.addItemStackToInventory(new ItemStack(Armor.HogyokuShoes));
						 player.inventoryContainer.detectAndSendChanges();
					 }
				 }
			 }
			 else if (!player.isSneaking()) {
				 if (props.getFaction() == 1 && props.getCurrentCap() >= 600 && props.getUnlock() == false) {
					 int chance= (int) (Math.random() * 100);
					 if (chance < 80) {
						 props.setFaction(5);
						 props.setUnlock(true);
						 player.addChatComponentMessage(new ChatComponentText("You have evolved into a Vizard."));
					 }
					 else if (chance < 95) {
						 return null;
						 
					 }
					 else {
						props.setMaxCap(props.getCurrentCap() - 1000); 
						player.addChatComponentMessage(new ChatComponentText("You have been set back to minimum spiritual energy."));
					 }
					 par1ItemStack.damageItem(60, player);
				 }
				 else if (props.getFaction() == 3 && props.getCurrentCap() >= 600 && props.getUnlock() == false) {
					 int chance = (int) (Math.random() * 100);
					 if (chance < 80) {
						 props.setFaction(4);
						 props.setUnlock(true);
						 player.addChatComponentMessage(new ChatComponentText("You have evolved into a Arrancar."));
					 }
					 else if (chance < 95) {
						 return null;
						 
					 }
					 else {
						props.setMaxCap(props.getCurrentCap() - 1000); 
						player.addChatComponentMessage(new ChatComponentText("You have been set back to minimum spiritual energy."));
					 }
					 par1ItemStack.damageItem(60, player);
				 }
				 else if (props.getFaction() == 7 && props.getCurrentCap() >= 600 && props.getUnlock() == false) {
					 int chance = (int) (Math.random() * 100);
					 if (chance < 80) {
						 props.setFaction(4);
						 props.setUnlock(true);
						 player.addChatComponentMessage(new ChatComponentText("You have evolved into a Arrancar."));
					 }
					 else if (chance < 95) {
						 return null;
						 
					 }
					 else {
						props.setMaxCap(props.getCurrentCap() - 1000); 
						player.addChatComponentMessage(new ChatComponentText("You have been set back to minimum spiritual energy."));
					 }
					 par1ItemStack.damageItem(60, player);
				 }
				 else if (props.getFaction() == 8 && props.getCurrentCap() >= 600 && props.getUnlock() == false) {
					 int chance = (int) (Math.random() * 100);
					 if (chance < 80) {
						 props.setFaction(4);
						 props.setUnlock(true);
						 props.setPlusDmg(true);
						 player.addChatComponentMessage(new ChatComponentText("You have evolved into a Arrancar."));
					 }
					 else if (chance < 95) {
						 return null;
						 
					 }
					 else {
						props.setMaxCap(props.getCurrentCap() - 1000); 
						player.addChatComponentMessage(new ChatComponentText("You have been set back to minimum spiritual energy."));
					 }
					 par1ItemStack.damageItem(60, player);
				 }
				 else if (props.getFaction() == 10 && props.getCurrentCap() >= 2000 && props.getUnlock() == false) {
					 int chance = (int) (Math.random() * 100);
					 if (chance < 80) {
						 props.setFaction(9);
						 props.setUnlock(true);
						 player.addChatComponentMessage(new ChatComponentText("You have evolved into a Vasto Arrancar."));
					 }
					 else if (chance < 95) {
						 return null;
						 
					 }
					 else {
						props.setMaxCap(props.getCurrentCap() - 1000); 
						player.addChatComponentMessage(new ChatComponentText("You have been set back to minimum spiritual energy."));
					 }
					 par1ItemStack.damageItem(60, player);
				 }
				 else {
					 player.addChatComponentMessage(new ChatComponentText("You do not meet the requirements to evolve."));
				 }
			 }
			 else {
				 player.addChatComponentMessage(new ChatComponentText("You do not meet the requirements to merge with the hogyoku."));
			 }
		 }
		return par1ItemStack;
	 }

}

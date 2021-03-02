package littlebreadloaf.bleachreborn.items.qglove;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import littlebreadloaf.bleachreborn.events.*;
import littlebreadloaf.bleachreborn.items.BleachItems;
import net.minecraft.item.*;

public class ItemSanreiGlove extends Item
{
    private float weaponDamage;
    public float damageBoost;
    public float robeboost;
    public float pantboost;
    public float sandalboost;
    
    public ItemSanreiGlove() {
        this.damageBoost = 25.0f;
        this.robeboost = 0.0f;
        this.pantboost = 0.0f;
        this.sandalboost = 0.0f;
        this.maxStackSize = 1;
    }
    
    public ItemStack onItemRightClick(ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        final ExtendedPlayer props = (ExtendedPlayer)par3EntityPlayer.getExtendedProperties("BleachPlayer");
        if (!par3EntityPlayer.isSneaking()) {
	        if (!par3EntityPlayer.worldObj.isRemote && props.getCurrentEnergy() >= 100.0f / props.getCurrentCap() && props.getFaction() == 2 && props.getCurrentCap() >= 450) {
	            props.consumeEnergy(100);
	            par1ItemStack = new ItemStack(BleachItems.sanrei_bow, 1);
	        }
        }
        else {
        	if (props.getSanreiBroken() == false /*props.getSanreiCount() >= 10080*/) {
        		if (!par3EntityPlayer.worldObj.isRemote) {
	        		//par3EntityPlayer.addChatComponentMessage(new ChatComponentText("You are about to break your sanrei glove, if you really want to do this, shift right click again."));
	        		//props.setSanreiBroken(true);
        		}
        	}
        }  
        return par1ItemStack;
    }
    
    public EnumAction getItemUseAction(final ItemStack par1ItemStack) {
        return null;
    }
}

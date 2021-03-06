package littlebreadloaf.bleachreborn.items;

import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.creativetab.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import littlebreadloaf.bleachreborn.events.*;
import net.minecraftforge.common.*;
import cpw.mods.fml.common.eventhandler.*;
import net.minecraft.entity.*;
import littlebreadloaf.bleachreborn.entities.*;
import net.minecraft.item.*;
import net.minecraftforge.event.entity.player.*;
import net.minecraft.client.renderer.texture.*;

public class ItemQuincyBow extends ItemBow
{
    @SideOnly(Side.CLIENT)
    public static IIcon[] iconArray;
    private static final String[] bowPullIconNameArray;
    private static final String __OBFID = "CL_00001777";
    private boolean isSeele;
    int shikaiTimer;
    
    public ItemQuincyBow() {
        this.shikaiTimer = 40;
        this.maxStackSize = 1;
        this.setMaxDamage(-1);
        this.setUnlocalizedName("quincy_bow");
        this.setCreativeTab((CreativeTabs)null);
    }
    
    public void onPlayerStoppedUsing(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer, final int par4) {
        int j = this.getMaxItemUseDuration(par1ItemStack) - par4;
        final ExtendedPlayer props = (ExtendedPlayer)par3EntityPlayer.getExtendedProperties("BleachPlayer");
        final ArrowLooseEvent event = new ArrowLooseEvent(par3EntityPlayer, par1ItemStack, j);
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (event.isCanceled()) {
            return;
        }
        j = event.charge;
        final boolean flag = par3EntityPlayer.capabilities.isCreativeMode;
	        if (par3EntityPlayer.inventory.hasItemStack(new ItemStack(BleachItems.seele, 1, 1))) {
	            float f = j / 20.0f;
	            f = (f * f + f * 2.0f) / 3.0f;
	            if (f < 0.1) {
	                return;
	            }
	            if (f > 1.0f) {
	                f = 1.0f;
	            }
	            final EntitySeeleArrow entitySeeleArrow = new EntitySeeleArrow(par2World, (EntityLivingBase)par3EntityPlayer, 2.0f);
	            if (f == 1.0f) {
	                entitySeeleArrow.setIsCritical(true);
	                if (!par3EntityPlayer.capabilities.isCreativeMode) {
	                    par3EntityPlayer.inventory.consumeInventoryItem(BleachItems.seele);
	                }
	                if (!par2World.isRemote) {
	                    par2World.spawnEntityInWorld((Entity)entitySeeleArrow);
	                    par2World.playSoundAtEntity((Entity)par3EntityPlayer, "bleachreborn:bowfire", 0.4f, 1.0f);
	                }
	            }
	        }
	        else if (props.getCurrentEnergy() > 0.0f) {
	            float f = j / 20.0f;
	            f = (f * f + f * 2.0f) / 3.0f;
	            if (f < 0.1) {
	                return;
	            }
	            if (f > 1.0f) {
	                f = 1.0f;
	            }
	            final EntityEnergyArrow entityEnergyArrow = new EntityEnergyArrow(par2World, (EntityLivingBase)par3EntityPlayer, 2.0f);
	            if (f == 1.0f) {
	                entityEnergyArrow.setIsCritical(true);
	                par2World.spawnEntityInWorld((Entity)entityEnergyArrow);
	                if (!par2World.isRemote) {
	                    props.consumeEnergy(2);
	                }
	                par2World.playSoundAtEntity((Entity)par3EntityPlayer, "bleachreborn:bowfire", 0.4f, 1.0f);
	            }
	        }
    }
    
    public ItemStack onEaten(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        return par1ItemStack;
    }
    
    public int getMaxItemUseDuration(final ItemStack par1ItemStack) {
        return 72000;
    }
    
    public EnumAction getItemUseAction(final ItemStack par1ItemStack) {
        return EnumAction.bow;
    }
    
    private boolean getIsSeele() {
        return this.isSeele;
    }
    
    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        final ExtendedPlayer props = (ExtendedPlayer)par3EntityPlayer.getExtendedProperties("BleachPlayer");
        if (props.getFaction() == 2) {
            if (par3EntityPlayer.inventory.hasItemStack(new ItemStack(BleachItems.seele, 1, 1))) {
                par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
                this.isSeele = true;
                par2World.playSoundAtEntity((Entity)par3EntityPlayer, "bleachreborn:bowcharge", 0.4f, 1.0f);
                final ArrowNockEvent event = new ArrowNockEvent(par3EntityPlayer, par1ItemStack);
                MinecraftForge.EVENT_BUS.post((Event)event);
                if (event.isCanceled()) {
                    return event.result;
                }
            }
            else if (par3EntityPlayer.capabilities.isCreativeMode || props.getCurrentEnergy() >= 1.0f / props.getCurrentCap()) {
                par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
                this.isSeele = false;
                par2World.playSoundAtEntity((Entity)par3EntityPlayer, "bleachreborn:bowcharge", 0.4f, 1.0f);
                final ArrowNockEvent event = new ArrowNockEvent(par3EntityPlayer, par1ItemStack);
                MinecraftForge.EVENT_BUS.post((Event)event);
                if (event.isCanceled()) {
                    return event.result;
                }
            }
        }
        return par1ItemStack;
    }
    
    public int getItemEnchantability() {
        return 1;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister par1IconRegister) {
        this.itemIcon = par1IconRegister.registerIcon("bleachreborn".toLowerCase() + ":quincy_bow");
        ItemQuincyBow.iconArray = new IIcon[ItemQuincyBow.bowPullIconNameArray.length];
        for (int i = 0; i < ItemQuincyBow.iconArray.length; ++i) {
            ItemQuincyBow.iconArray[i] = par1IconRegister.registerIcon("bleachreborn:" + ItemQuincyBow.bowPullIconNameArray[i]);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(final ItemStack stack, final int renderPass, final EntityPlayer player, final ItemStack usingItem, final int useRemaining) {
        if (player.getItemInUse() == null) {
            return this.itemIcon;
        }
        final int Pulling = stack.getMaxItemUseDuration() - useRemaining;
        if (Pulling >= 18) {
            if (this.getIsSeele()) {
                return ItemQuincyBow.iconArray[5];
            }
            return ItemQuincyBow.iconArray[2];
        }
        else if (Pulling > 13) {
            if (this.getIsSeele()) {
                return ItemQuincyBow.iconArray[4];
            }
            return ItemQuincyBow.iconArray[1];
        }
        else {
            if (Pulling <= 0) {
                return this.itemIcon;
            }
            if (this.getIsSeele()) {
                return ItemQuincyBow.iconArray[3];
            }
            return ItemQuincyBow.iconArray[0];
        }
    }
    
    public void onUpdate(final ItemStack par1ItemStack, final World par2World, final Entity par3Entity, final int par4, final boolean par5) {
        if (par3Entity instanceof EntityPlayer) {
            final EntityPlayer player = (EntityPlayer)par3Entity;
            final ExtendedPlayer props = (ExtendedPlayer)player.getExtendedProperties("BleachPlayer");
            final ItemStack heldItem = player.getCurrentEquippedItem();
            final ItemStack var13 = new ItemStack(BleachItems.quincypendant, 1, 0);
            if (heldItem != null && heldItem == par1ItemStack) {
                heldItem.setItemDamage(props.getZTex());
                if (props.getCurrentEnergy() <= 0.0f) {
                    props.deactivate(par1ItemStack.getItem());
                }
            }
            --this.shikaiTimer;
            if (this.shikaiTimer <= 0 && !player.worldObj.isRemote) {
                this.shikaiTimer = 40;
                props.consumeEnergy(2);
            }
        }
    }
    
    static {
        bowPullIconNameArray = new String[] { "quincy_bow_0", "quincy_bow_1", "quincy_bow_2", "quincy_seele_0", "quincy_seele_1", "quincy_seele_2" };
    }
}

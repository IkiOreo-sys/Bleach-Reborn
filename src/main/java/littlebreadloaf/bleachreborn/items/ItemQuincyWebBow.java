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
import net.minecraft.item.*;
import net.minecraftforge.event.entity.player.*;
import net.minecraft.client.renderer.texture.*;
import littlebreadloaf.bleachreborn.entities.*;

public class ItemQuincyWebBow extends Item
{
    @SideOnly(Side.CLIENT)
    public static IIcon[] iconArray;
    private static final String[] bowPullIconNameArray;
    private static final String __OBFID = "CL_00001777";
    private boolean isSeele;
    private int bowCoolDown;
    int shikaiTimer;
    
    public ItemQuincyWebBow() {
        this.bowCoolDown = 20;
        this.shikaiTimer = 40;
        this.maxStackSize = 1;
        this.setMaxDamage(-1);
        this.setUnlocalizedName("quincy_web");
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
	                par2World.spawnEntityInWorld((Entity)entitySeeleArrow);
	                if (!par2World.isRemote) {
	                    par2World.playSoundAtEntity((Entity)par3EntityPlayer, "bleachreborn:bowfire", 0.4f, 1.0f);
	                }
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
            final ArrowNockEvent event = new ArrowNockEvent(par3EntityPlayer, par1ItemStack);
            MinecraftForge.EVENT_BUS.post((Event)event);
            if (event.isCanceled()) {
                return event.result;
            }
            if (par3EntityPlayer.inventory.hasItemStack(new ItemStack(BleachItems.seele, 1, 1))) {
                par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
                this.isSeele = true;
                par2World.playSoundAtEntity((Entity)par3EntityPlayer, "bleachreborn:bowcharge", 0.4f, 1.0f);
            }
            if (par3EntityPlayer.capabilities.isCreativeMode || props.getCurrentEnergy() >= 1.0f / props.getCurrentCap()) {
                par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
                this.isSeele = false;
            }
        }
        return par1ItemStack;
    }
    
    public int getItemEnchantability() {
        return 1;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister par1IconRegister) {
        this.itemIcon = par1IconRegister.registerIcon("bleachreborn".toLowerCase() + ":quincy_web");
        ItemQuincyWebBow.iconArray = new IIcon[ItemQuincyWebBow.bowPullIconNameArray.length];
        for (int i = 0; i < ItemQuincyWebBow.iconArray.length; ++i) {
            ItemQuincyWebBow.iconArray[i] = par1IconRegister.registerIcon("bleachreborn:" + ItemQuincyWebBow.bowPullIconNameArray[i]);
        }
    }
    
    public void onUpdate(final ItemStack par1ItemStack, final World par2World, final Entity par3Entity, final int par4, final boolean par5) {
        if (par3Entity instanceof EntityPlayer) {
            final EntityPlayer player = (EntityPlayer)par3Entity;
            final ExtendedPlayer props = (ExtendedPlayer)player.getExtendedProperties("BleachPlayer");
            final ItemStack heldItem = player.getCurrentEquippedItem();
            final ItemStack var13 = new ItemStack(BleachItems.quincypendant, 1, 1);
            if (heldItem != null && heldItem == par1ItemStack && props.getCurrentEnergy() <= 0.0f) {
                props.deactivate(par1ItemStack.getItem());
            }
            --this.shikaiTimer;
            if (this.shikaiTimer <= 0 && !player.worldObj.isRemote) {
                this.shikaiTimer = 40;
                props.consumeEnergy(3);
            }
        }
    }
    
    public void onUsingTick(final ItemStack stack, final EntityPlayer player, final int count) {
        final ExtendedPlayer props = (ExtendedPlayer)player.getExtendedProperties("BleachPlayer");
	        if (props.getCurrentEnergy() > 0.0f && props.getFaction() == 2 && !player.inventory.hasItemStack(new ItemStack(BleachItems.seele, 1, 1))) {
	            if (count % 11 == 0) {
	                final EntityEnergyArrow entityEnergyArrow = new EntityEnergyArrow(player.worldObj, (EntityLivingBase)player, 2.0f);
	                entityEnergyArrow.setIsCritical(true);
	                player.worldObj.spawnEntityInWorld((Entity)entityEnergyArrow);
	                player.worldObj.playSoundAtEntity((Entity)player, "bleachreborn:bowfire", 0.4f, 1.0f);
	                props.consumeEnergy(5);
	            }
	        }
	        else if (props.getCurrentEnergy() > 0.0f && props.getFaction() == 2 && player.inventory.hasItem(BleachItems.seele)) {
	            this.isSeele = true;
	        }
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(final ItemStack stack, final int renderPass, final EntityPlayer player, final ItemStack usingItem, final int useRemaining) {
        if (player.getItemInUse() == null) {
            return this.itemIcon;
        }
        final int Pulling = stack.getMaxItemUseDuration() - useRemaining;
        if (this.getIsSeele()) {
            if (Pulling >= 18) {
                return ItemQuincyWebBow.iconArray[2];
            }
            if (Pulling > 13) {
                return ItemQuincyWebBow.iconArray[1];
            }
            if (Pulling > 0) {
                return ItemQuincyWebBow.iconArray[0];
            }
        }
        return this.itemIcon;
    }
    
    static {
        bowPullIconNameArray = new String[] { "web_seele1", "web_seele2", "web_seele3" };
    }
}

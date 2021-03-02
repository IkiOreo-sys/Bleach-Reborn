package littlebreadloaf.bleachreborn.items;

import java.util.*;
import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.entity.player.*;
import littlebreadloaf.bleachreborn.events.*;
import littlebreadloaf.bleachreborn.armor.*;
import net.minecraft.potion.*;
import littlebreadloaf.bleachreborn.api.*;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.*;
import net.minecraft.item.*;
import littlebreadloaf.bleachreborn.*;
import cpw.mods.fml.common.network.internal.*;
import com.google.common.collect.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;

public class ItemZanpakuto extends ItemSword
{
    private float weaponDamage;
    private final Item.ToolMaterial toolMaterial;
    public float damageBoost;
    public float robeboost;
    public float pantboost;
    public float sandalboost;
    public float waspboost;
    Random rand;
    
    public ItemZanpakuto(final Item.ToolMaterial par2EnumToolReiatsu) {
        super(par2EnumToolReiatsu);
        this.damageBoost = 0.0f;
        this.robeboost = 0.0f;
        this.pantboost = 0.0f;
        this.sandalboost = 0.0f;
        this.waspboost = 0.0f;
        this.rand = new Random();
        this.toolMaterial = par2EnumToolReiatsu;
        this.maxStackSize = 1;
        this.setMaxDamage(par2EnumToolReiatsu.getMaxUses());
        this.setUnlocalizedName("zanpakuto");
        this.setCreativeTab(BleachItems.tabBleach);
        this.weaponDamage = 4.0f + par2EnumToolReiatsu.getDamageVsEntity();
    }
    
    public float func_150931_i() {
        return this.toolMaterial.getDamageVsEntity();
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister icon) {
        this.itemIcon = icon.registerIcon("bleachreborn".toLowerCase() + ":zanpakuto");
    }
    
    public float getDamage() {
        return this.weaponDamage;
    }
    
    public boolean hitEntity(final ItemStack par1ItemStack, final EntityLivingBase par2EntityLivingBase, final EntityLivingBase par3EntityLivingBase) {
        final EntityPlayer player = (EntityPlayer)par3EntityLivingBase;
        final ExtendedPlayer props = (ExtendedPlayer)player.getExtendedProperties("BleachPlayer");
        final ItemStack var9 = player.inventory.armorInventory[0];
        final ItemStack var10 = player.inventory.armorInventory[1];
        final ItemStack var11 = player.inventory.armorInventory[2];
        final ItemStack var12 = player.inventory.armorInventory[3];
        if (var9 != null && (var9.getItem() == Armor.Sandals || var9.getItem() == Armor.ArrancarShoes)) {
            this.sandalboost = 1.0f;
        } else if (var9 != null && var9.getItem() == Armor.QuincyShoes) {
            this.sandalboost = -1.0f;
        } else {
            this.sandalboost = 0.0f;
        }
        if (var10 != null && (var10.getItem() == Armor.ShiniPants || var10.getItem() == Armor.ArrancarPants)) {
            this.pantboost = 2.0f;
        } else if (var10 != null && var10.getItem() == Armor.QuincyPants) {
            this.pantboost = -1.0f;
        } else {
            this.pantboost = 0.0f;
        }
        if (var11 != null && (var11.getItem() == Armor.ShiniRobe || var11.getItem() == Armor.ArrancarPants)) {
            this.robeboost = 3.0f;
        } else if (var11 != null && var11.getItem() == Armor.QuincyRobe) {
            this.robeboost = -2.0f;
        } else {
            this.robeboost = 0.0f;
        }
        if (var12 != null && var12.getItem() == Armor.GolemHelmet && props.getFaction() == 1 && !player.worldObj.isRemote && props.consumeEnergy(3)) {
            par2EntityLivingBase.setFire(6);
        }
        if (var12 != null && var12.getItem() == Armor.SnakeHelmet && props.getFaction() == 1 && !player.worldObj.isRemote && props.consumeEnergy(3)) {
            par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.poison.id, 200, 1));
        }
        if (var12 != null && var12.getItem() == Armor.WaspHelmet && props.getFaction() == 1 && !player.worldObj.isRemote) {
            props.replenishEnergy(1);
        }
        if (par2EntityLivingBase.getCreatureAttribute() == Tools.SPIRIT) {
            if (props.getFaction() == 14 || props.getFaction() == 1 || props.getFaction() == 11 || props.getFaction() == 4 || props.getFaction() == 5 && !player.worldObj.isRemote) {
                props.addSXP(3 + (3 * props.getXpRate()));
            }
            this.damageBoost = 2.0f;
        } else {
            if (props.getFaction() == 14 || props.getFaction() == 1 || props.getFaction() == 11 || props.getFaction() == 4 || props.getFaction() == 5 && !player.worldObj.isRemote) {
                props.addSXP((int)1.5f + (1 * props.getXpRate()));
            }
            this.damageBoost = 0.0f;
        }
        float factionBoost = 0;
        if(props.getFaction() == 4 || props.getFaction() == 12) {
            factionBoost = (props.getCurrentEnergy() / 100);
        }
        final float damage = this.damageBoost + this.sandalboost + this.pantboost + this.robeboost + factionBoost;
        if (damage > 0.0f && props.getFaction() == 1 && damage <= par2EntityLivingBase.getHealth()) {
            par2EntityLivingBase.setHealth(par2EntityLivingBase.getHealth() - damage);
        }
        if (props.getFaction() == 2) {
            player.dropPlayerItemWithRandomChoice(par1ItemStack, false);
            player.destroyCurrentEquippedItem();
        }
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }
    
    public void onCreated(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        final ExtendedPlayer props = (ExtendedPlayer)par3EntityPlayer.getExtendedProperties("BleachPlayer");
    }
    
    public EnumAction getItemUseAction(final ItemStack par1ItemStack) {
        return EnumAction.block;
    }
    
    public int getMaxItemUseDuration(final ItemStack par1ItemStack) {
        return 72000;
    }
    
    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        final ExtendedPlayer props = (ExtendedPlayer)par3EntityPlayer.getExtendedProperties("BleachPlayer");
        if (par3EntityPlayer.isSneaking()) {
            if (props.getZName().length() <= 0 && par1ItemStack.hasDisplayName() && !par1ItemStack.getDisplayName().equals("Zanpakuto")) {
                props.setZName(par1ItemStack.getDisplayName());
            }
            if (props.getZName().length() <= 0 && par1ItemStack.getDisplayName().equals("Zanpakuto")) {
                FMLNetworkHandler.openGui(par3EntityPlayer, (Object)BleachMod.instance, 12, par2World, (int)par3EntityPlayer.posX, (int)par3EntityPlayer.posY, (int)par3EntityPlayer.posZ);
            }
            if (props.getZName().length() > 0 && par1ItemStack.getDisplayName().equals("Zanpakuto")) {
            	par1ItemStack.setStackDisplayName(props.getZName());
            }
            if (props.getZName().length() >= 0 && !par1ItemStack.getDisplayName().equals("Zanpakuto")) {
                FMLNetworkHandler.openGui(par3EntityPlayer, (Object)BleachMod.instance, 0, par2World, (int)par3EntityPlayer.posX, (int)par3EntityPlayer.posY, (int)par3EntityPlayer.posZ);
                if (props.getZTex() == 5) {
                    props.randomTexture();
                }
            }
            if (props.getPoints(9) >= 400) {
                int check = 1;
                for (int i = 1; i < 9; ++i) {
                    if (props.getPoints(i) > props.getPoints(check)) {
                        check = i;
                    }
                }
                if (props.getPoints(check) >= 100) {
                    props.setZType(check);
                    int secondType = 23;
                    for (int j = 1; j < 9; ++j) {
                        if (props.getPoints(j) >= props.getPoints(secondType) && j != check) {
                            secondType = j;
                        }
                    }
                    if (props.getPoints(secondType) >= 100) {
                        if ((check == 6 && secondType == 7) || (check == 7 && secondType == 6)) {
                            props.setZType(10);
                        }
                        else if ((check == 7 && secondType == 8) || (check == 8 && secondType == 7)) {
                            props.setZType(9);
                        }
                        else if ((check == 1 && secondType == 2) || (check == 2 && secondType == 1)) {
                            props.setZType(12);
                        }
                    }
                }
                else {
                    props.setZType(11);
                }
            }
        }
        return par1ItemStack;
    }
    
    @SideOnly(Side.CLIENT)
    public void onUsingTick(final ItemStack stack, final EntityPlayer player, final int count) {
        final ExtendedPlayer props = (ExtendedPlayer)player.getExtendedProperties("BleachPlayer");
        if (props.getCurrentCap() >= 200 && props.getPoints(9) >= 400 && stack.hasDisplayName() && stack.getDisplayName().equals(props.getZName()) && props.getFaction() == 1) {
            final double var2 = player.posX;
            final double var3 = player.posY;
            final double posZ = player.posZ;
        }
    }
    
    public int getItemEnchantability() {
        return this.toolMaterial.getEnchantability();
    }
    
    public String getToolMaterialName() {
        return this.toolMaterial.toString();
    }
    
    public Multimap getItemAttributeModifiers() {
        final float damage = this.getDamage();
        final Multimap multimap = super.getItemAttributeModifiers();
        multimap.put((Object)SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), (Object)new AttributeModifier(ItemZanpakuto.field_111210_e, "Weapon modifier", (double)damage, 0));
        return multimap;
    }
}

package littlebreadloaf.bleachreborn.items;

import java.util.*;
import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.entity.player.*;
import littlebreadloaf.bleachreborn.events.*;
import littlebreadloaf.bleachreborn.api.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.block.*;
import net.minecraft.init.*;
import com.google.common.collect.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;

public class ItemShinai extends ItemSword
{
    private float weaponDamage;
    private final Item.ToolMaterial toolMaterial;
    Random rand;
    
    public ItemShinai(final Item.ToolMaterial par2EnumToolReiatsu) {
        super(par2EnumToolReiatsu);
        this.rand = new Random();
        this.toolMaterial = par2EnumToolReiatsu;
        this.maxStackSize = 1;
        this.setMaxDamage(par2EnumToolReiatsu.getMaxUses());
        this.setCreativeTab(BleachItems.tabBleach);
        this.setUnlocalizedName("shinai");
        this.weaponDamage = 1.0f;
    }
    
    public float func_150931_i() {
        return this.toolMaterial.getDamageVsEntity();
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister icon) {
        this.itemIcon = icon.registerIcon("bleachreborn".toLowerCase() + ":shinai");
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
        if (par2EntityLivingBase.getCreatureAttribute() == Tools.SPIRIT) {
            if ((!player.worldObj.isRemote && props.getFaction() == 1) || props.getFaction() == 2 || props.getFaction() == 11 || props.getFaction() == 4 || props.getFaction() == 5) {
                if (props.getCurrentCap() <= 4999) {
                	props.addSXP(2 + (2 * props.getXpRate()));
                }
            }
        }
        else if ((!player.worldObj.isRemote && props.getFaction() == 1) || props.getFaction() == 2 || props.getFaction() == 11 || props.getFaction() == 4 || props.getFaction() == 5) {
            if (props.getCurrentCap() <= 4999) {
            	props.addSXP(1 + (1 * props.getXpRate()));
            }
        }
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }
    
    public EnumAction getItemUseAction(final ItemStack par1ItemStack) {
        return EnumAction.block;
    }
    
    public int getMaxItemUseDuration(final ItemStack par1ItemStack) {
        return 72000;
    }
    
    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        return par1ItemStack;
    }
    
    public boolean canHarvestBlock(final Block par1Block) {
        return par1Block == Blocks.web;
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
        multimap.put((Object)SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), (Object)new AttributeModifier(ItemShinai.field_111210_e, "Weapon modifier", (double)damage, 0));
        return multimap;
    }
}

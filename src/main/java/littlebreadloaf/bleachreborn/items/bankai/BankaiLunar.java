package littlebreadloaf.bleachreborn.items.bankai;

import net.minecraft.creativetab.*;
import littlebreadloaf.bleachreborn.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.entity.player.*;
import littlebreadloaf.bleachreborn.events.*;
import littlebreadloaf.bleachreborn.armor.*;
import littlebreadloaf.bleachreborn.api.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import com.google.common.collect.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.*;
import littlebreadloaf.bleachreborn.items.*;
import net.minecraft.potion.*;

public class BankaiLunar extends ItemBankai
{
    public static IIcon[] icons;
    private static final String[] ICON;
    private float weaponDamage;
    private final Item.ToolMaterial toolMaterial;
    public float damageBoost;
    public float robeboost;
    public float pantboost;
    public float sandalboost;
    int shikaiTimer;
    
    public BankaiLunar(final Item.ToolMaterial material) {
        super(material);
        this.damageBoost = 0.0f;
        this.robeboost = 0.0f;
        this.pantboost = 0.0f;
        this.sandalboost = 0.0f;
        this.shikaiTimer = 40;
        this.toolMaterial = material;
        this.maxStackSize = 1;
        this.setMaxDamage(material.getMaxUses());
        this.setCreativeTab((CreativeTabs)null);
        this.setHasSubtypes(true);
        this.weaponDamage = 10.0f + material.getDamageVsEntity();
    }
    
    public String getUnlocalizedName(final ItemStack itemstack) {
        return Names.BankaiLunar_UnlocalizedName[0];
    }
    
    public float getDamage() {
        return this.weaponDamage;
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(final int damage) {
        return BankaiLunar.icons[0];
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister icon) {
        BankaiLunar.icons = new IIcon[BankaiLunar.ICON.length];
        for (int i = 0; i < BankaiLunar.icons.length; ++i) {
            BankaiLunar.icons[i] = icon.registerIcon("bleachreborn".toLowerCase() + ":" + BankaiLunar.ICON[i]);
        }
    }
    
    @Override
    public float func_150931_i() {
        return this.toolMaterial.getDamageVsEntity();
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
        }
        else if (var9 != null && var9.getItem() == Armor.QuincyShoes) {
            this.sandalboost = -1.0f;
        }
        else {
            this.sandalboost = 0.0f;
        }
        if (var10 != null && (var10.getItem() == Armor.ShiniPants || var10.getItem() == Armor.ArrancarPants)) {
            this.pantboost = 2.0f;
        }
        else if (var10 != null && var10.getItem() == Armor.QuincyPants) {
            this.pantboost = -1.0f;
        }
        else {
            this.pantboost = 0.0f;
        }
        if (var11 != null && (var11.getItem() == Armor.ShiniRobe || var11.getItem() == Armor.ArrancarPants)) {
            this.robeboost = 3.0f;
        }
        else if (var11 != null && var11.getItem() == Armor.QuincyRobe) {
            this.robeboost = -2.0f;
        }
        else {
            this.robeboost = 0.0f;
        }
        if (!player.worldObj.isRemote) {
            par2EntityLivingBase.motionY += 0.2000000059604645;
        }
        if (par2EntityLivingBase.getCreatureAttribute() == Tools.SPIRIT) {
            if (props.getFaction() == 14 || props.getFaction() == 1 || props.getFaction() == 11 || props.getFaction() == 4 || props.getFaction() == 5 && !player.worldObj.isRemote) {
                props.addSXP(5 * props.getXpRate());
            }
            this.damageBoost = 2.0f;
        }
        else {
            if (props.getFaction() == 14 || props.getFaction() == 1 || props.getFaction() == 11 || props.getFaction() == 4 || props.getFaction() == 5 && !player.worldObj.isRemote) {
                props.addSXP(2 * props.getXpRate());
            }
            this.damageBoost = 0.0f;
        }
        final float damage = this.damageBoost + this.sandalboost + this.pantboost + this.robeboost;
        if (damage > 0.0f && props.getFaction() == 1 && damage <= par2EntityLivingBase.getHealth()) {
            par2EntityLivingBase.attackEntityFrom(DamageSource.generic, damage);
        }
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public boolean isFull3D() {
        return true;
    }
    
    @Override
    public EnumAction getItemUseAction(final ItemStack par1ItemStack) {
        return EnumAction.block;
    }
    
    @Override
    public int getMaxItemUseDuration(final ItemStack par1ItemStack) {
        return 72000;
    }
    
    @Override
    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        return par1ItemStack;
    }
    
    @Override
    public int getItemEnchantability() {
        return this.toolMaterial.getEnchantability();
    }
    
    @Override
    public String getToolMaterialName() {
        return this.toolMaterial.toString();
    }
    
    public Multimap getItemAttributeModifiers() {
        final float damage = this.getDamage();
        final Multimap multimap = super.getItemAttributeModifiers();
        multimap.put((Object)SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), (Object)new AttributeModifier(BankaiLunar.field_111210_e, "Weapon modifier", (double)damage, 0));
        return multimap;
    }
    
    public void onPlayerStoppedUsing(final ItemStack var1, final World var2, final EntityPlayer var3, final int var4) {
    }
    
    public boolean isBookEnchantable(final ItemStack itemstack1, final ItemStack itemstack2) {
        return false;
    }
    
    public void onUpdate(final ItemStack par1ItemStack, final World par2World, final Entity par3Entity, final int par4, final boolean par5) {
        if (par3Entity instanceof EntityPlayer) {
            final EntityPlayer player = (EntityPlayer)par3Entity;
            final ExtendedPlayer props = (ExtendedPlayer)player.getExtendedProperties("BleachPlayer");
            final ItemStack heldItem = player.getCurrentEquippedItem();
            final ItemStack var13 = new ItemStack(BleachItems.zanpakuto, 1);
            --this.shikaiTimer;
            if (this.shikaiTimer <= 0 && !player.worldObj.isRemote) {
                this.shikaiTimer = 40;
                props.consumeEnergy(15);
            }
            if (heldItem != null && heldItem == par1ItemStack) {
                if (props.getCurrentEnergy() <= 0.0f) {
                    props.deactivate(par1ItemStack.getItem());
                }
                heldItem.setItemDamage(props.getZTex());
                player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 40, 2));
                player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 40, 2));
                if (props.getZType() != 9) {
                    props.deactivate(par1ItemStack.getItem());
                }
            }
        }
    }
    
    static {
        ICON = Names.BankaiLunar_UnlocalizedName;
    }
}

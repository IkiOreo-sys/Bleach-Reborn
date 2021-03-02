package littlebreadloaf.bleachreborn.items.shikai;

import net.minecraft.creativetab.*;
import net.minecraft.entity.player.*;
import java.util.*;
import cpw.mods.fml.relauncher.*;
import littlebreadloaf.bleachreborn.*;
import net.minecraft.client.renderer.texture.*;
import littlebreadloaf.bleachreborn.events.*;
import littlebreadloaf.bleachreborn.armor.*;
import littlebreadloaf.bleachreborn.api.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import com.google.common.collect.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import littlebreadloaf.bleachreborn.items.*;
import net.minecraft.potion.*;

public class ShikaiFire extends ItemShikai
{
    public static IIcon[] icons;
    private static final String[] ICON;
    private float weaponDamage;
    private final Item.ToolMaterial toolMaterial;
    public float damageBoost;
    public float robeboost;
    public float pantboost;
    public float sandalboost;
    public float waspboost;
    int shikaiTimer;
    
    public ShikaiFire(final Item.ToolMaterial material) {
        super(material);
        this.damageBoost = 0.0f;
        this.robeboost = 0.0f;
        this.pantboost = 0.0f;
        this.sandalboost = 0.0f;
        this.waspboost = 0.0f;
        this.shikaiTimer = 40;
        this.toolMaterial = material;
        this.maxStackSize = 1;
        this.setMaxDamage(material.getMaxUses());
        this.setCreativeTab((CreativeTabs)null);
        this.setHasSubtypes(true);
        this.weaponDamage = 5.0f + material.getDamageVsEntity();
    }
    
    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack itemStack, final EntityPlayer player, final List data, final boolean b) {
        if (itemStack.getItemDamage() == 2) {
            data.add("Jrich144");
        }
        else if (itemStack.getItemDamage() == 3) {
            data.add("SuperToby12");
        }
        else if (itemStack.getItemDamage() == 4) {
            data.add("JohnJoyce");
        }
    }
    
    public String getUnlocalizedName(final ItemStack itemstack) {
        return Names.ShikaiFire_UnlocalizedName[itemstack.getItemDamage()];
    }
    
    public float getDamage() {
        return this.weaponDamage;
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(final int damage) {
        return ShikaiFire.icons[damage];
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister icon) {
        ShikaiFire.icons = new IIcon[ShikaiFire.ICON.length];
        for (int i = 0; i < ShikaiFire.icons.length; ++i) {
            ShikaiFire.icons[i] = icon.registerIcon("bleachreborn".toLowerCase() + ":" + ShikaiFire.ICON[i]);
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
        if (par2EntityLivingBase.getCreatureAttribute() == Tools.SPIRIT) {
            if (props.getFaction() == 14 || props.getFaction() == 1 || props.getFaction() == 11 || props.getFaction() == 4 || props.getFaction() == 5 && !player.worldObj.isRemote) {
                props.addSXP(5 + (5 * props.getXpRate()));
            }
            this.damageBoost = 2.0f;
        }
        else {
            if (props.getFaction() == 14 || props.getFaction() == 1 || props.getFaction() == 11 || props.getFaction() == 4 || props.getFaction() == 5 && !player.worldObj.isRemote) {
                props.addSXP(3 + (3 * props.getXpRate()));
            }
            this.damageBoost = 0.0f;
        }
        final float damage = this.damageBoost + this.sandalboost + this.pantboost + this.robeboost;
        if (damage > 0.0f && props.getFaction() == 1 && damage <= par2EntityLivingBase.getHealth()) {
            par2EntityLivingBase.attackEntityFrom(DamageSource.generic, damage);
        }
        par2EntityLivingBase.setFire(10);
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
        multimap.put((Object)SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), (Object)new AttributeModifier(ShikaiFire.field_111210_e, "Weapon modifier", (double)damage, 0));
        return multimap;
    }
    
    public boolean onItemUse(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final World par3World, int par4, int par5, int par6, final int par7, final float par8, final float par9, final float par10) {
        if (par7 == 0) {
            --par5;
        }
        if (par7 == 1) {
            ++par5;
        }
        if (par7 == 2) {
            --par6;
        }
        if (par7 == 3) {
            ++par6;
        }
        if (par7 == 4) {
            --par4;
        }
        if (par7 == 5) {
            ++par4;
        }
        if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack)) {
            return false;
        }
        final Block var11 = par3World.getBlock(par4, par5, par6);
        if (var11 == Blocks.air) {
            par3World.playSoundEffect(par4 + 0.5, par5 + 0.5, par6 + 0.5, "fire.ignite", 1.0f, ShikaiFire.itemRand.nextFloat() * 0.4f + 0.8f);
            par3World.setBlock(par4, par5, par6, (Block)Blocks.fire);
        }
        return true;
    }
    
    public void onPlayerStoppedUsing(final ItemStack var1, final World var2, final EntityPlayer var3, final int var4) {
        final ExtendedPlayer props = (ExtendedPlayer)var3.getExtendedProperties("BleachPlayer");
        final int var5 = this.getMaxItemUseDuration(var1) - var4;
        float var6 = var5 / 20.0f;
        var6 = (var6 * var6 + var6 * 2.0f) / 3.0f;
        if (var6 < 0.1) {
            return;
        }
        if (var6 > 1.0f) {
            var6 = 1.0f;
            if (!var2.isRemote) {
                final EntitySmallFireball Fireball = new EntitySmallFireball(var2, (EntityLivingBase)var3, 5.0 * Math.cos(-var3.rotationPitch * 0.017453292519943295) * Math.sin(-var3.rotationYaw * 0.017453292519943295), 5.0 * Math.sin(-var3.rotationPitch * 0.017453292519943295), 5.0 * Math.cos(-var3.rotationPitch * 0.017453292519943295) * Math.cos(-var3.rotationYaw * 0.017453292519943295));
                final Vec3 look = var3.getLook(1.0f);
                Fireball.posX = var3.posX + look.xCoord * 0.800000011920929;
                Fireball.posY = var3.posY + 0.6000000238418579;
                Fireball.posZ = var3.posZ + look.zCoord * 0.800000011920929;
                var2.playSoundAtEntity((Entity)var3, "mob.ghast.fireball", 1.0f, 1.0f);
                var2.spawnEntityInWorld((Entity)Fireball);
                props.consumeEnergy(20);
            }
            var3.swingItem();
        }
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
                props.consumeEnergy(3);
            }
            if (heldItem != null && heldItem == par1ItemStack) {
                if (props.getCurrentEnergy() <= 0.0f) {
                    props.deactivate(par1ItemStack.getItem());
                }
                heldItem.setItemDamage(props.getZTex());
                player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 40, 0));
                if (props.getZType() != 1) {
                    props.deactivate(par1ItemStack.getItem());
                }
            }
        }
    }
    
    static {
        ICON = Names.ShikaiFire_UnlocalizedName;
    }
}

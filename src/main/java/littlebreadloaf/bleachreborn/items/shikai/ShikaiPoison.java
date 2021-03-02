package littlebreadloaf.bleachreborn.items.shikai;

import net.minecraft.creativetab.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.entity.player.*;
import littlebreadloaf.bleachreborn.events.*;
import littlebreadloaf.bleachreborn.armor.*;
import net.minecraft.potion.*;
import littlebreadloaf.bleachreborn.api.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import com.google.common.collect.*;
import net.minecraft.entity.ai.attributes.*;
import littlebreadloaf.bleachreborn.blocks.*;
import net.minecraft.block.*;
import littlebreadloaf.bleachreborn.*;
import littlebreadloaf.bleachreborn.network.*;
import cpw.mods.fml.common.network.simpleimpl.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import java.util.*;
import littlebreadloaf.bleachreborn.items.*;
import net.minecraft.init.*;

public class ShikaiPoison extends ItemShikai
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
    Random rand;
    int shikaiTimer;
    
    public ShikaiPoison(final Item.ToolMaterial material) {
        super(material);
        this.damageBoost = 0.0f;
        this.robeboost = 0.0f;
        this.pantboost = 0.0f;
        this.sandalboost = 0.0f;
        this.waspboost = 0.0f;
        this.rand = new Random();
        this.shikaiTimer = 40;
        this.toolMaterial = material;
        this.maxStackSize = 1;
        this.setMaxDamage(material.getMaxUses());
        this.setCreativeTab((CreativeTabs)null);
        this.setHasSubtypes(true);
        this.weaponDamage = 5.0f + material.getDamageVsEntity();
    }
    
    public String getUnlocalizedName(final ItemStack itemstack) {
        return Names.ShikaiPoison_UnlocalizedName[itemstack.getItemDamage()];
    }
    
    public float getDamage() {
        return this.weaponDamage;
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(final int damage) {
        return ShikaiPoison.icons[damage];
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister icon) {
        ShikaiPoison.icons = new IIcon[ShikaiPoison.ICON.length];
        for (int i = 0; i < ShikaiPoison.icons.length; ++i) {
            ShikaiPoison.icons[i] = icon.registerIcon("bleachreborn".toLowerCase() + ":" + ShikaiPoison.ICON[i]);
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
        if (par2EntityLivingBase.getCreatureAttribute() == EnumCreatureAttribute.UNDEAD) {
            par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.regeneration.id, 100, 1));
        }
        else {
            par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.poison.id, 100, 2));
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
        multimap.put((Object)SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), (Object)new AttributeModifier(ShikaiPoison.field_111210_e, "Weapon modifier", (double)damage, 0));
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
        final Block var12 = par3World.getBlock(par4, par5 - 1, par6);
        if (var11 == Blocks.air && (var12 == Blocks.dirt || var12 == Blocks.grass)) {
            par3World.setBlock(par4, par5, par6, BleachBlocks.poisonShroom);
            if (!par3World.isRemote) {
                ExtendedPlayer.get(par2EntityPlayer).consumeEnergy(15);
            }
        }
        return true;
    }
    
    public boolean isBookEnchantable(final ItemStack itemstack1, final ItemStack itemstack2) {
        return false;
    }
    
    public void onPlayerStoppedUsing(final ItemStack var1, final World var2, final EntityPlayer var3, final int var4) {
        final ExtendedPlayer props = (ExtendedPlayer)var3.getExtendedProperties("BleachPlayer");
        final int var5 = this.getMaxItemUseDuration(var1) - var4;
        float var6 = var5 / 20.0f;
        var6 = (var6 * var6 + var6 * 2.0f) / 3.0f;
        if (var6 < 0.1) {
            return;
        }
        if (var6 > 2.0f) {
            var6 = 1.0f;
            if (!var2.isRemote) {
                for (int i = -6; i < 6; ++i) {
                    for (int k = -6; k < 6; ++k) {
                        if (this.rand.nextBoolean()) {
                            PacketDispatcher.sendToAll((IMessage)new ParticleMessage(1, (int)var3.posX + i, (int)var3.posY, (int)var3.posZ + k));
                        }
                    }
                }
                var2.playSoundAtEntity((Entity)var3, "bleachreborn:poison", 0.4f, 1.0f);
                props.consumeEnergy(20);
            }
            final Vec3 normalizer = Vec3.createVectorHelper(0.008, 0.008, 0.008).normalize();
            final List list = var2.getEntitiesWithinAABBExcludingEntity((Entity)var3, var3.boundingBox.copy().expand(Math.abs(normalizer.xCoord * 3.0) + 3.0, Math.abs(normalizer.yCoord * 3.0) + 3.0, Math.abs(normalizer.zCoord * 3.0) + 3.0));
            for (int l = 0; l < list.size(); ++l) {
                final Entity entity1 = (Entity) list.get(l);
                if (entity1 instanceof EntityLivingBase) {
                    ((EntityLivingBase)entity1).addPotionEffect(new PotionEffect(Potion.poison.id, 200, 0));
                }
            }
            var3.swingItem();
        }
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
                if (player.getActivePotionEffect(Potion.poison) != null) {
                    player.curePotionEffects(new ItemStack(Items.milk_bucket));
                }
                if (props.getZType() != 3) {
                    props.deactivate(par1ItemStack.getItem());
                }
            }
        }
    }
    
    static {
        ICON = Names.ShikaiPoison_UnlocalizedName;
    }
}

package littlebreadloaf.bleachreborn.items.shikai;

import net.minecraft.creativetab.*;
import net.minecraft.entity.player.*;
import java.util.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.client.renderer.texture.*;
import littlebreadloaf.bleachreborn.events.*;
import littlebreadloaf.bleachreborn.armor.*;
import littlebreadloaf.bleachreborn.api.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import com.google.common.collect.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import littlebreadloaf.bleachreborn.*;
import littlebreadloaf.bleachreborn.network.*;
import cpw.mods.fml.common.network.simpleimpl.*;
import littlebreadloaf.bleachreborn.items.*;

public class ShikaiEarth extends ItemShikai
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
    int ringTimer;
    int shockwaveRing;
    int shockwaveMax;
    int Xpos;
    int Ypos;
    int Zpos;
    int shikaiTimer;
    
    public ShikaiEarth(final Item.ToolMaterial material) {
        super(material);
        this.damageBoost = 0.0f;
        this.robeboost = 0.0f;
        this.pantboost = 0.0f;
        this.sandalboost = 0.0f;
        this.waspboost = 0.0f;
        this.rand = new Random();
        this.ringTimer = 3;
        this.shockwaveRing = 0;
        this.shockwaveMax = 5;
        this.shikaiTimer = 40;
        this.toolMaterial = material;
        this.maxStackSize = 1;
        this.setMaxDamage(material.getMaxUses());
        this.setCreativeTab((CreativeTabs)null);
        this.setHasSubtypes(true);
        this.weaponDamage = 7.0f + material.getDamageVsEntity();
    }
    
    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack itemStack, final EntityPlayer player, final List data, final boolean b) {
        if (itemStack.getItemDamage() == 3) {
            data.add("BrandonKgp13");
        }
    }
    
    public String getUnlocalizedName(final ItemStack itemstack) {
        return Names.ShikaiEarth_UnlocalizedName[itemstack.getItemDamage()];
    }
    
    public float getDamage() {
        return this.weaponDamage;
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(final int damage) {
        return ShikaiEarth.icons[damage];
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister icon) {
        ShikaiEarth.icons = new IIcon[ShikaiEarth.ICON.length];
        for (int i = 0; i < ShikaiEarth.icons.length; ++i) {
            ShikaiEarth.icons[i] = icon.registerIcon("bleachreborn".toLowerCase() + ":" + ShikaiEarth.ICON[i]);
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
            par2EntityLivingBase.addVelocity(player.motionX * 52.8 * 0.7000000238418579, 0.1, player.motionZ * 52.8 * 0.7000000238418579);
            par2EntityLivingBase.motionY += 0.2000000059604645;
        }
        if (par2EntityLivingBase.getCreatureAttribute() == Tools.SPIRIT) {
            if (props.getFaction() == 14 ||props.getFaction() == 1 || props.getFaction() == 11 || props.getFaction() == 4 || props.getFaction() == 5 && !player.worldObj.isRemote) {
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
        multimap.put((Object)SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), (Object)new AttributeModifier(ShikaiEarth.field_111210_e, "Weapon modifier", (double)damage, 0));
        return multimap;
    }
    
    public void onPlayerStoppedUsing(final ItemStack var1, final World var2, final EntityPlayer var3, final int var4) {
        final ExtendedPlayer props = (ExtendedPlayer)var3.getExtendedProperties("BleachPlayer");
        final int var5 = this.getMaxItemUseDuration(var1) - var4;
        float var6 = var5 / 20.0f;
        var6 = (var6 * var6 + var6 * 2.0f) / 3.0f;
        var3.swingItem();
        if (var6 < 0.1) {
            return;
        }
        if (var6 > 1.0f) {
            if (var6 > 3.0f) {
                var6 = 3.0f;
            }
            if (!var2.isRemote && var2.getBlock((int)var3.posX, (int)var3.posY - 1, (int)var3.posZ) != Blocks.air) {
                this.shockwaveRing = 1;
                this.shockwaveMax = 5 + (int)var6;
                this.Xpos = (int)var3.posX;
                this.Ypos = (int)var3.posY;
                this.Zpos = (int)var3.posZ;
                final Vec3 normalizer = Vec3.createVectorHelper(0.008, 0.008, 0.008).normalize();
                final List list = var2.getEntitiesWithinAABBExcludingEntity((Entity)var3, var3.boundingBox.copy().expand(Math.abs(normalizer.xCoord * 3.0) + 3.0, Math.abs(normalizer.yCoord * 3.0) + 3.0, Math.abs(normalizer.zCoord * 3.0) - 3.0 + this.shockwaveMax));
                for (int l = 0; l < list.size(); ++l) {
                    final Entity entity1 = (Entity) list.get(l);
                    if (entity1 instanceof EntityLivingBase) {
                        double moveX = entity1.posX - var3.posX;
                        double moveY = entity1.posY - var3.posY;
                        double moveZ = entity1.posZ - var3.posZ;
                        final double angle = Math.atan2(moveZ, moveX);
                        moveX = 0.4 * Math.cos(angle);
                        moveZ = 0.4 * Math.sin(angle);
                        moveY = 0.30000001192092896;
                        entity1.addVelocity(moveX, moveY, moveZ);
                        ((EntityLivingBase)entity1).attackEntityFrom(DamageSource.generic, 6.0f);
                    }
                }
                props.consumeEnergy(20);
            }
        }
    }
    
    public boolean isBookEnchantable(final ItemStack itemstack1, final ItemStack itemstack2) {
        return false;
    }
    
    public void onUpdate(final ItemStack par1ItemStack, final World par2World, final Entity par3Entity, final int par4, final boolean par5) {
        if (par3Entity instanceof EntityPlayer) {
            if (this.shockwaveRing > 0) {
                --this.ringTimer;
                for (int i = -this.shockwaveRing; i < this.shockwaveRing; ++i) {
                    for (int k = -this.shockwaveRing; k < this.shockwaveRing; ++k) {
                        if (Math.ceil(par3Entity.getDistance(par3Entity.posX + i, par3Entity.posY, par3Entity.posZ + k)) == this.shockwaveRing) {
                            PacketDispatcher.sendToAll((IMessage)new ParticleMessage(2, this.Xpos + i, this.Ypos, this.Zpos + k));
                        }
                    }
                }
                if (this.ringTimer <= 0) {
                    ++this.shockwaveRing;
                    this.ringTimer = 2 + this.shockwaveRing;
                }
                if (this.shockwaveRing > this.shockwaveMax) {
                    this.shockwaveRing = 0;
                }
            }
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
                if (props.getZType() != 5) {
                    props.deactivate(par1ItemStack.getItem());
                }
            }
        }
    }
    
    static {
        ICON = Names.ShikaiEarth_UnlocalizedName;
    }
}

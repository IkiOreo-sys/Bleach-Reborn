package littlebreadloaf.bleachreborn.items;

import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;
import littlebreadloaf.bleachreborn.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.entity.player.*;
import littlebreadloaf.bleachreborn.events.*;
import net.minecraft.world.*;
import littlebreadloaf.bleachreborn.blocks.*;
import littlebreadloaf.bleachreborn.armor.*;
import littlebreadloaf.bleachreborn.api.*;
import net.minecraft.item.*;
import com.google.common.collect.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;

public class ItemSeeleschneider extends ItemSword
{
    @SideOnly(Side.CLIENT)
    public static IIcon[] icons;
    private float weaponDamage;
    private final Item.ToolMaterial toolMaterial;
    public float damageBoost;
    public float robeboost;
    public float pantboost;
    public float sandalboost;
    private static final String[] ICON;
    
    public ItemSeeleschneider(final Item.ToolMaterial material) {
        super(material);
        this.damageBoost = 0.0f;
        this.robeboost = 0.0f;
        this.pantboost = 0.0f;
        this.sandalboost = 0.0f;
        this.toolMaterial = material;
        this.maxStackSize = 1;
        this.setMaxDamage(material.getMaxUses());
        this.setCreativeTab(BleachItems.tabBleach);
        this.setHasSubtypes(true);
        this.weaponDamage = 2.0f + material.getDamageVsEntity();
    }
    
    public float func_150931_i() {
        return this.toolMaterial.getDamageVsEntity();
    }
    
    public float getDamage() {
        return this.weaponDamage;
    }
    
    public String getUnlocalizedName(final ItemStack itemstack) {
        return Names.Seeleschneider_UnlocalizedName[itemstack.getItemDamage()];
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(final int damage) {
        return ItemSeeleschneider.icons[damage];
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister icon) {
        ItemSeeleschneider.icons = new IIcon[ItemSeeleschneider.ICON.length];
        for (int i = 0; i < ItemSeeleschneider.icons.length; ++i) {
            ItemSeeleschneider.icons[i] = icon.registerIcon("bleachreborn".toLowerCase() + ":" + ItemSeeleschneider.ICON[i]);
        }
    }
    
    public ItemStack onItemRightClick(final ItemStack item, final World par2World, final EntityPlayer player) {
        final ExtendedPlayer props = (ExtendedPlayer)player.getExtendedProperties("BleachPlayer");
        if (item.getItemDamage() == 0 && !player.worldObj.isRemote && props.getCurrentEnergy() >= 70.0f / props.getCurrentCap() && props.getFaction() == 2) {
            props.consumeEnergy(70);
            item.setItemDamage(1);
        }
        return item;
    }
    
    public boolean onItemUse(final ItemStack item, final EntityPlayer player, final World world, final int x, final int y, final int z, final int side, final float par8, final float par9, final float f) {
        if (!world.isRemote && item.getItemDamage() == 1 && side == 1 && World.doesBlockHaveSolidTopSurface((IBlockAccess)world, x, y, z)) {
            world.setBlock(x, y + 1, z, BleachBlocks.seeleSchneiderBlock);
            if (!player.capabilities.isCreativeMode) {
                final ItemStack currentEquippedItem2;
                final ItemStack currentEquippedItem = currentEquippedItem2 = player.getCurrentEquippedItem();
                --currentEquippedItem2.stackSize;
            }
        }
        return true;
    }
    
    public boolean hitEntity(final ItemStack par1ItemStack, final EntityLivingBase par2EntityLivingBase, final EntityLivingBase par3EntityLivingBase) {
        final EntityPlayer player = (EntityPlayer)par3EntityLivingBase;
        final ExtendedPlayer props = (ExtendedPlayer)player.getExtendedProperties("BleachPlayer");
        final ItemStack var9 = player.inventory.armorInventory[0];
        final ItemStack var10 = player.inventory.armorInventory[1];
        final ItemStack var11 = player.inventory.armorInventory[2];
        final ItemStack var12 = player.inventory.armorInventory[3];
        final ItemStack var13 = player.inventory.getCurrentItem();
        if (var13 != null && var13.getItem() == BleachItems.seele && var13.getItemDamage() == 1) {
            if (var9 != null && var9.getItem() == Armor.QuincyShoes) {
                this.sandalboost = 1.0f;
            }
            else {
                this.sandalboost = 0.0f;
            }
            if (var10 != null && var10.getItem() == Armor.QuincyPants) {
                this.pantboost = 1.0f;
            }
            else {
                this.pantboost = 0.0f;
            }
            if (var11 != null && var11.getItem() == Armor.QuincyRobe) {
                this.robeboost = 1.0f;
            }
            else {
                this.robeboost = 0.0f;
            }
            if (par2EntityLivingBase.getCreatureAttribute() == Tools.SPIRIT) {
                if (!player.worldObj.isRemote && props.getFaction() == 2) {
                    props.addSXP(3);
                }
                this.damageBoost = 4.0f;
            }
            else {
                if (!player.worldObj.isRemote && props.getFaction() == 2) {
                    props.addSXP(1);
                }
                this.damageBoost = 0.0f;
            }
            final float damage = this.damageBoost + this.sandalboost + this.pantboost + this.robeboost;
            if (damage > 0.0f && props.getFaction() == 2 && var13.getItemDamage() == 1) {
                par2EntityLivingBase.setHealth(par2EntityLivingBase.getHealth() - damage);
            }
        }
        return true;
    }
    
    public EnumAction getItemUseAction(final ItemStack par1ItemStack) {
        return EnumAction.block;
    }
    
    public Multimap getItemAttributeModifiers() {
        final float damage = this.getDamage();
        final Multimap multimap = super.getItemAttributeModifiers();
        multimap.put((Object)SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), (Object)new AttributeModifier(ItemSeeleschneider.field_111210_e, "Weapon modifier", (double)damage, 0));
        return multimap;
    }
    
    static {
        ICON = new String[] { "seele", "seele2" };
    }
}

package littlebreadloaf.bleachreborn.items.bankai;

import net.minecraft.util.*;
import net.minecraft.creativetab.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import littlebreadloaf.bleachreborn.*;

public class ItemBankai extends ItemSword
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
    public float darkboost;
    
    public ItemBankai(final Item.ToolMaterial material) {
        super(material);
        this.damageBoost = 0.0f;
        this.robeboost = 0.0f;
        this.pantboost = 0.0f;
        this.sandalboost = 0.0f;
        this.waspboost = 0.0f;
        this.darkboost = 0.0f;
        this.toolMaterial = material;
        this.maxStackSize = 1;
        this.setMaxDamage(material.getMaxUses());
        this.setCreativeTab((CreativeTabs)null);
        this.setHasSubtypes(true);
        this.weaponDamage = 10.0f + material.getDamageVsEntity();
    }
    
    public float func_150931_i() {
        return this.toolMaterial.getDamageVsEntity();
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
    
    public int getItemEnchantability() {
        return this.toolMaterial.getEnchantability();
    }
    
    public String getToolMaterialName() {
        return this.toolMaterial.toString();
    }
    
    static {
        ICON = Names.BankaiNormal_UnlocalizedName;
    }
}

package littlebreadloaf.bleachreborn.items;

import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;
import littlebreadloaf.bleachreborn.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import littlebreadloaf.bleachreborn.events.*;
import net.minecraft.item.*;
import net.minecraft.creativetab.*;
import java.util.*;

public class ItemPendant extends Item
{
    @SideOnly(Side.CLIENT)
    public static IIcon[] icons;
    private float weaponDamage;
    public float damageBoost;
    public float robeboost;
    public float pantboost;
    public float sandalboost;
    private static final String[] ICON;
    
    public ItemPendant() {
        this.damageBoost = 10.0f;
        this.robeboost = 0.0f;
        this.pantboost = 0.0f;
        this.sandalboost = 0.0f;
        this.maxStackSize = 1;
        this.setCreativeTab(BleachItems.tabBleach);
        this.setHasSubtypes(true);
    }
    
    public String getUnlocalizedName(final ItemStack itemstack) {
        return Names.QuincyPendant_UnlocalizedName[itemstack.getItemDamage()];
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(final int damage) {
        return ItemPendant.icons[damage];
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister icon) {
        ItemPendant.icons = new IIcon[ItemPendant.ICON.length];
        for (int i = 0; i < ItemPendant.icons.length; ++i) {
            ItemPendant.icons[i] = icon.registerIcon("bleachreborn".toLowerCase() + ":" + ItemPendant.ICON[i]);
        }
    }
    
    public ItemStack onItemRightClick(ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        final ExtendedPlayer props = (ExtendedPlayer)par3EntityPlayer.getExtendedProperties("BleachPlayer");
        if (par1ItemStack.getItemDamage() == 0 && !par3EntityPlayer.worldObj.isRemote && props.getCurrentEnergy() >= 10.0f / props.getCurrentCap() && props.getFaction() == 2) {
            props.consumeEnergy(10);
            par1ItemStack = new ItemStack(BleachItems.quincybow, 1);
        }
        else if (par1ItemStack.getItemDamage() == 1 && !par3EntityPlayer.worldObj.isRemote && props.getCurrentEnergy() >= 20.0f / props.getCurrentCap() && props.getFaction() == 2) {
            props.consumeEnergy(20);
            par1ItemStack = new ItemStack(BleachItems.quincyweb, 1);
        }
        return par1ItemStack;
    }
    
    public EnumAction getItemUseAction(final ItemStack par1ItemStack) {
        return null;
    }
    
    public void getSubItems(final Item item, final CreativeTabs tab, final List list) {
        for (int i = 0; i < ItemPendant.icons.length; ++i) {
            final ItemStack itemstack = new ItemStack(item, 1, i);
            list.add(itemstack);
        }
    }
    
    static {
        ICON = new String[] { "quincy_pendant", "quincy_pentacle" };
    }
}

package littlebreadloaf.bleachreborn.items;

import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import littlebreadloaf.bleachreborn.events.*;
import net.minecraft.entity.*;

public class ItemReiatsuPillIron extends Item
{
    public final int itemUseDuration;
    
    public ItemReiatsuPillIron() {
        this.setCreativeTab(BleachItems.tabBleach);
        this.setUnlocalizedName("reiatsu_pill2");
        this.itemUseDuration = 48;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister icon) {
        this.itemIcon = icon.registerIcon("bleachreborn".toLowerCase() + ":reiatsu_pill2");
    }
    
    public int getMaxItemUseDuration(final ItemStack par1ItemStack) {
        return 48;
    }
    
    public EnumAction getItemUseAction(final ItemStack par1ItemStack) {
        return EnumAction.eat;
    }
    
    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        return par1ItemStack;
    }
    
    public ItemStack onEaten(final ItemStack itemstack, final World world, final EntityPlayer player) {
        if (!world.isRemote) {
            final ExtendedPlayer props = (ExtendedPlayer)player.getExtendedProperties("BleachPlayer");
            --itemstack.stackSize;
            if (props.getFaction() == 2) {
                props.replenishEnergy(275);
            }
            else {
                props.replenishEnergy(250);
            }
            world.playSoundAtEntity((Entity)player, "random.burp", 0.5f, world.rand.nextFloat() * 0.1f + 0.9f);
        }
        return itemstack;
    }
}

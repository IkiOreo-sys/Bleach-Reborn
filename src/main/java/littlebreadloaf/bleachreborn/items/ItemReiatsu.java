package littlebreadloaf.bleachreborn.items;

import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import littlebreadloaf.bleachreborn.events.*;
import net.minecraft.entity.*;

public class ItemReiatsu extends Item
{
    public final int itemUseDuration;
    
    public ItemReiatsu() {
        this.setCreativeTab(BleachItems.tabBleach);
        this.setUnlocalizedName("reiatsu");
        this.itemUseDuration = 32;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister icon) {
        this.itemIcon = icon.registerIcon("bleachreborn".toLowerCase() + ":reiatsu");
    }
    
    public int getMaxItemUseDuration(final ItemStack par1ItemStack) {
        return 32;
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
                props.replenishEnergy(10);
            }
            else {
                props.replenishEnergy(5);
            }
            world.playSoundAtEntity((Entity)player, "random.burp", 0.5f, world.rand.nextFloat() * 0.1f + 0.9f);
        }
        return itemstack;
    }
}

package littlebreadloaf.bleachreborn.items;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import littlebreadloaf.bleachreborn.BleachIds;
import littlebreadloaf.bleachreborn.entities.EntityAizen;
import littlebreadloaf.bleachreborn.events.ExtendedPlayer;
import littlebreadloaf.bleachreborn.world.HuecoMundoTeleporter;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;

public class DebugItem extends Item
{
    Random rand;
    
    public DebugItem() {
        this.rand = new Random();
    }
    
    public ItemStack onItemRightClick(final ItemStack stack, final World world, final EntityPlayer player) {
        final ExtendedPlayer props = ExtendedPlayer.get(player);
        if (player.isSneaking() && player instanceof EntityPlayerMP) {
            final EntityPlayerMP playermp = (EntityPlayerMP)player;
            if (playermp.dimension == BleachIds.worldHuecoMundoID) {
                playermp.mcServer.getConfigurationManager().transferPlayerToDimension(playermp, 0, (Teleporter)new HuecoMundoTeleporter(playermp.mcServer.worldServerForDimension(0)));
            }
            else {
                playermp.mcServer.getConfigurationManager().transferPlayerToDimension(playermp, BleachIds.worldHuecoMundoID, (Teleporter)new HuecoMundoTeleporter(playermp.mcServer.worldServerForDimension(BleachIds.worldHuecoMundoID)));
            }
        }
        else if (!player.isSneaking() && player instanceof EntityPlayer && props.getCurrentCap() >= 500) {
        	if (!player.worldObj.isRemote) {
	        	final EntityAizen aizen = new EntityAizen(player.worldObj);
	            aizen.setLocationAndAngles(player.posX + 1.0, player.posY + 1.0, player.posZ + 1.0, 0.0f, 0.0f);
	            player.worldObj.spawnEntityInWorld((Entity)aizen);
	        	--stack.stackSize;
        	}
        }
        return stack;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister icon) {
        this.itemIcon = icon.registerIcon("bleachreborn".toLowerCase() + ":garganta");
    }
}

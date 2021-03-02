package littlebreadloaf.bleachreborn.blocks;

import net.minecraft.block.material.*;
import littlebreadloaf.bleachreborn.items.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.enchantment.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import java.util.*;
import net.minecraft.block.*;
import net.minecraft.item.*;

public class BlockShikaiIce extends BlockBreakable
{
    int iceMeltTimer;
    
    public BlockShikaiIce() {
        super("ice", Material.ice, false);
        this.iceMeltTimer = 10;
        this.slipperiness = 0.98f;
        this.setTickRandomly(true);
        this.setCreativeTab(BleachItems.tabBleach);
        this.setBlockName("icey");
    }
    
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 1;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(final IBlockAccess par1IBlockAccess, final int par2, final int par3, final int par4, final int par5) {
        return super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, 1 - par5);
    }
    
    public void harvestBlock(final World par1World, final EntityPlayer par2EntityPlayer, final int par3, final int par4, final int par5, final int par6) {
        par2EntityPlayer.addExhaustion(0.025f);
        if (!this.canSilkHarvest() || !EnchantmentHelper.getSilkTouchModifier((EntityLivingBase)par2EntityPlayer)) {
            if (par1World.provider.isHellWorld) {
                par1World.setBlockToAir(par3, par4, par5);
                return;
            }
            final Material material = par1World.getBlock(par3, par4 - 1, par5).getMaterial();
            if (material.blocksMovement() || material.isLiquid()) {
                par1World.setBlock(par3, par4, par5, Blocks.water);
            }
        }
    }
    
    public int quantityDropped(final Random par1Random) {
        return 0;
    }
    
    public void updateTick(final World par1World, final int par2, final int par3, final int par4, final Random par5Random) {
        --this.iceMeltTimer;
        if (this.iceMeltTimer < 0) {
            par1World.setBlock(par2, par3, par4, Blocks.water);
            par1World.scheduleBlockUpdate(par2, par3, par4, (Block)this, 10);
        }
        par1World.scheduleBlockUpdate(par2, par3, par4, (Block)this, 10);
    }
    
    public int getMobilityFlag() {
        return 0;
    }
    
    public void onBlockPlacedBy(final World world, final int i, final int j, final int k, final EntityLivingBase entity, final ItemStack ItemStack) {
        world.scheduleBlockUpdate(i, j, k, (Block)this, 10);
    }
}

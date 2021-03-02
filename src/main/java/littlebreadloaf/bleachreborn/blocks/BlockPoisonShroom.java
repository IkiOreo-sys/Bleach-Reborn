package littlebreadloaf.bleachreborn.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.potion.*;
import java.util.*;
import net.minecraft.item.*;

public class BlockPoisonShroom extends Block
{
    int iceMeltTimer;
    
    protected BlockPoisonShroom() {
        super(Material.plants);
        this.iceMeltTimer = 1200;
        this.setBlockTextureName("poison_shroom");
        this.setBlockName("poison_shroom");
        this.setHardness(1.0f);
        this.setResistance(1.0f);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister icon) {
        this.blockIcon = icon.registerIcon("bleachreborn".toLowerCase() + ":poison_shroom");
    }
    
    public boolean canPlaceBlockAt(final World par1World, final int par2, final int par3, final int par4) {
        return super.canPlaceBlockAt(par1World, par2, par3, par4) && this.canBlockStay(par1World, par2, par3, par4);
    }
    
    public void onNeighborBlockChange(final World par1World, final int par2, final int par3, final int par4, final Block block) {
        super.onNeighborBlockChange(par1World, par2, par3, par4, block);
        this.checkFlowerChange(par1World, par2, par3, par4);
    }
    
    protected final void checkFlowerChange(final World par1World, final int par2, final int par3, final int par4) {
        if (!this.canBlockStay(par1World, par2, par3, par4)) {
            this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
            par1World.setBlock(par2, par3, par4, Blocks.air, 0, 2);
        }
    }
    
    public boolean canBlockStay(final World par1World, final int par2, final int par3, final int par4) {
        return par1World.getBlock(par2, par3 - 1, par4) == Blocks.grass || par1World.getBlock(par2, par3 - 1, par4) == Blocks.dirt;
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(final World par1World, final int par2, final int par3, final int par4) {
        return null;
    }
    
    public boolean isOpaqueCube() {
        return false;
    }
    
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    public int getRenderType() {
        return 1;
    }
    
    public void onEntityCollidedWithBlock(final World world, final int x, final int y, final int z, final Entity entity) {
        if (entity instanceof EntityLivingBase && ((EntityLivingBase)entity).getActivePotionEffect(Potion.poison) == null) {
            ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.poison.id, 200, 0));
            world.setBlockToAir(x, y, z);
        }
    }
    
    public void updateTick(final World par1World, final int par2, final int par3, final int par4, final Random par5Random) {
        this.checkFlowerChange(par1World, par2, par3, par4);
        --this.iceMeltTimer;
        if (this.iceMeltTimer < 0) {
            par1World.setBlock(par2, par3, par4, Blocks.water);
            par1World.scheduleBlockUpdate(par2, par3, par4, (Block)this, 10);
        }
        par1World.scheduleBlockUpdate(par2, par3, par4, (Block)this, 10);
    }
    
    public int getMobilityFlag() {
        return 2;
    }
    
    public void onBlockPlacedBy(final World world, final int i, final int j, final int k, final EntityLivingBase entity, final ItemStack ItemStack) {
        world.scheduleBlockUpdate(i, j, k, (Block)this, 10);
    }
}

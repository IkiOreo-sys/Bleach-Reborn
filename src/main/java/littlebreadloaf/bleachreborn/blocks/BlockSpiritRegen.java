package littlebreadloaf.bleachreborn.blocks;

import net.minecraft.block.*;
import cpw.mods.fml.relauncher.*;
import java.util.*;
import net.minecraft.block.material.*;
import littlebreadloaf.bleachreborn.items.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.entity.player.*;
import littlebreadloaf.bleachreborn.events.ExtendedPlayer;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import littlebreadloaf.bleachreborn.extras.*;

public class BlockSpiritRegen extends Block
{
    @SideOnly(Side.CLIENT)
    private IIcon cakeTopIcon;
    @SideOnly(Side.CLIENT)
    private IIcon cakeBottomIcon;
    @SideOnly(Side.CLIENT)
    private IIcon field_94382_c;
    protected Random rand;
    public int posX;
    public int posY;
    public int posZ;
    public boolean activated;
    public int baitTimer;
    public int regenTimer;
    boolean var18;
    
    protected BlockSpiritRegen() {
        super(Material.cake);
        this.setTickRandomly(this.var18 = false);
        this.rand = new Random();
        this.setCreativeTab(BleachItems.tabBleach);
        this.setBlockName("spirit_regen_block");
        this.setHardness(3.0f);
        this.setResistance(15.0f);
        this.setStepSound(Block.soundTypeStone);
        this.regenTimer = 60;
    }
    
    public int tickRate(final World par1World) {
        return 10;
    }
    
    public void setBlockBoundsBasedOnState(final IBlockAccess par1IBlockAccess, final int par2, final int par3, final int par4) {
        final int l = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
        final float f = 0.0625f;
        final float f2 = (1 + l * 2) / 16.0f;
        final float f3 = 0.5f;
        this.setBlockBounds(f2, 0.0f, 0.0625f, 0.9375f, 0.5f, 0.9375f);
    }
    
    public void setBlockBoundsForItemRender() {
        final float f = 0.0625f;
        final float f2 = 0.5f;
        this.setBlockBounds(0.0625f, 0.0f, 0.0625f, 0.9375f, 0.5f, 0.9375f);
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(final World par1World, final int par2, final int par3, final int par4) {
        final int l = par1World.getBlockMetadata(par2, par3, par4);
        final float f = 0.0625f;
        final float f2 = (1 + l * 2) / 16.0f;
        final float f3 = 0.5f;
        return AxisAlignedBB.getBoundingBox((double)(par2 + f2), (double)par3, (double)(par4 + 0.0625f), (double)(par2 + 1 - 0.0625f), (double)(par3 + 0.5f - 0.0625f), (double)(par4 + 1 - 0.0625f));
    }
    
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(final World par1World, final int par2, final int par3, final int par4) {
        final int l = par1World.getBlockMetadata(par2, par3, par4);
        final float f = 0.0625f;
        final float f2 = (1 + l * 2) / 16.0f;
        final float f3 = 0.5f;
        return AxisAlignedBB.getBoundingBox((double)(par2 + f2), (double)par3, (double)(par4 + 0.0625f), (double)(par2 + 1 - 0.0625f), (double)(par3 + 0.5f), (double)(par4 + 1 - 0.0625f));
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(final int par1, final int par2) {
        return (par1 == 1) ? this.cakeTopIcon : ((par1 == 0) ? this.cakeBottomIcon : ((par2 > 0 && par1 == 4) ? this.field_94382_c : this.blockIcon));
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon("bleachreborn".toLowerCase() + ":spirit_regen_block2");
        this.field_94382_c = par1IconRegister.registerIcon("cake_inner");
        this.cakeTopIcon = par1IconRegister.registerIcon("bleachreborn".toLowerCase() + ":spirit_regen_block");
        this.cakeBottomIcon = par1IconRegister.registerIcon("bleachreborn".toLowerCase() + ":spirit_regen_block2");
    }
    
    public boolean isOpaqueCube() {
        return false;
    }
    
    public boolean onBlockActivated(final World var1, final int var2, final int var3, final int var4, final EntityPlayer var5, final int var6, final float var7, final float var8, final float var9) {
        this.baitTimer = 0;
        var1.scheduleBlockUpdate(var2, var3, var4, (Block)this, this.tickRate(var1));
        this.posX = var2;
        this.posY = var3;
        this.posZ = var4;
        return this.activated = true;
    }
    
    public void onBlockClicked(final World var1, final int var2, final int var3, final int var4, final EntityPlayer var5) {
        this.baitTimer = 0;
        var1.scheduleBlockUpdate(var2, var3, var4, (Block)this, this.tickRate(var1));
        this.posX = var2;
        this.posY = var3;
        this.posZ = var4;
        this.activated = true;
    }
    
    public void onNeighborBlockChange(final World par1World, final int par2, final int par3, final int par4, final Block par5) {
        if (!this.canBlockStay(par1World, par2, par3, par4)) {
            par1World.setBlockToAir(par2, par3, par4);
        }
    }
    
    public void updateTick(final World var1, final int var2, final int var3, final int var4, final Random var5) {
        ++this.baitTimer;
        --this.regenTimer;
        if (this.baitTimer < 840) {
            if (this.regenTimer <= 60) {
            	final List players = var1.getEntitiesWithinAABB((Class)EntityPlayer.class, AxisAlignedBB.getBoundingBox(this.posX - 10.0, this.posY - 10.0, this.posZ - 10.0, this.posX + 10.0, this.posY + 10.0, this.posZ + 10.0));
                for (int i = 0; i < players.size(); ++i) {
                    final EntityLivingBase entity = (EntityLivingBase) players.get(i);
                    if (entity != null && entity instanceof EntityPlayer) {
                    	ExtendedPlayer props = ExtendedPlayer.get((EntityPlayer) entity);
                    	props.replenishEnergy(((int)(5.0 * (1.0 + 0.002 * props.getCurrentCap()))) * 2);
                    }
                }
                this.regenTimer = 60;
            }
            var1.scheduleBlockUpdate(var2, var3, var4, (Block)this, this.tickRate(var1));
        }
        if (this.baitTimer >= 840) {
            var1.setBlockToAir(var2, var3, var4);
            this.baitTimer = 0;
            this.activated = false;
        }
    }
    
    public int quantityDropped(final Random par1Random) {
        return 0;
    }
    
    public Item getItemDropped(final int par1, final Random par2Random, final int par3) {
        return null;
    }
    
    public void randomDisplayTick(final World var1, final int var2, final int var3, final int var4, final Random var5) {
        final double var6 = var2 + 0.1f + var5.nextFloat() * 0.8f;
        final double var7 = var3 + 0.3f + var5.nextFloat() * 0.3f;
        final double var8 = var4 + 0.1f + var5.nextFloat() * 0.8f;
        ParticleEffects.spawnParticle("soul", var6, var7, var8, 0.0, 0.0, 0.0);
    }
}
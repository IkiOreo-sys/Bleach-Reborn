package littlebreadloaf.bleachreborn.blocks;

import cpw.mods.fml.relauncher.*;
import net.minecraft.block.material.*;
import littlebreadloaf.bleachreborn.items.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.entity.*;
import net.minecraftforge.common.util.*;
import net.minecraft.item.*;
import net.minecraft.client.renderer.texture.*;

public class BlockPaperWall extends BlockPane
{
    private final String sideTextureIndex;
    private final boolean canDropItself;
    private final String field_94402_c;
    @SideOnly(Side.CLIENT)
    private IIcon theIcon;
    
    protected BlockPaperWall(final String par2Str, final String par3Str, final Material par4Material, final boolean par5) {
        super(par3Str, par3Str, par4Material, par5);
        this.sideTextureIndex = "bleachreborn".toLowerCase() + ":" + par3Str;
        this.canDropItself = par5;
        this.field_94402_c = "bleachreborn".toLowerCase() + ":" + par2Str;
        this.setCreativeTab(BleachItems.tabBleach);
    }
    
    public Item getItemDropped(final int par1, final Random par2Random, final int par3) {
        return this.canDropItself ? super.getItemDropped(par1, par2Random, par3) : null;
    }
    
    public boolean isOpaqueCube() {
        return false;
    }
    
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    public int getRenderType() {
        return 41;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(final IBlockAccess par1IBlockAccess, final int par2, final int par3, final int par4, final int par5) {
        final Block i1 = par1IBlockAccess.getBlock(par2, par3, par4);
        return i1 != this && super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5);
    }
    
    public void addCollisionBoxesToList(final World par1World, final int par2, final int par3, final int par4, final AxisAlignedBB par5AxisAlignedBB, final List par6List, final Entity par7Entity) {
        final boolean flag = this.canPaneConnectTo((IBlockAccess)par1World, par2, par3, par4, ForgeDirection.NORTH);
        final boolean flag2 = this.canPaneConnectTo((IBlockAccess)par1World, par2, par3, par4, ForgeDirection.SOUTH);
        final boolean flag3 = this.canPaneConnectTo((IBlockAccess)par1World, par2, par3, par4, ForgeDirection.WEST);
        final boolean flag4 = this.canPaneConnectTo((IBlockAccess)par1World, par2, par3, par4, ForgeDirection.EAST);
        if ((!flag3 || !flag4) && (flag3 || flag4 || flag || flag2)) {
            if (flag3 && !flag4) {
                this.setBlockBounds(0.0f, 0.0f, 0.4375f, 0.5f, 1.0f, 0.5625f);
                super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
            }
            else if (!flag3 && flag4) {
                this.setBlockBounds(0.5f, 0.0f, 0.4375f, 1.0f, 1.0f, 0.5625f);
                super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
            }
        }
        else {
            this.setBlockBounds(0.0f, 0.0f, 0.4375f, 1.0f, 1.0f, 0.5625f);
            super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
        }
        if ((!flag || !flag2) && (flag3 || flag4 || flag || flag2)) {
            if (flag && !flag2) {
                this.setBlockBounds(0.4375f, 0.0f, 0.0f, 0.5625f, 1.0f, 0.5f);
                super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
            }
            else if (!flag && flag2) {
                this.setBlockBounds(0.4375f, 0.0f, 0.5f, 0.5625f, 1.0f, 1.0f);
                super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
            }
        }
        else {
            this.setBlockBounds(0.4375f, 0.0f, 0.0f, 0.5625f, 1.0f, 1.0f);
            super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
        }
    }
    
    public void setBlockBoundsForItemRender() {
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }
    
    public void setBlockBoundsBasedOnState(final IBlockAccess par1IBlockAccess, final int par2, final int par3, final int par4) {
        float f = 0.4375f;
        float f2 = 0.5625f;
        float f3 = 0.4375f;
        float f4 = 0.5625f;
        final boolean flag = this.canPaneConnectTo(par1IBlockAccess, par2, par3, par4, ForgeDirection.NORTH);
        final boolean flag2 = this.canPaneConnectTo(par1IBlockAccess, par2, par3, par4, ForgeDirection.SOUTH);
        final boolean flag3 = this.canPaneConnectTo(par1IBlockAccess, par2, par3, par4, ForgeDirection.WEST);
        final boolean flag4 = this.canPaneConnectTo(par1IBlockAccess, par2, par3, par4, ForgeDirection.EAST);
        if ((!flag3 || !flag4) && (flag3 || flag4 || flag || flag2)) {
            if (flag3 && !flag4) {
                f = 0.0f;
            }
            else if (!flag3 && flag4) {
                f2 = 1.0f;
            }
        }
        else {
            f = 0.0f;
            f2 = 1.0f;
        }
        if ((!flag || !flag2) && (flag3 || flag4 || flag || flag2)) {
            if (flag && !flag2) {
                f3 = 0.0f;
            }
            else if (!flag && flag2) {
                f4 = 1.0f;
            }
        }
        else {
            f3 = 0.0f;
            f4 = 1.0f;
        }
        this.setBlockBounds(f, 0.0f, f3, f2, 1.0f, f4);
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon func_150097_e() {
        return this.theIcon;
    }
    
    protected boolean canSilkHarvest() {
        return true;
    }
    
    protected ItemStack createStackedBlock(final int par1) {
        return new ItemStack((Block)this, 1, par1);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon(this.field_94402_c);
        this.theIcon = par1IconRegister.registerIcon(this.sideTextureIndex);
    }
    
    public boolean canPaneConnectTo(final IBlockAccess access, final int x, final int y, final int z, final ForgeDirection dir) {
        return this.canPaneConnectToBlock(access.getBlock(x + dir.offsetX, y + dir.offsetY, z + dir.offsetZ)) || access.isSideSolid(x + dir.offsetX, y + dir.offsetY, z + dir.offsetZ, dir.getOpposite(), false);
    }
}

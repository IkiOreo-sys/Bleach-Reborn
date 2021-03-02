package littlebreadloaf.bleachreborn.blocks;

import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.block.*;
import littlebreadloaf.bleachreborn.*;
import net.minecraft.world.*;
import net.minecraft.tileentity.*;
import littlebreadloaf.bleachreborn.tiles.*;
import net.minecraft.entity.player.*;
import cpw.mods.fml.common.*;
import java.util.*;
import littlebreadloaf.bleachreborn.items.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.item.*;

public class BlockSeeleSchneider extends BleachBlockContainer
{
    public BlockSeeleSchneider(final Material mat) {
        super(mat);
        this.setCreativeTab((CreativeTabs)null);
        this.setBlockTextureName("seeleblock");
        this.setHardness(1.0f);
        this.setResistance(1.0f);
        this.setStepSound(Block.soundTypeMetal);
        this.setLightLevel(0.9f);
        this.setBlockBounds(0.4375f, 0.0f, 0.4375f, 0.5625f, 1.5f, 0.5625f);
    }
    
    public int getRenderType() {
        return BleachIds.seeleSchneiderRenderingID;
    }
    
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    public boolean isOpaqueCube() {
        return false;
    }
    
    public TileEntity createNewTileEntity(final World world, final int metadata) {
        return new TileSeeleSchneider();
    }
    
    public boolean onBlockActivated(final World world, final int x, final int y, final int z, final EntityPlayer player, final int par6, final float par7, final float par8, final float par9) {
        if (player.getCurrentEquippedItem() == null) {
            this.dropBlockAsItem(world, x, y, z, 1, 0);
            world.setBlockToAir(x, y, z);
        }
        return false;
    }
    
    public void onBlockPreDestroy(final World world, final int i, final int j, final int k, final int meta) {
        TileSeeleSchneider tile = (TileSeeleSchneider)world.getTileEntity(i, j, k);
        if (tile.isMain) {
            for (int var = 0; var < TileSeeleSchneider.magicSquare.size(); ++var) {
                final int x = TileSeeleSchneider.magicSquare.get(var).posX;
                final int y = TileSeeleSchneider.magicSquare.get(var).posY;
                final int z = TileSeeleSchneider.magicSquare.get(var).posZ;
                if (x == i && y == j && z == k) {
                    TileSeeleSchneider.magicSquare.remove(var);
                }
            }
        }
        else {
            tile = tile.getMainBlockTile();
            if (tile == null) {
                FMLLog.info("[BleachMod] Seeleschneider tile null", new Object[0]);
                return;
            }
            for (int var = 0; var < TileSeeleSchneider.magicSquare.size(); ++var) {
                final int x = TileSeeleSchneider.magicSquare.get(var).posX;
                final int y = TileSeeleSchneider.magicSquare.get(var).posY;
                final int z = TileSeeleSchneider.magicSquare.get(var).posZ;
                if (x == tile.xCoord && y == tile.yCoord && z == tile.zCoord) {
                    TileSeeleSchneider.magicSquare.remove(var);
                }
            }
            tile.isMain = false;
        }
    }
    
    public Item getItemDropped(final int par1, final Random par2Random, final int par3) {
        return BleachItems.seele;
    }
    
    public int damageDropped(final int par1) {
        return 0;
    }
    
    public void onNeighborBlockChange(final World world, final int x, final int y, final int z, final Block block) {
        if (world.getBlock(x, y - 1, z) == Blocks.air) {
            this.dropBlockAsItem(world, x, y, z, 1, 0);
            world.setBlockToAir(x, y, z);
        }
    }
    
    public ItemStack getPickBlock(final MovingObjectPosition target, final World world, final int x, final int y, final int z) {
        return new ItemStack(BleachItems.seele, 1, 1);
    }
}

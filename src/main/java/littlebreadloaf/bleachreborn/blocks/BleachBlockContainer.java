package littlebreadloaf.bleachreborn.blocks;

import net.minecraft.block.material.*;
import net.minecraft.world.*;
import net.minecraft.block.*;
import net.minecraft.tileentity.*;

public abstract class BleachBlockContainer extends BleachBlock implements ITileEntityProvider
{
    public BleachBlockContainer(final Material mat) {
    }
    
    public void breakBlock(final World world, final int x, final int y, final int z, final Block par5, final int par6) {
        super.breakBlock(world, x, y, z, par5, par6);
        world.removeTileEntity(x, y, z);
    }
    
    public boolean onBlockEventReceived(final World world, final int x, final int y, final int z, final int blockID, final int eventID) {
        super.onBlockEventReceived(world, x, y, z, blockID, eventID);
        final TileEntity tileentity = world.getTileEntity(x, y, z);
        return tileentity != null && tileentity.receiveClientEvent(blockID, eventID);
    }
}

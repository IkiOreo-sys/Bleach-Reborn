package littlebreadloaf.bleachreborn.blocks;

import net.minecraft.block.material.*;
import net.minecraft.block.*;
import littlebreadloaf.bleachreborn.*;
import net.minecraft.world.*;
import net.minecraft.tileentity.*;
import littlebreadloaf.bleachreborn.tiles.*;

public class BlockLantern extends BleachBlockContainer
{
    public BlockLantern(final Material material) {
        super(material);
        this.setBlockTextureName("lantern_item");
        this.setBlockName("lantern");
        this.setHardness(5.0f);
        this.setResistance(15.0f);
        this.setStepSound(Block.soundTypeGlass);
        this.setLightLevel(1.0f);
    }
    
    public int getRenderType() {
        return BleachIds.lanternRenderingID;
    }
    
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    public boolean isOpaqueCube() {
        return false;
    }
    
    public TileEntity createNewTileEntity(final World world, final int metadata) {
        return new TileLantern();
    }
}

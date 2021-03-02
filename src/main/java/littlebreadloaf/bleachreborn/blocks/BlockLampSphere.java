package littlebreadloaf.bleachreborn.blocks;

import net.minecraft.block.material.*;
import net.minecraft.block.*;
import littlebreadloaf.bleachreborn.*;
import net.minecraft.world.*;
import net.minecraft.tileentity.*;
import littlebreadloaf.bleachreborn.tiles.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;

public class BlockLampSphere extends BleachBlockContainer
{
    public BlockLampSphere() {
        super(Material.glass);
        this.setBlockName("reiatsu_lamp");
        this.setHardness(5.0f);
        this.setResistance(15.0f);
        this.setStepSound(Block.soundTypeGlass);
        this.setLightLevel(0.9f);
    }
    
    public int getRenderType() {
        return BleachIds.sphereLampRenderID;
    }
    
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    public boolean isOpaqueCube() {
        return false;
    }
    
    public TileEntity createNewTileEntity(final World world, final int metadata) {
        return new TileSphereLamp();
    }
    
    public void onBlockPlacedBy(final World world, final int i, final int j, final int k, final EntityLivingBase entity, final ItemStack ItemStack) {
        if (world.getTileEntity(i, j, k) instanceof TileSphereLamp && entity instanceof EntityPlayer) {
            ((TileSphereLamp)world.getTileEntity(i, j, k)).setOwnerEntity((EntityPlayer)entity);
        }
    }
}

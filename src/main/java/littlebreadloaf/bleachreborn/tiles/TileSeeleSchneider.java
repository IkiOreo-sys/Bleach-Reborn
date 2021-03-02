package littlebreadloaf.bleachreborn.tiles;

import java.util.*;
import net.minecraft.util.*;
import littlebreadloaf.bleachreborn.blocks.*;
import cpw.mods.fml.common.*;
import net.minecraft.nbt.*;

public class TileSeeleSchneider extends TileBleach
{
    public static ArrayList<ChunkCoordinates> magicSquare;
    public boolean isMain;
    public int side;
    public int tick;
    public ChunkCoordinates mainBlock;
    private boolean init;
    public float rotation;
    public float alpha;
    
    public TileSeeleSchneider() {
        this.isMain = false;
        this.side = -1;
        this.tick = 0;
        this.mainBlock = new ChunkCoordinates(this.xCoord, this.yCoord, this.zCoord);
        this.init = false;
        this.rotation = 0.0f;
        this.alpha = 0.0f;
    }
    
    public void updateEntity() {
        ++this.tick;
        this.rotation += 2.5f;
        if (this.rotation >= 360.0f) {
            this.rotation -= 360.0f;
        }
        final double radius = Math.sin(Math.toRadians(this.rotation * 2.0f)) / 4.0 + 1.0;
        this.alpha = 0.8f + (float)Math.sin(Math.toRadians(this.rotation * 3.0f)) / 8.0f;
        if (!this.worldObj.isRemote && !this.init) {
            this.checkForShape();
            this.init = true;
        }
    }
    
    public void checkForShape() {
        for (int x = 3; x <= 16; ++x) {
            if (this.worldObj.getBlock(this.xCoord + x, this.yCoord, this.zCoord) == BleachBlocks.seeleSchneiderBlock && this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord + x) == BleachBlocks.seeleSchneiderBlock && this.worldObj.getBlock(this.xCoord + x, this.yCoord, this.zCoord + x) == BleachBlocks.seeleSchneiderBlock) {
                this.setBlockMain(this.xCoord + x, this.yCoord, this.zCoord, this.xCoord, this.yCoord, this.zCoord);
                this.setBlockMain(this.xCoord, this.yCoord, this.zCoord + x, this.xCoord, this.yCoord, this.zCoord);
                this.setBlockMain(this.xCoord + x, this.yCoord, this.zCoord + x, this.xCoord, this.yCoord, this.zCoord);
                this.setMain(x);
                return;
            }
            if (this.worldObj.getBlock(this.xCoord - x, this.yCoord, this.zCoord) == BleachBlocks.seeleSchneiderBlock && this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord - x) == BleachBlocks.seeleSchneiderBlock && this.worldObj.getBlock(this.xCoord - x, this.yCoord, this.zCoord - x) == BleachBlocks.seeleSchneiderBlock) {
                this.setBlockMain(this.xCoord - x, this.yCoord, this.zCoord, this.xCoord - x, this.yCoord, this.zCoord - x);
                this.setBlockMain(this.xCoord, this.yCoord, this.zCoord - x, this.xCoord - x, this.yCoord, this.zCoord - x);
                this.setBlockMain(this.xCoord, this.yCoord, this.zCoord - x, this.xCoord - x, this.yCoord, this.zCoord - x);
                final TileSeeleSchneider tile = (TileSeeleSchneider)this.worldObj.getTileEntity(this.xCoord - x, this.yCoord, this.zCoord - x);
                tile.setMain(x);
                return;
            }
            if (this.worldObj.getBlock(this.xCoord - x, this.yCoord, this.zCoord) == BleachBlocks.seeleSchneiderBlock && this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord + x) == BleachBlocks.seeleSchneiderBlock && this.worldObj.getBlock(this.xCoord - x, this.yCoord, this.zCoord + x) == BleachBlocks.seeleSchneiderBlock) {
                this.setBlockMain(this.xCoord - x, this.yCoord, this.zCoord, this.xCoord - x, this.yCoord, this.zCoord);
                this.setBlockMain(this.xCoord, this.yCoord, this.zCoord, this.xCoord - x, this.yCoord, this.zCoord);
                this.setBlockMain(this.xCoord - x, this.yCoord, this.zCoord + x, this.xCoord - x, this.yCoord, this.zCoord);
                final TileSeeleSchneider tile = (TileSeeleSchneider)this.worldObj.getTileEntity(this.xCoord - x, this.yCoord, this.zCoord);
                tile.setMain(x);
                return;
            }
            if (this.worldObj.getBlock(this.xCoord + x, this.yCoord, this.zCoord) == BleachBlocks.seeleSchneiderBlock && this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord - x) == BleachBlocks.seeleSchneiderBlock && this.worldObj.getBlock(this.xCoord + x, this.yCoord, this.zCoord - x) == BleachBlocks.seeleSchneiderBlock) {
                this.setBlockMain(this.xCoord + x, this.yCoord, this.zCoord, this.xCoord, this.yCoord, this.zCoord - x);
                this.setBlockMain(this.xCoord, this.yCoord, this.zCoord, this.xCoord, this.yCoord, this.zCoord - x);
                this.setBlockMain(this.xCoord + x, this.yCoord, this.zCoord - x, this.xCoord, this.yCoord, this.zCoord - x);
                final TileSeeleSchneider tile = (TileSeeleSchneider)this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord - x);
                tile.setMain(x);
                return;
            }
        }
    }
    
    public void setMain(final int side) {
        this.isMain = true;
        this.side = side;
        TileSeeleSchneider.magicSquare.add(new ChunkCoordinates(this.xCoord, this.yCoord, this.zCoord));
        FMLLog.info("[Bleach mod] Main Seeleschneider, side: " + side, new Object[0]);
    }
    
    private void setBlockMain(final int x, final int y, final int z, final int i, final int j, final int k) {
        final TileSeeleSchneider tile = (TileSeeleSchneider)this.worldObj.getTileEntity(x, y, z);
        tile.mainBlock = new ChunkCoordinates(i, j, k);
    }
    
    public void readFromNBT(final NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        this.isMain = nbt.getBoolean("isMain");
        this.side = nbt.getInteger("side");
        final int x = nbt.getInteger("xMain");
        final int y = nbt.getInteger("yMain");
        final int z = nbt.getInteger("zMain");
        if (x != 0 && y != 0 && z != 0) {
            this.mainBlock = new ChunkCoordinates(x, y, z);
        }
    }
    
    public void writeToNBT(final NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setBoolean("isMain", this.isMain);
        nbt.setInteger("side", this.side);
        nbt.setInteger("xMain", this.mainBlock.posX);
        nbt.setInteger("yMain", this.mainBlock.posY);
        nbt.setInteger("zMain", this.mainBlock.posZ);
    }
    
    public TileSeeleSchneider getMainBlockTile() {
    	if (this.worldObj.getTileEntity(this.mainBlock.posX, this.mainBlock.posY, this.mainBlock.posZ) instanceof TileSeeleSchneider) {
    		return (TileSeeleSchneider) this.worldObj.getTileEntity(this.mainBlock.posX, this.mainBlock.posY, this.mainBlock.posZ);
    	}
		return null;
    }
    
    static {
        TileSeeleSchneider.magicSquare = new ArrayList<ChunkCoordinates>();
    }
}

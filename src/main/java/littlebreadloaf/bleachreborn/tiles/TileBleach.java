package littlebreadloaf.bleachreborn.tiles;

import net.minecraft.tileentity.*;
import net.minecraft.entity.player.*;
import net.minecraft.network.play.server.*;
import net.minecraft.nbt.*;
import net.minecraft.network.*;

public class TileBleach extends TileEntity
{
    public boolean isUseableByPlayer(final EntityPlayer player) {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) == this && player.getDistanceSq(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5) < 6.0;
    }
    
    public void onDataPacket(final NetworkManager net, final S35PacketUpdateTileEntity pkt) {
        final NBTTagCompound nbt = pkt.func_148857_g();
        this.readFromNBT(nbt);
    }
    
    public Packet getDescriptionPacket() {
        final NBTTagCompound nbt = new NBTTagCompound();
        this.writeToNBT(nbt);
        return (Packet)new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 0, nbt);
    }
}

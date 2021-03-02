package littlebreadloaf.bleachreborn.tiles;

import littlebreadloaf.bleachreborn.events.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.player.*;

public class TileSphereLamp extends TileBleach
{
    private String owner;
    byte tick;
    public ExtendedPlayer props;
    
    public TileSphereLamp() {
        this.tick = 0;
        this.props = null;
    }
    
    public void updateEntity() {
        ++this.tick;
        if (this.tick > 20) {
            this.tick -= 20;
        }
        if (this.getOwnerEntity() != null) {
            this.props = (ExtendedPlayer)this.getOwnerEntity().getExtendedProperties("BleachPlayer");
        }
        if (!this.worldObj.isRemote && this.tick == 20 && this.props != null) {
            this.props.consumeEnergy(1);
        }
        super.updateEntity();
    }
    
    public void readFromNBT(final NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        this.owner = nbt.getString("owner");
    }
    
    public void writeToNBT(final NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setString("owner", this.owner);
    }
    
    public void setOwner(final String owner) {
        this.owner = owner;
    }
    
    public void setOwnerEntity(final EntityPlayer owner) {
        this.owner = owner.getCommandSenderName();
    }
    
    public String getOwner() {
        return this.owner;
    }
    
    public EntityPlayer getOwnerEntity() {
        return this.worldObj.getPlayerEntityByName(this.owner);
    }
}

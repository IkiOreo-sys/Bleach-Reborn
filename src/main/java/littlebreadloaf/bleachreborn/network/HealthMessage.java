package littlebreadloaf.bleachreborn.network;

import cpw.mods.fml.common.network.simpleimpl.*;
import io.netty.buffer.*;

public class HealthMessage implements IMessage
{
    public int simpleInt;
    public boolean simpleBool;
    
    public HealthMessage() {
    }
    
    public HealthMessage(final int simpleInt, final boolean simpleBool) {
        this.simpleInt = simpleInt;
        this.simpleBool = simpleBool;
    }
    
    public void fromBytes(final ByteBuf buf) {
        this.simpleInt = buf.readInt();
        this.simpleBool = buf.readBoolean();
    }
    
    public void toBytes(final ByteBuf buf) {
        buf.writeInt(this.simpleInt);
        buf.writeBoolean(this.simpleBool);
    }
}

package littlebreadloaf.bleachreborn.network;

import io.netty.buffer.*;
import cpw.mods.fml.common.network.simpleimpl.*;
import littlebreadloaf.bleachreborn.*;
import net.minecraft.entity.player.*;

public class MoveMessage implements IMessage
{
    private int distance;
    
    public MoveMessage() {
    }
    
    public MoveMessage(final int distance) {
        this.distance = distance;
    }
    
    public void fromBytes(final ByteBuf buf) {
        this.distance = buf.readInt();
    }
    
    public void toBytes(final ByteBuf buf) {
        buf.writeInt(this.distance);
    }
    
    public static class Handler implements IMessageHandler<MoveMessage, IMessage>
    {
        public IMessage onMessage(final MoveMessage message, final MessageContext ctx) {
            final EntityPlayer player = BleachMod.proxy.getPlayerFromMessage(ctx);
            player.moveEntity(message.distance * Math.cos(-player.rotationPitch * 0.017453292519943295) * Math.sin(-player.rotationYaw * 0.017453292519943295), message.distance * Math.sin(-player.rotationPitch * 0.017453292519943295), message.distance * Math.cos(-player.rotationPitch * 0.017453292519943295) * Math.cos(-player.rotationYaw * 0.017453292519943295));
            return null;
        }
    }
}

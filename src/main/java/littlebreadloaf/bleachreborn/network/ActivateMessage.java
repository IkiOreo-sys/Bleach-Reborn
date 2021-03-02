package littlebreadloaf.bleachreborn.network;

import io.netty.buffer.*;
import cpw.mods.fml.common.network.simpleimpl.*;
import littlebreadloaf.bleachreborn.events.*;
import net.minecraft.entity.player.*;

public class ActivateMessage implements IMessage
{
    private int id;
    
    public ActivateMessage() {
    }
    
    public ActivateMessage(final int id) {
        this.id = id;
    }
    
    public void fromBytes(final ByteBuf buf) {
        this.id = buf.readInt();
    }
    
    public void toBytes(final ByteBuf buf) {
        buf.writeInt(this.id);
    }
    
    public static class Handler implements IMessageHandler<ActivateMessage, IMessage>
    {
        public IMessage onMessage(final ActivateMessage message, final MessageContext ctx) {
            final ExtendedPlayer props = ExtendedPlayer.get((EntityPlayer)ctx.getServerHandler().playerEntity);
            if (ctx.getServerHandler().playerEntity.getHeldItem() != null) {
                props.activate(ctx.getServerHandler().playerEntity.getHeldItem());
            }
            return null;
        }
    }
}

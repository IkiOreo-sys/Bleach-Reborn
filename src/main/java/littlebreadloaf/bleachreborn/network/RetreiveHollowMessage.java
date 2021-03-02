package littlebreadloaf.bleachreborn.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;

import javax.annotation.Nonnull;
import java.util.UUID;

public class RetreiveHollowMessage implements IMessage
{
    public boolean toggle;
    public long uuid;
    public RetreiveHollowMessage() {
    }
    
    public RetreiveHollowMessage(final boolean toggle, @Nonnull final UUID uuid) {
        this.toggle = toggle;
        this.uuid = uuid.getMostSignificantBits();
    }

    @Override
    public void fromBytes(final ByteBuf buf) {
        this.toggle = buf.readBoolean();
        this.uuid = buf.readLong();
    }

    @Override
    public void toBytes(final ByteBuf buf) {
        buf.writeBoolean(this.toggle);
        buf.writeLong(this.uuid);
    }
    
    public static class Handler implements IMessageHandler<RetreiveHollowMessage, IMessage>
    {
        public IMessage onMessage(final RetreiveHollowMessage message, final MessageContext ctx) {
            //PacketDispatcher.sendToAll(new HollowRenderableMessage(true, message.uuid));
            return null;
        }
    }
}
package littlebreadloaf.bleachreborn.network;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import littlebreadloaf.bleachreborn.ConfigHandler;

import java.util.UUID;

public class HollowRenderableMessage implements IMessage
{
    public boolean toggle;
    public long uuid;
    public HollowRenderableMessage() {
    }

    public HollowRenderableMessage(final boolean toggle, final long uuid) {
        this.toggle = toggle;
        this.uuid = uuid;
    }

    public void fromBytes(final ByteBuf buf) {
        this.toggle = buf.readBoolean();
        this.uuid = buf.readLong();
    }

    public void toBytes(final ByteBuf buf) {
        buf.writeBoolean(this.toggle);
        buf.writeLong(this.uuid);
    }
    
    public static class Handler implements IMessageHandler<HollowRenderableMessage, IMessage>
    {
        public IMessage onMessage(final HollowRenderableMessage message, final MessageContext ctx) {
            ConfigHandler.renderHollowMap.put(message.uuid, message.toggle);
            ConfigHandler.save();
            return null;
        }
    }
}
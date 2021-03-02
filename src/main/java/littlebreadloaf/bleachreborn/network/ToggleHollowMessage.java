package littlebreadloaf.bleachreborn.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import littlebreadloaf.bleachreborn.ConfigHandler;

public class ToggleHollowMessage implements IMessage
{
    public boolean toggle;
    
    public ToggleHollowMessage() {
    }

    public ToggleHollowMessage(final boolean toggle) {
        this.toggle = toggle;
    }
    
    public void fromBytes(final ByteBuf buf) {
        this.toggle = buf.readBoolean();
    }
    
    public void toBytes(final ByteBuf buf) {
        buf.writeBoolean(this.toggle);
    }
    
    public static class Handler implements IMessageHandler<ToggleHollowMessage, IMessage>
    {
        public IMessage onMessage(final ToggleHollowMessage message, final MessageContext ctx) {
            ConfigHandler.renderHollow = message.toggle;
            ConfigHandler.setRenderHollow(message.toggle);
            ConfigHandler.save();
            return null;
        }
    }
}
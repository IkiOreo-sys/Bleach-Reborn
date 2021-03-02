package littlebreadloaf.bleachreborn.network;

import io.netty.buffer.*;
import cpw.mods.fml.common.network.simpleimpl.*;
import littlebreadloaf.bleachreborn.events.*;
import net.minecraft.entity.player.*;

public class FlashMessage implements IMessage
{
    private int id;
    
    public FlashMessage() {
    }
    
    public FlashMessage(final int id) {
        this.id = id;
    }
    
    public void fromBytes(final ByteBuf buf) {
        this.id = buf.readInt();
    }
    
    public void toBytes(final ByteBuf buf) {
        buf.writeInt(this.id);
    }
    
    public static class Handler implements IMessageHandler<FlashMessage, IMessage>
    {
        public IMessage onMessage(final FlashMessage message, final MessageContext ctx) {
            final ExtendedPlayer props = ExtendedPlayer.get((EntityPlayer)ctx.getServerHandler().playerEntity);
            props.decideWhatToDo(message.id);
            return null;
        }
    }
}

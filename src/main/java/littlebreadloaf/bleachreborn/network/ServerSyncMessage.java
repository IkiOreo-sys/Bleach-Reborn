package littlebreadloaf.bleachreborn.network;

import net.minecraft.nbt.*;
import net.minecraft.entity.player.*;
import littlebreadloaf.bleachreborn.events.*;
import io.netty.buffer.*;
import cpw.mods.fml.common.network.*;
import cpw.mods.fml.common.network.simpleimpl.*;
import littlebreadloaf.bleachreborn.*;

public class ServerSyncMessage implements IMessage
{
    private NBTTagCompound data;
    
    public ServerSyncMessage() {
    }
    
    public ServerSyncMessage(final EntityPlayer player) {
        this.data = new NBTTagCompound();
        ExtendedPlayer.get(player).saveNBTData(this.data);
    }
    
    public void fromBytes(final ByteBuf buf) {
        this.data = ByteBufUtils.readTag(buf);
    }
    
    public void toBytes(final ByteBuf buf) {
        ByteBufUtils.writeTag(buf, this.data);
    }
    
    public static class Handler implements IMessageHandler<ServerSyncMessage, IMessage>
    {
        public IMessage onMessage(final ServerSyncMessage message, final MessageContext ctx) {
            final EntityPlayer player = BleachMod.proxy.getPlayerFromMessage(ctx);
            final ExtendedPlayer props = ExtendedPlayer.get(BleachMod.proxy.getPlayerFromMessage(ctx));
            props.loadNBTData(message.data);
            return null;
        }
    }
}

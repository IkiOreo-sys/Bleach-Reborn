package littlebreadloaf.bleachreborn.network;

import io.netty.buffer.*;
import cpw.mods.fml.common.network.simpleimpl.*;
import littlebreadloaf.bleachreborn.*;
import littlebreadloaf.bleachreborn.events.*;
import cpw.mods.fml.common.network.internal.*;
import net.minecraft.entity.player.*;

public class GuiMessage implements IMessage
{
    private int id;
    
    public GuiMessage() {
    }
    
    public GuiMessage(final int id) {
        this.id = id;
    }
    
    public void fromBytes(final ByteBuf buf) {
        this.id = buf.readInt();
    }
    
    public void toBytes(final ByteBuf buf) {
        buf.writeInt(this.id);
    }
    
    public static class Handler implements IMessageHandler<GuiMessage, IMessage>
    {
        public IMessage onMessage(final GuiMessage message, final MessageContext ctx) {
            final EntityPlayer player = BleachMod.proxy.getPlayerFromMessage(ctx);
            final ExtendedPlayer props = ExtendedPlayer.get(player);
            System.out.println(player.worldObj.isRemote);
            FMLNetworkHandler.openGui(player, (Object)BleachMod.instance, message.id, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
            return null;
        }
    }
}

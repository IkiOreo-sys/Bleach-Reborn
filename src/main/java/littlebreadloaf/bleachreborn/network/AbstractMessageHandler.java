package littlebreadloaf.bleachreborn.network;

import net.minecraft.entity.player.*;
import cpw.mods.fml.common.network.simpleimpl.*;
import cpw.mods.fml.relauncher.*;
import littlebreadloaf.bleachreborn.BleachMod;

public abstract class AbstractMessageHandler<T extends IMessage> implements IMessageHandler<T, IMessage>
{
    @SideOnly(Side.CLIENT)
    public abstract IMessage handleClientMessage(final EntityPlayer p0, final T p1, final MessageContext p2);
    
    public abstract IMessage handleServerMessage(final EntityPlayer p0, final T p1, final MessageContext p2);
    
    public IMessage onMessage(final T message, final MessageContext ctx) {
        if (ctx.side.isClient()) {
            return this.handleClientMessage(BleachMod.proxy.getPlayerFromMessage(ctx), message, ctx);
        }
        return this.handleServerMessage(BleachMod.proxy.getPlayerFromMessage(ctx), message, ctx);
    }
}

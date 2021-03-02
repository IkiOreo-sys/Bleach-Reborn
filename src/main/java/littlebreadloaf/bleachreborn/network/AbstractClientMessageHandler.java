package littlebreadloaf.bleachreborn.network;

import net.minecraft.entity.player.*;
import cpw.mods.fml.common.network.simpleimpl.*;

public abstract class AbstractClientMessageHandler<T extends IMessage> extends AbstractMessageHandler<T>
{
    @Override
    public final IMessage handleServerMessage(final EntityPlayer player, final T message, final MessageContext ctx) {
        return null;
    }
}

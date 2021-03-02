package littlebreadloaf.bleachreborn.network;

import net.minecraft.entity.player.*;
import cpw.mods.fml.common.network.simpleimpl.*;

public abstract class AbstractServerMessageHandler<T extends IMessage> extends AbstractMessageHandler<T>
{
    @Override
    public final IMessage handleClientMessage(final EntityPlayer player, final T message, final MessageContext ctx) {
        return null;
    }
}

package littlebreadloaf.bleachreborn.network;

import cpw.mods.fml.common.network.simpleimpl.*;

public class MessageHealth implements IMessageHandler<HealthMessage, IMessage>
{
    public IMessage onMessage(final HealthMessage message, final MessageContext ctx) {
        if (ctx.side.isClient()) {
            final int integer = message.simpleInt;
            final boolean simpleBool = message.simpleBool;
        }
        return (IMessage)message;
    }
}

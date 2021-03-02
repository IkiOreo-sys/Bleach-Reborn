package littlebreadloaf.bleachreborn.network;

import cpw.mods.fml.relauncher.*;
import littlebreadloaf.bleachreborn.network.AbstractMessage.AbstractClientMessage;
import cpw.mods.fml.common.network.simpleimpl.*;
import cpw.mods.fml.common.network.*;
import net.minecraft.entity.player.*;
import java.util.*;

public class PacketDispatcher
{
    private static byte packetId = 0;
    private static final SimpleNetworkWrapper dispatcher = NetworkRegistry.INSTANCE.newSimpleChannel("BleachChannel");
    
    
    public static final void registerPackets() {
        registerMessage((Class)ServerSyncMessage.Handler.class, (Class)ServerSyncMessage.class, Side.SERVER);
        registerMessage((Class)ClientSyncMessage.Handler.class, (Class)ClientSyncMessage.class, Side.CLIENT);
        registerMessage(ToggleHollowMessage.Handler.class, ToggleHollowMessage.class, Side.CLIENT);
        registerMessage(RetreiveHollowMessage.Handler.class, RetreiveHollowMessage.class, Side.SERVER);
        registerMessage((Class)ActivateMessage.Handler.class, (Class)ActivateMessage.class, Side.SERVER);
        registerMessage((Class)DeactivateMessage.Handler.class, (Class)DeactivateMessage.class, Side.SERVER);
        registerMessage((Class)FlashMessage.Handler.class, (Class)FlashMessage.class, Side.SERVER);
        registerMessage((Class)ParticleMessage.Handler.class, (Class)ParticleMessage.class, Side.CLIENT);
        registerMessage((Class)MoveMessage.Handler.class, (Class)MoveMessage.class, Side.CLIENT);
        registerMessage((Class)GuiMessage.Handler.class, (Class)GuiMessage.class, Side.CLIENT);
        registerMessage((Class)HollowPieceMessage.Handler.class, (Class)HollowPieceMessage.class, Side.SERVER);
        registerMessage((Class)CeroMessage.Handler.class, (Class)CeroMessage.class, Side.SERVER);
        registerMessage(MessageHealth.class, HealthMessage.class, 21);

    }
    
    private static final void registerMessage(final Class handlerClass, final Class messageClass, final Side side) {
        final SimpleNetworkWrapper dispatcher = PacketDispatcher.dispatcher;
        final byte packetId = PacketDispatcher.packetId;
        PacketDispatcher.packetId = (byte)(packetId + 1);
        dispatcher.registerMessage(handlerClass, messageClass, (int)packetId, side);
    }
    private static void registerMessage(final Class packet, final Class message, int packetid) {
        dispatcher.registerMessage(packet, message, packetid, Side.CLIENT);
        dispatcher.registerMessage(packet, message, packetid, Side.SERVER);
    }
    
    private static final <T extends AbstractMessage> void registerMessage(final Class<T> clazz) {
        if (AbstractClientMessage.class.isAssignableFrom((Class<?>)clazz)) {
            final SimpleNetworkWrapper dispatcher = PacketDispatcher.dispatcher;
            final byte packetId = PacketDispatcher.packetId;
            PacketDispatcher.packetId = (byte)(packetId + 1);
            dispatcher.registerMessage((Class)clazz, (Class)clazz, (int)packetId, Side.CLIENT);
        }
        else if (AbstractMessage.AbstractServerMessage.class.isAssignableFrom((Class<?>)clazz)) {
            final SimpleNetworkWrapper dispatcher2 = PacketDispatcher.dispatcher;
            final byte packetId2 = PacketDispatcher.packetId;
            PacketDispatcher.packetId = (byte)(packetId2 + 1);
            dispatcher2.registerMessage((Class)clazz, (Class)clazz, (int)packetId2, Side.SERVER);
        }
        else {
            PacketDispatcher.dispatcher.registerMessage((Class)clazz, (Class)clazz, (int)PacketDispatcher.packetId, Side.CLIENT);
            final SimpleNetworkWrapper dispatcher3 = PacketDispatcher.dispatcher;
            final byte packetId3 = PacketDispatcher.packetId;
            PacketDispatcher.packetId = (byte)(packetId3 + 1);
            dispatcher3.registerMessage((Class)clazz, (Class)clazz, (int)packetId3, Side.SERVER);
        }
    }
    
    public static final void sendTo(final IMessage message, final EntityPlayerMP player) {
        PacketDispatcher.dispatcher.sendTo(message, player);
    }
    
    public static void sendToAll(final IMessage message) {
        PacketDispatcher.dispatcher.sendToAll(message);
    }
    
    public static final void sendToAllAround(final IMessage message, final NetworkRegistry.TargetPoint point) {
        PacketDispatcher.dispatcher.sendToAllAround(message, point);
    }
    
    public static final void sendToAllAround(final IMessage message, final int dimension, final double x, final double y, final double z, final double range) {
        sendToAllAround(message, new NetworkRegistry.TargetPoint(dimension, x, y, z, range));
    }
    
    public static final void sendToAllAround(final IMessage message, final EntityPlayer player, final double range) {
        sendToAllAround(message, player.worldObj.provider.dimensionId, player.posX, player.posY, player.posZ, range);
    }
    
    public static final void sendToDimension(final IMessage message, final int dimensionId) {
        PacketDispatcher.dispatcher.sendToDimension(message, dimensionId);
    }
    
    public static final void sendToServer(final IMessage message) {
        PacketDispatcher.dispatcher.sendToServer(message);
    }
    
    public static final void sendToPlayers(final IMessage message, final Set<EntityPlayer> players) {
        for (final EntityPlayer player : players) {
            PacketDispatcher.dispatcher.sendTo(message, (EntityPlayerMP)player);
        }
    }
}

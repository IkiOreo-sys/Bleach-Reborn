package littlebreadloaf.bleachreborn.network;

import net.minecraft.network.*;
import java.io.*;
import net.minecraft.entity.player.*;
import cpw.mods.fml.relauncher.*;
import io.netty.buffer.*;
import littlebreadloaf.bleachreborn.BleachMod;

import com.google.common.base.*;
import cpw.mods.fml.common.network.simpleimpl.*;

public abstract class AbstractMessage<T extends AbstractMessage<T>> implements IMessage, IMessageHandler<T, IMessage>
{
    protected abstract void read(final PacketBuffer p0) throws IOException;
    
    protected abstract void write(final PacketBuffer p0) throws IOException;
    
    public abstract void process(final EntityPlayer p0, final Side p1);
    
    protected boolean isValidOnSide(final Side side) {
        return true;
    }
    
    protected boolean requiresMainThread() {
        return true;
    }
    
    public void fromBytes(final ByteBuf buffer) {
        try {
            this.read(new PacketBuffer(buffer));
        }
        catch (IOException e) {
            throw Throwables.propagate((Throwable)e);
        }
    }
    
    public void toBytes(final ByteBuf buffer) {
        try {
            this.write(new PacketBuffer(buffer));
        }
        catch (IOException e) {
            throw Throwables.propagate((Throwable)e);
        }
    }
    
    public final IMessage onMessage(final T msg, final MessageContext ctx) {
        if (!msg.isValidOnSide(ctx.side)) {
            throw new RuntimeException("Invalid side " + ctx.side.name() + " for " + msg.getClass().getSimpleName());
        }
        msg.process(BleachMod.proxy.getPlayerFromMessage(ctx), ctx.side);
        return null;
    }
    
    public abstract static class AbstractClientMessage<T extends AbstractMessage<T>> extends AbstractMessage<T>
    {
        @Override
        protected final boolean isValidOnSide(final Side side) {
            return side.isClient();
        }
    }
    
    public abstract static class AbstractServerMessage<T extends AbstractMessage<T>> extends AbstractMessage<T>
    {
        @Override
        protected final boolean isValidOnSide(final Side side) {
            return side.isServer();
        }
    }
}

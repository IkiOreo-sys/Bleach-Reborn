package littlebreadloaf.bleachreborn.network;

import io.netty.buffer.*;
import cpw.mods.fml.common.network.simpleimpl.*;
import littlebreadloaf.bleachreborn.*;
import littlebreadloaf.bleachreborn.events.*;
import littlebreadloaf.bleachreborn.entities.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;

public class CeroMessage implements IMessage
{
    private int id;
    
    public CeroMessage() {
    }
    
    public CeroMessage(final int id) {
        this.id = id;
    }
    
    public void fromBytes(final ByteBuf buf) {
        this.id = buf.readInt();
    }
    
    public void toBytes(final ByteBuf buf) {
        buf.writeInt(this.id);
    }
    
    public static class Handler implements IMessageHandler<CeroMessage, IMessage>
    {
        public IMessage onMessage(final CeroMessage message, final MessageContext ctx) {
            final EntityPlayer player = BleachMod.proxy.getPlayerFromMessage(ctx);
            final ExtendedPlayer props = ExtendedPlayer.get(player);
            if (props.getFaction() == 4 && props.getCurrentEnergy() * props.getCurrentCap() > 50.0f) {
                final EntityCero entityCero = new EntityCero(player.worldObj, (EntityLivingBase)player, 2.0f);
                player.worldObj.spawnEntityInWorld((Entity)entityCero);
            }
            return null;
        }
    }
}

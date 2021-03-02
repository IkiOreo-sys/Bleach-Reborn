package littlebreadloaf.bleachreborn.network;

import io.netty.buffer.*;
import cpw.mods.fml.common.network.simpleimpl.*;
import littlebreadloaf.bleachreborn.events.*;
import net.minecraft.entity.player.*;

public class HollowPieceMessage implements IMessage
{
    private int part;
    private int choice;
    private int points;
    
    public HollowPieceMessage() {
    }
    
    public HollowPieceMessage(final int part, final int choice, final int points) {
        this.part = part;
        this.choice = choice;
        this.points = points;
    }
    
    public void fromBytes(final ByteBuf buf) {
        this.part = buf.readInt();
        this.choice = buf.readInt();
        this.points = buf.readInt();
    }
    
    public void toBytes(final ByteBuf buf) {
        buf.writeInt(this.part);
        buf.writeInt(this.choice);
        buf.writeInt(this.points);
    }
    
    public static class Handler implements IMessageHandler<HollowPieceMessage, IMessage>
    {
        public IMessage onMessage(final HollowPieceMessage message, final MessageContext ctx) {
            final ExtendedPlayer props = ExtendedPlayer.get((EntityPlayer)ctx.getServerHandler().playerEntity);
            props.subtractCurrentHPoints(message.points);
            switch (message.part) {
                case 0: {
                    props.setHead(message.choice);
                    break;
                }
                case 1: {
                    props.setBack(message.choice);
                    break;
                }
                case 2: {
                    props.setArms(message.choice);
                    break;
                }
                case 3: {
                    props.setTail(message.choice);
                    break;
                }
                case 4: {
                    props.setLegs(message.choice);
                    break;
                }
                case 5: {
                    props.setHColor(message.choice);
                    break;
                }
            }
            return null;
        }
    }
}

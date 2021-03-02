package littlebreadloaf.bleachreborn.commands;

import net.minecraft.command.*;
import littlebreadloaf.bleachreborn.events.*;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.util.*;
import littlebreadloaf.bleachreborn.network.*;
import cpw.mods.fml.common.network.simpleimpl.*;
import net.minecraft.entity.player.*;

public class CommandResetHollow extends CommandBase
{
    public String getCommandName() {
        return "resethollow";
    }
    
    public int getRequiredPermissionLevel() {
        return 0;
    }
    
    public void processCommand(final ICommandSender par1ICommandSender, final String[] par2ArrayOfStr) {
        if(SrvCmd.testForServer(par1ICommandSender)) {
            DedicatedServer server = (DedicatedServer) par1ICommandSender;
            server.addChatMessage(new ChatComponentText("You cannot reset hollow of the server!"));
            return;
        }
        final EntityPlayer var3 = (EntityPlayer)getCommandSenderAsPlayer(par1ICommandSender);
        final ExtendedPlayer props = (ExtendedPlayer)var3.getExtendedProperties("BleachPlayer");
        props.setCapMin();
        props.setArms(0);
        props.setBack(0);
        props.setHColor(0);
        props.setHead(0);
        props.setHTex(0);
        props.setLegs(0);
        props.setMColor(0);
        props.setTail(0);
        props.setTotalHPoints(0);
        props.subtractCurrentHPoints(props.getCurrentHPoints());
        var3.addChatMessage((IChatComponent)new ChatComponentText("Resetting Hollow"));
        PacketDispatcher.sendTo((IMessage)new ClientSyncMessage(var3), (EntityPlayerMP)var3);
    }
    
    public String getCommandUsage(final ICommandSender icommandsender) {
        return "/resethollow";
    }
}

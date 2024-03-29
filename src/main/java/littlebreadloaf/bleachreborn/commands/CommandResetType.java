package littlebreadloaf.bleachreborn.commands;

import net.minecraft.command.*;
import littlebreadloaf.bleachreborn.events.*;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.util.*;
import littlebreadloaf.bleachreborn.network.*;
import cpw.mods.fml.common.network.simpleimpl.*;
import net.minecraft.entity.player.*;

public class CommandResetType extends CommandBase
{
    public String getCommandName() {
        return "resettype";
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
        props.resetType();
        var3.addChatMessage((IChatComponent)new ChatComponentText("Resetting zanpakuto type"));
        PacketDispatcher.sendTo((IMessage)new ClientSyncMessage(var3), (EntityPlayerMP)var3);
    }
    
    public String getCommandUsage(final ICommandSender icommandsender) {
        return "/resettype";
    }
}

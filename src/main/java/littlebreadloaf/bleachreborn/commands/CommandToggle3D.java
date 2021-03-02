package littlebreadloaf.bleachreborn.commands;

import net.minecraft.command.*;
import littlebreadloaf.bleachreborn.events.*;
import littlebreadloaf.bleachreborn.network.*;
import cpw.mods.fml.common.network.simpleimpl.*;
import net.minecraft.entity.player.*;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.util.ChatComponentText;

public class CommandToggle3D extends CommandBase
{
    public String getCommandName() {
        return "toggle3d";
    }
    
    public int getRequiredPermissionLevel() {
        return 0;
    }
    
    public void processCommand(final ICommandSender par1ICommandSender, final String[] par2ArrayOfStr) {
        if(SrvCmd.testForServer(par1ICommandSender)) {
            DedicatedServer server = (DedicatedServer) par1ICommandSender;
            server.addChatMessage(new ChatComponentText("You cannot Toggle3D on the server!"));
            return;
        }
        final EntityPlayer var3 = (EntityPlayer)getCommandSenderAsPlayer(par1ICommandSender);
        final ExtendedPlayer props = (ExtendedPlayer)var3.getExtendedProperties("BleachPlayer");
        if (ExtendedPlayer.getIs3D()) {
            ExtendedPlayer.set3D(false);
        }
        else {
            ExtendedPlayer.set3D(true);
        }
        PacketDispatcher.sendTo((IMessage)new ClientSyncMessage(var3), (EntityPlayerMP)var3);
    }
    
    public String getCommandUsage(final ICommandSender icommandsender) {
        return "/toggle3d";
    }
}

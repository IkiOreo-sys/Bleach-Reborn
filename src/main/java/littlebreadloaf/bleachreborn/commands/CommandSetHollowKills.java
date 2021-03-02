package littlebreadloaf.bleachreborn.commands;

import net.minecraft.command.*;
import littlebreadloaf.bleachreborn.events.*;
import net.minecraft.server.*;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.util.*;
import littlebreadloaf.bleachreborn.network.*;
import cpw.mods.fml.common.network.simpleimpl.*;
import net.minecraft.entity.player.*;

public class CommandSetHollowKills extends CommandBase
{
    public String getCommandName() {
        return "sethollowkills";
    }
    
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    public void processCommand(final ICommandSender par1ICommandSender, final String[] par2ArrayOfStr) {
        int var5 = 0;
        if(SrvCmd.testForServer(par1ICommandSender)) {
            DedicatedServer server = (DedicatedServer) par1ICommandSender;
            if(par2ArrayOfStr.length > 1) {
                EntityPlayer var6 = (EntityPlayer) MinecraftServer.getServer().getConfigurationManager().func_152612_a(par2ArrayOfStr[0]);
                final EntityPlayerMP entityplayermp = (EntityPlayerMP) var6;
                ExtendedPlayer props = (ExtendedPlayer) var6.getExtendedProperties("BleachPlayer");
                var5 = parseIntBounded(par1ICommandSender, par2ArrayOfStr[1], 1, 100000);
                server.addChatMessage((IChatComponent) new ChatComponentText("Setting " + par2ArrayOfStr[0] + "'s Hollow Kills to " + var5));
                props.setHollowKills(var5);
                var6.addChatMessage((IChatComponent) new ChatComponentText("Setting Hollow Kills to " + var5));
                PacketDispatcher.sendTo((IMessage) new ClientSyncMessage(var6), (EntityPlayerMP) var6);
            } else
                server.addChatMessage(new ChatComponentText("You need to specify what player you want to set hollow kills to!"));
        } else {
            EntityPlayer var6 = (EntityPlayer) getCommandSenderAsPlayer(par1ICommandSender);
            ExtendedPlayer props = (ExtendedPlayer) var6.getExtendedProperties("BleachPlayer");
            if(par2ArrayOfStr.length == 1) {
                var5 = parseIntBounded(par1ICommandSender, par2ArrayOfStr[0], 1, 100000);
            }
            if(par2ArrayOfStr.length > 1) {
                final EntityPlayerMP entityplayermp = (EntityPlayerMP) (var6 = (EntityPlayer) MinecraftServer.getServer().getConfigurationManager().func_152612_a(par2ArrayOfStr[0]));
                props = (ExtendedPlayer) var6.getExtendedProperties("BleachPlayer");
                var5 = parseIntBounded(par1ICommandSender, par2ArrayOfStr[1], 1, 100000);
                getCommandSenderAsPlayer(par1ICommandSender).addChatMessage((IChatComponent) new ChatComponentText("Setting " + par2ArrayOfStr[0] + "'s Hollow Kills to " + var5));
            }
            props.setHollowKills(var5);
            var6.addChatMessage((IChatComponent) new ChatComponentText("Setting Hollow Kills to " + var5));
            PacketDispatcher.sendTo((IMessage) new ClientSyncMessage(var6), (EntityPlayerMP) var6);
        }
    }
    
    public String getCommandUsage(final ICommandSender icommandsender) {
        return "/sethollowkills {username} <amount>";
    }
}

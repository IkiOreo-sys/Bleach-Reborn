package littlebreadloaf.bleachreborn.commands;

import net.minecraft.command.*;
import littlebreadloaf.bleachreborn.events.*;
import net.minecraft.server.*;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.util.*;
import littlebreadloaf.bleachreborn.network.*;
import cpw.mods.fml.common.network.simpleimpl.*;
import net.minecraft.entity.player.*;

public class CommandSetSpirit extends CommandBase
{
    public String getCommandName() {
        return "setspirit";
    }
    
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    public void processCommand(final ICommandSender par1ICommandSender, final String[] par2ArrayOfStr) {
        int var5 = 50;
        if(SrvCmd.testForServer(par1ICommandSender)) {
            DedicatedServer server = (DedicatedServer) par1ICommandSender;
            if(par2ArrayOfStr.length > 1) {
                EntityPlayerMP var6 = MinecraftServer.getServer().getConfigurationManager().func_152612_a(par2ArrayOfStr[0]);
                ExtendedPlayer props = (ExtendedPlayer) var6.getExtendedProperties("BleachPlayer");
                var5 = parseIntBounded(par1ICommandSender, par2ArrayOfStr[1], 50, 25000);
                getCommandSenderAsPlayer(par1ICommandSender).addChatMessage((IChatComponent) new ChatComponentText("Setting " + par2ArrayOfStr[0] + "'s Spiritual Energy to " + var5));
                props.setMaxCap(var5);
                var6.addChatMessage(new ChatComponentText("Setting Spiritual Energy to " + var5));
                PacketDispatcher.sendTo(new ClientSyncMessage(var6), var6);
            } else
                server.addChatMessage(new ChatComponentText("You need to specify what player you want to set spirits to!"));
        } else {
            EntityPlayerMP var6 = getCommandSenderAsPlayer(par1ICommandSender);
            ExtendedPlayer props = (ExtendedPlayer) var6.getExtendedProperties("BleachPlayer");
            if(par2ArrayOfStr.length == 1) {
                var5 = parseIntBounded(par1ICommandSender, par2ArrayOfStr[0], 50, 25000);
            }
            if(par2ArrayOfStr.length > 1) {
                var6 = MinecraftServer.getServer().getConfigurationManager().func_152612_a(par2ArrayOfStr[0]);
                props = (ExtendedPlayer) var6.getExtendedProperties("BleachPlayer");
                var5 = parseIntBounded(par1ICommandSender, par2ArrayOfStr[1], 50, 25000);
                getCommandSenderAsPlayer(par1ICommandSender).addChatMessage(new ChatComponentText("Setting " + par2ArrayOfStr[0] + "'s Spiritual Energy to " + var5));
            }
            props.setMaxCap(var5);
            var6.addChatMessage(new ChatComponentText("Setting Spiritual Energy to " + var5));
            PacketDispatcher.sendTo(new ClientSyncMessage(var6), var6);
        }
    }
    
    public String getCommandUsage(final ICommandSender icommandsender) {
        return "/setspirit {username} <amount>";
    }
}

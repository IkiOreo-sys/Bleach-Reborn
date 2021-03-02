package littlebreadloaf.bleachreborn.commands;

import net.minecraft.command.*;
import littlebreadloaf.bleachreborn.events.*;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.util.*;
import net.minecraft.server.*;
import littlebreadloaf.bleachreborn.network.*;
import cpw.mods.fml.common.network.simpleimpl.*;
import net.minecraft.entity.player.*;
import java.util.*;

public class CommandAddKidoPoints extends CommandBase
{
    public String getCommandName() {
        return "addkidopoints";
    }
    
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    public void processCommand(final ICommandSender par1ICommandSender, final String[] par2ArrayOfStr) {
        if(par2ArrayOfStr.length < 1)
            return;
        if(SrvCmd.testForServer(par1ICommandSender)) {
            DedicatedServer server = (DedicatedServer) par1ICommandSender;
            if(par2ArrayOfStr.length > 1) {
                EntityPlayer var3 = (EntityPlayer) MinecraftServer.getServer().getConfigurationManager().func_152612_a(par2ArrayOfStr[0]);
                final EntityPlayerMP entityplayermp = (EntityPlayerMP) var3;
                ExtendedPlayer props = (ExtendedPlayer) var3.getExtendedProperties("BleachPlayer");
                int faction = Integer.valueOf(par2ArrayOfStr[1]);
                props.setKidoPoints(props.getKidoPoints() + faction);
                var3.addChatMessage((IChatComponent) new ChatComponentText("Added " + faction + " Kido Points."));
                server.addChatMessage((IChatComponent) new ChatComponentText("Adding " + par2ArrayOfStr[1] + " Kido Points to " + par2ArrayOfStr[0]));
                PacketDispatcher.sendTo((IMessage) new ClientSyncMessage(var3), (EntityPlayerMP) var3);
            } else
                server.addChatMessage(new ChatComponentText("You need to specify which player you want to give kido points to!"));
        } else {
            EntityPlayer var3 = getCommandSenderAsPlayer(par1ICommandSender);
            ExtendedPlayer props = (ExtendedPlayer) var3.getExtendedProperties("BleachPlayer");
            int faction;
            if(par2ArrayOfStr.length == 1) {
                faction = Integer.valueOf(par2ArrayOfStr[0]);
                props.setFaction(faction);
                var3.addChatMessage(new ChatComponentText("Added " + faction + " Kido Points"));
            } else if(par2ArrayOfStr.length == 2) {
                var3 = (EntityPlayer) MinecraftServer.getServer().getConfigurationManager().func_152612_a(par2ArrayOfStr[0]);
                props = (ExtendedPlayer) var3.getExtendedProperties("BleachPlayer");
                faction = Integer.valueOf(par2ArrayOfStr[1]);
                props.setKidoPoints(props.getKidoPoints() + faction);
                var3.addChatMessage(new ChatComponentText("Added " + faction + " Kido Points"));
                getCommandSenderAsPlayer(par1ICommandSender).addChatMessage((IChatComponent) new ChatComponentText("Adding " + faction + " Kido Points to " + par2ArrayOfStr[0]));
            }
            PacketDispatcher.sendTo(new ClientSyncMessage(var3), (EntityPlayerMP) var3);
        }
    }
    
    public String getCommandUsage(final ICommandSender icommandsender) {
        return "/addkidopoints {username} [number]";
    }
}

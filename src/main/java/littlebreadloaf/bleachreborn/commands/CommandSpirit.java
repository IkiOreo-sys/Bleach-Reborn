package littlebreadloaf.bleachreborn.commands;

import net.minecraft.command.*;
import net.minecraft.server.*;
import littlebreadloaf.bleachreborn.events.*;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.util.*;
import littlebreadloaf.bleachreborn.network.*;
import cpw.mods.fml.common.network.simpleimpl.*;
import net.minecraft.entity.player.*;

public class CommandSpirit extends CommandBase
{
    public String getCommandName() {
        return "spirit";
    }
    
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    public void processCommand(final ICommandSender par1ICommandSender, final String[] par2ArrayOfStr) {
        if(SrvCmd.testForServer(par1ICommandSender)) {
            DedicatedServer server = (DedicatedServer) par1ICommandSender;
            if(par2ArrayOfStr.length >= 1 && par2ArrayOfStr[0].length() > 0) {
                final EntityPlayer var3 = (EntityPlayer) MinecraftServer.getServer().getConfigurationManager().func_152612_a(par2ArrayOfStr[0]);
                final EntityPlayerMP entityplayermp = (EntityPlayerMP) var3;
                final ExtendedPlayer props = (ExtendedPlayer) var3.getExtendedProperties("BleachPlayer");
                props.setCurrentEnergy(1.0f);
                var3.addChatMessage((IChatComponent) new ChatComponentText("Full Spiritual Energy"));
                server.addChatMessage((IChatComponent) new ChatComponentText("Filling " + par2ArrayOfStr[0] + "'s Spiritual Energy"));
                PacketDispatcher.sendTo((IMessage) new ClientSyncMessage(var3), (EntityPlayerMP) var3);
            } else
                server.addChatMessage(new ChatComponentText("You need to specify what player to set Spiritual Energy on!"));
        } else {
            if(par2ArrayOfStr.length >= 1 && par2ArrayOfStr[0].length() > 0) {
                final EntityPlayer var3;
                final EntityPlayerMP entityplayermp = (EntityPlayerMP) (var3 = (EntityPlayer) MinecraftServer.getServer().getConfigurationManager().func_152612_a(par2ArrayOfStr[0]));
                final ExtendedPlayer props = (ExtendedPlayer) var3.getExtendedProperties("BleachPlayer");
                props.setCurrentEnergy(1.0f);
                var3.addChatMessage((IChatComponent) new ChatComponentText("Full Spiritual Energy"));
                getCommandSenderAsPlayer(par1ICommandSender).addChatMessage((IChatComponent) new ChatComponentText("Filling " + par2ArrayOfStr[0] + "'s Spiritual Energy"));
                PacketDispatcher.sendTo((IMessage) new ClientSyncMessage(var3), (EntityPlayerMP) var3);
            } else {
                final EntityPlayer var4 = (EntityPlayer) getCommandSenderAsPlayer(par1ICommandSender);
                final ExtendedPlayer props2 = (ExtendedPlayer) var4.getExtendedProperties("BleachPlayer");
                props2.setCurrentEnergy(1.0f);
                var4.addChatMessage((IChatComponent) new ChatComponentText("Full Spiritual Energy"));
                PacketDispatcher.sendTo((IMessage) new ClientSyncMessage(var4), (EntityPlayerMP) var4);
            }
        }
    }
    
    public String getCommandUsage(final ICommandSender icommandsender) {
        return "/spirit [username]";
    }
}

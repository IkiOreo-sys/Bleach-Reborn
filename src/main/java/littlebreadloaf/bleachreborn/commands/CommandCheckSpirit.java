package littlebreadloaf.bleachreborn.commands;

import net.minecraft.command.*;
import net.minecraft.server.*;
import littlebreadloaf.bleachreborn.events.*;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;

public class CommandCheckSpirit extends CommandBase
{
    public String getCommandName() {
        return "checkspirit";
    }
    
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    public void processCommand(final ICommandSender par1ICommandSender, final String[] par2ArrayOfStr) {
        if(SrvCmd.testForServer(par1ICommandSender)) {
            DedicatedServer server = (DedicatedServer) par1ICommandSender;
            if (par2ArrayOfStr.length >= 1 && par2ArrayOfStr[0].length() > 0) {
                final EntityPlayer var3;
                final EntityPlayerMP entityplayermp = (EntityPlayerMP) (var3 = (EntityPlayer) MinecraftServer.getServer().getConfigurationManager().func_152612_a(par2ArrayOfStr[0]));
                final ExtendedPlayer props = (ExtendedPlayer) var3.getExtendedProperties("BleachPlayer");
                server.addChatMessage(new ChatComponentText(par2ArrayOfStr[0] + "'s Spiritual Energy is: " + props.getCurrentCap()));
            } else
                server.addChatMessage(new ChatComponentText("You must specify what player you want to check"));
        } else {
            if(par2ArrayOfStr.length >= 1 && par2ArrayOfStr[0].length() > 0) {
                final EntityPlayer var3;
                final EntityPlayerMP entityplayermp = (EntityPlayerMP) (var3 = (EntityPlayer) MinecraftServer.getServer().getConfigurationManager().func_152612_a(par2ArrayOfStr[0]));
                final ExtendedPlayer props = (ExtendedPlayer) var3.getExtendedProperties("BleachPlayer");
                getCommandSenderAsPlayer(par1ICommandSender).addChatMessage((IChatComponent) new ChatComponentText(par2ArrayOfStr[0] + "'s Spiritual Energy is: " + props.getCurrentCap()));
            } else {
                final EntityPlayer var4 = (EntityPlayer) getCommandSenderAsPlayer(par1ICommandSender);
                final ExtendedPlayer props2 = (ExtendedPlayer) var4.getExtendedProperties("BleachPlayer");
                var4.addChatMessage((IChatComponent) new ChatComponentText("Your spiritual energy is: " + props2.getCurrentCap()));
            }
        }
    }
    
    public String getCommandUsage(final ICommandSender icommandsender) {
        return "/checkspirit [username]";
    }
}

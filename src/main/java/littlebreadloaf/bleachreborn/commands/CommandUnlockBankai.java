package littlebreadloaf.bleachreborn.commands;

import net.minecraft.command.*;
import net.minecraft.server.*;
import littlebreadloaf.bleachreborn.events.*;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.util.*;
import littlebreadloaf.bleachreborn.network.*;
import cpw.mods.fml.common.network.simpleimpl.*;
import net.minecraft.entity.player.*;

public class CommandUnlockBankai extends CommandBase
{
    public String getCommandName() {
        return "bankai";
    }
    
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    public void processCommand(final ICommandSender par1ICommandSender, final String[] par2ArrayOfStr) {
        if(SrvCmd.testForServer(par1ICommandSender)) {
            DedicatedServer server = (DedicatedServer) par1ICommandSender;
            if(par2ArrayOfStr.length >= 1 && par2ArrayOfStr[0].length() > 0) {
                final EntityPlayer var3;
                final EntityPlayerMP entityplayermp = (EntityPlayerMP) (var3 = (EntityPlayer) MinecraftServer.getServer().getConfigurationManager().func_152612_a(par2ArrayOfStr[0]));
                final ExtendedPlayer props = (ExtendedPlayer) var3.getExtendedProperties("BleachPlayer");
                props.setBankaiUnlock(true);
                var3.addChatMessage(new ChatComponentText("Unlocked Bankai."));
                server.addChatMessage(new ChatComponentText("Unlocking " + par2ArrayOfStr[0] + "'s Bankai"));
                PacketDispatcher.sendTo(new ClientSyncMessage(var3), (EntityPlayerMP) var3);
            } else
                server.addChatMessage(new ChatComponentText("You must specify what player to Unlock Bankai on!"));
        } else {
            if(par2ArrayOfStr.length >= 1 && par2ArrayOfStr[0].length() > 0) {
                final EntityPlayerMP var3;
                var3 = MinecraftServer.getServer().getConfigurationManager().func_152612_a(par2ArrayOfStr[0]);
                final ExtendedPlayer props = (ExtendedPlayer) var3.getExtendedProperties("BleachPlayer");
                props.setBankaiUnlock(true);
                var3.addChatMessage(new ChatComponentText("Unlocked Bankai."));
                getCommandSenderAsPlayer(par1ICommandSender).addChatMessage(new ChatComponentText("Unlocking " + par2ArrayOfStr[0] + "'s Bankai"));
                PacketDispatcher.sendTo(new ClientSyncMessage(var3), var3);
            } else {
                final EntityPlayerMP var4 = getCommandSenderAsPlayer(par1ICommandSender);
                final ExtendedPlayer props2 = (ExtendedPlayer) var4.getExtendedProperties("BleachPlayer");
                props2.setBankaiUnlock(true);
                var4.addChatMessage(new ChatComponentText("Unlocked Bankai"));
                PacketDispatcher.sendTo(new ClientSyncMessage(var4), var4);
            }
        }
    }
    
    public String getCommandUsage(final ICommandSender icommandsender) {
        return "/bankai [username]";
    }
}
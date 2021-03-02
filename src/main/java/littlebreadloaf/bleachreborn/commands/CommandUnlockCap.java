package littlebreadloaf.bleachreborn.commands;

import net.minecraft.command.*;
import net.minecraft.server.*;
import littlebreadloaf.bleachreborn.events.*;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.util.*;
import littlebreadloaf.bleachreborn.network.*;
import cpw.mods.fml.common.network.simpleimpl.*;
import net.minecraft.entity.player.*;

public class CommandUnlockCap extends CommandBase
{
    public String getCommandName() {
        return "unlockcap";
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
                if (props.getCurrentCap() == 10000 && props.getHollowKills() >= 15000 && props.getCapUnlocked() == false) {
                	props.setCapUnlocked(true);
                    var3.addChatMessage(new ChatComponentText("Unlocked Spirit Cap."));
                    server.addChatMessage(new ChatComponentText("Unlocking " + par2ArrayOfStr[0] + "'s Spirit Cap"));
                }
                PacketDispatcher.sendTo(new ClientSyncMessage(var3), (EntityPlayerMP) var3);
            } else
                server.addChatMessage(new ChatComponentText("You must specify what player to Unlock Spirit Cap on!"));
        } else {
            if(par2ArrayOfStr.length >= 1 && par2ArrayOfStr[0].length() > 0) {
                final EntityPlayerMP var3;
                var3 = MinecraftServer.getServer().getConfigurationManager().func_152612_a(par2ArrayOfStr[0]);
                final ExtendedPlayer props = (ExtendedPlayer) var3.getExtendedProperties("BleachPlayer");
                if (props.getCurrentCap() == 10000 && props.getHollowKills() >= 15000 && props.getCapUnlocked() == false) {
                	props.setCapUnlocked(true);
                    var3.addChatMessage(new ChatComponentText("Unlocked Spirit Cap."));
                    getCommandSenderAsPlayer(par1ICommandSender).addChatMessage(new ChatComponentText("Unlocking " + par2ArrayOfStr[0] + "'s Spirit Cap"));
                }
                PacketDispatcher.sendTo(new ClientSyncMessage(var3), var3);
            } else {
                final EntityPlayerMP var4 = getCommandSenderAsPlayer(par1ICommandSender);
                final ExtendedPlayer props2 = (ExtendedPlayer) var4.getExtendedProperties("BleachPlayer");
                if (props2.getCurrentCap() == 10000 && props2.getHollowKills() >= 15000 && props2.getCapUnlocked() == false) {
                	props2.setCapUnlocked(true);
                    var4.addChatMessage(new ChatComponentText("Unlocked Spirit Cap"));
                }
                PacketDispatcher.sendTo(new ClientSyncMessage(var4), var4);
            }
        }
    }
    
    public String getCommandUsage(final ICommandSender icommandsender) {
        return "/unlockcap [username]";
    }
}
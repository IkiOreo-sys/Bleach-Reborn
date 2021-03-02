package littlebreadloaf.bleachreborn.commands;

import net.minecraft.command.*;
import littlebreadloaf.bleachreborn.events.*;
import net.minecraft.server.*;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.util.*;
import littlebreadloaf.bleachreborn.network.*;
import cpw.mods.fml.common.network.simpleimpl.*;
import net.minecraft.entity.player.*;
import java.util.*;

public class CommandSetType extends CommandBase
{
    public String getCommandName() {
        return "settype";
    }
    
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    public void processCommand(final ICommandSender par1ICommandSender, final String[] par2ArrayOfStr) {
        int var5 = 0;
        if(SrvCmd.testForServer(par1ICommandSender)) {
            DedicatedServer server = (DedicatedServer) par1ICommandSender;
            EntityPlayer var4 = null;
            ExtendedPlayer props = null;
            if(par2ArrayOfStr.length == 3) {
                final EntityPlayerMP entityplayermp = (EntityPlayerMP) (var4 = (EntityPlayer) MinecraftServer.getServer().getConfigurationManager().func_152612_a(par2ArrayOfStr[0]));
                props = (ExtendedPlayer) var4.getExtendedProperties("BleachPlayer");
                var5 = parseIntBounded(par1ICommandSender, par2ArrayOfStr[2], 0, 4);
                getCommandSenderAsPlayer(par1ICommandSender).addChatMessage((IChatComponent) new ChatComponentText("Setting " + par2ArrayOfStr[0] + "'s Type to " + par2ArrayOfStr[1]));
                var4.addChatMessage((IChatComponent) new ChatComponentText("Zanpakuto Type set to " + par2ArrayOfStr[1]));
                if(this.getTypeToSet(par1ICommandSender, par2ArrayOfStr[1]) < 12) {
                    props.setType(this.getTypeToSet(par1ICommandSender, par2ArrayOfStr[1]));
                    props.setZType(this.getTypeToSet(par1ICommandSender, par2ArrayOfStr[1]) + 1);
                } else {
                    props.resetType();
                }
            }
            if(par2ArrayOfStr.length == 2) {
                if(MinecraftServer.getServer().getConfigurationManager().func_152612_a(par2ArrayOfStr[0]) != null) {
                    final EntityPlayerMP entityplayermp = (EntityPlayerMP) (var4 = (EntityPlayer) MinecraftServer.getServer().getConfigurationManager().func_152612_a(par2ArrayOfStr[0]));
                    props = (ExtendedPlayer) var4.getExtendedProperties("BleachPlayer");
                    var4.addChatMessage((IChatComponent) new ChatComponentText("Zanpakuto Type set to " + par2ArrayOfStr[1]));
                    getCommandSenderAsPlayer(par1ICommandSender).addChatMessage((IChatComponent) new ChatComponentText("Setting " + par2ArrayOfStr[0] + "'s Type to " + par2ArrayOfStr[1]));
                    if(this.getTypeToSet(par1ICommandSender, par2ArrayOfStr[1]) < 12) {
                        props.setType(this.getTypeToSet(par1ICommandSender, par2ArrayOfStr[1]));
                        props.setZType(this.getTypeToSet(par1ICommandSender, par2ArrayOfStr[1]) + 1);
                    } else {
                        props.resetType();
                    }
                } else
                    server.addChatMessage((IChatComponent) new ChatComponentText("Cannot set Zanpakuto Type to " + par2ArrayOfStr[0] + " on the server!"));
            } else
                server.addChatMessage((IChatComponent) new ChatComponentText("Cannot set Zanpakuto Type to " + par2ArrayOfStr[0] + " on the server!"));
            if(props != null && var4 != null) {
                props.setTexture(var5);
                PacketDispatcher.sendTo((IMessage) new ClientSyncMessage(var4), (EntityPlayerMP) var4);
            }
        } else {
            EntityPlayer var4 = (EntityPlayer) getCommandSenderAsPlayer(par1ICommandSender);
            ExtendedPlayer props = (ExtendedPlayer) var4.getExtendedProperties("BleachPlayer");
            if(par2ArrayOfStr.length == 3) {
                final EntityPlayerMP entityplayermp = (EntityPlayerMP) (var4 = (EntityPlayer) MinecraftServer.getServer().getConfigurationManager().func_152612_a(par2ArrayOfStr[0]));
                props = (ExtendedPlayer) var4.getExtendedProperties("BleachPlayer");
                var5 = parseIntBounded(par1ICommandSender, par2ArrayOfStr[2], 0, 4);
                getCommandSenderAsPlayer(par1ICommandSender).addChatMessage((IChatComponent) new ChatComponentText("Setting " + par2ArrayOfStr[0] + "'s Type to " + par2ArrayOfStr[1]));
                var4.addChatMessage((IChatComponent) new ChatComponentText("Zanpakuto Type set to " + par2ArrayOfStr[1]));
                if(this.getTypeToSet(par1ICommandSender, par2ArrayOfStr[1]) < 12) {
                    props.setType(this.getTypeToSet(par1ICommandSender, par2ArrayOfStr[1]));
                    props.setZType(this.getTypeToSet(par1ICommandSender, par2ArrayOfStr[1]) + 1);
                } else {
                    props.resetType();
                }
            }
            if(par2ArrayOfStr.length == 2) {
                if(MinecraftServer.getServer().getConfigurationManager().func_152612_a(par2ArrayOfStr[0]) != null) {
                    final EntityPlayerMP entityplayermp = (EntityPlayerMP) (var4 = (EntityPlayer) MinecraftServer.getServer().getConfigurationManager().func_152612_a(par2ArrayOfStr[0]));
                    props = (ExtendedPlayer) var4.getExtendedProperties("BleachPlayer");
                    var4.addChatMessage((IChatComponent) new ChatComponentText("Zanpakuto Type set to " + par2ArrayOfStr[1]));
                    getCommandSenderAsPlayer(par1ICommandSender).addChatMessage((IChatComponent) new ChatComponentText("Setting " + par2ArrayOfStr[0] + "'s Type to " + par2ArrayOfStr[1]));
                    if(this.getTypeToSet(par1ICommandSender, par2ArrayOfStr[1]) < 12) {
                        props.setType(this.getTypeToSet(par1ICommandSender, par2ArrayOfStr[1]));
                        props.setZType(this.getTypeToSet(par1ICommandSender, par2ArrayOfStr[1]) + 1);
                    } else {
                        props.resetType();
                    }
                } else {
                    var5 = parseIntBounded(par1ICommandSender, par2ArrayOfStr[1], 0, 4);
                    if(this.getTypeToSet(par1ICommandSender, par2ArrayOfStr[0]) < 12) {
                        props.setType(this.getTypeToSet(par1ICommandSender, par2ArrayOfStr[0]));
                        props.setZType(this.getTypeToSet(par1ICommandSender, par2ArrayOfStr[0]) + 1);
                    } else {
                        props.resetType();
                    }
                    var4.addChatMessage((IChatComponent) new ChatComponentText("Setting Zanpakuto Type to " + par2ArrayOfStr[0]));
                }
            }
            if(par2ArrayOfStr.length == 1) {
                final int var6 = this.getTypeToSet(par1ICommandSender, par2ArrayOfStr[0]);
                if(var6 != 12) {
                    props.setType(var6);
                    props.setZType(var6 + 1);
                }
                if(var6 == 12) {
                    props.resetType();
                }
                var4.addChatMessage((IChatComponent) new ChatComponentText("Zanpakuto Type set to " + par2ArrayOfStr[0]));
            }
            props.setTexture(var5);
            PacketDispatcher.sendTo((IMessage) new ClientSyncMessage(var4), (EntityPlayerMP) var4);
        }
    }
    
    protected int getTypeToSet(final ICommandSender par1ICommandSender, final String par2Str) {
        return par2Str.equalsIgnoreCase("fire") ? 0 : (par2Str.equalsIgnoreCase("ice") ? 1 : (par2Str.equalsIgnoreCase("poison") ? 2 : (par2Str.equalsIgnoreCase("heal") ? 3 : (par2Str.equalsIgnoreCase("earth") ? 4 : (par2Str.equalsIgnoreCase("wind") ? 5 : (par2Str.equalsIgnoreCase("light") ? 6 : (par2Str.equalsIgnoreCase("dark") ? 7 : (par2Str.equalsIgnoreCase("lunar") ? 8 : (par2Str.equalsIgnoreCase("lightning") ? 9 : (par2Str.equalsIgnoreCase("normal") ? 10 : (par2Str.equalsIgnoreCase("water") ? 11 : (par2Str.equalsIgnoreCase("null") ? 12 : parseIntBounded(par1ICommandSender, par2Str, 0, 12)))))))))))));
    }
    
    public List addTabCompletionOptions(final ICommandSender par1ICommandSender, final String[] par2ArrayOfStr) {
        return (par2ArrayOfStr.length == 1) ? getListOfStringsMatchingLastWord(par2ArrayOfStr, new String[] { "fire", "ice", "poison", "heal", "earth", "wind", "light", "dark", "lunar", "lightning", "normal", "water", "null" }) : null;
    }
    
    public String getCommandUsage(final ICommandSender icommandsender) {
        return "/settype {username} <type> [texture 0-4] ";
    }
}

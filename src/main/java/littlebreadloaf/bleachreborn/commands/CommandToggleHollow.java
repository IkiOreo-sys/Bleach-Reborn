package littlebreadloaf.bleachreborn.commands;

import littlebreadloaf.bleachreborn.ConfigHandler;
import littlebreadloaf.bleachreborn.network.PacketDispatcher;
import littlebreadloaf.bleachreborn.network.ToggleHollowMessage;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;

public class CommandToggleHollow extends CommandBase {
    @Override
    public String getCommandName() {
        return "togglehollow";
    }
    
    public int getRequiredPermissionLevel() {
        return 0;
    }
    
    @Override
    public String getCommandUsage(ICommandSender p_71518_1_) {
        return "/togglehollow";
    }
    
    @Override
    public void processCommand(ICommandSender sender, String[] arr) {
        if(SrvCmd.testForServer(sender))
            return;
        EntityPlayerMP mp = (EntityPlayerMP) sender;
        boolean render;
        if(ConfigHandler.renderHollowMap.containsKey(mp.getDisplayName()))
            render = !ConfigHandler.renderHollowMap.get(mp.getDisplayName());
        else
            render = false;
        ConfigHandler.renderHollowMap.put(mp.getUniqueID().getMostSignificantBits(), render);
        PacketDispatcher.sendTo(new ToggleHollowMessage(render), mp);
        mp.addChatMessage(new ChatComponentText("Set Hollow rendering to " + render));
    }
}

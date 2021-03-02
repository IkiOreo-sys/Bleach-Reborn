package littlebreadloaf.bleachreborn.commands;

import net.minecraft.command.ICommandSender;
import net.minecraft.server.dedicated.DedicatedServer;

public class SrvCmd {
    public static boolean testForServer(ICommandSender sender) {
        try {
            if(sender instanceof DedicatedServer)
                return true;
            else
                return false;
        } catch(NoClassDefFoundError e) {
            return false;
        }
    }
}

package littlebreadloaf.bleachreborn.proxies;

import cpw.mods.fml.common.network.*;
import java.util.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import cpw.mods.fml.common.*;
import littlebreadloaf.bleachreborn.events.*;
import net.minecraft.client.model.*;
import cpw.mods.fml.common.network.simpleimpl.*;

public class CommonProxy implements IGuiHandler
{
    private static HashMap<String, NBTTagCompound> extendedEntityData;
    
    public void initRenderers() {
    }
    
    public int addArmor(final String string) {
        return 0;
    }
    
    public Object getServerGuiElement(final int guiId, final EntityPlayer player, final World world, final int x, final int y, final int z) {
        return null;
    }
    
    public Object getClientGuiElement(final int guiId, final EntityPlayer player, final World world, final int x, final int y, final int z) {
        return null;
    }
    
    public static void storeEntityData(final String name, final NBTTagCompound compound) {
        CommonProxy.extendedEntityData.put(name, compound);
    }
    
    public static NBTTagCompound getEntityData(final String name) {
        return CommonProxy.extendedEntityData.remove(name);
    }
    
    public void loadParts() {
        FMLCommonHandler.instance().bus().register((Object)new BleachPlayerTickHandler());
    }
    
    public void loadGUI() {
    }
    
    public void loadKeys() {
    }
    
    public void initZanpakutoRenderers() {
    }
    
    public ModelBiped getArmorModel(final int id) {
        return null;
    }
    
    public void loadMessages() {
    }
    
    public EntityPlayer getPlayerFromMessage(final MessageContext ctx) {
        return (EntityPlayer)ctx.getServerHandler().playerEntity;
    }
    
    static {
        CommonProxy.extendedEntityData = new HashMap<String, NBTTagCompound>();
    }
}

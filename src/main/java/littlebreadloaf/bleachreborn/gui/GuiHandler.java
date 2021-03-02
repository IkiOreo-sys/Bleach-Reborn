package littlebreadloaf.bleachreborn.gui;

import cpw.mods.fml.common.network.*;
import littlebreadloaf.bleachreborn.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import littlebreadloaf.bleachreborn.gui.hollow.*;

public class GuiHandler implements IGuiHandler
{
    public GuiHandler() {
        NetworkRegistry.INSTANCE.registerGuiHandler((Object)BleachMod.instance, (IGuiHandler)this);
    }
    
    public Object getServerGuiElement(final int ID, final EntityPlayer player, final World world, final int x, final int y, final int z) {
        return null;
    }
    
    public Object getClientGuiElement(final int ID, final EntityPlayer player, final World world, final int x, final int y, final int z) {
        switch (ID) {
            default: {
                return null;
            }
            case 0: {
                return new GuiZanpakuto();
            }
            case 1: {
                return new GuiHollowBook(player);
            }
            case 2: {
                return new GuiFaction(player);
            }
            case 3: {
                return new GuiHollowSelect(player);
            }
            case 4: {
                return new GuiHeadOptions(player);
            }
            case 5: {
                return new GuiBackOptions(player);
            }
            case 7: {
                return new GuiTailOptions(player);
            }
            case 8: {
                return new GuiLegsOptions(player);
            }
            case 9: {
                return new GuiColorSelect(player);
            }
            case 10: {
                return new GuiArmOptions(player);
            }
            case 11: {
            	return new GuiControl();
            }
            case 12: {
            	return new GuiName();
            }
            case 13: {
            	return new GuiHairclip();
            }
            case 14: {
            	return new GuiCard();
            }
        }
    }
}

package littlebreadloaf.bleachreborn.gui;

import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.potion.PotionEffect;
import net.minecraft.client.entity.*;
import cpw.mods.fml.client.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import littlebreadloaf.bleachreborn.network.*;
import cpw.mods.fml.common.network.simpleimpl.*;
import littlebreadloaf.bleachreborn.BleachMod;
import littlebreadloaf.bleachreborn.events.*;

public class GuiFaction extends GuiScreen
{
    ResourceLocation texture;
    public final int xSizeOfTexture = 256;
    public final int ySizeOfTexture = 256;
    EntityPlayer thePlayer;
    private int id;
    EntityClientPlayerMP player;
    
    public GuiFaction(final EntityPlayer player) {
        this.texture = new ResourceLocation("bleachreborn".toLowerCase(), "textures/guis/faction_gui.png");
        this.id = -1;
        this.player = FMLClientHandler.instance().getClient().thePlayer;
        this.thePlayer = player;
    }
    
    public void drawScreen(final int x, final int y, final float f) {
        this.drawDefaultBackground();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        Minecraft.getMinecraft().getTextureManager().bindTexture(this.texture);
        final int posX = (this.width - 256) / 2;
        final int posY = (this.height - 256) / 2;
        this.drawTexturedModalRect(posX, posY + 50, 0, 0, 256, 256);
        super.drawScreen(x, y, f);
    }
    
    public void initGui() {
        final int posX = (this.width - 256) / 2;
        final int posY = (this.height - 256) / 2;
        this.buttonList.add(new GuiButton(0, posX + 130, posY + 100, 100, 20, "Shinigami"));
        this.buttonList.add(new GuiButton(1, posX + 10, posY + 100, 100, 20, "Quincy"));
        this.buttonList.add(new GuiButton(2, posX + 130, posY + 180, 100, 20, "Hollow"));
        this.buttonList.add(new GuiButton(3, posX + 10, posY + 180, 100, 20, "Human"));
    }
    
    public void actionPerformed(final GuiButton button) {
        switch (button.id) {
            case 0: {
                PacketDispatcher.sendToServer((IMessage)new FlashMessage(11));
                ((ExtendedPlayer)this.thePlayer.getExtendedProperties("BleachPlayer")).setFaction(1);
                this.thePlayer.addPotionEffect(new PotionEffect(BleachMod.soulDisconnect.id, 999999999, 0));
                this.mc.displayGuiScreen((GuiScreen)null);
                break;
            }
            case 1: {
                PacketDispatcher.sendToServer((IMessage)new FlashMessage(12));
                ((ExtendedPlayer)this.thePlayer.getExtendedProperties("BleachPlayer")).setFaction(2);
                this.mc.displayGuiScreen((GuiScreen)null);
                break;
            }
            case 2: {
                PacketDispatcher.sendToServer((IMessage)new FlashMessage(13));
                ((ExtendedPlayer)this.thePlayer.getExtendedProperties("BleachPlayer")).setFaction(3);
                this.thePlayer.addPotionEffect(new PotionEffect(BleachMod.soulDisconnect.id, 999999999, 0));
                this.mc.displayGuiScreen((GuiScreen)null);
                break;
            }
            case 3: {
                PacketDispatcher.sendToServer((IMessage)new FlashMessage(14));
                ((ExtendedPlayer)this.thePlayer.getExtendedProperties("BleachPlayer")).setFaction(6);
                this.mc.displayGuiScreen((GuiScreen)null);
                break;
            }
        }
    }
    
    public boolean doesGuiPauseGame() {
        return true;
    }
}

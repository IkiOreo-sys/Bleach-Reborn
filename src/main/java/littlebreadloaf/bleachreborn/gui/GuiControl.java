package littlebreadloaf.bleachreborn.gui;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import littlebreadloaf.bleachreborn.BleachMod;
import littlebreadloaf.bleachreborn.events.ExtendedPlayer;
import littlebreadloaf.bleachreborn.network.FlashMessage;
import littlebreadloaf.bleachreborn.network.PacketDispatcher;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ResourceLocation;

public class GuiControl extends GuiScreen
{
    ResourceLocation texture;
    public final int xSizeOfTexture = 256;
    public final int ySizeOfTexture = 256;
    EntityPlayer thePlayer;
    private int id;
    EntityClientPlayerMP player;
    
    public GuiControl() {
        this.texture = new ResourceLocation("bleachreborn".toLowerCase(), "textures/guis/control.png");
        this.id = -1;
        this.player = FMLClientHandler.instance().getClient().thePlayer;
    }
    
    public void drawScreen(final int x, final int y, final float f) {
        this.drawDefaultBackground();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        Minecraft.getMinecraft().getTextureManager().bindTexture(this.texture);
        final int posX = (this.width - 256) / 2;
        final int posY = (this.height - 256) / 2;
        this.drawTexturedModalRect(posX, posY + 50, 0, 0, 256, 256);
        this.fontRendererObj.drawString(EnumChatFormatting.RED + "Gigai Control", posX + 91, posY + 65, 0);
        super.drawScreen(x, y, f);
    }
    
    public void initGui() {
        final int posX = (this.width - 256) / 2;
        final int posY = (this.height - 256) / 2;
        this.buttonList.add(new GuiButton(0, posX + 56, posY + 100, 38, 20, EnumChatFormatting.WHITE + "Follow"));
        this.buttonList.add(new GuiButton(1, posX + 156, posY + 100, 38, 20, EnumChatFormatting.WHITE + "Stay"));
        this.buttonList.add(new GuiButton(2, posX + 106, posY + 120, 38, 20, EnumChatFormatting.WHITE + "Attack"));
        this.buttonList.add(new GuiButton(3, posX + 74, posY + 150, 100, 20, EnumChatFormatting.WHITE + "Return To Body"));
        this.buttonList.add(new GuiButton(4, posX + 86, posY + 180, 76, 20, EnumChatFormatting.WHITE + "Close"));
    }
    
    public void actionPerformed(final GuiButton button) {
        final ExtendedPlayer props = (ExtendedPlayer)this.mc.thePlayer.getExtendedProperties("BleachPlayer");
        switch (button.id) {
            case 0: {
                PacketDispatcher.sendToServer(new FlashMessage(121));
            	break;
            }
            case 1: {
                PacketDispatcher.sendToServer(new FlashMessage(122));
            	break;
            }
            case 2: {
                PacketDispatcher.sendToServer(new FlashMessage(123));
            	break;
            }
            case 3: {
                PacketDispatcher.sendToServer(new FlashMessage(120));
            	break;
            }
            case 4: {
                this.mc.displayGuiScreen((GuiScreen)null);
                break;
            }
        }
        super.actionPerformed(button);
    }
    
    public boolean doesGuiPauseGame() {
        return false;
    }
}

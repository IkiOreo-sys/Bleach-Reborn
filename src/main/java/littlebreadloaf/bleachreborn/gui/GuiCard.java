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
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ResourceLocation;

public class GuiCard extends GuiScreen
{
    ResourceLocation texture;
    public final int xSizeOfTexture = 256;
    public final int ySizeOfTexture = 256;
    EntityPlayer thePlayer;
    private int id;
    private String sname;
    EntityClientPlayerMP player;
    
    public GuiCard() {
        this.texture = new ResourceLocation("bleachreborn".toLowerCase(), "textures/guis/card.png");
        this.id = -1;
        this.player = FMLClientHandler.instance().getClient().thePlayer;
    }
    
    public void drawScreen(final int x, final int y, final float f) {
        final ExtendedPlayer props = (ExtendedPlayer)this.mc.thePlayer.getExtendedProperties("BleachPlayer");
        this.drawDefaultBackground();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        Minecraft.getMinecraft().getTextureManager().bindTexture(this.texture);
        final int posX = (this.width - 256) / 2;
        final int posY = (this.height - 256) / 2;
        GL11.glPushMatrix();
        GL11.glEnable(GL11.GL_BLEND);
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.5F);
        this.drawTexturedModalRect(posX, posY + 50, 0, 0, 256, 256);
        GL11.glPopMatrix();
        this.fontRendererObj.drawString(EnumChatFormatting.GRAY + "Player Card", posX + 85, posY + 62, 0);
        this.fontRendererObj.drawString(EnumChatFormatting.LIGHT_PURPLE + "Player: " + player.getDisplayName(), posX + 12, posY + 82, 0);
        this.fontRendererObj.drawString(EnumChatFormatting.YELLOW + "Hollow Kills: " + props.getHollowKills(), posX + 12, posY + 102, 0);
        this.fontRendererObj.drawString(EnumChatFormatting.YELLOW + "Current SXP: " + props.getCurrentSXP(), posX + 12, posY + 122, 0);
        this.fontRendererObj.drawString(EnumChatFormatting.GRAY + "(Level up when SXP reaches 1.0)", posX + 12, posY + 132, 0);
        super.drawScreen(x, y, f);
    }
    
    public void initGui() {
        final int posX = (this.width - 256) / 2;
        final int posY = (this.height - 256) / 2;
        this.buttonList.add(new GuiButton(0, posX + 255, posY + 185, 35, 20, EnumChatFormatting.WHITE + "->"));
        this.buttonList.add(new GuiButton(1, posX + 83, posY + 220, 76, 20, EnumChatFormatting.WHITE + "Close"));
    }
    
    public void actionPerformed(final GuiButton button) {
        final ExtendedPlayer props = (ExtendedPlayer)this.mc.thePlayer.getExtendedProperties("BleachPlayer");
        switch (button.id) {
            case 0: {
            	this.mc.displayGuiScreen(new GuiKido());
            	break;
            }
            case 1: {
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

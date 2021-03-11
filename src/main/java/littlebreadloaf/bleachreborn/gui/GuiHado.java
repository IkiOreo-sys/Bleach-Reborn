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

public class GuiHado extends GuiScreen
{
    ResourceLocation texture;
    public final int xSizeOfTexture = 256;
    public final int ySizeOfTexture = 256;
    EntityPlayer thePlayer;
    private int id;
    private String sname;
    EntityClientPlayerMP player;
    
    public GuiHado() {
        this.texture = new ResourceLocation("bleachreborn".toLowerCase(), "textures/guis/hairclip.png");
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
        this.drawTexturedModalRect(posX, posY + 50, 0, 0, 256, 256);
        this.fontRendererObj.drawString(EnumChatFormatting.YELLOW + "Hadou", posX + 105, posY + 65, 0);
        this.fontRendererObj.drawString(EnumChatFormatting.YELLOW + "Kido Points: " + props.getKidoPoints(), posX + 85, posY + 90, 0);
        this.fontRendererObj.drawString(EnumChatFormatting.AQUA + "Hadou 4: Byakurai - Level: " + props.getHado4Level() + " | Cost: " + props.getHado4Cost(), posX + 5, posY + 120, 0);
        super.drawScreen(x, y, f);
    }
    
    public void initGui() {
        final int posX = (this.width - 256) / 2;
        final int posY = (this.height - 256) / 2;
        this.buttonList.add(new GuiButton(0, posX + 83, posY + 220, 76, 20, EnumChatFormatting.WHITE + "Close"));       
        this.buttonList.add(new GuiButton(1, posX + 198, posY + 118, 12, 11, EnumChatFormatting.WHITE + "+"));
        this.buttonList.add(new GuiButton(2, posX + 212, posY + 117, 32, 13, EnumChatFormatting.WHITE + "Equip"));
        this.buttonList.add(new GuiButton(3, posX - 45, posY + 185, 35, 20, EnumChatFormatting.WHITE + "<-"));
    }
    
    public void actionPerformed(final GuiButton button) {
        final ExtendedPlayer props = (ExtendedPlayer)this.mc.thePlayer.getExtendedProperties("BleachPlayer");
        switch (button.id) {
            case 0: {
                this.mc.displayGuiScreen((GuiScreen)null);
                break;
            }
            case 1: {
                PacketDispatcher.sendToServer(new FlashMessage(131));
                break;
            }
            case 2: {
                PacketDispatcher.sendToServer(new FlashMessage(134));
            	break;
            }
            case 3: {  
                this.mc.displayGuiScreen(new GuiKido());
                break;

            }
        }
        super.actionPerformed(button);
    }
    
    public boolean doesGuiPauseGame() {
        return false;
    }
}

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

public class GuiHeal extends GuiScreen
{
    ResourceLocation texture;
    public final int xSizeOfTexture = 256;
    public final int ySizeOfTexture = 256;
    EntityPlayer thePlayer;
    private int id;
    EntityClientPlayerMP player;
    
    public GuiHeal() {
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
        this.fontRendererObj.drawString(EnumChatFormatting.GREEN + "Healing Skills", posX + 91, posY + 65, 0);
        this.fontRendererObj.drawString(EnumChatFormatting.GREEN + "Current SubPoints: " + props.getSubPoints(), posX + 68, posY + 80, 0);

        super.drawScreen(x, y, f);
    }
    
    public void initGui() {
        final ExtendedPlayer props = (ExtendedPlayer)this.mc.thePlayer.getExtendedProperties("BleachPlayer");
        final int posX = (this.width - 256) / 2;
        final int posY = (this.height - 256) / 2;
        this.buttonList.add(new GuiButton(0, posX + 56, posY + 100, 140, 20, EnumChatFormatting.WHITE + "Healing Reject | Level: " + props.getSkill1hlevel()));
        this.buttonList.add(new GuiButton(1, posX + 56, posY + 140, 40, 20, EnumChatFormatting.WHITE + "Equip"));
        this.buttonList.add(new GuiButton(2, posX + 86, posY + 180, 76, 20, EnumChatFormatting.WHITE + "Close"));
    }
    
    public void actionPerformed(final GuiButton button) {
        final ExtendedPlayer props = (ExtendedPlayer)this.mc.thePlayer.getExtendedProperties("BleachPlayer");
        switch (button.id) {
            case 0: {
                PacketDispatcher.sendToServer(new FlashMessage(125));
            	break;
            }
            case 1: {
                PacketDispatcher.sendToServer(new FlashMessage(128));
            	break;
            }
            case 2: {
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

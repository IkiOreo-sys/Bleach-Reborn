package littlebreadloaf.bleachreborn.gui;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import littlebreadloaf.bleachreborn.events.ExtendedPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

public class GuiUpdate extends GuiScreen
{
	
    ResourceLocation texture;
    public final int xSizeOfTexture = 256;
    public final int ySizeOfTexture = 256;
    EntityPlayer thePlayer;
    private int id;
    EntityClientPlayerMP player;
    
    public GuiUpdate() {
        this.texture = new ResourceLocation("bleachreborn".toLowerCase(), "textures/guis/control.png");
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
                    this.mc.displayGuiScreen(new GuiCard());
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

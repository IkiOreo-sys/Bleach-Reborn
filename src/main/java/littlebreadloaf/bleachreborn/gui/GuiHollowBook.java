package littlebreadloaf.bleachreborn.gui;

import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.*;

public class GuiHollowBook extends GuiScreen
{
    ResourceLocation texture;
    public final int xSizeOfTexture = 256;
    public final int ySizeOfTexture = 256;
    private int id;
    
    public GuiHollowBook(final EntityPlayer player) {
        this.texture = new ResourceLocation("bleachreborn".toLowerCase(), "textures/guis/hollowbook_gui.png");
        this.id = -1;
    }
    
    public void drawScreen(final int x, final int y, final float f) {
        this.drawDefaultBackground();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        Minecraft.getMinecraft().getTextureManager().bindTexture(this.texture);
        final int posX = (this.width - 256) / 2;
        final int posY = (this.height - 256) / 2;
        this.drawTexturedModalRect(posX, posY, 0, 0, 256, 256);
        super.drawScreen(x, y, f);
    }
    
    public void initGui() {
        final int posX = (this.width - 256) / 2;
        final int posY = (this.height - 256) / 2;
    }
    
    public void actionPerformed(final GuiButton button) {
        switch (button.id) {
            case 0: {
                System.out.println("pressed");
                break;
            }
        }
    }
    
    public boolean doesGuiPauseGame() {
        return false;
    }
}

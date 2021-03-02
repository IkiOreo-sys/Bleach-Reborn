package littlebreadloaf.bleachreborn.gui.buttons;

import cpw.mods.fml.relauncher.*;
import net.minecraft.util.*;
import net.minecraft.client.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.gui.*;

@SideOnly(Side.CLIENT)
public class GuiTexturedButton extends GuiButton
{
    private static ResourceLocation buttonTextures;
    protected int width;
    protected int height;
    public int xPosition;
    public int yPosition;
    public String displayString;
    public int id;
    public boolean enabled;
    public boolean drawButton;
    protected boolean field_82253_i;
    
    public GuiTexturedButton(final int id, final int xPosition, final int yPosition, final String text, final ResourceLocation textureLocation) {
        this(id, xPosition, yPosition, 200, 20, text, textureLocation);
    }
    
    public GuiTexturedButton(final int id, final int xPosition, final int yPosition, final int width, final int height, final String text, final ResourceLocation textureLocation) {
        super(id, xPosition, yPosition, width, height, text);
        this.width = width;
        this.height = height;
        this.enabled = true;
        this.drawButton = true;
        this.id = id;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width = width;
        this.height = height;
        this.displayString = text;
        GuiTexturedButton.buttonTextures = textureLocation;
    }
    
    public int getHoverState(final boolean par1) {
        return 1;
    }
    
    public void drawButton(final Minecraft par1Minecraft, final int par2, final int par3) {
        if (this.drawButton) {
            final FontRenderer fontrenderer = par1Minecraft.fontRenderer;
            par1Minecraft.getTextureManager().bindTexture(GuiTexturedButton.buttonTextures);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            this.field_82253_i = (par2 >= this.xPosition && par3 >= this.yPosition && par2 < this.xPosition + this.width && par3 < this.yPosition + this.height);
            final int k = this.getHoverState(this.field_82253_i);
            this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 46 + k * 20, this.width / 2, this.height);
            this.drawTexturedModalRect(this.xPosition + this.width / 2, this.yPosition, 200 - this.width / 2, 46 + k * 20, this.width / 2, this.height);
            this.mouseDragged(par1Minecraft, par2, par3);
            int l = 14737632;
            if (!this.enabled) {
                l = -6250336;
            }
            else if (this.field_82253_i) {
                l = 16777120;
            }
            this.drawCenteredString(fontrenderer, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, l);
        }
    }
    
    protected void mouseDragged(final Minecraft par1Minecraft, final int par2, final int par3) {
    }
    
    public void mouseReleased(final int par1, final int par2) {
    }
    
    public boolean mousePressed(final Minecraft par1Minecraft, final int par2, final int par3) {
        return this.enabled && this.drawButton && par2 >= this.xPosition && par3 >= this.yPosition && par2 < this.xPosition + this.width && par3 < this.yPosition + this.height;
    }
    
    public boolean func_82252_a() {
        return this.field_82253_i;
    }
    
    public void func_82251_b(final int par1, final int par2) {
    }
    
    static {
        GuiTexturedButton.buttonTextures = new ResourceLocation("textures/gui/widgets.png");
    }
}

package littlebreadloaf.bleachreborn.gui;

import net.minecraft.util.*;
import org.lwjgl.opengl.*;
import littlebreadloaf.bleachreborn.events.*;
import net.minecraft.client.gui.*;

public class GuiZanpakuto extends GuiScreen
{
    public final int guiWidth = 248;
    public final int guiHeight = 166;
    public static final ResourceLocation texture;
    
    public void drawScreen(final int x, final int y, final float f) {
        this.mc.getTextureManager().bindTexture(GuiZanpakuto.texture);
        final ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
        final int var6 = var5.getScaledWidth();
        final int var7 = var5.getScaledHeight();
        final FontRenderer var8 = this.mc.fontRenderer;
        this.drawDefaultBackground();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        final ExtendedPlayer props = (ExtendedPlayer)this.mc.thePlayer.getExtendedProperties("BleachPlayer");
        this.mc.mcProfiler.startSection("swordgui");
        final int var9 = var7 / 2 - 90;
        final int var10 = 0;
        this.drawTexturedModalRect(10, var9 + 18, 0, 0, 49, 152);
        
        this.drawTexturedModalRect(55, var9 + 18, 46, 0, 75, 153);
        super.drawScreen(x, y, f);
        this.mc.mcProfiler.endStartSection("hollowKills");
        String hkills = "" + props.getHollowKills();
        int varp13 = 33;
        var8.drawString(hkills, varp13 + 54, var9 + 29, 0);
        this.mc.mcProfiler.endStartSection("Flame");
        final boolean var11 = false;
        int var12 = 15859712;
        String var13 = "" + props.getPoints(1);
        int var14 = 33;
        var8.drawString(var13, var14 - 4, var9 + 26, 0);
        var8.drawString(var13, var14 - 2, var9 + 26, 0);
        var8.drawString(var13, var14 - 3, var9 + 25, 0);
        var8.drawString(var13, var14 - 3, var9 + 27, 0);
        var8.drawString(var13, var14 - 3, var9 + 26, var12);
        this.mc.mcProfiler.endStartSection("Name");
        final String var15 = props.getName();
        final int var16 = (int)(var8.getStringWidth(var15) * 0.5);
        var8.drawString(var15, 33 - var16, var9 + 13, 0);
        var8.drawString(var15, 31 - var16, var9 + 13, 0);
        var8.drawString(var15, 32 - var16, var9 + 12, 0);
        var8.drawString(var15, 32 - var16, var9 + 14, 0);
        var8.drawString(var15, 32 - var16, var9 + 13, 16777215);
        this.mc.mcProfiler.endStartSection("Ice");
        var12 = 4097012;
        var13 = "" + props.getPoints(2);
        var14 = 33;
        var8.drawString(var13, var14 - 4, var9 + 40, 0);
        var8.drawString(var13, var14 - 2, var9 + 40, 0);
        var8.drawString(var13, var14 - 3, var9 + 39, 0);
        var8.drawString(var13, var14 - 3, var9 + 41, 0);
        var8.drawString(var13, var14 - 3, var9 + 40, var12);
        this.mc.mcProfiler.endStartSection("Poison");
        var12 = 946176;
        var13 = "" + props.getPoints(3);
        var14 = 33;
        var8.drawString(var13, var14 - 4, var9 + 54, 0);
        var8.drawString(var13, var14 - 2, var9 + 54, 0);
        var8.drawString(var13, var14 - 3, var9 + 53, 0);
        var8.drawString(var13, var14 - 3, var9 + 55, 0);
        var8.drawString(var13, var14 - 3, var9 + 54, var12);
        this.mc.mcProfiler.endStartSection("Heal");
        var12 = 12320839;
        var13 = "" + props.getPoints(4);
        var14 = 33;
        var8.drawString(var13, var14 - 4, var9 + 68, 0);
        var8.drawString(var13, var14 - 2, var9 + 68, 0);
        var8.drawString(var13, var14 - 3, var9 + 67, 0);
        var8.drawString(var13, var14 - 3, var9 + 69, 0);
        var8.drawString(var13, var14 - 3, var9 + 68, var12);
        this.mc.mcProfiler.endStartSection("Earth");
        var12 = 6697728;
        var13 = "" + props.getPoints(5);
        var14 = 33;
        var8.drawString(var13, var14 - 4, var9 + 82, 0);
        var8.drawString(var13, var14 - 2, var9 + 82, 0);
        var8.drawString(var13, var14 - 3, var9 + 81, 0);
        var8.drawString(var13, var14 - 3, var9 + 83, 0);
        var8.drawString(var13, var14 - 3, var9 + 82, var12);
        this.mc.mcProfiler.endStartSection("Wind");
        var12 = 15656414;
        var13 = "" + props.getPoints(6);
        var14 = 33;
        var8.drawString(var13, var14 - 4, var9 + 96, 0);
        var8.drawString(var13, var14 - 2, var9 + 96, 0);
        var8.drawString(var13, var14 - 3, var9 + 95, 0);
        var8.drawString(var13, var14 - 3, var9 + 97, 0);
        var8.drawString(var13, var14 - 3, var9 + 96, var12);
        this.mc.mcProfiler.endStartSection("Light");
        var12 = 16777062;
        var13 = "" + props.getPoints(7);
        var14 = 33;
        var8.drawString(var13, var14 - 4, var9 + 110, 0);
        var8.drawString(var13, var14 - 2, var9 + 110, 0);
        var8.drawString(var13, var14 - 3, var9 + 109, 0);
        var8.drawString(var13, var14 - 3, var9 + 111, 0);
        var8.drawString(var13, var14 - 3, var9 + 110, var12);
        this.mc.mcProfiler.endStartSection("Dark");
        var12 = 3342438;
        var13 = "" + props.getPoints(8);
        var14 = 33;
        var8.drawString(var13, var14 - 4, var9 + 124, 0);
        var8.drawString(var13, var14 - 2, var9 + 124, 0);
        var8.drawString(var13, var14 - 3, var9 + 123, 0);
        var8.drawString(var13, var14 - 3, var9 + 125, 0);
        var8.drawString(var13, var14 - 3, var9 + 124, var12);
        this.mc.mcProfiler.endStartSection("Total");
        var12 = 16777215;
        var13 = "" + props.getPoints(9);
        var14 = 33;
        var8.drawString(var13, var14 - 4, var9 + 137, 0);
        var8.drawString(var13, var14 - 2, var9 + 137, 0);
        var8.drawString(var13, var14 - 3, var9 + 136, 0);
        var8.drawString(var13, var14 - 3, var9 + 138, 0);
        var8.drawString(var13, var14 - 3, var9 + 137, var12);
    }
    
    static {
        texture = new ResourceLocation("bleachreborn".toLowerCase(), "textures/guis/sword_gui.png");
    }
}

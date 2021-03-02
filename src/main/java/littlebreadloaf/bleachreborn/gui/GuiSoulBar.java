package littlebreadloaf.bleachreborn.gui;

import cpw.mods.fml.relauncher.*;
import net.minecraft.client.*;
import net.minecraft.util.*;
import net.minecraftforge.client.event.*;
import littlebreadloaf.bleachreborn.events.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.gui.*;
import cpw.mods.fml.common.eventhandler.*;

@SideOnly(Side.CLIENT)
public class GuiSoulBar extends Gui
{
    private Minecraft mc;
    private static final ResourceLocation texture;
    private static final ResourceLocation texture1;
    int flux;
    boolean neg;
    
    public GuiSoulBar(final Minecraft mc) {
        this.flux = 0;
        this.neg = false;
        this.mc = mc;
    }
    
    @SubscribeEvent
    public void onRenderExperienceBar(final RenderGameOverlayEvent event) {
        final ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
        final int var6 = var5.getScaledWidth();
        final int var7 = var5.getScaledHeight();
        final int var8 = var7 / 2 - 63;
        final int var9 = var6 - 12;
        if (event.isCancelable() || event.type != RenderGameOverlayEvent.ElementType.EXPERIENCE)
            return;
        final ExtendedPlayer props = (ExtendedPlayer)this.mc.thePlayer.getExtendedProperties("BleachPlayer");
        if (props == null || props.getCurrentCap() == 0)
            return;
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(2896);
        this.mc.getTextureManager().bindTexture(GuiSoulBar.texture);
        final FontRenderer var10 = this.mc.fontRenderer;
        if (props.getFaction() != 0) {
            final int var13 = (int)(props.getCurrentEnergy() * 92.0f);
            final int var14 = 91 - var13;
            this.drawTexturedModalRect(var9, var8, 0, 84, 10, 91);
            this.drawTexturedModalRect(var9, var8 + var14, 10, 84 + var14, 10, 91);
            this.mc.mcProfiler.endStartSection("SoulLevel");
            final String var16 = "" + (int)(props.getCurrentEnergy() * props.getCurrentCap());
            final int var17 = var6 - var10.getStringWidth(var16) + 10;
            var10.drawString(var16, var17 - 10, var8 + 43, 0);
            var10.drawString(var16, var17 - 12, var8 + 43, 0);
            var10.drawString(var16, var17 - 11, var8 + 42, 0);
            var10.drawString(var16, var17 - 11, var8 + 44, 0);
            var10.drawString(var16, var17 - 11, var8 + 43, 1953999);
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(2896);
        this.mc.getTextureManager().bindTexture(GuiSoulBar.texture1);
        if (props.getCurrentCap() == 10000 && props.getCapUnlocked() == false) {
        	this.drawTexturedModalRect(var9 - 22, var8 + 5, 0, 110, 20, 60);
        }
        this.mc.mcProfiler.startSection("isShinigami");
        int i2 = 1953999;
        String s = props.getFactionName();
        if(props.getFaction() == 3) {
            if(props.getCurrentHPoints() > 0) {
                if(this.neg) {
                    this.flux += 256;
                } else {
                    this.flux -= 256;
                }
                if(this.flux < -2560) {
                    this.neg = true;
                }
                if(this.flux > 25600) {
                    this.neg = false;
                }
                i2 = 15019520 + this.flux;
            }
        } else {
            int fact = props.getFaction();
            if(fact == 9 || fact == 10 || fact == 12 || fact == 13) {
                float xp = props.getCurrentSXP();
                //props.setGrowth(1 + (xp / 20));
            }
        }
        final int l2 = (var6 - var10.getStringWidth(s)) / 2;
        var10.drawString(s, l2 + 1, 5, 0);
        var10.drawString(s, l2 - 1, 5, 0);
        var10.drawString(s, l2, 6, 0);
        var10.drawString(s, l2, 4, 0);
        var10.drawString(s, l2, 5, i2);
        this.mc.mcProfiler.endSection();
    }
    
    static {
        texture = new ResourceLocation("bleachreborn".toLowerCase(), "textures/guis/spirit_bar.png");
        texture1 = new ResourceLocation("bleachreborn".toLowerCase(), "textures/guis/caplock.png");
    }
}

package littlebreadloaf.bleachreborn.extras;

import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.potion.*;
import net.minecraft.client.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.*;

public class PotionMagicEffect extends Potion
{
    private static final ResourceLocation potionIcons;
    private final int textureIndex;
    
    public PotionMagicEffect(final int id, final boolean isBadEffect, final int liquidColour, final int textureIndex) {
        super(id, isBadEffect, liquidColour);
        this.textureIndex = textureIndex;
    }
    
    public void performEffect(final EntityLivingBase entitylivingbase, final int strength) {
    }
    
    public void renderInventoryEffect(final int x, final int y, final PotionEffect effect, final Minecraft mc) {
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        mc.renderEngine.bindTexture(PotionMagicEffect.potionIcons);
        drawTexturedRect(x + 6, y + 7, 18 * (this.textureIndex % 4), 18 * (this.textureIndex / 4), 18, 18, 72, 72);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
    }
    
    public static void drawTexturedRect(final int x, final int y, final int u, final int v, final int width, final int height, final int textureWidth, final int textureHeight) {
        final float f = 1.0f / textureWidth;
        final float f2 = 1.0f / textureHeight;
        final Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV((double)x, (double)(y + height), 0.0, (double)(u * f), (double)((v + height) * f2));
        tessellator.addVertexWithUV((double)(x + width), (double)(y + height), 0.0, (double)((u + width) * f), (double)((v + height) * f2));
        tessellator.addVertexWithUV((double)(x + width), (double)y, 0.0, (double)((u + width) * f), (double)(v * f2));
        tessellator.addVertexWithUV((double)x, (double)y, 0.0, (double)(u * f), (double)(v * f2));
        tessellator.draw();
    }
    
    static {
        potionIcons = new ResourceLocation("bleachreborn", "textures/guis/potion_icons.png");
    }
}

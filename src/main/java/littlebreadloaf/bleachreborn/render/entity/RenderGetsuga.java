package littlebreadloaf.bleachreborn.render.entity;

import net.minecraft.client.renderer.entity.*;
import cpw.mods.fml.relauncher.*;
import littlebreadloaf.bleachreborn.entities.*;
import net.minecraft.entity.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;

@SideOnly(Side.CLIENT)
public class RenderGetsuga extends Render
{
    private static final ResourceLocation arrowTextures;
    
    public void renderGetsuga(final EntityGetsuga par1EntityGetsuga, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.bindEntityTexture((Entity)par1EntityGetsuga);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)par2, (float)par4, (float)par6);
        GL11.glRotatef(par1EntityGetsuga.prevRotationYaw + (par1EntityGetsuga.rotationYaw - par1EntityGetsuga.prevRotationYaw) * par9 - 90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(par1EntityGetsuga.prevRotationPitch + (par1EntityGetsuga.rotationPitch - par1EntityGetsuga.prevRotationPitch) * par9, 0.0f, 0.0f, 1.0f);
        final Tessellator tessellator = Tessellator.instance;
        final byte b0 = 0;
        final float f2 = 0.0f;
        final float f3 = 0.5f;
        final float f4 = 0.0f;
        final float f5 = 0.15625f;
        final float f6 = 0.0f;
        final float f7 = 0.15625f;
        final float f8 = 0.15625f;
        final float f9 = 0.3125f;
        final float f10 = 0.05625f;
        GL11.glEnable(32826);
        final float f11 = par1EntityGetsuga.arrowShake - par9;
        if (f11 > 0.0f) {
            final float f12 = -MathHelper.sin(f11 * 3.0f) * f11;
            GL11.glRotatef(f12, 0.0f, 0.0f, 1.0f);
        }
        GL11.glRotatef(45.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScalef(0.05625f, 0.05625f, 0.05625f);
        GL11.glTranslatef(-4.0f, 0.0f, 0.0f);
        GL11.glNormal3f(0.05625f, 0.0f, 0.0f);
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(-7.0, -2.0, -2.0, 0.0, 0.15625);
        tessellator.addVertexWithUV(-7.0, -2.0, 2.0, 0.15625, 0.15625);
        tessellator.addVertexWithUV(-7.0, 2.0, 2.0, 0.15625, 0.3125);
        tessellator.addVertexWithUV(-7.0, 2.0, -2.0, 0.0, 0.3125);
        tessellator.draw();
        GL11.glNormal3f(-0.05625f, 0.0f, 0.0f);
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(-7.0, 2.0, -2.0, 0.0, 0.15625);
        tessellator.addVertexWithUV(-7.0, 2.0, 2.0, 0.15625, 0.15625);
        tessellator.addVertexWithUV(-7.0, -2.0, 2.0, 0.15625, 0.3125);
        tessellator.addVertexWithUV(-7.0, -2.0, -2.0, 0.0, 0.3125);
        tessellator.draw();
        for (int i = 0; i < 4; ++i) {
            GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
            GL11.glNormal3f(0.0f, 0.0f, 0.05625f);
            tessellator.startDrawingQuads();
            tessellator.addVertexWithUV(-8.0, -2.0, 0.0, 0.0, 0.0);
            tessellator.addVertexWithUV(8.0, -2.0, 0.0, 0.5, 0.0);
            tessellator.addVertexWithUV(8.0, 2.0, 0.0, 0.5, 0.15625);
            tessellator.addVertexWithUV(-8.0, 2.0, 0.0, 0.0, 0.15625);
            tessellator.draw();
        }
        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }
    
    protected ResourceLocation getArrowTextures(final EntityGetsuga par1EntityGetsuga) {
        return RenderGetsuga.arrowTextures;
    }
    
    protected ResourceLocation getEntityTexture(final Entity par1Entity) {
        return this.getArrowTextures((EntityGetsuga)par1Entity);
    }
    
    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.renderGetsuga((EntityGetsuga)par1Entity, par2, par4, par6, par8, par9);
    }
    
    static {
        arrowTextures = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/items/getsugaarrows.png");
    }
}

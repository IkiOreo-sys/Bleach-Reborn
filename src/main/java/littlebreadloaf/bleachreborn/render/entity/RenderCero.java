package littlebreadloaf.bleachreborn.render.entity;

import net.minecraft.client.renderer.entity.*;
import cpw.mods.fml.relauncher.*;
import littlebreadloaf.bleachreborn.entities.*;
import net.minecraft.util.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;

@SideOnly(Side.CLIENT)
public class RenderCero extends Render
{
    private static final ResourceLocation arrowTextures;
    private static final ResourceLocation ceroTexture;
    
    public void renderCero(final EntityCero par1EntityCero, final double par2, final double par4, final double par6, final float par8, final float par9) {
        if (par1EntityCero.startingX != 0.0 && par1EntityCero.startingY != 0.0 && par1EntityCero.startingZ != 0.0) {
            final float f2 = par9 + 0.8f;
            float f3 = MathHelper.sin(f2 * 0.2f) / 2.0f + 0.5f;
            f3 = (f3 * f3 + f3) * 0.2f;
            final float f4 = (float)(par1EntityCero.startingX - par1EntityCero.posX - (par1EntityCero.prevPosX - par1EntityCero.posX) * (1.0f - par9));
            final float f5 = (float)(f3 + par1EntityCero.startingY - 1.2 - par1EntityCero.posY - (par1EntityCero.prevPosY - par1EntityCero.posY) * (1.0f - par9));
            final float f6 = (float)(par1EntityCero.startingZ - par1EntityCero.posZ - (par1EntityCero.prevPosZ - par1EntityCero.posZ) * (1.0f - par9));
            final float f7 = MathHelper.sqrt_float(f4 * f4 + f6 * f6);
            final float f8 = MathHelper.sqrt_float(f4 * f4 + f5 * f5 + f6 * f6);
            GL11.glPushMatrix();
            GL11.glTranslatef((float)par2, (float)par4 + 2.0f, (float)par6);
            GL11.glRotatef((float)(-Math.atan2(f6, f4)) * 180.0f / 3.1415927f - 90.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef((float)(-Math.atan2(f7, f5)) * 180.0f / 3.1415927f - 90.0f, 1.0f, 0.0f, 0.0f);
            final Tessellator tessellator = Tessellator.instance;
            RenderHelper.disableStandardItemLighting();
            GL11.glDisable(2884);
            this.bindTexture(RenderCero.ceroTexture);
            GL11.glShadeModel(7425);
            final float f9 = 0.0f - (par1EntityCero.ticksExisted + par9) * 0.01f;
            final float f10 = MathHelper.sqrt_float(f4 * f4 + f5 * f5 + f6 * f6) / 32.0f - (par1EntityCero.ticksExisted + par9) * 0.01f;
            tessellator.startDrawing(5);
            final byte b0 = 8;
            for (int i = 0; i <= 8; ++i) {
                final float f11 = MathHelper.sin(i % 8 * 3.1415927f * 2.0f / 8.0f) * 0.75f;
                final float f12 = MathHelper.cos(i % 8 * 3.1415927f * 2.0f / 8.0f) * 0.75f;
                final float f13 = i % 8 * 1.0f / 8.0f;
                tessellator.setColorOpaque_I(10223616);
                tessellator.addVertexWithUV((double)(f11 * 0.2f), (double)(f12 * 0.2f), 0.0, (double)f13, (double)f10);
                tessellator.setColorOpaque_I(16777215);
                tessellator.addVertexWithUV((double)f11, (double)f12, (double)f8, (double)f13, (double)f9);
            }
            tessellator.draw();
            GL11.glEnable(2884);
            GL11.glShadeModel(7424);
            RenderHelper.enableStandardItemLighting();
            GL11.glPopMatrix();
        }
    }
    
    protected ResourceLocation getArrowTextures(final EntityCero par1EntityCero) {
        return RenderCero.arrowTextures;
    }
    
    protected ResourceLocation getEntityTexture(final Entity par1Entity) {
        return this.getArrowTextures((EntityCero)par1Entity);
    }
    
    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.renderCero((EntityCero)par1Entity, par2, par4, par6, par8, par9);
        this.renderLine((EntityCero)par1Entity, par2, par4, par6, par8, par9);
    }
    
    private void renderLine(final EntityCero par1Entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
    }
    
    private double func_110828_a(final double par1, final double par3, final double par5) {
        return par1 + (par3 - par1) * par5;
    }
    
    static {
        arrowTextures = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/items/energyarrows.png");
        ceroTexture = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/blocks/cero.png");
    }
}

package littlebreadloaf.bleachreborn.render;

import net.minecraftforge.client.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.client.*;
import littlebreadloaf.bleachreborn.*;
import org.lwjgl.opengl.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;
import cpw.mods.fml.client.*;
import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;

public class SkyRendererHuecoMundo extends IRenderHandler
{
    private static final ResourceLocation TEXTURE_SKY;
    private static final ResourceLocation TEXTURE_MOON;
    
    @SideOnly(Side.CLIENT)
    public void render(final float partialTicks, final WorldClient world, final Minecraft mc) {
        if (world.provider.dimensionId == BleachIds.worldHuecoMundoID) {
            final float f18 = world.getStarBrightness(partialTicks) * (1.0f - world.getRainStrength(partialTicks));
            this.renderNightSky(partialTicks);
            GL11.glDisable(3553);
            final Vec3 vec3 = world.getSkyColor((Entity)mc.renderViewEntity, partialTicks);
            float f19 = (float)vec3.xCoord;
            float f20 = (float)vec3.yCoord;
            float f21 = (float)vec3.zCoord;
            if (mc.gameSettings.anaglyph) {
                final float f22 = (f19 * 30.0f + f20 * 59.0f + f21 * 11.0f) / 100.0f;
                final float f23 = (f19 * 30.0f + f20 * 70.0f) / 100.0f;
                final float f24 = (f19 * 30.0f + f21 * 70.0f) / 100.0f;
                f19 = f22;
                f20 = f23;
                f21 = f24;
            }
            GL11.glColor3f(f19, f20, f21);
            final Tessellator tessellator1 = Tessellator.instance;
            GL11.glDepthMask(false);
            GL11.glDisable(3008);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            RenderHelper.disableStandardItemLighting();
            final float[] afloat = world.provider.calcSunriseSunsetColors(world.getCelestialAngle(partialTicks), partialTicks);
            if (afloat != null) {
                GL11.glDisable(3553);
                GL11.glShadeModel(7425);
                GL11.glPushMatrix();
                GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(135.0f, 0.0f, 0.0f, 1.0f);
                GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                float f24 = afloat[0];
                float f25 = afloat[1];
                float f26 = afloat[2];
                if (mc.gameSettings.anaglyph) {
                    final float f27 = (f24 * 30.0f + f25 * 59.0f + f26 * 11.0f) / 100.0f;
                    final float f28 = (f24 * 30.0f + f25 * 70.0f) / 100.0f;
                    final float f29 = (f24 * 30.0f + f26 * 70.0f) / 100.0f;
                    f24 = f27;
                    f25 = f28;
                    f26 = f29;
                }
                tessellator1.startDrawing(6);
                tessellator1.setColorRGBA_F(f24, f25, f26, afloat[3]);
                tessellator1.addVertex(0.0, 100.0, 0.0);
                final byte b0 = 16;
                tessellator1.setColorRGBA_F(afloat[0], afloat[1], afloat[2], 0.0f);
                for (int j = 0; j <= 16; ++j) {
                    final float f29 = j * 3.1415927f * 2.0f / 16.0f;
                    final float f30 = MathHelper.sin(f29);
                    final float f31 = MathHelper.cos(f29);
                    tessellator1.addVertex((double)(f30 * 120.0f), (double)(f31 * 120.0f), (double)(-f31 * 40.0f * afloat[3]));
                }
                tessellator1.draw();
                GL11.glPopMatrix();
                GL11.glShadeModel(7424);
            }
            GL11.glEnable(3553);
            GL11.glBlendFunc(770, 1);
            GL11.glPushMatrix();
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glTranslatef(0.0f, 0.0f, 0.0f);
            GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(135.0f, 1.0f, 0.0f, 0.0f);
            float f32 = 20.0f;
            FMLClientHandler.instance().getClient().renderEngine.bindTexture(SkyRendererHuecoMundo.TEXTURE_MOON);
            tessellator1.startDrawingQuads();
            tessellator1.addVertexWithUV((double)(-f32), -100.0, (double)f32, 0.0, 1.0);
            tessellator1.addVertexWithUV((double)f32, -100.0, (double)f32, 1.0, 1.0);
            tessellator1.addVertexWithUV((double)f32, -100.0, (double)(-f32), 1.0, 0.0);
            tessellator1.addVertexWithUV((double)(-f32), -100.0, (double)(-f32), 0.0, 0.0);
            tessellator1.draw();
            GL11.glDisable(3553);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glDisable(3042);
            GL11.glEnable(3008);
            GL11.glEnable(2912);
            GL11.glPopMatrix();
            GL11.glDisable(3553);
            GL11.glColor3f(0.0f, 0.0f, 0.0f);
            final double d0 = mc.thePlayer.getPosition(partialTicks).yCoord - world.getHorizon();
            if (d0 < 0.0) {
                final float f33 = 1.0f;
                final float f34 = -(float)(d0 + 65.0);
                f32 = -1.0f;
                tessellator1.startDrawingQuads();
                tessellator1.setColorRGBA_I(0, 255);
                tessellator1.addVertex(-1.0, (double)f34, 1.0);
                tessellator1.addVertex(1.0, (double)f34, 1.0);
                tessellator1.addVertex(1.0, (double)f32, 1.0);
                tessellator1.addVertex(-1.0, (double)f32, 1.0);
                tessellator1.addVertex(-1.0, (double)f32, -1.0);
                tessellator1.addVertex(1.0, (double)f32, -1.0);
                tessellator1.addVertex(1.0, (double)f34, -1.0);
                tessellator1.addVertex(-1.0, (double)f34, -1.0);
                tessellator1.addVertex(1.0, (double)f32, -1.0);
                tessellator1.addVertex(1.0, (double)f32, 1.0);
                tessellator1.addVertex(1.0, (double)f34, 1.0);
                tessellator1.addVertex(1.0, (double)f34, -1.0);
                tessellator1.addVertex(-1.0, (double)f34, -1.0);
                tessellator1.addVertex(-1.0, (double)f34, 1.0);
                tessellator1.addVertex(-1.0, (double)f32, 1.0);
                tessellator1.addVertex(-1.0, (double)f32, -1.0);
                tessellator1.addVertex(-1.0, (double)f32, -1.0);
                tessellator1.addVertex(-1.0, (double)f32, 1.0);
                tessellator1.addVertex(1.0, (double)f32, 1.0);
                tessellator1.addVertex(1.0, (double)f32, -1.0);
                tessellator1.draw();
            }
            GL11.glEnable(3553);
            GL11.glDepthMask(true);
        }
    }
    
    private void renderNightSky(final float partialTicks) {
        GL11.glDisable(2912);
        GL11.glDisable(3008);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        RenderHelper.disableStandardItemLighting();
        GL11.glDepthMask(false);
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(SkyRendererHuecoMundo.TEXTURE_SKY);
        final Tessellator tessellator = Tessellator.instance;
        GL11.glColor4f(0.4f, 0.4f, 0.4f, 1.0f);
        for (int i = 0; i < 6; ++i) {
            GL11.glPushMatrix();
            if (i == 1) {
                GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
            }
            if (i == 2) {
                GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
            }
            if (i == 3) {
                GL11.glRotatef(180.0f, 1.0f, 0.0f, 0.0f);
            }
            if (i == 4) {
                GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            }
            if (i == 5) {
                GL11.glRotatef(-90.0f, 0.0f, 0.0f, 1.0f);
            }
            tessellator.startDrawingQuads();
            tessellator.addVertexWithUV(-100.0, -100.0, -100.0, 0.0, 0.0);
            tessellator.addVertexWithUV(-100.0, -100.0, 100.0, 0.0, 2.0);
            tessellator.addVertexWithUV(100.0, -100.0, 100.0, 2.0, 2.0);
            tessellator.addVertexWithUV(100.0, -100.0, -100.0, 2.0, 0.0);
            tessellator.draw();
            GL11.glPopMatrix();
        }
        GL11.glDepthMask(true);
        GL11.glEnable(3553);
        GL11.glEnable(3008);
    }
    
    static {
        TEXTURE_SKY = new ResourceLocation("bleachreborn:textures/environment/hueco_mundo_sky.png");
        TEXTURE_MOON = new ResourceLocation("bleachreborn:textures/environment/moon.png");
    }
}

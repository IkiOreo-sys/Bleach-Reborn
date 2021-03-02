package littlebreadloaf.bleachreborn.extras;

import net.minecraft.client.*;
import net.minecraft.world.*;
import net.minecraft.client.particle.*;

public class ParticleEffects
{
    private static Minecraft mc;
    private static World theWorld;
    private static boolean red;
    
    public static EntityFX spawnParticle(final String var0, final double var1, final double var3, final double var5, final double var7, final double var9, final double var11) {
        if (ParticleEffects.mc == null || ParticleEffects.mc.renderViewEntity == null || ParticleEffects.mc.effectRenderer == null) {
            return null;
        }
        int var12 = ParticleEffects.mc.gameSettings.particleSetting;
        if (var12 == 1 && ParticleEffects.theWorld.rand.nextInt(3) == 0) {
            var12 = 2;
        }
        final double var13 = ParticleEffects.mc.renderViewEntity.posX - var1;
        final double var14 = ParticleEffects.mc.renderViewEntity.posY - var3;
        final double var15 = ParticleEffects.mc.renderViewEntity.posZ - var5;
        EntitySoulFX var16 = null;
        EntitySpiritFX var17 = null;
        EntityTenshoFX var18 = null;
        EntityPoisonGasFX var19 = null;
        EntityWindFX var20 = null;
        final double var21 = 16.0;
        if (var13 * var13 + var14 * var14 + var15 * var15 > 256.0) {
            return null;
        }
        if (var12 > 1) {
            return null;
        }
        if (var0.equals("soul")) {
            var16 = new EntitySoulFX(ParticleEffects.theWorld, var1, var3, var5, (float)var7, (float)var9, (float)var11);
            ParticleEffects.mc.effectRenderer.addEffect((EntityFX)var16);
            return var16;
        }
        if (var0.equals("spirit")) {
            var17 = new EntitySpiritFX(ParticleEffects.theWorld, var1, var3, var5, var7, var9, var11);
            ParticleEffects.mc.effectRenderer.addEffect((EntityFX)var17);
            return var17;
        }
        if (var0.equals("tensho")) {
            var18 = new EntityTenshoFX(ParticleEffects.theWorld, var1, var3, var5, var7, var9, var11);
            ParticleEffects.mc.effectRenderer.addEffect((EntityFX)var18);
            return var18;
        }
        if (var0.equals("poison")) {
            var19 = new EntityPoisonGasFX(ParticleEffects.theWorld, var1, var3, var5, (float)var7, (float)var9, (float)var11);
            ParticleEffects.mc.effectRenderer.addEffect((EntityFX)var19);
            return var19;
        }
        if (var0.equals("wind")) {
            var20 = new EntityWindFX(ParticleEffects.theWorld, var1, var3, var5, (float)var7, (float)var9, (float)var11);
            ParticleEffects.mc.effectRenderer.addEffect((EntityFX)var20);
            var20 = new EntityWindFX(ParticleEffects.theWorld, var1 - 1.0, var3, var5 + 0.5, (float)var7 + 1.0f, (float)var9, (float)var11 + 1.0f);
            ParticleEffects.mc.effectRenderer.addEffect((EntityFX)var20);
            var20 = new EntityWindFX(ParticleEffects.theWorld, var1 - 2.0, var3, var5 + 1.0, (float)var7 + 2.0f, (float)var9, (float)var11 + 2.0f);
            ParticleEffects.mc.effectRenderer.addEffect((EntityFX)var20);
            var20 = new EntityWindFX(ParticleEffects.theWorld, var1 - 3.0, var3, var5 + 1.5, (float)var7 + 3.0f, (float)var9, (float)var11 + 3.0f);
            ParticleEffects.mc.effectRenderer.addEffect((EntityFX)var20);
            var20 = new EntityWindFX(ParticleEffects.theWorld, var1 - 4.0, var3, var5 + 2.0, (float)var7 + 4.0f, (float)var9, (float)var11 + 4.0f);
            ParticleEffects.mc.effectRenderer.addEffect((EntityFX)var20);
            return var20;
        }
        return null;
    }
    
    static {
        ParticleEffects.mc = Minecraft.getMinecraft();
        ParticleEffects.theWorld = (World)ParticleEffects.mc.theWorld;
        ParticleEffects.red = true;
    }
}

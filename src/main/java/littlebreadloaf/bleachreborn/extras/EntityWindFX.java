package littlebreadloaf.bleachreborn.extras;

import net.minecraft.client.particle.*;
import net.minecraft.world.*;
import net.minecraft.client.renderer.*;

public class EntityWindFX extends EntityFX
{
    float reddustParticleScale;
    float Radius;
    float motionXBegin;
    float motionZBegin;
    int counter;
    
    public EntityWindFX(final World var1, final double var2, final double var4, final double var6, final float var8, final float var9, final float var10) {
        this(var1, var2, var4, var6, 1.0f, var8, var9, var10);
    }
    
    public EntityWindFX(final World var1, final double var2, final double var4, final double var6, final float var8, float var9, final float var10, final float var11) {
        super(var1, var2, var4, var6, 0.0, 0.0, 0.0);
        this.motionXBegin = var9;
        this.motionZBegin = var11;
        if (var9 == 0.0f) {
            var9 = 1.0f;
        }
        final float var12 = (float)Math.random() * 0.4f + 0.6f;
        this.particleRed = 2.0f;
        this.particleGreen = 2.0f;
        this.particleBlue = 2.0f;
        this.particleScale *= 0.75f;
        this.particleScale *= var8;
        this.Radius = 1.0f + this.rand.nextFloat() + this.rand.nextInt(5);
        this.reddustParticleScale = this.particleScale;
        this.particleMaxAge = (int)(10.0 / (Math.random() * 0.8 + 0.2));
        this.particleMaxAge *= (int)var8;
        this.noClip = false;
    }
    
    public int getBrightnessForRender(final float par1) {
        return 205;
    }
    
    public float getBrightness(final float par1) {
        float f1 = (this.particleAge + par1) / this.particleMaxAge;
        if (f1 < 0.0f) {
            f1 = 0.0f;
        }
        if (f1 > 1.0f) {
            f1 = 1.0f;
        }
        final float f2 = super.getBrightness(par1);
        return f2 * f1 + (1.0f - f1);
    }
    
    public void renderParticle(final Tessellator var1, final float var2, final float var3, final float var4, final float var5, final float var6, final float var7) {
        float var8 = (this.particleAge + var2) / this.particleMaxAge * 32.0f;
        if (var8 < 0.0f) {
            var8 = 0.0f;
        }
        if (var8 > 1.0f) {
            var8 = 1.0f;
        }
        this.particleScale = this.reddustParticleScale * var8 * 4.0f;
        super.renderParticle(var1, var2, var3, var4, var5, var6, var7);
    }
    
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        ++this.counter;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setDead();
        }
        this.setParticleTextureIndex(7 - this.particleAge * 8 / this.particleMaxAge);
        this.motionY *= 0.5599999785423279;
        this.motionX = Math.sin(this.counter) * this.motionXBegin;
        this.motionZ = Math.cos(this.counter) * this.motionZBegin;
        if (this != null) {
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
        }
        if (this.onGround) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
    }
}

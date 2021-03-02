package littlebreadloaf.bleachreborn.extras;

import net.minecraft.client.particle.*;
import net.minecraft.world.*;
import net.minecraft.client.renderer.*;

public class EntityPoisonGasFX extends EntityFX
{
    float reddustParticleScale;
    
    public EntityPoisonGasFX(final World var1, final double var2, final double var4, final double var6, final float var8, final float var9, final float var10) {
        this(var1, var2, var4, var6, 1.0f, var8, var9, var10);
    }
    
    public EntityPoisonGasFX(final World var1, final double var2, final double var4, final double var6, final float var8, float var9, final float var10, final float var11) {
        super(var1, var2, var4, var6, 0.0, 0.0, 0.0);
        this.motionX *= 0.10000000149011612;
        this.motionY *= 0.10000000149011612;
        this.motionZ *= 0.10000000149011612;
        if (var9 == 0.0f) {
            var9 = 1.0f;
        }
        final float var12 = (float)Math.random() * 0.4f + 0.6f;
        this.particleRed = 0.0f;
        this.particleGreen = 2.0f;
        this.particleBlue = 0.5f;
        this.particleScale *= 0.75f;
        this.particleScale *= var8;
        this.reddustParticleScale = this.particleScale;
        this.particleMaxAge = (int)(24.0 / (Math.random() * 0.8 + 0.2));
        this.particleMaxAge *= (int)var8;
        this.noClip = false;
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
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setDead();
        }
        this.setParticleTextureIndex(7 - this.particleAge * 8 / this.particleMaxAge);
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        if (this.posY == this.prevPosY) {
            this.motionX *= 1.1;
            this.motionZ *= 1.1;
        }
        this.motionX *= 0.9599999785423279;
        this.motionY *= 0.9599999785423279;
        this.motionZ *= 0.9599999785423279;
        if (this.onGround) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
    }
}

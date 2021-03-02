package littlebreadloaf.bleachreborn.extras;

import net.minecraft.client.particle.*;
import net.minecraft.world.*;
import net.minecraft.client.renderer.*;

public class EntitySpiritFX extends EntityFX
{
    private float flameScale;
    int counter;
    
    public EntitySpiritFX(final World par1World, final double par2, final double par4, final double par6, final double par8, final double par10, final double par12) {
        super(par1World, par2, par4, par6, par8, par10, par12);
        this.motionX = 1.0;
        this.motionY = this.motionY * 0.009999999776482582 + par10;
        this.motionZ = 1.0;
        double d6 = par2 + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.05f;
        d6 = par4 + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.05f;
        d6 = par6 + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.05f;
        this.flameScale = this.particleScale;
        this.particleRed = 1.0f;
        this.particleGreen = 1.0f;
        this.particleBlue = 1.0f;
        this.particleMaxAge = (int)(8.0 / (Math.random() * 0.8 + 0.2)) + 4;
        this.noClip = true;
        this.setParticleTextureIndex(96);
    }
    
    public void renderParticle(final Tessellator par1Tessellator, final float par2, final float par3, final float par4, final float par5, final float par6, final float par7) {
        final float f6 = (this.particleAge + par2) / this.particleMaxAge;
        this.particleScale = this.flameScale * (1.0f - f6 * f6 * 0.5f);
        super.renderParticle(par1Tessellator, par2, par3, par4, par5, par6, par7);
    }
    
    public int getBrightnessForRender(final float par1) {
        float f1 = (this.particleAge + par1) / this.particleMaxAge;
        if (f1 < 0.0f) {
            f1 = 0.0f;
        }
        if (f1 > 1.0f) {
            f1 = 1.0f;
        }
        final int i = super.getBrightnessForRender(par1);
        int j = i & 0xFF;
        final int k = i >> 16 & 0xFF;
        j += (int)(f1 * 15.0f * 16.0f);
        if (j > 240) {
            j = 240;
        }
        return j | k << 16;
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
    
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        ++this.counter;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setDead();
        }
        this.motionX = Math.sin(this.counter);
        this.motionY *= 0.9599999785423279;
        this.motionZ = Math.cos(this.counter);
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        if (this.onGround) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
    }
}

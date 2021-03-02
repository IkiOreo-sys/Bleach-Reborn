package littlebreadloaf.bleachreborn.entities;

import net.minecraft.entity.projectile.*;
import net.minecraft.world.*;
import littlebreadloaf.bleachreborn.api.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.potion.*;

public class EntityGlob extends EntityThrowable
{
    private static final String __OBFID = "CL_00001722";
    
    public EntityGlob(final World par1World) {
        super(par1World);
    }
    
    public EntityGlob(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
    }
    
    public EntityGlob(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }
    
    protected void onImpact(final MovingObjectPosition par1MovingObjectPosition) {
        if (par1MovingObjectPosition.entityHit != null && par1MovingObjectPosition.entityHit instanceof EntityLivingBase) {
            final EntityLivingBase entity = (EntityLivingBase)par1MovingObjectPosition.entityHit;
            byte b0 = 1;
            if (entity.getCreatureAttribute() == Tools.SPIRIT) {
                b0 = 4;
            }
            entity.attackEntityFrom(DamageSource.causeThrownDamage((Entity)this, (Entity)this.getThrower()), (float)b0);
            if (this.rand.nextInt(5) == 0) {
                entity.addPotionEffect(new PotionEffect(Potion.poison.id, 80, 0));
            }
        }
        for (int i = 0; i < 8; ++i) {
            this.worldObj.spawnParticle("slime", this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0);
        }
        if (!this.worldObj.isRemote) {
            this.setDead();
        }
    }
}

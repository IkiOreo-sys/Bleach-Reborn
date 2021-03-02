package littlebreadloaf.bleachreborn.entities.ai;

import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import littlebreadloaf.bleachreborn.entities.EntityGigai;
import littlebreadloaf.bleachreborn.events.ExtendedPlayer;
import net.minecraft.entity.*;

public class EntityBleachAISit extends EntityAIBase
{
    private EntityGigai theEntity;
    private boolean isSitting;
    
    public EntityBleachAISit(final EntityGigai entity) {
        this.theEntity = entity;
        this.setMutexBits(5);
    }
    
    public boolean shouldExecute() {
        if (!this.theEntity.isTamed()) {
            return false;
        }
        if (this.theEntity.isInWater()) {
            return false;
        }
        if (!this.theEntity.onGround) {
            return false;
        }
        final EntityLivingBase entitylivingbase = this.theEntity.getOwner();
        if (entitylivingbase != null) {
        	ExtendedPlayer props = ExtendedPlayer.get((EntityPlayer) entitylivingbase);
        	if (props.getStay() == 0) {
            	return false;
            }
        }
        
        return entitylivingbase == null || ((this.theEntity.getDistanceSqToEntity((Entity)entitylivingbase) >= 144.0 || entitylivingbase.getAITarget() == null) && this.isSitting);
    }
    
    public void startExecuting() {
        this.theEntity.getNavigator().clearPathEntity();
        this.theEntity.setSitting(true);
    }
    
    public void resetTask() {
        this.theEntity.setSitting(false);
    }
    
    public void setSitting(final boolean par1) {
        this.isSitting = par1;
    }
}

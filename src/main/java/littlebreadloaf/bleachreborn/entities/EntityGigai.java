package littlebreadloaf.bleachreborn.entities;

import littlebreadloaf.bleachreborn.armor.Armor;
import littlebreadloaf.bleachreborn.entities.ai.EntityBleachAIAttackOnCollide;
import littlebreadloaf.bleachreborn.entities.ai.EntityBleachAIFollowOwner;
import littlebreadloaf.bleachreborn.entities.ai.EntityBleachAISit;
import littlebreadloaf.bleachreborn.events.ExtendedPlayer;
import littlebreadloaf.bleachreborn.items.BleachItems;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityGigai extends EntityTameable
{
	
	public EntityBleachAISit bleachaiSit;
	
    public EntityGigai(final World par1World) {
        super(par1World);
        this.setSize(1.4f, 2.9f);
        this.setupAI();
    }
    
    protected void setupAI() {
        this.getNavigator().setAvoidsWater(false);
        this.clearAITasks();
        this.bleachaiSit = new EntityBleachAISit(this);
        this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.tasks.addTask(1, (EntityAIBase)this.bleachaiSit);
        this.tasks.addTask(2, (EntityAIBase)new EntityBleachAIFollowOwner((EntityTameable)this, 0.5, 10.0f, 2.0f));
        this.tasks.addTask(3, (EntityAIBase)new EntityBleachAIAttackOnCollide(this, (EntityCreature)this, (Class)EntityLiving.class, 1.0, false));
        this.tasks.addTask(4, (EntityAIBase)new EntityBleachAIAttackOnCollide(this, (EntityCreature)this, (Class)EntityPlayer.class, 1.0, false));
        this.tasks.addTask(5, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityLiving.class, 8.0f));
        this.tasks.addTask(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.tasks.addTask(7, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAIOwnerHurtByTarget((EntityTameable)this));
        this.targetTasks.addTask(2, (EntityAIBase)new EntityAIOwnerHurtTarget((EntityTameable)this));
        this.targetTasks.addTask(3, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
    }
    
    protected void clearAITasks() {
        this.tasks.taskEntries.clear();
        this.targetTasks.taskEntries.clear();
    }
    
    public boolean isAIEnabled() {
        return true;
    }
    
    public EntityBleachAISit sittingAI() {
        return this.bleachaiSit;
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5);
    }
    
    public boolean attackEntityAsMob(final Entity par1Entity) {
        return par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 25.0f);
    }
    
    public String getTexture() {
    	AbstractClientPlayer plr = (AbstractClientPlayer) this.getOwner();
		return plr.getLocationSkin().toString();
    }
    
    public void onDeath(final DamageSource par1DamageSource) {
        super.onDeath(par1DamageSource);
        if (this.isTamed()) {
	        final EntityPlayer var7 = (EntityPlayer)this.getOwner();
	        final ExtendedPlayer props = ExtendedPlayer.get(var7);
	        props.setBodyID("");
	        var7.inventory.consumeInventoryItem(BleachItems.control);
	        var7.inventoryContainer.detectAndSendChanges();
        }
    }
    
    @Override
    public EntityAgeable createChild(final EntityAgeable p_90011_1_) {
        return null;
    }
}

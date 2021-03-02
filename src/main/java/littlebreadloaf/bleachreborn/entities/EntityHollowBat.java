package littlebreadloaf.bleachreborn.entities;

import java.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.ai.*;
import net.minecraft.world.*;
import littlebreadloaf.bleachreborn.ConfigHandler;
import littlebreadloaf.bleachreborn.api.*;
import littlebreadloaf.bleachreborn.items.*;
import net.minecraft.item.*;
import littlebreadloaf.bleachreborn.armor.*;
import net.minecraft.entity.*;
import net.minecraft.potion.*;
import net.minecraft.util.*;
import littlebreadloaf.bleachreborn.events.*;
import net.minecraft.nbt.*;

public class EntityHollowBat extends EntityMob
{
    private static Random rand;
    public int courseChangeCooldown;
    private ChunkCoordinates currentFlightTarget;
    
    public EntityHollowBat(final World par1) {
        this(par1, EntityHollowBat.rand.nextInt(3));
    }
    
    public EntityHollowBat(final World par1World, final int par2) {
        super(par1World);
        this.setTexture(par2);
        this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityPlayer.class, 0.6, false));
        this.tasks.addTask(2, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityWhole.class, 0.4, false));
        this.tasks.addTask(3, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityShinigami.class, 0.4, false));
        this.tasks.addTask(4, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, (Class)EntityIronGolem.class, 6.0f, 0.30000001192092896, 0.30000001192092896));
        this.tasks.addTask(5, (EntityAIBase)new EntityAIMoveTowardsRestriction((EntityCreature)this, 0.4));
        this.tasks.addTask(6, (EntityAIBase)new EntityAIWander((EntityCreature)this, 0.4));
        this.tasks.addTask(7, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.tasks.addTask(8, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.tasks.addTask(9, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityWhole.class, 8.0f));
        this.targetTasks.addTask(0, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, 0, true));
        this.targetTasks.addTask(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityWhole.class, 0, false));
        this.targetTasks.addTask(3, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityShinigami.class, 0, false));
        this.experienceValue = 15;
        this.isImmuneToFire = true;
        this.setSize(0.5f, 0.9f);
    }
    
    protected boolean isAIEnabled() {
        return true;
    }
    
    public int getTotalArmorValue() {
        return 4;
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL || this.worldObj.difficultySetting == EnumDifficulty.HARD) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(ConfigHandler.batHP);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0);
        }
        else {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(150.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(8.0);
        }
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(50.0);
    }
    
    public EnumCreatureAttribute getCreatureAttribute() {
        return Tools.SPIRIT;
    }
    
    protected String getHurtSound() {
        if (EntityHollowBat.rand.nextInt(100) >= 50) {
            return "bleachreborn:hollowscream";
        }
        return null;
    }
    
    protected String getLivingSound() {
        if (EntityHollowBat.rand.nextInt(100) >= 25) {
            return "bleachreborn:hollowscream";
        }
        return null;
    }
    
    protected String getDeathSound() {
        return "bleachreborn:hollowscream";
    }
    
    protected void dropFewItems(final boolean par1, final int par2) {
        super.dropFewItems(par1, par2);
        this.entityDropItem(new ItemStack(BleachItems.reiatsu, 2 + EntityHollowBat.rand.nextInt(3) + par2), 0.0f);
        if (EntityHollowBat.rand.nextInt(20 - par2) == 0) {
            this.dropItem(Armor.BatHelmet, 1);
        }
    }
    
    public void onLivingUpdate() {
        super.onLivingUpdate();
    }
    
    public int getMaxSpawnedInChunk() {
        return 1;
    }
    
    protected void attackEntity(final Entity target, final float distace) {
        if (this.attackTime <= 0 && distace < 2.0f && target.boundingBox.maxY > this.boundingBox.minY && target.boundingBox.minY < this.boundingBox.maxY) {
            this.attackTime = 20;
            this.attackEntityAsMob(target);
        }
    }
    
    public boolean attackEntityAsMob(final Entity par1Entity) {
        if (super.attackEntityAsMob(par1Entity)) {
            if (par1Entity instanceof EntityLivingBase) {
                byte b0 = 0;
                if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL) {
                    b0 = 4;
                }
                else if (this.worldObj.difficultySetting == EnumDifficulty.HARD) {
                    b0 = 7;
                }
                if (b0 > 0) {
                    ((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.blindness.id, b0 * 20, 0));
                }
            }
            return true;
        }
        return false;
    }
    
    public boolean canBePushed() {
        return false;
    }
    
    protected void collideWithEntity(final Entity par1Entity) {
        this.attackEntityAsMob(par1Entity);
    }
    
    protected void collideWithNearbyEntities() {
    }
    
    public void onUpdate() {
        super.onUpdate();
        this.motionY *= 0.6000000238418579;
        if (this.entityToAttack != null && this.entityToAttack != this.attackingPlayer) {
            this.entityToAttack = (Entity)this.attackingPlayer;
        }
        if (this.entityToAttack == null) {
            this.entityToAttack = (Entity)this.worldObj.getClosestVulnerablePlayerToEntity((Entity)this, 32.0);
        }
        if (this.currentFlightTarget != null && (!this.worldObj.isAirBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ) || this.currentFlightTarget.posY < 1)) {
            this.currentFlightTarget = null;
        }
        if (this.entityToAttack != null) {
            this.currentFlightTarget = new ChunkCoordinates((int)this.entityToAttack.posX, (int)this.entityToAttack.posY, (int)this.entityToAttack.posZ);
        }
        else if (this.currentFlightTarget == null || EntityHollowBat.rand.nextInt(30) == 0 || this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 4.0f) {
            this.currentFlightTarget = new ChunkCoordinates((int)this.posX + EntityHollowBat.rand.nextInt(10) - EntityHollowBat.rand.nextInt(10), (int)this.posY + EntityHollowBat.rand.nextInt(9) - 2, (int)this.posZ + EntityHollowBat.rand.nextInt(10) - EntityHollowBat.rand.nextInt(10));
        }
        final double d0 = this.currentFlightTarget.posX + 0.5 - this.posX;
        final double d2 = this.currentFlightTarget.posY + 0.1 - this.posY;
        final double d3 = this.currentFlightTarget.posZ + 0.5 - this.posZ;
        this.motionX += (Math.signum(d0) * 0.5 - this.motionX) * 0.10000000149011612;
        this.motionY += (Math.signum(d2) * 0.699999988079071 - this.motionY) * 0.10000000149011612;
        this.motionZ += (Math.signum(d3) * 0.5 - this.motionZ) * 0.10000000149011612;
        final float f = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0 / 3.141592653589793) - 90.0f;
        final float f2 = MathHelper.wrapAngleTo180_float(f - this.rotationYaw);
        this.moveForward = 0.5f;
        this.rotationYaw += f2;
        if (this.entityToAttack != null && this.entityToAttack.getDistanceSqToEntity((Entity)this) < 3.0) {
            this.attackEntity(this.entityToAttack, this.getDistanceToEntity(this.entityToAttack));
        }
    }
    
    protected boolean canTriggerWalking() {
        return false;
    }
    
    protected void fall(final float par1) {
    }
    
    protected void updateFallState(final double par1, final boolean par3) {
    }
    
    public boolean doesEntityNotTriggerPressurePlate() {
        return true;
    }
    
    public void onDeath(final DamageSource par1DamageSource) {
        super.onDeath(par1DamageSource);
        if (par1DamageSource.getEntity() instanceof EntityPlayer) {
            final ExtendedPlayer props = (ExtendedPlayer)this.attackingPlayer.getExtendedProperties("BleachPlayer");
            if (props.getFaction() == 1 && this.attackingPlayer.inventory.getCurrentItem() != null && this.attackingPlayer.inventory.getCurrentItem().getItem() == BleachItems.zanpakuto && props.getZTotal() < 400) {
                props.addPoints(7, 4);
                props.addPoints(6, 3);
                props.addPoints(8, -2);
            }
            if (props.getFaction() == 3) {
                props.addSXP(8);
            }
        }
    }
    
    public void setTexture(final int par1) {
        this.dataWatcher.updateObject(19, (Object)par1);
    }
    
    public int getTexture() {
        return this.dataWatcher.getWatchableObjectInt(19);
    }
    
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(19, (Object)0);
    }
    
    public void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("Texture", this.getTexture());
    }
    
    public void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.setTexture(par1NBTTagCompound.getInteger("Texture"));
    }
    
    static {
        EntityHollowBat.rand = new Random();
    }
}

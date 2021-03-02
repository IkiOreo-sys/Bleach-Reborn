package littlebreadloaf.bleachreborn.entities;

import littlebreadloaf.bleachreborn.ConfigHandler;
import littlebreadloaf.bleachreborn.api.Tools;
import littlebreadloaf.bleachreborn.events.ExtendedPlayer;
import littlebreadloaf.bleachreborn.items.BleachItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityMenosGrande extends EntityMob
{
    public int deathTicks;
    private int ceroCooldown;
    private int ceroCharging;
    private EntityPlayer target;
    
    public EntityMenosGrande(final World par1World) {
        super(par1World);
        this.deathTicks = 0;
        this.ceroCooldown = 100;
        this.ceroCharging = 60;
        this.target = null;
        this.tasks.addTask(1, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityPlayer.class, 0.4, false));
        this.tasks.addTask(2, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityWhole.class, 0.4, false));
        this.tasks.addTask(3, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityShinigami.class, 0.4, false));
        this.tasks.addTask(5, (EntityAIBase)new EntityAIMoveTowardsRestriction((EntityCreature)this, 0.4));
        this.tasks.addTask(6, (EntityAIBase)new EntityAIWander((EntityCreature)this, 0.4));
        this.tasks.addTask(7, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.tasks.addTask(8, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.tasks.addTask(9, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityWhole.class, 8.0f));
        this.targetTasks.addTask(0, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, 0, true));
        this.targetTasks.addTask(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityWhole.class, 0, false));
        this.targetTasks.addTask(3, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityShinigami.class, 0, false));
        this.isImmuneToFire = true;
        this.ignoreFrustumCheck = true;
        this.setSize(1.9f, 20.9f);
        this.stepHeight = 3.5f;
    }
    
    public float getEyeHeight() {
        return this.height - 1.0f;
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
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(ConfigHandler.menosHP);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(8.0);
        }
        else {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(250.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(32.0);
        }
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(85.0);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(25.0);
    }
    
    public EnumCreatureAttribute getCreatureAttribute() {
        return Tools.SPIRIT;
    }
    
    protected String getHurtSound() {
        if (this.rand.nextInt(2) == 0) {
            return "bleachreborn:hollowscream";
        }
        return null;
    }
    
    protected String getLivingSound() {
        if (this.rand.nextInt(100) >= 25) {
            return "bleachreborn:hollowscream";
        }
        return null;
    }
    
    protected String getDeathSound() {
        return "bleachreborn:hollowscream";
    }
    
    protected float getSoundPitch() {
        return super.getSoundPitch() * 0.8f;
    }
    
    protected float getSoundVolume() {
        return 3.0f;
    }
    
    protected void dropFewItems(final boolean par1, final int par2) {
        super.dropFewItems(par1, par2);
        this.entityDropItem(new ItemStack(BleachItems.reiatsu, 8 + this.rand.nextInt(3) + par2), 0.0f);
        if (this.rand.nextInt(20 - par2) == 0) {
            this.dropItem(BleachItems.menosmask, 1);
        }
        if (this.rand.nextInt(10 - par2) == 0) {
            this.dropItem(BleachItems.debugItem, 1);
        }
    }
    
    public void onLivingUpdate() {
        super.onLivingUpdate();
    }
    
    public int getMaxSpawnedInChunk() {
        return 16;
    }
    
    protected void fall(final float var1) {
    }
    
    protected void onDeathUpdate() {
        ++this.deathTicks;
        final int var1 = MathHelper.floor_double(this.posY);
        final int var2 = MathHelper.floor_double(this.posX);
        final int var3 = MathHelper.floor_double(this.posZ);
        if (this.deathTicks <= 200) {
            for (int var4 = -3; var4 <= 3; ++var4) {
                for (int var5 = -3; var5 <= 3; ++var5) {
                    for (int var6 = -1; var6 <= 20; ++var6) {
                        if (this.rand.nextInt(1500) == 0) {
                            final int var7 = var2 + var4;
                            final int var8 = var1 + var6;
                            final int var9 = var3 + var5;
                            this.worldObj.spawnParticle("largeexplode", (double)var7, (double)var8, (double)var9, 0.0, 0.0, 0.0);
                        }
                    }
                }
            }
        }
        if (!this.worldObj.isRemote) {
            if (this.deathTicks > 150 && this.deathTicks % 5 == 0) {
                int var4 = 10;
                while (var4 > 0) {
                    final int var5 = EntityXPOrb.getXPSplit(var4);
                    var4 -= var5;
                    this.worldObj.spawnEntityInWorld((Entity)new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, var5));
                }
            }
            if (this.deathTicks == 1) {}
        }
        if (this.deathTicks == 200 && !this.worldObj.isRemote) {
            int var4 = 10;
            while (var4 > 0) {
                final int var5 = EntityXPOrb.getXPSplit(var4);
                var4 -= var5;
                this.worldObj.spawnEntityInWorld((Entity)new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, var5));
            }
            this.setDead();
        }
    }
    
    public void onDeath(final DamageSource par1DamageSource) {
        super.onDeath(par1DamageSource);
        if (par1DamageSource.getEntity() instanceof EntityPlayer) {
            final ExtendedPlayer props = (ExtendedPlayer)this.attackingPlayer.getExtendedProperties("BleachPlayer");
            if (props.getFaction() == 3) {
                props.addSXP(10);
            }
            if (props.getFaction() == 1 && this.attackingPlayer.inventory.getCurrentItem() != null && this.attackingPlayer.inventory.getCurrentItem().getItem() == BleachItems.zanpakuto && props.getZTotal() < 376) {
                for (int i = 0; i < 25; ++i) {
                    props.addPoints(this.rand.nextInt(8) + 1, 1);
                }
            }
            if (this.rand.nextInt(50) == 0) {
                final Item recordNumberOne = BleachItems.recordNumberOne;
            }
        }
    }
    
    public int getChargingProgress() {
        return this.ceroCharging;
    }
    
    @Override
    public boolean getCanSpawnHere() {
    	if (this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && this.posY < 50.0 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && !this.worldObj.isAnyLiquid(this.boundingBox)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    @Override
    public boolean canDespawn() {
        return false;
    }
}

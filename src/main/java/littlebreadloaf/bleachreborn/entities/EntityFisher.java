package littlebreadloaf.bleachreborn.entities;

import net.minecraft.entity.player.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.ai.*;
import net.minecraft.world.*;
import net.minecraft.potion.*;
import net.minecraft.entity.*;
import littlebreadloaf.bleachreborn.ConfigHandler;
import littlebreadloaf.bleachreborn.api.*;
import littlebreadloaf.bleachreborn.items.*;
import net.minecraft.util.*;
import littlebreadloaf.bleachreborn.events.*;
import net.minecraft.item.*;

public class EntityFisher extends EntityMob
{
    int invis;
    
    public EntityFisher(final World par1World) {
        super(par1World);
        this.invis = 0;
        this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityPlayer.class, 0.4, false));
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
        this.setSize(1.2f, 3.4f);
        this.experienceValue = 15;
    }
    
    protected boolean isAIEnabled() {
        return true;
    }
    
    protected void updateAITasks() {
        super.updateAITasks();
        ++this.invis;
        int length = 10;
        if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL) {
            length = 10;
        }
        if (this.worldObj.difficultySetting == EnumDifficulty.HARD) {
            length = 15;
        }
        if (this.invis == 1800) {
            this.addPotionEffect(new PotionEffect(Potion.invisibility.id, 20 * length, 0));
            this.invis = 0;
        }
    }
    
    public int getTotalArmorValue() {
        return 4;
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL || this.worldObj.difficultySetting == EnumDifficulty.HARD) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(ConfigHandler.fisherHP);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0);
        }
        else {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(200.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(16.0);
        }
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(50.0);
    }
    
    public EnumCreatureAttribute getCreatureAttribute() {
        return Tools.SPIRIT;
    }
    
    protected float getSoundVolume() {
        return 0.6f;
    }
    
    protected String getHurtSound() {
        if (this.rand.nextInt(100) >= 25) {
            return "bleachreborn:hollowscream";
        }
        return null;
    }
    
    protected String getLivingSound() {
        if (this.rand.nextInt(10) < 4) {
            return "bleachreborn:fisherlaugh1";
        }
        if (this.rand.nextInt(10) < 4) {
            return "bleachreborn:fisherlaugh2";
        }
        return "bleachreborn:fisherlaugh3";
    }
    
    protected String getDeathSound() {
        return "bleachreborn:hollowscream";
    }
    
    protected void dropFewItems(final boolean par1, final int par2) {
        super.dropFewItems(par1, par2);
        this.entityDropItem(new ItemStack(BleachItems.reiatsu, 2 + this.rand.nextInt(3) + par2), 0.0f);
        if (this.rand.nextInt(20 - par2) == 0) {
            this.dropItem(BleachItems.fishermask, 1);
        }
    }
    
    public void onLivingUpdate() {
        super.onLivingUpdate();
    }
    
    public int getMaxSpawnedInChunk() {
        return 1;
    }
    
    protected void fall(final float var1) {
    }
    
    public void onDeath(final DamageSource par1DamageSource) {
        super.onDeath(par1DamageSource);
        if (par1DamageSource.getEntity() instanceof EntityPlayer) {
            final ExtendedPlayer props = (ExtendedPlayer)this.attackingPlayer.getExtendedProperties("BleachPlayer");
            if (props.getFaction() == 1 && this.attackingPlayer.inventory.getCurrentItem() != null && this.attackingPlayer.inventory.getCurrentItem().getItem() == BleachItems.zanpakuto && props.getZTotal() < 400) {
                props.addPoints(3, 5);
                props.addPoints(7, 2);
                props.addPoints(4, -2);
            }
            if (props.getFaction() == 3) {
                props.addSXP(8);
            }
        }
        if (this.rand.nextInt(50) == 0) {
            final Item recordAsterisk = BleachItems.recordAsterisk;
        }
    }
}

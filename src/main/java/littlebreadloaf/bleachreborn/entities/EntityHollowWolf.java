package littlebreadloaf.bleachreborn.entities;

import java.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.ai.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import littlebreadloaf.bleachreborn.ConfigHandler;
import littlebreadloaf.bleachreborn.api.*;
import littlebreadloaf.bleachreborn.items.*;
import net.minecraft.item.*;
import littlebreadloaf.bleachreborn.armor.*;
import net.minecraft.util.*;
import littlebreadloaf.bleachreborn.events.*;
import net.minecraft.nbt.*;

public class EntityHollowWolf extends EntityMob
{
    private static Random rand;
    
    public EntityHollowWolf(final World par1) {
        this(par1, EntityHollowWolf.rand.nextInt(3));
    }
    
    public EntityHollowWolf(final World par1World, final int par2) {
        super(par1World);
        this.setTexture(par2);
        this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityPlayer.class, 0.55, false));
        this.tasks.addTask(2, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityWhole.class, 0.55, false));
        this.tasks.addTask(3, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityShinigami.class, 0.55, false));
        this.tasks.addTask(4, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, (Class)EntityIronGolem.class, 6.0f, 0.44999998807907104, 0.44999998807907104));
        this.tasks.addTask(5, (EntityAIBase)new EntityAIMoveTowardsRestriction((EntityCreature)this, 0.6));
        this.tasks.addTask(6, (EntityAIBase)new EntityAIWander((EntityCreature)this, 0.45));
        this.tasks.addTask(7, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.tasks.addTask(8, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.tasks.addTask(9, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityWhole.class, 8.0f));
        this.targetTasks.addTask(0, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, 0, true));
        this.targetTasks.addTask(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityWhole.class, 0, false));
        this.targetTasks.addTask(3, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityShinigami.class, 0, false));
        this.experienceValue = 15;
        this.setSize(1.0f, 1.1f);
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
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(ConfigHandler.wolfHP);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0);
        }
        else {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(150.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(16.0);
        }
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(50.0);
    }
    
    public EnumCreatureAttribute getCreatureAttribute() {
        return Tools.SPIRIT;
    }
    
    protected String getHurtSound() {
        if (EntityHollowWolf.rand.nextInt(100) >= 50) {
            return "bleachreborn:hollowscream";
        }
        return null;
    }
    
    protected String getLivingSound() {
        if (EntityHollowWolf.rand.nextInt(100) >= 25) {
            return "bleachreborn:hollowscream";
        }
        return null;
    }
    
    protected String getDeathSound() {
        return "bleachreborn:hollowscream";
    }
    
    protected void dropFewItems(final boolean par1, final int par2) {
        super.dropFewItems(par1, par2);
        this.entityDropItem(new ItemStack(BleachItems.reiatsu, 2 + EntityHollowWolf.rand.nextInt(3) + par2), 0.0f);
        if (EntityHollowWolf.rand.nextInt(20 - par2) == 0) {
            this.dropItem(Armor.WolfHelmet, 1);
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
                props.addPoints(2, 5);
                props.addPoints(8, 2);
                props.addPoints(1, -2);
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
        EntityHollowWolf.rand = new Random();
    }
}

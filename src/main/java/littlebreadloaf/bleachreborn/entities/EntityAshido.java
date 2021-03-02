package littlebreadloaf.bleachreborn.entities;

import net.minecraft.entity.monster.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.ai.*;
import littlebreadloaf.bleachreborn.api.*;
import net.minecraft.util.*;
import littlebreadloaf.bleachreborn.items.*;
import net.minecraft.entity.*;

public class EntityAshido extends EntityMob
{
    private static Random rand;
    private boolean angry;
    public static final ItemStack heldItem;
    
    public EntityAshido(final World par1) {
        this(par1, 1);
    }
    
    public EntityAshido(final World par1World, final int par2) {
        super(par1World);
        this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityHollowBat.class, 0.5, false));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityHollowBlaze.class, 0.5, true));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityHollowGolem.class, 0.5, true));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityHollowSnake.class, 0.5, false));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityHollowSpider.class, 0.5, true));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityHollowOre.class, 0.5, false));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityHollowWolf.class, 0.5, true));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityFisher.class, 0.5, true));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityMenosGrande.class, 0.5, true));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityHollowWasp.class, 0.5, true));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityHollowStalker.class, 0.5, true));
        this.tasks.addTask(11, (EntityAIBase)new EntityAIMoveTowardsRestriction((EntityCreature)this, 0.5));
        this.tasks.addTask(12, (EntityAIBase)new EntityAIWander((EntityCreature)this, 0.5));
        this.tasks.addTask(13, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.tasks.addTask(14, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.targetTasks.addTask(0, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, 0, false));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityHollowBat.class, 0, false));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityHollowBlaze.class, 0, false));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityHollowGolem.class, 0, false));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityHollowSnake.class, 0, false));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityHollowSpider.class, 0, false));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityHollowWolf.class, 0, false));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityHollowOre.class, 0, false));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityFisher.class, 0, false));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityMenosGrande.class, 0, false));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityHollowWasp.class, 0, false));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityHollowStalker.class, 0, false));
        this.experienceValue = 15;
        this.setSize(1.0f, 1.4f);
    }
    
    protected boolean isAIEnabled() {
        return true;
    }
    
    public int getTotalArmorValue() {
        return 6;
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(300.0);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(50.0);
    }
    
    public ItemStack getHeldItem() {
        return EntityAshido.heldItem;
    }
    
    public EnumCreatureAttribute getCreatureAttribute() {
        return Tools.SPIRIT;
    }
    
    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        if (par1DamageSource.getEntity() instanceof EntityPlayer) {
            this.tasks.addTask(4, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityPlayer.class, 0.5, true));
        }
        this.angry = true;
        return super.attackEntityFrom(par1DamageSource, par2);
    }
    
    protected String getHurtSound() {
        if (EntityAshido.rand.nextInt(100) >= 50) {
            return null;
        }
        return null;
    }
    
    protected String getLivingSound() {
        if (EntityAshido.rand.nextInt(100) >= 25) {
            return null;
        }
        return null;
    }
    
    protected String getDeathSound() {
        return null;
    }
    
    protected void dropFewItems(final boolean par1, final int par2) {
        super.dropFewItems(par1, par2);
        this.entityDropItem(new ItemStack(BleachItems.reiatsu, 2 + EntityAshido.rand.nextInt(3) + par2), 0.0f);
    }
    
    public void onLivingUpdate() {
        super.onLivingUpdate();
    }
    
    public int getMaxSpawnedInChunk() {
        return 1;
    }
    
    protected void fall(final float var1) {
    }
    
    protected Entity findPlayerToAttack() {
        return this.angry ? null : super.findPlayerToAttack();
    }
    
    static {
        EntityAshido.rand = new Random();
        heldItem = new ItemStack(BleachItems.zanpakuto, 1);
    }
}

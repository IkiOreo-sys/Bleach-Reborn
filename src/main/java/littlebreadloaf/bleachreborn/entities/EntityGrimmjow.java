package littlebreadloaf.bleachreborn.entities;

import net.minecraft.entity.monster.*;
import java.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.ai.*;
import net.minecraft.world.*;
import littlebreadloaf.bleachreborn.ConfigHandler;
import littlebreadloaf.bleachreborn.api.*;
import net.minecraft.util.*;
import littlebreadloaf.bleachreborn.items.*;
import littlebreadloaf.bleachreborn.armor.*;
import net.minecraft.entity.*;
import net.minecraft.nbt.*;
import littlebreadloaf.bleachreborn.events.*;
import net.minecraft.item.*;

public class EntityGrimmjow extends EntityMob
{
    private static Random rand;
    private boolean angry;
    public static final ItemStack heldItem;
    
    public EntityGrimmjow(final World par1) {
        this(par1, EntityGrimmjow.rand.nextInt(11));
    }
    
    public EntityGrimmjow(final World par1World, final int par2) {
        super(par1World);
        this.setTexture(par2);
        this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityPlayer.class, 0.5, false));
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
    }
    
    protected boolean isAIEnabled() {
        return true;
    }
    
    public int getTotalArmorValue() {
        return 6;
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL || this.worldObj.difficultySetting == EnumDifficulty.HARD) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(ConfigHandler.grimmjowHP);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(60.0);
        }
        else {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(4500.0);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(45.0);
        }
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(100.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.6);
    }
    
    public ItemStack getHeldItem() {
        return EntityGrimmjow.heldItem;
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
        if (EntityGrimmjow.rand.nextInt(100) >= 50) {
            return null;
        }
        return null;
    }
    
    protected String getLivingSound() {
        if (EntityGrimmjow.rand.nextInt(100) >= 25) {
            return null;
        }
        return null;
    }
    
    protected String getDeathSound() {
        return null;
    }
    
    protected void dropFewItems(final boolean par1, final int par2) {
        super.dropFewItems(par1, par2);
        this.entityDropItem(new ItemStack(BleachItems.reiatsu, 2 + EntityGrimmjow.rand.nextInt(3) + par2), 0.0f);
        if (EntityGrimmjow.rand.nextInt(50 - par2) == 0) {
            this.dropItem(BleachItems.zanpakuto, 1);
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
    
    protected Entity findPlayerToAttack() {
        return this.angry ? null : super.findPlayerToAttack();
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
    
    public void onDeath(final DamageSource par1DamageSource) {
        super.onDeath(par1DamageSource);
        if (par1DamageSource.getEntity() instanceof EntityPlayer) {
            final EntityPlayer var7 = (EntityPlayer)par1DamageSource.getEntity();
            final ExtendedPlayer props = ExtendedPlayer.get(var7);
            final ItemStack var8 = var7.inventory.armorInventory[3];
            if (var8 != null && var8.getItem() == Armor.HollowHelmet && EntityGrimmjow.rand.nextInt(20) == 0) {
                final Item recordEscalon = BleachItems.recordEscalon;
            }
            if (props.getFaction() == 3) {
                props.addSXP(8);
            }
        }
    }
    
    static {
        EntityGrimmjow.rand = new Random();
        heldItem = new ItemStack(BleachItems.zanpakuto, 1);
    }
}

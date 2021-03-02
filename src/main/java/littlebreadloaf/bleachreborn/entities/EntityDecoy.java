package littlebreadloaf.bleachreborn.entities;

import net.minecraft.entity.monster.*;
import java.util.*;
import net.minecraft.world.*;
import littlebreadloaf.bleachreborn.items.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.ai.*;
import littlebreadloaf.bleachreborn.api.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.nbt.*;

public class EntityDecoy extends EntityMob
{
    private static Random rand;
    
    public EntityDecoy(final World par1) {
        this(par1, EntityDecoy.rand.nextInt(10));
    }
    
    public EntityDecoy(final World par1World, final int par2) {
        super(par1World);
        this.setTexture(par2);
        final float var3 = 0.43f;
        this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 0.3799999952316284));
        this.tasks.addTask(2, (EntityAIBase)new EntityAITempt((EntityCreature)this, 0.25, BleachItems.zanpakuto, false));
        this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 6.0f));
        this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.tasks.addTask(12, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.tasks.addTask(13, (EntityAIBase)new EntityAIWander((EntityCreature)this, 0.4300000071525574));
    }
    
    protected boolean isAIEnabled() {
        return true;
    }
    
    public void onLivingUpdate() {
        super.onLivingUpdate();
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1.0);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0);
    }
    
    protected void dropFewItems(final boolean var1, final int var2) {
    }
    
    protected int getDropItemId() {
        return 0;
    }
    
    public EnumCreatureAttribute getCreatureAttribute() {
        return Tools.SPIRIT;
    }
    
    public boolean interact(final EntityPlayer var1) {
        final ItemStack var2 = var1.inventory.getCurrentItem();
        if (var2 != null && var2.getItem() == BleachItems.zanpakuto) {
            final EntityFisher par1 = new EntityFisher(this.worldObj);
            par1.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
            if (!this.worldObj.isRemote) {
                this.worldObj.createExplosion((Entity)this, this.posX, this.posY, this.posZ, 3.0f, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
                this.worldObj.spawnEntityInWorld((Entity)par1);
            }
            this.setDead();
        }
        return true;
    }
    
    protected String getLivingSound() {
        return "mob.endermen.idle";
    }
    
    protected String getHurtSound() {
        return "mob.endermen.idle";
    }
    
    protected String getDeathSound() {
        return "mob.endermen.portal";
    }
    
    protected void fall(final float var1) {
    }
    
    public int getBrightnessForRender(final float par1) {
        return 15728880;
    }
    
    public float getBrightness(final float par1) {
        return 1.0f;
    }
    
    public void initCreature() {
    }
    
    public void onDeath(final DamageSource par1DamageSource) {
        this.worldObj.createExplosion((Entity)this, this.posX, this.posY, this.posZ, 3.0f, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
        final EntityFisher par1 = new EntityFisher(this.worldObj);
        par1.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
        this.worldObj.spawnEntityInWorld((Entity)par1);
        this.setDead();
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
        EntityDecoy.rand = new Random();
    }
}

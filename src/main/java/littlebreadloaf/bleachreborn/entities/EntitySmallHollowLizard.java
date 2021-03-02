package littlebreadloaf.bleachreborn.entities;

import net.minecraft.entity.passive.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.ai.*;
import littlebreadloaf.bleachreborn.items.*;
import net.minecraft.item.*;
import littlebreadloaf.bleachreborn.api.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.*;

public class EntitySmallHollowLizard extends EntityAnimal
{
    private static Random rand;
    
    public EntitySmallHollowLizard(final World par1) {
        this(par1, EntitySmallHollowLizard.rand.nextInt(7));
    }
    
    public EntitySmallHollowLizard(final World par1World, final int par2) {
        super(par1World);
        this.setTexture(par2);
        final float var3 = 0.55f;
        this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, (Class)EntityPlayer.class, 6.0f, 0.550000011920929, 0.550000011920929));
        this.tasks.addTask(2, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 0.6000000238418579));
        this.tasks.addTask(4, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 6.0f));
        this.tasks.addTask(5, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.tasks.addTask(7, (EntityAIBase)new EntityAIWander((EntityCreature)this, 0.550000011920929));
        this.setSize(0.9f, 0.2f);
    }
    
    protected boolean isAIEnabled() {
        return true;
    }
    
    public void onLivingUpdate() {
        super.onLivingUpdate();
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0);
    }
    
    protected void dropFewItems(final boolean var1, final int var2) {
        this.entityDropItem(new ItemStack(BleachItems.reiatsu, 1), 0.0f);
    }
    
    protected int getDropItemId() {
        return 0;
    }
    
    public EnumCreatureAttribute getCreatureAttribute() {
        return Tools.SPIRIT;
    }
    
    protected String getLivingSound() {
        return null;
    }
    
    protected String getHurtSound() {
        return "mob.silverfish.hit";
    }
    
    protected String getDeathSound() {
        return "mob.bat.death";
    }
    
    protected void fall(final float var1) {
    }
    
    public void initCreature() {
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
    
    public boolean getCanSpawnHere() {
        return this.posY > 65.0 && super.getCanSpawnHere();
    }
    
    public EntityAgeable createChild(final EntityAgeable entityageable) {
        return null;
    }
    
    static {
        EntitySmallHollowLizard.rand = new Random();
    }
}

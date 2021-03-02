package littlebreadloaf.bleachreborn.entities;

import net.minecraft.entity.monster.*;
import java.util.*;
import net.minecraft.world.*;
import littlebreadloaf.bleachreborn.items.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.ai.*;
import net.minecraft.item.*;
import littlebreadloaf.bleachreborn.api.*;
import net.minecraft.util.*;
import littlebreadloaf.bleachreborn.events.*;
import net.minecraft.entity.*;
import net.minecraft.nbt.*;

public class EntityWhole extends EntityMob
{
    private static Random rand;
    
    public EntityWhole(final World par1) {
        this(par1, EntityWhole.rand.nextInt(10));
    }
    
    public EntityWhole(final World par1World, final int par2) {
        super(par1World);
        this.setTexture(par2);
        final float var3 = 0.38f;
        this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, (Class)EntityHollowBat.class, 6.0f, 0.44999998807907104, 0.44999998807907104));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, (Class)EntityHollowBlaze.class, 6.0f, 0.44999998807907104, 0.44999998807907104));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, (Class)EntityHollowSpider.class, 6.0f, 0.44999998807907104, 0.44999998807907104));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, (Class)EntityHollowGolem.class, 6.0f, 0.44999998807907104, 0.44999998807907104));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, (Class)EntityHollowSnake.class, 6.0f, 0.44999998807907104, 0.44999998807907104));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, (Class)EntityHollowWasp.class, 6.0f, 0.44999998807907104, 0.44999998807907104));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, (Class)EntityHollowStalker.class, 6.0f, 0.44999998807907104, 0.44999998807907104));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, (Class)EntityHollowWolf.class, 6.0f, 0.44999998807907104, 0.44999998807907104));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, (Class)EntityHollowOre.class, 6.0f, 0.44999998807907104, 0.44999998807907104));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, (Class)EntityFisher.class, 6.0f, 0.44999998807907104, 0.44999998807907104));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, (Class)EntityMenosGrande.class, 6.0f, 0.44999998807907104, 0.44999998807907104));
        this.tasks.addTask(2, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 0.5));
        this.tasks.addTask(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 0.4000000059604645, BleachItems.zanpakuto, false));
        this.tasks.addTask(4, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 6.0f));
        this.tasks.addTask(5, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.tasks.addTask(6, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.tasks.addTask(7, (EntityAIBase)new EntityAIWander((EntityCreature)this, 0.3799999952316284));
    }
    
    protected boolean isAIEnabled() {
        return true;
    }
    
    public void onLivingUpdate() {
        super.onLivingUpdate();
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0);
    }
    
    protected void dropFewItems(final boolean var1, final int var2) {
        this.entityDropItem(new ItemStack(BleachItems.reiatsu, 1), 0.0f);
    }
    
    public EnumCreatureAttribute getCreatureAttribute() {
        return Tools.SPIRIT;
    }
    
    public boolean interact(final EntityPlayer var1) {
        final ItemStack var2 = var1.inventory.getCurrentItem();
        if (var2 != null && var2.getItem() == BleachItems.zanpakuto) {
            if (!this.worldObj.isRemote) {
                final int var3 = 4 + EntityWhole.rand.nextInt(3);
                this.entityDropItem(new ItemStack(BleachItems.reiatsu, var3), 0.0f);
            }
            this.playSound("mob.endermen.portal", 1.0f, 1.0f);
            this.setDead();
        }
        return super.interact(var1);
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
        final int randomHollow = EntityWhole.rand.nextInt(12);
        if (par1DamageSource.getEntity() instanceof EntityPlayer) {
            final ExtendedPlayer props = (ExtendedPlayer)this.attackingPlayer.getExtendedProperties("BleachPlayer");
            if (props.getFaction() == 3) {
                props.addSXP(5);
            }
        }
        final EntityHollowBat par3 = new EntityHollowBat(this.worldObj);
        final EntityHollowBlaze par4 = new EntityHollowBlaze(this.worldObj);
        final EntityHollowSpider par5 = new EntityHollowSpider(this.worldObj);
        final EntityHollowGolem par6 = new EntityHollowGolem(this.worldObj);
        final EntityHollowSnake par7 = new EntityHollowSnake(this.worldObj);
        final EntityHollowWasp par8 = new EntityHollowWasp(this.worldObj);
        final EntityHollowStalker par9 = new EntityHollowStalker(this.worldObj);
        final EntityHollowOre par10 = new EntityHollowOre(this.worldObj);
        final EntityHollowWolf par11 = new EntityHollowWolf(this.worldObj);
        par3.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
        par4.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
        par5.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
        par6.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
        par7.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
        par8.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
        par9.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
        par10.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
        par11.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
        if (par1DamageSource.getEntity() instanceof EntityHollowBat) {
            if (randomHollow == 2) {
                this.worldObj.spawnEntityInWorld((Entity)par4);
            }
            else if (randomHollow == 3) {
                this.worldObj.spawnEntityInWorld((Entity)par5);
            }
            else if (randomHollow == 4) {
                this.worldObj.spawnEntityInWorld((Entity)par6);
            }
            else if (randomHollow == 5) {
                this.worldObj.spawnEntityInWorld((Entity)par7);
            }
            else if (randomHollow == 6) {
                this.worldObj.spawnEntityInWorld((Entity)par8);
            }
            else if (randomHollow == 7) {
                this.worldObj.spawnEntityInWorld((Entity)par9);
            }
            else if (randomHollow == 8) {
                this.worldObj.spawnEntityInWorld((Entity)par10);
            }
            else if (randomHollow == 9) {
                this.worldObj.spawnEntityInWorld((Entity)par11);
            }
        }
        if (par1DamageSource.getEntity() instanceof EntityHollowBlaze) {
            if (randomHollow == 1) {
                this.worldObj.spawnEntityInWorld((Entity)par3);
            }
            else if (randomHollow == 3) {
                this.worldObj.spawnEntityInWorld((Entity)par5);
            }
            else if (randomHollow == 4) {
                this.worldObj.spawnEntityInWorld((Entity)par6);
            }
            else if (randomHollow == 5) {
                this.worldObj.spawnEntityInWorld((Entity)par7);
            }
            else if (randomHollow == 6) {
                this.worldObj.spawnEntityInWorld((Entity)par8);
            }
            else if (randomHollow == 7) {
                this.worldObj.spawnEntityInWorld((Entity)par9);
            }
            else if (randomHollow == 8) {
                this.worldObj.spawnEntityInWorld((Entity)par10);
            }
            else if (randomHollow == 9) {
                this.worldObj.spawnEntityInWorld((Entity)par11);
            }
        }
        if (par1DamageSource.getEntity() instanceof EntityHollowSpider) {
            if (randomHollow == 1) {
                this.worldObj.spawnEntityInWorld((Entity)par3);
            }
            else if (randomHollow == 2) {
                this.worldObj.spawnEntityInWorld((Entity)par4);
            }
            else if (randomHollow == 4) {
                this.worldObj.spawnEntityInWorld((Entity)par6);
            }
            else if (randomHollow == 5) {
                this.worldObj.spawnEntityInWorld((Entity)par7);
            }
            else if (randomHollow == 6) {
                this.worldObj.spawnEntityInWorld((Entity)par8);
            }
            else if (randomHollow == 7) {
                this.worldObj.spawnEntityInWorld((Entity)par9);
            }
            else if (randomHollow == 8) {
                this.worldObj.spawnEntityInWorld((Entity)par10);
            }
            else if (randomHollow == 9) {
                this.worldObj.spawnEntityInWorld((Entity)par11);
            }
        }
        if (par1DamageSource.getEntity() instanceof EntityHollowGolem) {
            if (randomHollow == 1) {
                this.worldObj.spawnEntityInWorld((Entity)par3);
            }
            else if (randomHollow == 2) {
                this.worldObj.spawnEntityInWorld((Entity)par4);
            }
            else if (randomHollow == 3) {
                this.worldObj.spawnEntityInWorld((Entity)par5);
            }
            else if (randomHollow == 5) {
                this.worldObj.spawnEntityInWorld((Entity)par7);
            }
            else if (randomHollow == 6) {
                this.worldObj.spawnEntityInWorld((Entity)par8);
            }
            else if (randomHollow == 7) {
                this.worldObj.spawnEntityInWorld((Entity)par9);
            }
            else if (randomHollow == 8) {
                this.worldObj.spawnEntityInWorld((Entity)par10);
            }
            else if (randomHollow == 9) {
                this.worldObj.spawnEntityInWorld((Entity)par11);
            }
        }
        if (par1DamageSource.getEntity() instanceof EntityHollowSnake) {
            if (randomHollow == 1) {
                this.worldObj.spawnEntityInWorld((Entity)par3);
            }
            else if (randomHollow == 2) {
                this.worldObj.spawnEntityInWorld((Entity)par4);
            }
            else if (randomHollow == 3) {
                this.worldObj.spawnEntityInWorld((Entity)par5);
            }
            else if (randomHollow == 4) {
                this.worldObj.spawnEntityInWorld((Entity)par6);
            }
            else if (randomHollow == 6) {
                this.worldObj.spawnEntityInWorld((Entity)par8);
            }
            else if (randomHollow == 7) {
                this.worldObj.spawnEntityInWorld((Entity)par9);
            }
            else if (randomHollow == 8) {
                this.worldObj.spawnEntityInWorld((Entity)par10);
            }
            else if (randomHollow == 9) {
                this.worldObj.spawnEntityInWorld((Entity)par11);
            }
        }
        if (par1DamageSource.getEntity() instanceof EntityHollowWasp) {
            if (randomHollow == 1) {
                this.worldObj.spawnEntityInWorld((Entity)par3);
            }
            else if (randomHollow == 2) {
                this.worldObj.spawnEntityInWorld((Entity)par4);
            }
            else if (randomHollow == 3) {
                this.worldObj.spawnEntityInWorld((Entity)par5);
            }
            else if (randomHollow == 4) {
                this.worldObj.spawnEntityInWorld((Entity)par6);
            }
            else if (randomHollow == 6) {
                this.worldObj.spawnEntityInWorld((Entity)par7);
            }
            else if (randomHollow == 7) {
                this.worldObj.spawnEntityInWorld((Entity)par9);
            }
            else if (randomHollow == 8) {
                this.worldObj.spawnEntityInWorld((Entity)par10);
            }
            else if (randomHollow == 9) {
                this.worldObj.spawnEntityInWorld((Entity)par11);
            }
        }
        if (par1DamageSource.getEntity() instanceof EntityHollowStalker) {
            if (randomHollow == 1) {
                this.worldObj.spawnEntityInWorld((Entity)par3);
            }
            else if (randomHollow == 2) {
                this.worldObj.spawnEntityInWorld((Entity)par4);
            }
            else if (randomHollow == 3) {
                this.worldObj.spawnEntityInWorld((Entity)par5);
            }
            else if (randomHollow == 4) {
                this.worldObj.spawnEntityInWorld((Entity)par6);
            }
            else if (randomHollow == 6) {
                this.worldObj.spawnEntityInWorld((Entity)par7);
            }
            else if (randomHollow == 7) {
                this.worldObj.spawnEntityInWorld((Entity)par8);
            }
            else if (randomHollow == 8) {
                this.worldObj.spawnEntityInWorld((Entity)par10);
            }
            else if (randomHollow == 9) {
                this.worldObj.spawnEntityInWorld((Entity)par11);
            }
        }
        if (par1DamageSource.getEntity() instanceof EntityHollowOre) {
            if (randomHollow == 1) {
                this.worldObj.spawnEntityInWorld((Entity)par3);
            }
            else if (randomHollow == 2) {
                this.worldObj.spawnEntityInWorld((Entity)par4);
            }
            else if (randomHollow == 3) {
                this.worldObj.spawnEntityInWorld((Entity)par5);
            }
            else if (randomHollow == 4) {
                this.worldObj.spawnEntityInWorld((Entity)par6);
            }
            else if (randomHollow == 6) {
                this.worldObj.spawnEntityInWorld((Entity)par7);
            }
            else if (randomHollow == 7) {
                this.worldObj.spawnEntityInWorld((Entity)par8);
            }
            else if (randomHollow == 8) {
                this.worldObj.spawnEntityInWorld((Entity)par9);
            }
            else if (randomHollow == 9) {
                this.worldObj.spawnEntityInWorld((Entity)par11);
            }
        }
        if (par1DamageSource.getEntity() instanceof EntityHollowWolf) {
            if (randomHollow == 1) {
                this.worldObj.spawnEntityInWorld((Entity)par3);
            }
            else if (randomHollow == 2) {
                this.worldObj.spawnEntityInWorld((Entity)par4);
            }
            else if (randomHollow == 3) {
                this.worldObj.spawnEntityInWorld((Entity)par5);
            }
            else if (randomHollow == 4) {
                this.worldObj.spawnEntityInWorld((Entity)par6);
            }
            else if (randomHollow == 6) {
                this.worldObj.spawnEntityInWorld((Entity)par7);
            }
            else if (randomHollow == 7) {
                this.worldObj.spawnEntityInWorld((Entity)par8);
            }
            else if (randomHollow == 8) {
                this.worldObj.spawnEntityInWorld((Entity)par9);
            }
            else if (randomHollow == 9) {
                this.worldObj.spawnEntityInWorld((Entity)par10);
            }
        }
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
        EntityWhole.rand = new Random();
    }
}

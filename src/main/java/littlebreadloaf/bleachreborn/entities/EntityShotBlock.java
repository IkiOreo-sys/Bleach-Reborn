package littlebreadloaf.bleachreborn.entities;

import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import littlebreadloaf.bleachreborn.api.*;
import littlebreadloaf.bleachreborn.events.*;
import net.minecraft.entity.monster.*;
import net.minecraft.enchantment.*;
import net.minecraft.entity.player.*;
import net.minecraft.network.play.server.*;
import net.minecraft.network.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.nbt.*;

public class EntityShotBlock extends Entity implements IProjectile
{
    private int xTile;
    private int yTile;
    private int zTile;
    private Block inTile;
    private int inData;
    private boolean inGround;
    public int canBePickedUp;
    public int arrowShake;
    public Entity shootingEntity;
    private int ticksInGround;
    private int ticksInAir;
    private double damage;
    private int knockbackStrength;
    public int blockID;
    
    public EntityShotBlock(final World par1World) {
        super(par1World);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.inData = 0;
        this.inGround = false;
        this.canBePickedUp = 0;
        this.arrowShake = 0;
        this.ticksInAir = 0;
        this.damage = 2.0;
        this.setSize(1.0f, 1.0f);
    }
    
    public EntityShotBlock(final World var1, final EntityLivingBase var2, final float var3, final int id) {
        super(var1);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.inData = 0;
        this.inGround = false;
        this.canBePickedUp = 0;
        this.arrowShake = 0;
        this.ticksInAir = 0;
        this.damage = 2.0;
        this.renderDistanceWeight = 10.0;
        this.shootingEntity = (Entity)var2;
        this.blockID = id;
        this.setSize(1.0f, 1.0f);
        this.setLocationAndAngles(var2.posX, var2.posY + var2.getEyeHeight(), var2.posZ, var2.rotationYaw, var2.rotationPitch);
        this.posX -= MathHelper.cos(this.rotationYaw / 180.0f * 3.1415927f) * 0.16f;
        this.posY -= 0.10000000149011612;
        this.posZ -= MathHelper.sin(this.rotationYaw / 180.0f * 3.1415927f) * 0.16f;
        this.setPosition(this.posX, this.posY, this.posZ);
        this.yOffset = 0.0f;
        this.motionX = -MathHelper.sin(this.rotationYaw / 180.0f * 3.1415927f) * MathHelper.cos(this.rotationPitch / 180.0f * 3.1415927f);
        this.motionZ = MathHelper.cos(this.rotationYaw / 180.0f * 3.1415927f) * MathHelper.cos(this.rotationPitch / 180.0f * 3.1415927f);
        this.motionY = -MathHelper.sin(this.rotationPitch / 180.0f * 3.1415927f);
        this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, var3 * 1.5f, 1.0f);
    }
    
    public void setThrowableHeading(double var1, double var3, double var5, final float var7, final float var8) {
        final float var9 = MathHelper.sqrt_double(var1 * var1 + var3 * var3 + var5 * var5);
        var1 /= var9;
        var3 /= var9;
        var5 /= var9;
        var1 += this.rand.nextGaussian() * 0.007499999832361937 * var8;
        var3 += this.rand.nextGaussian() * 0.007499999832361937 * var8;
        var5 += this.rand.nextGaussian() * 0.007499999832361937 * var8;
        var1 *= var7;
        var3 *= var7;
        var5 *= var7;
        this.motionX = var1;
        this.motionY = var3;
        this.motionZ = var5;
        final float var10 = MathHelper.sqrt_double(var1 * var1 + var5 * var5);
        final float n = (float)(Math.atan2(var1, var5) * 180.0 / 3.141592653589793);
        this.rotationYaw = n;
        this.prevRotationYaw = n;
        final float n2 = (float)(Math.atan2(var3, var10) * 180.0 / 3.141592653589793);
        this.rotationPitch = n2;
        this.prevRotationPitch = n2;
        this.ticksInGround = 0;
    }
    
    public void setVelocity(final double var1, final double var3, final double var5) {
        this.motionX = var1;
        this.motionY = var3;
        this.motionZ = var5;
        if (this.prevRotationPitch == 0.0f && this.prevRotationYaw == 0.0f) {
            final float var6 = MathHelper.sqrt_double(var1 * var1 + var5 * var5);
            final float n = (float)(Math.atan2(var1, var5) * 180.0 / 3.141592653589793);
            this.rotationYaw = n;
            this.prevRotationYaw = n;
            final float n2 = (float)(Math.atan2(var3, var6) * 180.0 / 3.141592653589793);
            this.rotationPitch = n2;
            this.prevRotationPitch = n2;
            this.prevRotationPitch = this.rotationPitch;
            this.prevRotationYaw = this.rotationYaw;
            this.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
            this.ticksInGround = 0;
        }
    }
    
    public void onUpdate() {
        super.onUpdate();
        if (this.prevRotationPitch == 0.0f && this.prevRotationYaw == 0.0f) {
            final float var1 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
            final float n = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0 / 3.141592653589793);
            this.rotationYaw = n;
            this.prevRotationYaw = n;
            final float n2 = (float)(Math.atan2(this.motionY, var1) * 180.0 / 3.141592653589793);
            this.rotationPitch = n2;
            this.prevRotationPitch = n2;
        }
        final Block block = this.worldObj.getBlock(this.xTile, this.yTile, this.zTile);
        if (block.getMaterial() != Material.air) {
            block.setBlockBoundsBasedOnState((IBlockAccess)this.worldObj, this.xTile, this.yTile, this.zTile);
            final AxisAlignedBB axisalignedbb = block.getCollisionBoundingBoxFromPool(this.worldObj, this.xTile, this.yTile, this.zTile);
            if (axisalignedbb != null && axisalignedbb.isVecInside(Vec3.createVectorHelper(this.posX, this.posY, this.posZ))) {
                this.inGround = true;
            }
        }
        if (this.inGround) {
            final int j = this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);
            if (block == this.inTile && j == this.inData) {
                if (this.blockID == 0) {
                    this.worldObj.setBlock(this.xTile, this.yTile + 1, this.zTile, (Block)Blocks.grass);
                }
                if (this.blockID == 1) {
                    this.worldObj.setBlock(this.xTile, this.yTile + 1, this.zTile, Blocks.dirt);
                }
                if (this.blockID == 2) {
                    this.worldObj.setBlock(this.xTile, this.yTile + 1, this.zTile, Blocks.stone);
                }
            }
        }
        else {
            ++this.ticksInAir;
            Vec3 var2 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
            Vec3 var3 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
            MovingObjectPosition var4 = this.worldObj.func_147447_a(var2, var3, false, true, false);
            var2 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
            var3 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
            if (var4 != null) {
                var3 = Vec3.createVectorHelper(var4.hitVec.xCoord, var4.hitVec.yCoord, var4.hitVec.zCoord);
            }
            if (this.ticksInAir == 200) {
                this.setDead();
            }
            Entity var5 = null;
            final List var6 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0, 1.0, 1.0));
            double var7 = 0.0;
            for (int var8 = 0; var8 < var6.size(); ++var8) {
                final Entity var9 = (Entity) var6.get(var8);
                if (var9.canBeCollidedWith() && (var9 != this.shootingEntity || this.ticksInAir >= 5)) {
                    final float var10 = 0.3f;
                    final AxisAlignedBB var11 = var9.boundingBox.expand(0.30000001192092896, 0.30000001192092896, 0.30000001192092896);
                    final MovingObjectPosition var12 = var11.calculateIntercept(var2, var3);
                    if (var12 != null) {
                        final double var13 = var2.distanceTo(var12.hitVec);
                        if (var13 < var7 || var7 == 0.0) {
                            var5 = var9;
                            var7 = var13;
                        }
                    }
                }
            }
            if (var5 != null) {
                var4 = new MovingObjectPosition(var5);
            }
            if (var4 != null) {
                if (var4.entityHit != null) {
                    final EntityPlayer player = (EntityPlayer)this.shootingEntity;
                    if (this.shootingEntity instanceof EntityPlayer) {}
                    if (var4.entityHit instanceof EntityLivingBase) {
                        if (((EntityLivingBase)var4.entityHit).getCreatureAttribute() == Tools.SPIRIT && this.shootingEntity instanceof EntityPlayer) {
                            final ExtendedPlayer props = (ExtendedPlayer)player.getExtendedProperties("BleachPlayer");
                            if (!player.worldObj.isRemote && props.getFaction() == 1) {
                                props.addSXP(3);
                            }
                        }
                        if (this.shootingEntity instanceof EntityPlayer) {
                            final ExtendedPlayer extendedPlayer = (ExtendedPlayer)player.getExtendedProperties("BleachPlayer");
                        }
                    }
                    this.ticksInAir = 495;
                    final float var14 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
                    final int var15 = MathHelper.ceiling_double_int(var14 * this.damage);
                    DamageSource var16 = null;
                    if (this.shootingEntity == null) {
                        var16 = DamageSource.causeThrownDamage((Entity)this, (Entity)this);
                    }
                    else {
                        var16 = DamageSource.causeThrownDamage((Entity)this, this.shootingEntity);
                    }
                    if (this.isBurning() && !(var4.entityHit instanceof EntityEnderman)) {
                        var4.entityHit.setFire(5);
                    }
                    if (var4.entityHit.attackEntityFrom(var16, (float)var15)) {
                        if (var4.entityHit instanceof EntityLivingBase) {
                            final EntityLivingBase var17 = (EntityLivingBase)var4.entityHit;
                            if (!this.worldObj.isRemote) {
                                var17.setArrowCountInEntity(var17.getArrowCountInEntity() + 1);
                            }
                            if (this.knockbackStrength > 0) {
                                final float var18 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
                                if (var18 > 0.0f) {
                                    var4.entityHit.addVelocity(this.motionX * this.knockbackStrength * 0.6000000238418579 / var18, 0.1, this.motionZ * this.knockbackStrength * 0.6000000238418579 / var18);
                                }
                            }
                            if (this.shootingEntity != null && this.shootingEntity instanceof EntityLivingBase) {
                                EnchantmentHelper.func_151384_a(var17, this.shootingEntity);
                                EnchantmentHelper.func_151385_b((EntityLivingBase)this.shootingEntity, (Entity)var17);
                            }
                            if (this.shootingEntity != null && var4.entityHit != this.shootingEntity && var4.entityHit instanceof EntityPlayer && this.shootingEntity instanceof EntityPlayerMP) {
                                ((EntityPlayerMP)this.shootingEntity).playerNetServerHandler.sendPacket((Packet)new S2BPacketChangeGameState(6, 0.0f));
                            }
                        }
                        this.playSound("random.bowhit", 1.0f, 1.2f / (this.rand.nextFloat() * 0.2f + 0.9f));
                        if (!(var4.entityHit instanceof EntityEnderman)) {
                            this.setDead();
                        }
                    }
                    else {
                        this.motionX *= -0.10000000149011612;
                        this.motionY *= -0.10000000149011612;
                        this.motionZ *= -0.10000000149011612;
                        this.rotationYaw += 180.0f;
                        this.prevRotationYaw += 180.0f;
                        this.ticksInAir = 0;
                    }
                    this.setDead();
                }
                else {
                    this.xTile = var4.blockX;
                    this.yTile = var4.blockY;
                    this.zTile = var4.blockZ;
                    this.inTile = this.worldObj.getBlock(this.xTile, this.yTile, this.zTile);
                    this.inData = this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);
                    this.motionX = (float)(var4.hitVec.xCoord - this.posX);
                    this.motionY = (float)(var4.hitVec.yCoord - this.posY);
                    this.motionZ = (float)(var4.hitVec.zCoord - this.posZ);
                    final float var19 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
                    this.posX -= this.motionX / var19 * 0.05000000074505806;
                    this.posY -= this.motionY / var19 * 0.05000000074505806;
                    this.posZ -= this.motionZ / var19 * 0.05000000074505806;
                    this.playSound("random.bowhit", 1.0f, 1.2f / (this.rand.nextFloat() * 0.2f + 0.9f));
                    this.inGround = true;
                    this.arrowShake = 7;
                    if (this.inTile != Blocks.air) {
                        this.inTile.onEntityCollidedWithBlock(this.worldObj, this.xTile, this.yTile, this.zTile, (Entity)this);
                    }
                }
            }
            this.posX += this.motionX;
            this.posY += this.motionY;
            this.posZ += this.motionZ;
            final float var19 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0 / 3.141592653589793);
            this.rotationPitch = (float)(Math.atan2(this.motionY, var19) * 180.0 / 3.141592653589793);
            while (this.rotationPitch - this.prevRotationPitch < -180.0f) {
                this.prevRotationPitch -= 360.0f;
            }
            while (this.rotationPitch - this.prevRotationPitch >= 180.0f) {
                this.prevRotationPitch += 360.0f;
            }
            while (this.rotationYaw - this.prevRotationYaw < -180.0f) {
                this.prevRotationYaw -= 360.0f;
            }
            while (this.rotationYaw - this.prevRotationYaw >= 180.0f) {
                this.prevRotationYaw += 360.0f;
            }
            this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2f;
            this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2f;
            float var20 = 0.99f;
            final float var10 = 0.05f;
            if (this.isInWater()) {
                for (int var21 = 0; var21 < 4; ++var21) {
                    final float var22 = 0.25f;
                    this.worldObj.spawnParticle("bubble", this.posX - this.motionX * 0.25, this.posY - this.motionY * 0.25, this.posZ - this.motionZ * 0.25, this.motionX, this.motionY, this.motionZ);
                }
                var20 = 0.8f;
            }
            this.motionX *= var20;
            this.motionZ *= var20;
            this.setPosition(this.posX, this.posY, this.posZ);
            this.func_145775_I();
        }
    }
    
    protected void entityInit() {
    }
    
    protected void readEntityFromNBT(final NBTTagCompound var1) {
        this.blockID = var1.getInteger("BlockID");
    }
    
    protected void writeEntityToNBT(final NBTTagCompound var1) {
        var1.setInteger("BlockID", this.blockID);
    }
}

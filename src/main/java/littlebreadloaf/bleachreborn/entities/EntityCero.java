package littlebreadloaf.bleachreborn.entities;

import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import littlebreadloaf.bleachreborn.blocks.*;
import littlebreadloaf.bleachreborn.api.*;
import littlebreadloaf.bleachreborn.events.*;
import littlebreadloaf.bleachreborn.armor.*;
import net.minecraft.entity.monster.*;
import net.minecraft.enchantment.*;
import net.minecraft.entity.player.*;
import net.minecraft.network.play.server.*;
import net.minecraft.network.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import littlebreadloaf.bleachreborn.items.*;

public class EntityCero extends Entity implements IProjectile
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
    public double startingX;
    public double startingY;
    public double startingZ;
    double robeboost;
    double pantboost;
    double sandalboost;
    double damageboost;
    
    public EntityCero(final World var1) {
        super(var1);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.inData = 0;
        this.inGround = false;
        this.canBePickedUp = 0;
        this.arrowShake = 0;
        this.ticksInAir = 0;
        this.damage = 10.0;
        this.robeboost = 0.0;
        this.pantboost = 0.0;
        this.sandalboost = 0.0;
        this.damageboost = 0.0;
        this.renderDistanceWeight = 10.0;
        this.setSize(0.5f, 0.5f);
        this.startingX = this.posX;
        this.startingY = this.posY;
        this.startingZ = this.posZ;
    }
    
    public int getBrightnessForRender(final float par1) {
        return 15728880;
    }
    
    public float getBrightness(final float par1) {
        return 1.0f;
    }
    
    public EntityCero(final World var1, final double var2, final double var4, final double var6) {
        super(var1);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.inData = 0;
        this.inGround = false;
        this.canBePickedUp = 0;
        this.arrowShake = 0;
        this.ticksInAir = 0;
        this.damage = 10.0;
        this.robeboost = 0.0;
        this.pantboost = 0.0;
        this.sandalboost = 0.0;
        this.damageboost = 0.0;
        this.renderDistanceWeight = 10.0;
        this.setSize(0.5f, 0.5f);
        this.setPosition(var2, var4, var6);
        this.yOffset = 0.0f;
        this.startingX = this.posX;
        this.startingY = this.posY - 1;
        this.startingZ = this.posZ;
    }
    
    public EntityCero(final World var1, final EntityLiving var2, final EntityLiving var3, final float var4, final float var5) {
        super(var1);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.inData = 0;
        this.inGround = false;
        this.canBePickedUp = 0;
        this.arrowShake = 0;
        this.ticksInAir = 0;
        this.damage = 10.0;
        this.robeboost = 0.0;
        this.pantboost = 0.0;
        this.sandalboost = 0.0;
        this.damageboost = 0.0;
        this.renderDistanceWeight = 10.0;
        this.shootingEntity = (Entity)var2;
        this.posY = var2.posY + var2.getEyeHeight() - 0.10000000149011612;
        final double var6 = var3.posX - var2.posX;
        final double var7 = var3.posY + var3.getEyeHeight() - 0.699999988079071 - this.posY;
        final double var8 = var3.posZ - var2.posZ;
        final double var9 = MathHelper.sqrt_double(var6 * var6 + var8 * var8);
        if (var9 >= 1.0E-7) {
            final float var10 = (float)(Math.atan2(var8, var6) * 180.0 / 3.141592653589793) - 90.0f;
            final float var11 = (float)(-(Math.atan2(var7, var9) * 180.0 / 3.141592653589793));
            final double var12 = var6 / var9;
            final double var13 = var8 / var9;
            this.setLocationAndAngles(var2.posX + var12, this.posY, var2.posZ + var13, var10, var11);
            this.yOffset = 0.0f;
            final float var14 = (float)var9 * 0.2f;
            this.setThrowableHeading(var6, var7 + var14, var8, var4, var5);
        }
        this.startingX = this.posX;
        this.startingY = this.posY - 1;
        this.startingZ = this.posZ;
    }
    
    public EntityCero(final World var1, final EntityLivingBase var2, final float var3) {
        super(var1);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.inData = 0;
        this.inGround = false;
        this.canBePickedUp = 0;
        this.arrowShake = 0;
        this.ticksInAir = 0;
        this.damage = 10.0;
        this.robeboost = 0.0;
        this.pantboost = 0.0;
        this.sandalboost = 0.0;
        this.damageboost = 0.0;
        this.renderDistanceWeight = 10.0;
        this.shootingEntity = (Entity)var2;
        this.setSize(0.5f, 0.5f);
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
        this.startingX = this.posX;
        this.startingY = this.posY - 1;
        this.startingZ = this.posZ;
    }
    
    public EntityCero(final World var1, final EntityMenosGrande menos, final float var3, final boolean b) {
        super(var1);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.inData = 0;
        this.inGround = false;
        this.canBePickedUp = 0;
        this.arrowShake = 0;
        this.ticksInAir = 0;
        this.damage = 10.0;
        this.robeboost = 0.0;
        this.pantboost = 0.0;
        this.sandalboost = 0.0;
        this.damageboost = 0.0;
        this.renderDistanceWeight = 10.0;
        this.shootingEntity = (Entity)menos;
        this.setSize(0.5f, 0.5f);
        this.setLocationAndAngles(menos.posX, menos.posY + menos.getEyeHeight(), menos.posZ, menos.rotationYaw, -0.62831855f);
        this.rotationPitch = -0.62831855f;
        this.posX -= MathHelper.cos(this.rotationYaw / 180.0f * 3.1415927f) * 0.16f;
        this.posY -= 0.10000000149011612;
        this.posZ -= MathHelper.sin(this.rotationYaw / 180.0f * 3.1415927f) * 0.16f;
        this.setPosition(this.posX, this.posY, this.posZ);
        this.yOffset = 0.0f;
        this.motionX = -MathHelper.sin(this.rotationYaw / 180.0f * 3.1415927f) * MathHelper.cos(this.rotationPitch / 180.0f * 3.1415927f);
        this.motionZ = MathHelper.cos(this.rotationYaw / 180.0f * 3.1415927f) * MathHelper.cos(this.rotationPitch / 180.0f * 3.1415927f);
        this.motionY = -MathHelper.sin(this.rotationPitch / 180.0f * 3.1415927f);
        this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, var3 * 1.5f, 1.0f);
        this.startingX = this.posX;
        this.startingY = this.posY - 1;
        this.startingZ = this.posZ;
    }
    
    protected void entityInit() {
        this.dataWatcher.addObject(16, (Object)0);
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
    
    public void setPositionAndRotation2(final double var1, final double var3, final double var5, final float var7, final float var8, final int var9) {
        this.setPosition(var1, var3, var5);
        this.setRotation(var7, var8);
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
        final int ar1 = MathHelper.floor_double(this.posY);
        final int ar2 = MathHelper.floor_double(this.posX);
        final int ar3 = MathHelper.floor_double(this.posZ);
        final float velocityy = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
        if (velocityy < 1.4) {
            this.setDead();
        }
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
        if (this.arrowShake > 0) {
            --this.arrowShake;
        }
        if (this.inGround) {
            final int j = this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);
            if (block == this.inTile && j == this.inData) {
                ++this.ticksInGround;
                if (this.ticksInGround == 12) {
                    this.setDead();
                }
            }
            else {
                this.inGround = false;
                this.motionX *= this.rand.nextFloat() * 0.2f;
                this.motionY *= this.rand.nextFloat() * 0.2f;
                this.motionZ *= this.rand.nextFloat() * 0.2f;
                this.ticksInGround = 0;
                this.ticksInAir = 0;
            }
        }
        else {
            for (int ar4 = -1; ar4 <= 1; ++ar4) {
                for (int ar5 = -1; ar5 <= 1; ++ar5) {
                    for (int ar6 = -2; ar6 <= 2; ++ar6) {
                        final int ar7 = ar2 + ar4;
                        final int ar8 = ar1 + ar6;
                        final int ar9 = ar3 + ar5;
                        final Block ar10 = this.worldObj.getBlock(ar7, ar8, ar9);
                        if (!this.worldObj.isRemote && this.ticksExisted > 3 && ar10 != null && ar10 != Blocks.bedrock && ar10 != Blocks.obsidian && ar10 != Blocks.portal && ar10 != BleachBlocks.reiatsuBlock && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
                            final int ar11 = this.worldObj.getBlockMetadata(ar7, ar8, ar9);
                            this.worldObj.setBlockToAir(ar7, ar8, ar9);
                        }
                    }
                }
            }
            ++this.ticksInAir;
            Vec3 var2 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
            Vec3 var3 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
            MovingObjectPosition var4 = this.worldObj.func_147447_a(var2, var3, false, true, false);
            var2 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
            var3 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
            if (var4 != null) {
                var3 = Vec3.createVectorHelper(var4.hitVec.xCoord, var4.hitVec.yCoord, var4.hitVec.zCoord);
            }
            if (this.ticksInAir >= 40) {
                this.setDead();
            }
            Entity var5 = null;
            final List var6 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0, 1.0, 1.0));
            double var7 = 0.0;
            for (int var8 = 0; var8 < var6.size(); ++var8) {
                final Entity var9 = (Entity) var6.get(var8);
                if (var9.canBeCollidedWith() && var9 != this.shootingEntity) {
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
            if (var4 != null && this.ticksExisted > 2) {
                if (!this.worldObj.isRemote) {
                    this.worldObj.createExplosion((Entity)this, this.posX, this.posY, this.posZ, 2.0f, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
                }
                if (var4.entityHit != null) {
                    if (var4.entityHit instanceof EntityLiving && ((EntityLiving)var4.entityHit).getCreatureAttribute() == Tools.SPIRIT) {
                        this.damage = 12.0;
                    }
                    this.ticksInAir = 195;
                    if (this.shootingEntity instanceof EntityPlayer) {
                        final EntityPlayer player = (EntityPlayer)this.shootingEntity;
                        final ExtendedPlayer props = (ExtendedPlayer)player.getExtendedProperties("BleachPlayer");
                        final ItemStack var14 = ((EntityPlayer)this.shootingEntity).getCurrentArmor(0);
                        final ItemStack var15 = ((EntityPlayer)this.shootingEntity).getCurrentArmor(1);
                        final ItemStack var16 = ((EntityPlayer)this.shootingEntity).getCurrentArmor(2);
                        if (var14 != null && (var14.getItem() == Armor.Sandals || var14.getItem() == Armor.ArrancarShoes)) {
                            this.sandalboost = -0.2;
                        }
                        else if (var14 != null && var14.getItem() == Armor.QuincyShoes) {
                            this.sandalboost = 0.2;
                        }
                        else {
                            this.sandalboost = 0.0;
                        }
                        if (var15 != null && (var15.getItem() == Armor.ShiniPants || var15.getItem() == Armor.ArrancarPants)) {
                            this.pantboost = -0.4;
                        }
                        else if (var15 != null && var15.getItem() == Armor.QuincyPants) {
                            this.pantboost = 0.4;
                        }
                        else {
                            this.pantboost = 0.0;
                        }
                        if (var16 != null && (var16.getItem() == Armor.ShiniRobe || var16.getItem() == Armor.ArrancarJacket)) {
                            this.robeboost = -0.8;
                        }
                        else if (var16 != null && var16.getItem() == Armor.QuincyRobe) {
                            this.robeboost = 0.8;
                        }
                        else {
                            this.robeboost = 0.0;
                        }
                        if (var4.entityHit instanceof EntityLivingBase) {
                            if (((EntityLivingBase)var4.entityHit).getCreatureAttribute() == Tools.SPIRIT) {
                                if (this.shootingEntity instanceof EntityPlayer) {
                                    if (!player.worldObj.isRemote && props.getFaction() == 2) {
                                        props.addSXP(3);
                                    }
                                    this.damageboost = 3.0;
                                    if (props.getFaction() == 2) {
                                        final double spirit = props.getCurrentCap() * (double)props.getCurrentEnergy() / 100.0;
                                        final double ddamage = this.damageboost + this.robeboost + this.sandalboost + this.pantboost + spirit;
                                        ((EntityLivingBase)var4.entityHit).setHealth(((EntityLivingBase)var4.entityHit).getHealth() - (float)ddamage);
                                    }
                                }
                            }
                            else {
                                if (!player.worldObj.isRemote && props.getFaction() == 2) {
                                    props.addSXP(1);
                                }
                                this.damageboost = 0.0;
                                if (props.getFaction() == 2) {
                                    final double spirit = props.getCurrentCap() * (double)props.getCurrentEnergy() / 100.0;
                                    final double ddamage = this.damageboost + this.robeboost + this.sandalboost + this.pantboost + spirit;
                                    ((EntityLivingBase)var4.entityHit).setHealth(((EntityLivingBase)var4.entityHit).getHealth() - (float)ddamage);
                                }
                            }
                        }
                    }
                    this.ticksInAir = 495;
                    final float var17 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
                    int var18 = MathHelper.ceiling_double_int(var17 * this.damage);
                    if (this.getIsCritical()) {
                        var18 += this.rand.nextInt(var18 / 2 + 2);
                    }
                    DamageSource var19 = null;
                    if (this.shootingEntity == null) {
                        var19 = DamageSource.causeThrownDamage((Entity)this, (Entity)this);
                    }
                    else {
                        var19 = DamageSource.causeThrownDamage((Entity)this, this.shootingEntity);
                    }
                    if (this.isBurning() && !(var4.entityHit instanceof EntityEnderman)) {
                        var4.entityHit.setFire(5);
                    }
                    if (var4.entityHit.attackEntityFrom(var19, (float)var18)) {
                        if (var4.entityHit instanceof EntityLivingBase) {
                            final EntityLivingBase var20 = (EntityLivingBase)var4.entityHit;
                            if (!this.worldObj.isRemote) {
                                var20.setArrowCountInEntity(var20.getArrowCountInEntity() + 1);
                            }
                            if (this.knockbackStrength > 0) {
                                final float var21 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
                                if (var21 > 0.0f) {
                                    var4.entityHit.addVelocity(this.motionX * this.knockbackStrength * 0.6000000238418579 / var21, 0.1, this.motionZ * this.knockbackStrength * 0.6000000238418579 / var21);
                                }
                            }
                            if (this.shootingEntity != null && this.shootingEntity instanceof EntityLivingBase) {
                                EnchantmentHelper.func_151384_a(var20, this.shootingEntity);
                                EnchantmentHelper.func_151385_b((EntityLivingBase)this.shootingEntity, (Entity)var20);
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
                    final float var17 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
                    this.posX -= this.motionX / var17 * 0.05000000074505806;
                    this.posY -= this.motionY / var17 * 0.05000000074505806;
                    this.posZ -= this.motionZ / var17 * 0.05000000074505806;
                    this.playSound("random.bowhit", 1.0f, 1.2f / (this.rand.nextFloat() * 0.2f + 0.9f));
                    this.inGround = true;
                    this.arrowShake = 7;
                    this.setIsCritical(false);
                    if (this.inTile != Blocks.air) {
                        this.inTile.onEntityCollidedWithBlock(this.worldObj, this.xTile, this.yTile, this.zTile, (Entity)this);
                    }
                }
            }
            this.posX += this.motionX;
            this.posY += this.motionY;
            this.posZ += this.motionZ;
            final float var17 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0 / 3.141592653589793);
            this.rotationPitch = (float)(Math.atan2(this.motionY, var17) * 180.0 / 3.141592653589793);
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
            float var22 = 0.99f;
            final float var10 = 0.05f;
            if (this.isInWater()) {
                for (int var23 = 0; var23 < 4; ++var23) {
                    final float var21 = 0.25f;
                    this.worldObj.spawnParticle("bubble", this.posX - this.motionX * 0.25, this.posY - this.motionY * 0.25, this.posZ - this.motionZ * 0.25, this.motionX, this.motionY, this.motionZ);
                }
                var22 = 0.8f;
            }
            this.motionX *= var22;
            this.motionZ *= var22;
            this.setPosition(this.posX, this.posY, this.posZ);
            this.func_145775_I();
        }
    }
    
    public void writeEntityToNBT(final NBTTagCompound var1) {
        var1.setShort("xTile", (short)this.xTile);
        var1.setShort("yTile", (short)this.yTile);
        var1.setShort("zTile", (short)this.zTile);
        var1.setByte("inTile", (byte)Block.getIdFromBlock(this.inTile));
        var1.setByte("inData", (byte)this.inData);
        var1.setByte("shake", (byte)this.arrowShake);
        var1.setByte("inGround", (byte)(byte)(this.inGround ? 1 : 0));
        var1.setByte("pickup", (byte)this.canBePickedUp);
        var1.setDouble("damage", this.damage);
    }
    
    public void readEntityFromNBT(final NBTTagCompound var1) {
        this.xTile = var1.getShort("xTile");
        this.yTile = var1.getShort("yTile");
        this.zTile = var1.getShort("zTile");
        this.inTile = Block.getBlockById(var1.getByte("inTile") & 0xFF);
        this.inData = (var1.getByte("inData") & 0xFF);
        this.arrowShake = (var1.getByte("shake") & 0xFF);
        this.inGround = (var1.getByte("inGround") == 1);
        if (var1.hasKey("damage")) {
            this.damage = var1.getDouble("damage");
        }
        if (var1.hasKey("pickup")) {
            this.canBePickedUp = var1.getByte("pickup");
        }
        else if (var1.hasKey("player")) {
            this.canBePickedUp = (var1.getBoolean("player") ? 1 : 0);
        }
    }
    
    public void onCollideWithPlayer(final EntityPlayer var1) {
        if (!this.worldObj.isRemote && this.inGround && this.arrowShake <= 0) {
            boolean var2 = this.canBePickedUp == 1 || (this.canBePickedUp == 2 && var1.capabilities.isCreativeMode);
            if (this.canBePickedUp == 1 && !var1.inventory.addItemStackToInventory(new ItemStack(BleachItems.reiatsu, 1))) {
                var2 = false;
            }
            if (var2) {
                this.playSound("random.pop", 0.2f, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7f + 1.0f) * 2.0f);
                var1.onItemPickup((Entity)this, 1);
                this.setDead();
            }
        }
    }
    
    protected boolean canTriggerWalking() {
        return false;
    }
    
    public float getShadowSize() {
        return 0.0f;
    }
    
    public void setDamage(final double var1) {
        this.damage = var1;
    }
    
    public double getDamage() {
        return this.damage;
    }
    
    public void setKnockbackStrength(final int var1) {
        this.knockbackStrength = var1;
    }
    
    public boolean canAttackWithItem() {
        return false;
    }
    
    public void setIsCritical(final boolean var1) {
        final int var2 = this.dataWatcher.getWatchableObjectInt(16);
        if (var1) {
            this.dataWatcher.updateObject(16, (Object)1);
        }
        else {
            this.dataWatcher.updateObject(16, (Object)0);
        }
    }
    
    public boolean getIsCritical() {
        final int var1 = this.dataWatcher.getWatchableObjectInt(16);
        return var1 == 1;
    }
}

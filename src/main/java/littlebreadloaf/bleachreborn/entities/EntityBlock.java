package littlebreadloaf.bleachreborn.entities;

import net.minecraft.block.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import littlebreadloaf.bleachreborn.events.*;
import littlebreadloaf.bleachreborn.items.*;
import net.minecraft.util.*;
import net.minecraft.nbt.*;

public class EntityBlock extends Entity
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
    
    public EntityBlock(final World par1World) {
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
    
    public EntityBlock(final World var1, final EntityLivingBase var2, final float var3, final int id) {
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
        this.ignoreFrustumCheck = true;
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
        if (this.shootingEntity != null && this.shootingEntity instanceof EntityPlayer) {
            final EntityPlayer player = (EntityPlayer)this.shootingEntity;
            final ExtendedPlayer props = ExtendedPlayer.get(player);
            if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == BleachItems.shikaiearth) {
                if (props.getHasBlock()) {
                    final Vec3 look = player.getLook(1.0f);
                    this.posX = this.shootingEntity.posX + look.xCoord;
                    this.posY = this.shootingEntity.posY + look.yCoord;
                    this.posZ = this.shootingEntity.posZ + look.zCoord;
                }
                else {
                    this.setDead();
                }
            }
            else {
                props.setHasBlock(false);
                this.setDead();
            }
        }
        else {
            this.setDead();
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

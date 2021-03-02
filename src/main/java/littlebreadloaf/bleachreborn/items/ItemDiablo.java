package littlebreadloaf.bleachreborn.items;

import java.util.List;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import littlebreadloaf.bleachreborn.events.ExtendedPlayer;
import littlebreadloaf.bleachreborn.network.PacketDispatcher;
import littlebreadloaf.bleachreborn.network.ParticleMessage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ItemDiablo extends ItemSword {
    
	
	int ringTimer;
	int shockwaveRing;
    int shockwaveMax;
    int Xpos;
    int Ypos;
    int Zpos;
    
    public ItemDiablo(ToolMaterial p_i45356_1_) {
		super(p_i45356_1_);
		this.ringTimer = 3;
		this.shockwaveRing = 0;
        this.shockwaveMax = 10;
	}

	public ItemStack onItemRightClick(final ItemStack stack, final World world, final EntityPlayer player) {
    	ExtendedPlayer props = ExtendedPlayer.get(player);
    	if (props.getFaction() == 6) {
    		props.setFaction(16);
    	}
    	if (props.getFaction() == 16) {
            player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
    	}
		return stack;
    	
    }
	
	public void onPlayerStoppedUsing(final ItemStack var1, final World var2, final EntityPlayer var3, final int var4) {
        final ExtendedPlayer props = (ExtendedPlayer)var3.getExtendedProperties("BleachPlayer");
        final int var5 = this.getMaxItemUseDuration(var1) - var4;
        float var6 = var5 / 20.0f;
        var6 = (var6 * var6 + var6 * 2.0f) / 3.0f;
        var3.swingItem();
        if (var6 < 0.1) {
            return;
        }
        if (var6 > 1.0f) {
            if (var6 > 3.0f) {
                var6 = 3.0f;
            }
            if (!var2.isRemote && var2.getBlock((int)var3.posX, (int)var3.posY - 1, (int)var3.posZ) != Blocks.air) {
                this.shockwaveRing = 1;
                this.shockwaveMax = 5 + (int)var6;
                this.Xpos = (int)var3.posX;
                this.Ypos = (int)var3.posY;
                this.Zpos = (int)var3.posZ;
                final Vec3 normalizer = Vec3.createVectorHelper(0.008, 0.008, 0.008).normalize();
                final List list = var2.getEntitiesWithinAABBExcludingEntity((Entity)var3, var3.boundingBox.copy().expand(Math.abs(normalizer.xCoord * 3.0) + 6.0, Math.abs(normalizer.yCoord * 3.0) + 6.0, Math.abs(normalizer.zCoord * 3.0) - 6.0 + this.shockwaveMax));
                for (int l = 0; l < list.size(); ++l) {
                    final Entity entity1 = (Entity) list.get(l);
                    if (entity1 instanceof EntityLivingBase) {
                        double moveX = entity1.posX - var3.posX;
                        double moveY = entity1.posY - var3.posY;
                        double moveZ = entity1.posZ - var3.posZ;
                        final double angle = Math.atan2(moveZ, moveX);
                        moveX = 0.4 * Math.cos(angle);
                        moveZ = 0.4 * Math.sin(angle);
                        moveY = 0.30000001192092896;
                        ((EntityLivingBase) entity1).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 2000, 3, true));
                        ((EntityLivingBase)entity1).attackEntityFrom(DamageSource.generic, props.getCurrentCap() / 5.0f);
                    }
                }
                props.consumeEnergy(50);
            }
        }
    }
	
	public void onUpdate(final ItemStack par1ItemStack, final World par2World, final Entity par3Entity, final int par4, final boolean par5) {
        if (par3Entity instanceof EntityPlayer) {
            if (this.shockwaveRing > 0) {
                --this.ringTimer;
                for (int i = -this.shockwaveRing; i < this.shockwaveRing; ++i) {
                    for (int k = -this.shockwaveRing; k < this.shockwaveRing; ++k) {
                        if (Math.ceil(par3Entity.getDistance(par3Entity.posX + i, par3Entity.posY, par3Entity.posZ + k)) == this.shockwaveRing) {
                            PacketDispatcher.sendToAll((IMessage)new ParticleMessage(2, this.Xpos + i, this.Ypos, this.Zpos + k));
                        }
                    }
                }
                if (this.ringTimer <= 0) {
                    ++this.shockwaveRing;
                    this.ringTimer = 2 + this.shockwaveRing;
                }
                if (this.shockwaveRing > this.shockwaveMax) {
                    this.shockwaveRing = 0;
                }
            }
        }
    }

    	

}

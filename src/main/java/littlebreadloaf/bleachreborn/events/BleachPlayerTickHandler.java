package littlebreadloaf.bleachreborn.events;

import java.util.List;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import littlebreadloaf.bleachreborn.api.Tools;
import littlebreadloaf.bleachreborn.items.BleachItems;
import littlebreadloaf.bleachreborn.network.PacketDispatcher;
import littlebreadloaf.bleachreborn.network.ParticleMessage;
import littlebreadloaf.bleachreborn.world.biomes.BleachBiomes;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Vec3;

public class BleachPlayerTickHandler
{
    private int armorBonus;
    private boolean countPoints;
    private int flapCountdown;
    private int flapsLeft;
    private int healTimer;
    private int sent;
    
    public BleachPlayerTickHandler() {
        this.armorBonus = 3;
        this.countPoints = true;
        this.flapCountdown = 23;
        this.flapsLeft = 4;
        this.healTimer = 300;
    }
    
    @SubscribeEvent
    public void onPlayerTick(final TickEvent.PlayerTickEvent event) {
        final EntityPlayer player = event.player;
        final ExtendedPlayer props = (ExtendedPlayer)player.getExtendedProperties("BleachPlayer");
        final ItemStack chest = player.getCurrentArmor(3);
        final ItemStack legs = player.getCurrentArmor(2);
        final ItemStack shoes = player.getCurrentArmor(1);
        if (props.getFaction() == 3 && props.getHead() == 3) {
            --this.healTimer;
            if (this.healTimer <= 0 && !player.worldObj.isRemote) {
                player.heal(1.0f);
                this.healTimer = 300;
            }
        }
        if (props.getFaction() == 3 && props.getLegs() == 1) {
            player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 1, 0));
        }
        if (props.getFaction() == 3 && props.getLegs() == 2 && player.isSneaking()) {
            final EntityPlayer entityPlayer = player;
            final EntityPlayer entityPlayer2 = player;
            final double n = 0.0;
            entityPlayer2.motionZ = 0.0;
            entityPlayer.motionX = 0.0;
        }
        if (props.getFaction() == 3 && props.getArms() == 3) {
            player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 1, 0));
        }
        if (props.getFaction() == 3 && props.getBack() == 1) {
            player.addPotionEffect(new PotionEffect(Potion.resistance.id, 1, 0));
        }
        if (props.getFaction() == 3 && props.getTail() == 2 && player.isInWater()) {
            player.moveFlying(player.moveStrafing, player.moveForward, 0.01f + props.getCurrentEnergy() * props.getCurrentCap() / 10000.0f);
        }
        for (int j = -1; j <= 1; ++j) {
            for (int k = -1; k <= 1; ++k) {
                if (player.worldObj.getBlock((int)player.posX, (int)(player.posY + j), (int)(player.posZ + k)) != Blocks.air && !props.getValidFlash()) {
                    props.setValidFlash(true);
                }
            }
        }
        if (!player.onGround && player.isSneaking() && player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == BleachItems.shikaiwind) {
            if (props.getCurrentCap() >= 2000) {
            	player.motionY = -0.3 + props.getCurrentEnergy() * (props.getCurrentCap() / 10) / 10000.0f;
	            player.moveFlying(player.moveStrafing, player.moveForward, 0.12f + props.getCurrentEnergy() * (props.getCurrentCap() / 10) / 10000.0f);
	            PacketDispatcher.sendToAll((IMessage)new ParticleMessage(3, player.posX, player.posY + 1.0, player.posZ));
            }
            else {
	        	player.motionY = -0.3 + props.getCurrentEnergy() * props.getCurrentCap() / 10000.0f;
	            player.moveFlying(player.moveStrafing, player.moveForward, 0.12f + props.getCurrentEnergy() * props.getCurrentCap() / 10000.0f);
	            PacketDispatcher.sendToAll((IMessage)new ParticleMessage(3, player.posX, player.posY + 1.0, player.posZ));
            }
        }
        if (props.getFaction() == 3 && props.getTail() == 1) {
            final Vec3 normalizer = Vec3.createVectorHelper(1.0, 1.0, 1.0).normalize();
            final List list = player.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)player, player.boundingBox.copy().expand(Math.abs(normalizer.xCoord * 25.0), Math.abs(normalizer.yCoord * 25.0), Math.abs(normalizer.zCoord * 25.0)));
            int number = 0;
            for (int l = 0; l < list.size(); ++l) {
                final Entity entity1 = (Entity) list.get(l);
                if (entity1 instanceof EntityLivingBase && ((EntityLivingBase)entity1).getCreatureAttribute() == Tools.SPIRIT) {
                    ++number;
                }
            }
            if (number >= 5) {
                player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 0, 1));
            }
            else if (number >= 2) {
                player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 0, 0));
            }
        }
        if (props.getFaction() == 3 && props.getHead() == 2 && player.isSprinting()) {
            final Vec3 normalizer = Vec3.createVectorHelper(0.008, 0.008, 0.008).normalize();
            final List list = player.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)player, player.boundingBox.copy().expand(Math.abs(normalizer.xCoord * 0.5), Math.abs(normalizer.yCoord * 0.5), Math.abs(normalizer.zCoord * 0.5)));
            for (int i = 0; i < list.size(); ++i) {
                final Entity entity2 = (Entity) list.get(i);
                if (entity2 instanceof EntityLivingBase) {
                    double moveX = entity2.posX - player.posX;
                    double moveY = entity2.posY - player.posY;
                    double moveZ = entity2.posZ - player.posZ;
                    final double angle = Math.atan2(moveZ, moveX);
                    moveX = 0.8 * Math.cos(angle);
                    moveZ = 0.8 * Math.sin(angle);
                    moveY = 0.5;
                    entity2.addVelocity(moveX, moveY, moveZ);
                    ((EntityLivingBase)entity2).attackEntityFrom(DamageSource.generic, 1.0f);
                }
            }
        }
        if (!player.worldObj.isRemote && player.worldObj.getBiomeGenForCoordsBody((int)player.posX, (int)player.posZ) == BleachBiomes.HuecoMundo && player.posY <= 45) {
        	if (sent == 0) {
        		player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.DARK_RED + "Welcome to the menos forest."));
        		sent = sent + 1;
        	}
        }
        else if (player.worldObj.getBiomeGenForCoordsBody((int)player.posX, (int)player.posZ) != BleachBiomes.HuecoMundo || player.posY >= 45) {
        	sent = sent - 1;
        }
        if (player.onGround) {
            this.flapsLeft = 4;
        }
        if (props.getHollowKills() < 0) {
        	props.setHollowKills(0);
        }
        if (props.getSkill1alevel() > 8) {
        	props.setSkill1alevel(8);
        }
        if (props.getSkill1dlevel() > 8) {
        	props.setSkill1dlevel(8);
        }
        if (props.getSkill1hlevel() > 8) {
        	props.setSkill1hlevel(8);
        }
        if (props.getCurrentCap() < 50) {
            props.setCapMin();
        }
        if (props.getCurrentCap() > 10000 && props.getCapUnlocked() == false) {
            props.setCapMax();
        }
        if (props.getCurrentCap() > 25000 && props.getCapUnlocked() == true) {
        	props.setCapMaxUnlocked();
        }
        if (props.getCurrentSXP() >= 1.0) {
            props.addCap();
        }
        props.balanceTotal();
        if (props.getPoints(1) < 0) {
            props.setPoints(1, 0);
        }
        else if (props.getPoints(2) < 0) {
            props.setPoints(2, 0);
        }
        else if (props.getPoints(3) < 0) {
            props.setPoints(3, 0);
        }
        else if (props.getPoints(4) < 0) {
            props.setPoints(4, 0);
        }
        else if (props.getPoints(5) < 0) {
            props.setPoints(5, 0);
        }
        else if (props.getPoints(6) < 0) {
            props.setPoints(6, 0);
        }
        else if (props.getPoints(7) < 0) {
            props.setPoints(7, 0);
        }
        else if (props.getPoints(8) < 0) {
            props.setPoints(8, 0);
        }
    }
    
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onPlayerTick2(final TickEvent.PlayerTickEvent event) {
        final EntityPlayer player = event.player;
        final ExtendedPlayer props = (ExtendedPlayer)player.getExtendedProperties("BleachPlayer");
        if (player instanceof EntityClientPlayerMP) {
            final EntityClientPlayerMP SPPlayer = (EntityClientPlayerMP)player;
            if (this.flapCountdown > 0) {
                --this.flapCountdown;
            }
            if (!player.onGround && props.getFaction() == 3 && props.getBack() == 3) {
                if (SPPlayer.movementInput.jump && this.flapCountdown <= 0 && this.flapsLeft > 0) {
                    this.flapCountdown = 23;
                    player.motionY = 0.800000011920929;
                    --this.flapsLeft;
                }
                if (player.motionY <= -0.6 && !player.isSneaking()) {
                    player.motionY = -0.6000000238418579;
                }
                player.moveFlying(player.moveStrafing, player.moveForward, 0.02f);
            }
            if (player.isCollidedHorizontally && props.getFaction() == 3 && props.getLegs() == 3 && SPPlayer.movementInput.moveForward > 0.0f) {
                player.motionY = 0.20000000298023224;
            }
            if (props.getCurrentCap() >= 350) {
                player.stepHeight = 1.0f;
            }
            else {
                player.stepHeight = 0.5f;
            }
        }
    }
}

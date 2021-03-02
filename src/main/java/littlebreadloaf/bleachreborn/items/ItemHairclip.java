package littlebreadloaf.bleachreborn.items;

import java.util.List;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import littlebreadloaf.bleachreborn.BleachMod;
import littlebreadloaf.bleachreborn.entities.EntityEnergyArrow;
import littlebreadloaf.bleachreborn.entities.EntityHCArrow;
import littlebreadloaf.bleachreborn.events.ExtendedPlayer;
import littlebreadloaf.bleachreborn.network.PacketDispatcher;
import littlebreadloaf.bleachreborn.network.ParticleMessage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class ItemHairclip extends Item {
	
public ItemStack onItemRightClick(final ItemStack stack, final World world, final EntityPlayer player) {
		if (world.isRemote) {
			if (!player.isSneaking()) {
				ExtendedPlayer props = ExtendedPlayer.get(player);
				if (props.getFaction() == 17) {
		    		FMLNetworkHandler.openGui(player, (Object)BleachMod.instance, 13, world, (int)player.posX, (int)player.posY, (int)player.posZ);
		    	}
			}
		}
    	if (!world.isRemote) {
        	ExtendedPlayer props = ExtendedPlayer.get(player);
	    	if (player.isSneaking()) {
	    		if (props.getSelectedSkill() == 1) {
	    			final List list = world.getEntitiesWithinAABB(EntityPlayer.class, player.boundingBox.copy().expand(6.0, 6.0, 6.0));
	                for (int l = 0; l < list.size(); ++l) {
	                    final Entity entity1 = (Entity) list.get(l);
	                    if (entity1 instanceof EntityPlayer) {
	                    	if (props.getSkill1hlevel() == 1) {
	                    		((EntityLivingBase)entity1).heal(4f);
	                    		props.consumeEnergy(25);
	                    	}
	                    	else if (props.getSkill1hlevel() == 2) {
	                    		((EntityLivingBase)entity1).heal(8f);
	                    		props.consumeEnergy(30);
	                    	}
	                    	else if (props.getSkill1hlevel() == 3) {
	                    		((EntityLivingBase)entity1).heal(12f);
	                    		props.consumeEnergy(35);
	                    	}
	                    	else if (props.getSkill1hlevel() == 4) {
	                    		((EntityLivingBase)entity1).heal(16f);
	                    		props.consumeEnergy(40);
	                    	}
	                    	else if (props.getSkill1hlevel() == 5) {
	                    		((EntityLivingBase)entity1).heal(20f);
	                    		props.consumeEnergy(45);
	                    	}
	                    	else if (props.getSkill1hlevel() == 6) {
	                    		((EntityLivingBase)entity1).heal(30f);
	                    		props.consumeEnergy(60);
	                    	}
	                    	else if (props.getSkill1hlevel() == 7) {
	                    		((EntityLivingBase)entity1).heal(40f);
	                    		props.consumeEnergy(70);
	                    	}
	                    	else if (props.getSkill1hlevel() == 8) {
	                    		((EntityLivingBase)entity1).heal(60f);
	                    		props.consumeEnergy(90);
	                    	}
	                        PacketDispatcher.sendToAll((IMessage)new ParticleMessage(4, (int)entity1.posX, (int)entity1.posY, (int)entity1.posZ));
	                    }
	                }
	    		}
	    		else if (props.getSelectedSkill() == 2) {
	    			if (props.getSkill1dlevel() == 1) {
	    				player.addPotionEffect(new PotionEffect(BleachMod.defenseReject.id, 8, 0));
	    				props.consumeEnergy(20);
	    			}
	    			else if (props.getSkill1dlevel() == 2) {
	    				player.addPotionEffect(new PotionEffect(BleachMod.defenseReject.id, 12, 0));
	    				props.consumeEnergy(25);
	    			}
	    			else if (props.getSkill1dlevel() == 3) {
	    				player.addPotionEffect(new PotionEffect(BleachMod.defenseReject.id, 16, 0));
	    				props.consumeEnergy(30);
	    			}
	    			else if (props.getSkill1dlevel() == 4) {
	    				player.addPotionEffect(new PotionEffect(BleachMod.defenseReject.id, 20, 0));
	    				props.consumeEnergy(35);
	    			}
	    			else if (props.getSkill1dlevel() == 5) {
	    				player.addPotionEffect(new PotionEffect(BleachMod.defenseReject.id, 24, 0));
	    				props.consumeEnergy(40);
	    			}
	    			else if (props.getSkill1dlevel() == 6) {
	    				player.addPotionEffect(new PotionEffect(BleachMod.defenseReject.id, 28, 0));
	    				props.consumeEnergy(45);
	    			}
	    			else if (props.getSkill1dlevel() == 7) {
	    				player.addPotionEffect(new PotionEffect(BleachMod.defenseReject.id, 32, 0));
	    				props.consumeEnergy(50);
	    			}
	    			else if (props.getSkill1dlevel() == 8) {
	    				player.addPotionEffect(new PotionEffect(BleachMod.defenseReject.id, 36, 0));
	    				props.consumeEnergy(55);
	    			}

	    		}
	    		else if (props.getSelectedSkill() == 3) {
		            final EntityHCArrow entityEnergyArrow = new EntityHCArrow(world, (EntityLivingBase)player, 2.0f);
		            world.spawnEntityInWorld((Entity)entityEnergyArrow);
	                if (!world.isRemote) {
	                	if (props.getSkill1alevel() == 1) {
		    				props.consumeEnergy(90);
		    			}
		    			else if (props.getSkill1alevel() == 2) {
		    				props.consumeEnergy(80);
		    			}
		    			else if (props.getSkill1alevel() == 3) {
		    				props.consumeEnergy(70);
		    			}
		    			else if (props.getSkill1alevel() == 4) {
		    				props.consumeEnergy(60);
		    			}
		    			else if (props.getSkill1alevel() == 5) {
		    				props.consumeEnergy(50);
		    			}
		    			else if (props.getSkill1alevel() == 6) {
		    				props.consumeEnergy(40);
		    			}
		    			else if (props.getSkill1alevel() == 7) {
		    				props.consumeEnergy(30);
		    			}
		    			else if (props.getSkill1alevel() == 8) {
		    				props.consumeEnergy(20);
		    			}
	                }
	    		}
	    	}
	    	else {
		    	if (props.getFaction() == 6) {
		    		props.setFaction(17);
		    	}
		    	if (props.getFaction() == 17) {
		    		FMLNetworkHandler.openGui(player, (Object)BleachMod.instance, 13, world, (int)player.posX, (int)player.posY, (int)player.posZ);
		    	}
	    	}
    	}
		return stack;
    	
    }

}

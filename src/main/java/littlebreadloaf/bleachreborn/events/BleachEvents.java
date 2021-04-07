package littlebreadloaf.bleachreborn.events;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import littlebreadloaf.bleachreborn.BleachMod;
import littlebreadloaf.bleachreborn.ConfigHandler;
import littlebreadloaf.bleachreborn.api.Tools;
import littlebreadloaf.bleachreborn.armor.Armor;
import littlebreadloaf.bleachreborn.blocks.BleachBlocks;
import littlebreadloaf.bleachreborn.entities.EntityAizen;
import littlebreadloaf.bleachreborn.entities.EntityCero;
import littlebreadloaf.bleachreborn.entities.EntityDecoy;
import littlebreadloaf.bleachreborn.entities.EntityFisher;
import littlebreadloaf.bleachreborn.entities.EntityGigai;
import littlebreadloaf.bleachreborn.entities.EntityGigaiWeak;
import littlebreadloaf.bleachreborn.entities.EntityHollowBat;
import littlebreadloaf.bleachreborn.entities.EntityHollowBlaze;
import littlebreadloaf.bleachreborn.entities.EntityHollowGolem;
import littlebreadloaf.bleachreborn.entities.EntityHollowOre;
import littlebreadloaf.bleachreborn.entities.EntityHollowSnake;
import littlebreadloaf.bleachreborn.entities.EntityHollowSpider;
import littlebreadloaf.bleachreborn.entities.EntityHollowStalker;
import littlebreadloaf.bleachreborn.entities.EntityHollowWasp;
import littlebreadloaf.bleachreborn.entities.EntityHollowWolf;
import littlebreadloaf.bleachreborn.entities.EntityInnerSpirit;
import littlebreadloaf.bleachreborn.entities.EntityMenosGrande;
import littlebreadloaf.bleachreborn.entities.EntityWhole;
import littlebreadloaf.bleachreborn.items.BleachItems;
import littlebreadloaf.bleachreborn.items.ItemDiablo;
import littlebreadloaf.bleachreborn.items.ItemSeeleschneider;
import littlebreadloaf.bleachreborn.items.bankai.BankaiNormal;
import littlebreadloaf.bleachreborn.items.bankai.ItemBankai;
import littlebreadloaf.bleachreborn.items.shikai.ItemShikai;
import littlebreadloaf.bleachreborn.items.shikai.ShikaiNormal;
import littlebreadloaf.bleachreborn.network.CeroMessage;
import littlebreadloaf.bleachreborn.network.FlashMessage;
import littlebreadloaf.bleachreborn.network.PacketDispatcher;
import littlebreadloaf.bleachreborn.network.ParticleMessage;
import littlebreadloaf.bleachreborn.network.RetreiveHollowMessage;
import littlebreadloaf.bleachreborn.network.ServerSyncMessage;
import littlebreadloaf.bleachreborn.proxies.CommonProxy;
import littlebreadloaf.bleachreborn.tiles.TileSeeleSchneider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;

public class BleachEvents
{
    public static CommonProxy proxy;
    Random rand;
    EntityPlayer myPlayer;
    private int replenishTimer;
    private int soundTimer;
    private int pressureTimer;
    public static int bankaiTimer;
    private int mediTimer;
    private int meditimer;
    private int pressTimer;
    private int hollowTimer;
    public static int chainTimer;
    static int biteTimer;
    public static UUID spiritSpeedModifierUUID;
    public static AttributeModifier spiritSpeedModifier;
    
    public BleachEvents() {
        this.rand = new Random();
        this.myPlayer = null;
        this.replenishTimer = 40;
        this.soundTimer = 150;
        this.pressureTimer = 80;
        BleachEvents.bankaiTimer = 100;
        this.mediTimer = 20;
        this.meditimer = 100;
        this.pressTimer = 1800;
        BleachEvents.biteTimer = 750;
        this.hollowTimer = 36000;
        this.chainTimer = 20;
    }
    
    @SubscribeEvent
    public void onEntityConstructing(final EntityEvent.EntityConstructing event) {
        if (event.entity instanceof EntityPlayer && event.entity.getExtendedProperties("BleachPlayer") == null) {
            this.myPlayer = (EntityPlayer)event.entity;
            ExtendedPlayer.register((EntityPlayer)event.entity);
        }
    }
    
    @SubscribeEvent
	public void onClonePlayer(PlayerEvent.Clone event) {
		ExtendedPlayer.get(event.entityPlayer).copy(ExtendedPlayer.get(event.original));
	}
  
    @SubscribeEvent
    public void onEntityJoinWorld(final EntityJoinWorldEvent event) {
        if (event.entity instanceof EntityPlayer) {
            final EntityPlayer player = (EntityPlayer)event.entity;
            final ExtendedPlayer props = ExtendedPlayer.get(player);
            if (!event.world.isRemote) {
                ExtendedPlayer.loadProxyData(player);
                if (!props.getGift() && !player.inventory.hasItem(BleachItems.servergift)) {
                    // player.inventory.addItemStackToInventory(new ItemStack(BleachItems.servergift, 1));
                  //  props.setGift(false);
                } 
    
                if (props.getDeathPotion() == 1) {
    				player.addPotionEffect(new PotionEffect(BleachMod.soulDisconnect.id, 999999999, 0));
    				props.setDeathPotion(0);
        		}
            } else {
                PacketDispatcher.sendToServer(new RetreiveHollowMessage(ConfigHandler.renderHollow, player.getUniqueID()));
            }
            if (props.getFaction() == 0 && !player.worldObj.isRemote && !player.inventory.hasItem(BleachItems.factionSelect)) {
                player.inventory.addItemStackToInventory(new ItemStack(BleachItems.factionSelect, 1));
                props.replenishEnergy(1);
                if (props.getZTex() == 5) {
                    props.randomTexture();
                }
            }
        }
        if (event.entity instanceof EntityWhole || event.entity instanceof EntityDecoy) {
            event.entity.setCurrentItemOrArmor(2, new ItemStack(Armor.SoulChain, 1));
        }
        if (event.entity instanceof EntityMenosGrande) {
            final EntityMenosGrande grande = (EntityMenosGrande)event.entity;
            if (grande.worldObj.checkNoEntityCollision(grande.boundingBox) && grande.worldObj.getCollidingBoundingBoxes((Entity)grande, grande.boundingBox).isEmpty()) {
                grande.setPositionAndUpdate(grande.posX, 40.0, grande.posZ);
            }
        }
    }
    
    @SubscribeEvent
    public void onLivingDeathEvent(final LivingDeathEvent event) {
        if (event.entity instanceof EntityPlayer) {
            final EntityPlayer player = (EntityPlayer)event.entity;
            ExtendedPlayer props = ExtendedPlayer.get(player);
            World world = player.worldObj;
            if (player.isPotionActive(BleachMod.soulDisconnect.id) && !event.entity.worldObj.isRemote) {
            	props.setDeathPotion(1);
            }
            if (!event.entity.worldObj.isRemote) {
                ExtendedPlayer.saveProxyData(player);
            }
            if (event.source.getEntity() instanceof EntityPlayer) {
            	EntityPlayer attacker = (EntityPlayer) event.source.getEntity();
            	ExtendedPlayer aprops = ExtendedPlayer.get(attacker);
            	if (aprops.getFaction() == 1 && aprops.getCurrentCap() >= 25000) {
            		if (player.getCurrentEquippedItem().getItem() != null && player.getCurrentEquippedItem().getItem() == BleachItems.shinai && props.getFaction() == 3) {
                        PacketDispatcher.sendToServer((IMessage)new FlashMessage(14));
            			player.addChatComponentMessage(new ChatComponentText("You have been converted into a human, thanks to the help of a shinigami."));
            		}
            	}
            }
            if (player.isPotionActive(BleachMod.soulDisconnect.id) && !event.entity.worldObj.isRemote) {
            	if (props.getFaction() == 6 && event.source.getEntity() instanceof EntityFisher || event.source.getEntity() instanceof EntityHollowBat || event.source.getEntity() instanceof EntityHollowBlaze || event.source.getEntity() instanceof EntityHollowGolem || event.source.getEntity() instanceof EntityHollowOre || event.source.getEntity() instanceof EntityHollowSnake || event.source.getEntity() instanceof EntityHollowSpider || event.source.getEntity() instanceof EntityHollowStalker || event.source.getEntity() instanceof EntityHollowWasp || event.source.getEntity() instanceof EntityHollowWolf || event.source.getEntity() instanceof EntityMenosGrande) {
            		Random rand = new Random();
            		if (props.getCurrentCap() >= 150 && props.getCurrentCap() <= 1000) {
            			if (rand.nextInt(100) < 40) {
                            PacketDispatcher.sendToServer((IMessage)new FlashMessage(31));
            			}
            		}
            		if (props.getCurrentCap() >= 1005 && props.getCurrentCap() <= 2000) {
            			if (rand.nextInt(100) < 35) {
                            PacketDispatcher.sendToServer((IMessage)new FlashMessage(31));
            			}
            		}
            		if (props.getCurrentCap() >= 2005 && props.getCurrentCap() <= 3000) {
            			if (rand.nextInt(100) < 30) {
                            PacketDispatcher.sendToServer((IMessage)new FlashMessage(31));
            			}
            		}
            		if (props.getCurrentCap() >= 3005 && props.getCurrentCap() <= 4000) {
            			if (rand.nextInt(100) < 25) {
                            PacketDispatcher.sendToServer((IMessage)new FlashMessage(31));
            			}
            		}
            		if (props.getCurrentCap() >= 4005 && props.getCurrentCap() <= 5000) {
            			if (rand.nextInt(100) < 20) {
                            PacketDispatcher.sendToServer((IMessage)new FlashMessage(31));
            			}
            		}
            		if (props.getCurrentCap() >= 5005 && props.getCurrentCap() <= 6000) {
            			if (rand.nextInt(100) < 15) {
                            PacketDispatcher.sendToServer((IMessage)new FlashMessage(31));
            			}
            		}
            		if (props.getCurrentCap() >= 6005 && props.getCurrentCap() <= 7000) {
            			if (rand.nextInt(100) < 10) {
                            PacketDispatcher.sendToServer((IMessage)new FlashMessage(31));
            			}
            		}
            		if (props.getCurrentCap() >= 7005) {
            			if (rand.nextInt(100) < 5) {
                            PacketDispatcher.sendToServer((IMessage)new FlashMessage(31));
            			}
            		}
            	}
            }
        }
        else if (event.source.getEntity() instanceof EntityPlayer) {
            final EntityPlayer player = (EntityPlayer)event.source.getEntity();
            final ExtendedPlayer props = ExtendedPlayer.get(player);
            if (!event.entity.worldObj.isRemote && (event.entity instanceof EntityHollowBat || event.entity instanceof EntityHollowBlaze || event.entity instanceof EntityHollowGolem || event.entity instanceof EntityHollowOre || event.entity instanceof EntityHollowSnake || event.entity instanceof EntityHollowSpider || event.entity instanceof EntityHollowStalker || event.entity instanceof EntityHollowWasp || event.entity instanceof EntityHollowWolf || event.entity instanceof EntityMenosGrande || event.entity instanceof EntityFisher)) {
                props.setHollowKills(props.getHollowKills() + 1);
                props.setKillCounter(props.getKillCounter() + 1);
                props.setSkillCounter(props.getSkillCounter() + 1);
            }
        }
        else if (event.source.damageType.equals(DamageSource.generic.toString())) {
            final Entity ent = event.entity;
            final List players = ent.worldObj.getEntitiesWithinAABB((Class)EntityPlayer.class, AxisAlignedBB.getBoundingBox(ent.posX - 6.0, ent.posY - 6.0, ent.posZ - 6.0, ent.posX + 6.0, ent.posY + 6.0, ent.posZ + 6.0));
            for (int i = 0; i < players.size(); ++i) {
                final EntityLivingBase entity = (EntityLivingBase) players.get(i);
                final ExtendedPlayer props2 = ExtendedPlayer.get((EntityPlayer)entity);
                if (entity != null && entity instanceof EntityPlayer && entity != ent) {
                    props2.setHollowKills(props2.getHollowKills() + 1);
                }
            }
        }
    }
    
    @SubscribeEvent
    public void onLivingUpdateEvent(final LivingEvent.LivingUpdateEvent event) {
        if (!event.entity.worldObj.isRemote) {
            if (this.isEntityInCube(event.entity)) {
                FMLLog.info("[Bleach mod] event", new Object[0]);
                event.entity.motionX = 0.0;
                event.entity.motionZ = 0.0;
                if (event.entity.motionY > 0.0) {
                    event.entity.motionY = 0.0;
                }
            }
            if (event.entityLiving instanceof EntityPlayer) {
                final EntityPlayer player = (EntityPlayer)event.entityLiving;
                final ExtendedPlayer props = ExtendedPlayer.get(player);
                final ItemStack var10 = player.getEquipmentInSlot(2);
                --this.replenishTimer;
                --this.soundTimer;
                --this.pressureTimer;
                --BleachEvents.bankaiTimer;
                --this.meditimer;
                --this.mediTimer;
                --this.pressTimer;
                -- this.chainTimer;
                --BleachEvents.biteTimer;
                if (props.getCeroCharge() > 0) {
                    props.addCeroCharge(1);
                    if (props.getCeroCharge() >= 40) {
                        props.setCeroCharge(0);
                        final EntityCero entityCero = new EntityCero(player.worldObj, (EntityLivingBase)player, 2.0f);
                        if (!player.worldObj.isRemote) {
                            player.worldObj.spawnEntityInWorld((Entity)entityCero);
                            PacketDispatcher.sendToServer((IMessage)new CeroMessage(2));
                        }
                    }
                }  
        	      if (props.getFaction() == 3 || props.getFaction() == 7 || props.getFaction() == 8) {
        	          if (props.getCurrentCap() <= 10000) {
        	            	if (props.getCurrentCap() % 50 == 0) {
        	            			props.addCurrentHPoints(1);
        	            		}
        	            	}
        	        	}
                if (player.isSprinting()) {
                    final IAttributeInstance movement = player.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
                    if (movement.getModifier(BleachEvents.spiritSpeedModifierUUID) != null) {
                        movement.removeModifier(BleachEvents.spiritSpeedModifier);
                    }
                    final float timesFaster = (float)((float)props.getCurrentCap() * 2.1E-5);
                    movement.applyModifier(BleachEvents.spiritSpeedModifier = new AttributeModifier(BleachEvents.spiritSpeedModifierUUID, "Spirit Enhanced Speed", (double)timesFaster, 0));
                }
                else {
                    final IAttributeInstance movement = player.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
                    if (movement.getModifier(BleachEvents.spiritSpeedModifierUUID) != null) {
                        movement.removeModifier(BleachEvents.spiritSpeedModifier);
                    }
                }
                if (this.replenishTimer <= 0) {
                    props.replenishEnergy((int)(5.0 * (1.0 + 0.002 * props.getCurrentCap())));
                    PacketDispatcher.sendToAll((IMessage)new ServerSyncMessage(player));
                    this.replenishTimer = 40;
                }
                if (props.getKillCounter() == 10) {
                	props.setKillCounter(0);
                	props.setSubPoints(props.getSubPoints() + 2);
                }
                if (props.getSkillCounter() == 10) {
                	props.setSkillCounter(0);
                	props.setKidoPoints(props.getKidoPoints() + 2);
                }
                if (props.getCurrentEnergy() <= 0.0f && props.getPressure()) {
                    props.setPressure(false);
                    player.addChatComponentMessage((IChatComponent)new ChatComponentText("De-Activated Spiritual Pressure."));
                }
                if (this.pressureTimer <= 0 && props.getPressure()) {
                    props.consumeEnergy((int)(0.01 * props.getCurrentCap()));
                    this.pressureTimer = 80;
                }
                if (event.entityLiving.isPotionActive(BleachMod.spiritpressure)) {
                    props.setAffected(true);
                    if (this.soundTimer <= 0) {
                        player.worldObj.playSoundAtEntity((Entity)event.entityLiving, "bleachreborn:pressure", 0.2f, 1.0f);
                        this.soundTimer = 150;
                    }
                }
                else if (!event.entityLiving.isPotionActive(BleachMod.spiritpressure)) {
                    props.setAffected(false);
                }
                if (BleachEvents.bankaiTimer <= 0 && !props.getReady() && player.getHeldItem() != null && player.getHeldItem().getItem() instanceof ItemShikai) {
                    props.setReady(true);
                }
                if (this.mediTimer <= 0 && props.getMeditation() && props.getMediCount() <= 1799) {
                    props.setMediCount(props.getMediCount() + 1);
                    this.mediTimer = 20;
                }
                if (!props.getSpiritSpawn() && !props.getBankaiUnlock() && props.getMeditation() && props.getCurrentCap() >= 2500 && props.getMediCount() >= 1800 && props.getHollowKills() >= 1000 && (props.getFaction() == 1 || props.getFaction() == 5)) {
                    final EntityInnerSpirit spirit = new EntityInnerSpirit(player.worldObj);
                    spirit.setLocationAndAngles(player.posX + 1.0, player.posY + 1.0, player.posZ + 1.0, 0.0f, 0.0f);
                    player.worldObj.spawnEntityInWorld((Entity)spirit);
                    props.setSpiritSpawn(true);
                }
                if (props.getMeditation() && this.meditimer <= 0) {
                    player.worldObj.playSoundAtEntity((Entity)player, "bleachreborn:meditation", 0.2f, 1.0f);
                    this.meditimer = 100;
                }
                if (props.getFaction() == 11) {
                    props.setXpRate(1);
                }
                if (props.getCurrentEnergy() <= 0.0f) {
                    props.setSanreiBroken(false);
                }
                if (props.getAffected() && this.pressTimer <= 0) {
                    player.removePotionEffect(BleachMod.spiritpressure.id);
                    player.removePotionEffect(Potion.weakness.id);
                    player.removePotionEffect(Potion.moveSlowdown.id);
                    this.pressTimer = 1800;
                }
                if (props.getFaction() == 3 && props.getHollowKills() >= 300) {
                    props.setFaction(7);
                    player.worldObj.playSoundAtEntity((Entity)player, "bleachreborn:hollowscream", 0.5f, 1.0f);
                }
                if ((props.getFaction() == 7 || props.getFaction() == 8) && this.hollowTimer <= 0) {
                    props.setHollowKills(props.getHollowKills() - 1);
                }
                if (props.getFaction() == 7 && props.getHollowKills() >= 800) {
                    props.setFaction(8);
                    player.worldObj.playSoundAtEntity((Entity)player, "bleachreborn:hollowscream", 0.5f, 1.0f);
                }
                if (props.getFaction() == 8 && props.getHollowKills() <= 0) {
                    props.setFaction(7);
                }
                if (props.getFaction() == 8) {
                    player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 200000000, 2, true));
                }
                if (props.getFaction() == 8 && props.getChainCount() >= 72000 && props.getHollowKills() >= 2000) {
                    props.setFaction(10);
                    player.worldObj.createExplosion((Entity)player, player.posX, player.posY, player.posZ, 0.0f, false);
                    player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.DARK_RED + "You have successfully evolved into a vasto lorde."));
                }
                if (props.getCurrentCap() >= 1100) {
                    player.capabilities.allowFlying = true;
                    player.sendPlayerAbilities();
                }
                if (props.getCurrentCap() >= 150 && props.getFaction() == 6 && props.getSubType() == 3 && props.getSubUnlocked() == true) {
                	props.setFaction(3);
                	player.addChatComponentMessage(new ChatComponentText("You have been converted into a hollow."));
                }
                if (event.entityLiving instanceof EntityAizen) {
                	EntityAizen aizen = (EntityAizen) event.entityLiving;
                	if (aizen.isPotionActive(Potion.blindness.id)) {
                		aizen.removePotionEffect(Potion.blindness.id);
                	}
                }
                if (event.entityLiving instanceof EntityPlayer) {
                	if (event.entityLiving.isPotionActive(BleachMod.bleeding)) {
	                	event.entityLiving.attackEntityFrom(DamageSource.generic, (float) ((props.getCurrentCap() / 100.0) + 3.0));
	                }
                }
            }
            if (event.entityLiving instanceof EntityLivingBase) {
            	if (!(event.entityLiving instanceof EntityPlayer)) {
	            	if (event.entityLiving.isPotionActive(BleachMod.bleeding)) {
	                	event.entityLiving.attackEntityFrom(DamageSource.generic, (float) (1.0));
	                }
            	}
            }
        }
    }
    
    @SubscribeEvent
    public void onLivingJumpEvent(final LivingEvent.LivingJumpEvent event) {
        if (event.entityLiving instanceof EntityPlayer) {
            final EntityPlayer player = (EntityPlayer)event.entityLiving;
            final ExtendedPlayer props = (ExtendedPlayer)player.getExtendedProperties("BleachPlayer");
            final EntityLivingBase entityLiving = event.entityLiving;
            if (player.isSprinting()) {
                if (props.getCurrentCap() <= 1000) {
                    final EntityLivingBase entityLivingBase3;
                    final EntityLivingBase entityLivingBase = entityLivingBase3 = entityLiving;
                    entityLivingBase3.motionY += (float)props.getCurrentCap() * (6.0E-4 * props.getCurrentEnergy());                  
                                         
                }
                else if (props.getCurrentCap() >= 1001) {
                    final EntityLivingBase entityLivingBase4;
                    final EntityLivingBase entityLivingBase2 = entityLivingBase4 = entityLiving;
                    entityLivingBase4.motionY += (float)props.getCurrentCap() * (4.0E-5 * props.getCurrentEnergy());                  
                    
                	}
                }
            }
        }
    
    
    @SubscribeEvent
    public void onDisconnectEvent(cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedOutEvent event) {
    	if (event.player instanceof EntityPlayer) {
    		EntityPlayer player = event.player;
    		ExtendedPlayer props = ExtendedPlayer.get(player);
    		World world = player.worldObj;
    		for (int i = 0; i < world.loadedEntityList.size(); ++i) {
                final Entity currentEntity = (Entity) world.loadedEntityList.get(i);
                if (currentEntity.getUniqueID().toString().equalsIgnoreCase(props.getBodyID())) {
                    currentEntity.setDead();
                }
			}
    	}
    }
    
    @SubscribeEvent
    public void onLivingFallEvent(final LivingFallEvent event) {
        if (event.entityLiving instanceof EntityPlayer) {
            final EntityPlayer player = (EntityPlayer)event.entityLiving;
            final ExtendedPlayer props = (ExtendedPlayer)player.getExtendedProperties("BleachPlayer");
            event.distance -= (float)((float)props.getCurrentCap() * (0.02 * props.getCurrentEnergy()));
            if ((props.getFaction() == 3 || props.getFaction() == 7 || props.getFaction() == 8) && props.getBack() == 3) {
                event.setCanceled(true);
            }
            if ((props.getFaction() == 3 || props.getFaction() == 7 || props.getFaction() == 8) && props.getLegs() == 3 && player.isCollidedHorizontally) {
                event.setCanceled(true);
            }
            if (props.getCurrentCap() >= 300) {
                event.setCanceled(true);
            }
        }
    }
    
    @SubscribeEvent
    public void onItemPickup(final EntityItemPickupEvent event) {
        if (event.item.getEntityItem().getItem().equals(BleachItems.heart) && event.entityPlayer != null) {
            event.entityPlayer.heal(8.0f);
            for (int i = 0; i < 5; ++i) {
                PacketDispatcher.sendToAll((IMessage)new ParticleMessage(4, (int)event.entityPlayer.posX, (int)event.entityPlayer.posY, (int)event.entityPlayer.posZ));
            }
            event.item.setDead();
            event.setCanceled(true);
        }
    }
    
    @SubscribeEvent
    public void onLivingHurtEvent(final LivingHurtEvent event) {

        if (event.source.getEntity() != null && event.source.getEntity() instanceof EntityPlayer) {
            final EntityPlayer thePlayer = (EntityPlayer)event.source.getEntity();
            final ExtendedPlayer props = ExtendedPlayer.get(thePlayer);
            if ((props.getFaction() == 3 || props.getFaction() == 7 || props.getFaction() == 8) && props.getArms() == 1) {
                double moveX = event.entity.posX - thePlayer.posX;
                double moveZ = event.entity.posZ - thePlayer.posZ;
                final double angle = Math.atan2(moveZ, moveX);
                moveX = Math.cos(angle);
                moveZ = Math.sin(angle);
                double moveY = 0.5;
                event.entity.addVelocity(moveX, moveY, moveZ);
            }
            if(props.getFaction() == 12) {
                event.entityLiving.setHealth(event.entityLiving.getHealth() - 5);
            }
            
        }
        if (event.entityLiving instanceof EntityPlayer) {
            final EntityPlayer player = (EntityPlayer)event.entityLiving;
            final ExtendedPlayer props = ExtendedPlayer.get(player);
            final ItemStack heldItem = player.getCurrentEquippedItem();
            if (heldItem != null && heldItem.getItem() == BleachItems.shikaipoison && event.source.getEntity() instanceof EntityLivingBase) {
                final EntityLivingBase var12 = (EntityLivingBase)event.source.getEntity();
                var12.addPotionEffect(new PotionEffect(Potion.poison.id, 80, 0));
            }
            if ((props.getFaction() == 3 || props.getFaction() == 7 || props.getFaction() == 8) && event.source.getEntity() instanceof EntityLivingBase) {
                final EntityLivingBase hurter = (EntityLivingBase)event.source.getEntity();
                if (props.getBack() == 2) {
                    hurter.attackEntityFrom(DamageSource.generic, 0.5f);
                }
            }
            if (event.source.getEntity() instanceof EntityPlayer) {
                final EntityPlayer hurter = (EntityPlayer)event.source.getEntity();
            	ExtendedPlayer props2 = ExtendedPlayer.get((EntityPlayer) hurter);
            	if (props.getCurrentCap() > props2.getCurrentCap()) {
            		if (props.getCurrentCap() - props2.getCurrentCap() >= 100) {
            			event.ammount *= 0.75f;
            		}
            	}
            	switch(props2.getFaction()) {
                    case 4: event.ammount *= 1.10;break;
                    case 12: event.ammount *= 1.20;break;
                    case 13: event.ammount *= 1.15;break;
                    default: break;
                }
            	if (player.isPotionActive(BleachMod.soulDisconnectPotionID)) {
            		event.ammount = 0;
            	}
            	if (props.getPressure()) {
            		props.consumeEnergy((int) event.ammount * 2);
            		event.ammount = 0;
            	}
            }
        }
        if (event.entityLiving instanceof EntityHollowOre && event.source.equals(DamageSource.inWall)) {
            event.setCanceled(true);
        }
        if (event.source.getEntity() instanceof EntityPlayer) {
        	EntityPlayer player = (EntityPlayer) event.source.getEntity();
	        if (event.entityLiving instanceof EntityAizen) {
	        	EntityAizen aizen = (EntityAizen) event.entityLiving;
	        	aizen.setPositionAndUpdate(player.posX, player.posY, player.posZ);
	        }
	        if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == BleachItems.diablo) {
	        	ExtendedPlayer props = ExtendedPlayer.get(player);
	        	if (props.getFaction() == 16) {
		        	if (event.entity instanceof EntityPlayer) {
		        		EntityPlayer target = (EntityPlayer) event.entity;
	                    target.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 60, 1));
	                    target.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 60, 2));
	                    player.addPotionEffect(new PotionEffect(Potion.resistance.id, 100, 2));
		        	}
	        	}
	        }
        }
        if (event.entityLiving != null && event.source.getEntity() instanceof Entity) {
        	if (event.entityLiving instanceof EntityPlayer) {
        		EntityPlayer player = (EntityPlayer) event.entityLiving;
        		if (player.isPotionActive(BleachMod.defenseRejectPotionID)) {
        			event.ammount = event.ammount / 2;
        		}
        	}
        }
        if (event.entityLiving != null && event.source.getEntity() instanceof EntityPlayer) {
            final ExtendedPlayer props2 = ExtendedPlayer.get((EntityPlayer)event.source.getEntity());
            if ((props2.getFaction() == 3 || props2.getFaction() == 7 || props2.getFaction() == 8 || props2.getFaction() == 12) && ((EntityPlayer)event.source.getEntity()).getHeldItem() == null) {
                final EntityLivingBase var13 = event.entityLiving;
                if (var13.getCreatureAttribute() == Tools.SPIRIT) {
                    props2.addSXP(5 + (5 * props2.getXpRate()));
                }
                else if (this.rand.nextInt(4) == 0) {
                    props2.addSXP(2 + (2 * props2.getXpRate()));
                }
                int extraAmount = (int)(props2.getCurrentEnergy() * props2.getCurrentCap() / 50.0f) + 10;
                int extraAmount1 = (int)(props2.getCurrentEnergy() * props2.getCurrentCap() / 38.0f) + 15;
                int extraAmount2 = (int)(props2.getCurrentEnergy() * props2.getCurrentCap() / 25.0f) + 29;
                int extraAmount3 = (int)(props2.getCurrentEnergy() * props2.getCurrentCap() / 12.0f) + 29;

                if (props2.getArms() == 1) {
                    extraAmount += 2;
                }
                if (props2.getFaction() == 3) {
                    var13.attackEntityFrom(DamageSource.generic, (extraAmount));
                }
                if (props2.getFaction() == 7) {
                    var13.attackEntityFrom(DamageSource.generic, (extraAmount1));
                }
                if (props2.getFaction() == 8) {
                    var13.attackEntityFrom(DamageSource.generic, (extraAmount2));
                }
                if (props2.getFaction() == 12) {
                    var13.attackEntityFrom(DamageSource.generic, (extraAmount3));
                }
                if (props2.getTail() == 3) {
                    var13.addPotionEffect(new PotionEffect(Potion.poison.id, 80, 0));
                }
                if (props2.getTail() == 3) {}
            }
            else if ((props2.getFaction() == 6) && ((EntityPlayer)event.source.getEntity()).getHeldItem().getItem() instanceof ItemSword) {
                final EntityLivingBase var13 = event.entityLiving;
            	if (var13.getCreatureAttribute() == Tools.SPIRIT) {
                    props2.addSXP(5 + (5 * props2.getXpRate()));
                }
                else if (this.rand.nextInt(4) == 0) {
                    props2.addSXP(2 + (2 * props2.getXpRate()));
                }
            }
            else if ((props2.getFaction() == 16) && ((EntityPlayer)event.source.getEntity()).getHeldItem().getItem() instanceof ItemDiablo) {
                final EntityLivingBase var13 = event.entityLiving;
            	if (var13.getCreatureAttribute() == Tools.SPIRIT) {
                    props2.addSXP(5 + (5 * props2.getXpRate()));
                }
                else if (this.rand.nextInt(4) == 0) {
                    props2.addSXP(2 + (2 * props2.getXpRate()));
                }
            }

        }
        assert event.entityLiving != null;
        if (!event.entityLiving.worldObj.isRemote) {
            final EntityLivingBase attackedEnt = event.entityLiving;
            final DamageSource attackSource = event.source;
            if (event.source.getEntity() instanceof EntityPlayer) {
                final EntityPlayer plr = (EntityPlayer)event.source.getEntity();
                final ExtendedPlayer props3 = ExtendedPlayer.get(plr);
                if ((props3.getFaction() == 1 || props3.getFaction() == 2) && plr.getHeldItem() != null) {
                    if (plr.getHeldItem().getItem().equals(BleachItems.zanpakuto)) {
                        event.ammount = ((props3.getCurrentCap() / 50)) + 10;
                    }
                    if (plr.getHeldItem().getItem() instanceof ItemShikai) {
                        event.ammount = ((props3.getCurrentCap() / 30)) + 25;
                    }
                    if (plr.getHeldItem().getItem() instanceof ItemBankai) {
                        event.ammount = ((props3.getCurrentCap() / 15)) + 40;
                    }
                    if (plr.getHeldItem().getItem() instanceof ItemSeeleschneider) {
                        event.ammount = ((props3.getCurrentCap() / 40)) + 10;
                    }
                    if (plr.getHeldItem().getItem() instanceof ShikaiNormal || plr.getHeldItem().getItem() instanceof BankaiNormal) {
                        attackedEnt.addPotionEffect(new PotionEffect(BleachMod.bleeding.id, 50, 0));
                    }
                }
                switch(props3.getFaction()) {
                case 4:
                	if (plr.getHeldItem() !=null) {
	                	if (plr.getHeldItem().getItem().equals(BleachItems.zanpakuto)) {
	                        event.ammount = ((props3.getCurrentCap() / 3.85f)) + 5;
	                    }   
                	}
                	break;
                case 5:
                	if (plr.getHeldItem() !=null) {
	                	if (plr.getHeldItem().getItem().equals(BleachItems.zanpakuto)) {
	                        event.ammount = ((props3.getCurrentCap() / 28)) + 10;
	                    }
	                	else if (plr.getHeldItem().getItem() instanceof ItemShikai) {
	                        event.ammount = ((props3.getCurrentCap() / 16)) + 20;
	                    }
	                	else if (plr.getHeldItem().getItem() instanceof ItemBankai) {
	                        event.ammount = ((props3.getCurrentCap() / 8)) + 20;
	                    }
                	}
                	break;
                case 11:
                	if (plr.getHeldItem() !=null) {
	                	if (plr.getHeldItem().getItem().equals(BleachItems.zanpakuto)) {
	                        event.ammount = ((props3.getCurrentCap() / 10f)) + 20;
	                    }
                	}
                	break;
                case 16:
                	if (plr.getHeldItem() !=null) {
	                	if (plr.getHeldItem().getItem().equals(BleachItems.diablo)) {
	                        event.ammount = ((props3.getCurrentCap() / 13f)) + 20;
	                    }
                	}
                	break;
                case 6:
                	if (plr.getHeldItem() !=null) {
	                	if (plr.getHeldItem().getItem() instanceof ItemSword) {
	                        event.ammount = ((props3.getCurrentCap() / 28)) + 10;
	                    }
                	}
                	break;
                }
            }
        }
    }
    
    @SubscribeEvent
    public void onEntityInteractEvent(final EntityInteractEvent event) {
        if (event.entityPlayer != null) {
            final ExtendedPlayer props = (ExtendedPlayer)event.entityPlayer.getExtendedProperties("BleachPlayer");
            if (event.entityPlayer.getCurrentEquippedItem() != null && event.entityPlayer.getCurrentEquippedItem().getItem() == BleachItems.shikaiheal && event.target instanceof EntityLiving) {
                final EntityLiving theTarget = (EntityLiving)event.target;
                if (theTarget.getCreatureAttribute() != EnumCreatureAttribute.UNDEAD && theTarget.getHealth() < theTarget.getMaxHealth()) {
                    theTarget.heal(2.0f);
                    for (int i = 0; i < 5; ++i) {
                        PacketDispatcher.sendToAll((IMessage)new ParticleMessage(4, (int)theTarget.posX, (int)theTarget.posY, (int)theTarget.posZ));
                    }
                    if (!event.entityPlayer.worldObj.isRemote) {
                        props.consumeEnergy(5);
                    }
                }
            }
            if (event.entityPlayer.getCurrentEquippedItem() != null && event.entityPlayer.getCurrentEquippedItem().getItem() == BleachItems.gauntlet && event.target instanceof EntityPlayer && !event.entityPlayer.worldObj.isRemote) {
                final EntityPlayer theTarget = (EntityPlayer)event.target;
                ExtendedPlayer props2 = ExtendedPlayer.get(theTarget);
                if (!theTarget.isPotionActive(BleachMod.soulDisconnect.id)) {
    				theTarget.addPotionEffect(new PotionEffect(BleachMod.soulDisconnect.id, 999999999, 0));
    				EntityGigaiWeak gigai = new EntityGigaiWeak(theTarget.worldObj);
    				gigai.setLocationAndAngles(theTarget.posX, theTarget.posY, theTarget.posZ, 0f, 0f);
    				gigai.func_152115_b(theTarget.getUniqueID().toString());
    				gigai.setTamed(true);
    				theTarget.worldObj.spawnEntityInWorld(gigai);
    				theTarget.setInvisible(true);
    				props2.setBodyID(gigai.getUniqueID().toString());
    			}
            }
            if (event.entityPlayer.getCurrentEquippedItem() != null && event.entityPlayer.getCurrentEquippedItem().getItem() == BleachItems.zanpakuto && event.target instanceof EntityGigai && !event.entityPlayer.worldObj.isRemote) {
                final EntityGigai target = (EntityGigai)event.target;
                EntityPlayer player = (EntityPlayer) target.getOwner();
                ExtendedPlayer props2 = ExtendedPlayer.get(player);
                if (player.isPotionActive(BleachMod.soulDisconnect.id)) {
                	if (!player.inventory.hasItem(BleachItems.control)) {
                		if (props2.getBodyID().equals(target.getUniqueID().toString())) {
                			player.inventory.addItemStackToInventory(new ItemStack(BleachItems.control));
                			player.inventoryContainer.detectAndSendChanges();
                		}
                	}
    			}
            }
            if (event.entityPlayer.getCurrentEquippedItem() != null && event.entityPlayer.getCurrentEquippedItem().getItem() == BleachItems.zanpakuto && event.target instanceof EntityPlayer && !event.entityPlayer.worldObj.isRemote) {
            	EntityPlayer player = event.entityPlayer;
            	EntityPlayer target = (EntityPlayer) event.target;
            	ExtendedPlayer plr = ExtendedPlayer.get(player);
            	ExtendedPlayer targ = ExtendedPlayer.get(target);
            	if (plr.getCurrentCap() >= 1000 && targ.getCurrentCap() >= 250 && plr.getFaction() == 1 && targ.getFaction() == 6 && target.getCurrentEquippedItem() != null && target.getCurrentEquippedItem().getItem() == BleachItems.zanpakuto && targ.getSubUnlocked() == false) {
            		targ.setSubUnlocked(true, 1);
            	}
            }
            if (event.entityPlayer.getCurrentEquippedItem() != null && event.entityPlayer.getCurrentEquippedItem().getItem() == BleachItems.hairclip && event.target instanceof EntityPlayer && !event.entityPlayer.worldObj.isRemote) {
            	EntityPlayer player = event.entityPlayer;
            	EntityPlayer target = (EntityPlayer) event.target;
            	ExtendedPlayer plr = ExtendedPlayer.get(player);
            	ExtendedPlayer targ = ExtendedPlayer.get(target);
            	if (player.isSneaking()) {
	            	if (!target.isPotionActive(BleachMod.defenseReject.id)) {
	            	   if (plr.getSelectedSkill() == 2) {
	    	    			if (plr.getSkill1dlevel() == 1) {
	    	    				target.addPotionEffect(new PotionEffect(BleachMod.defenseReject.id, 8, 0));
	    	    				plr.consumeEnergy(20);
	    	    			}
	    	    			else if (plr.getSkill1dlevel() == 2) {
	    	    				target.addPotionEffect(new PotionEffect(BleachMod.defenseReject.id, 12, 0));
	    	    				plr.consumeEnergy(25);
	    	    			}
	    	    			else if (plr.getSkill1dlevel() == 3) {
	    	    				target.addPotionEffect(new PotionEffect(BleachMod.defenseReject.id, 16, 0));
	    	    				plr.consumeEnergy(30);
	    	    			}
	    	    			else if (plr.getSkill1dlevel() == 4) {
	    	    				target.addPotionEffect(new PotionEffect(BleachMod.defenseReject.id, 20, 0));
	    	    				plr.consumeEnergy(35);
	    	    			}
	    	    			else if (plr.getSkill1dlevel() == 5) {
	    	    				target.addPotionEffect(new PotionEffect(BleachMod.defenseReject.id, 24, 0));
	    	    				plr.consumeEnergy(40);
	    	    			}
	    	    			else if (plr.getSkill1dlevel() == 6) {
	    	    				target.addPotionEffect(new PotionEffect(BleachMod.defenseReject.id, 28, 0));
	    	    				plr.consumeEnergy(45);
	    	    			}
	    	    			else if (plr.getSkill1dlevel() == 7) {
	    	    				target.addPotionEffect(new PotionEffect(BleachMod.defenseReject.id, 32, 0));
	    	    				plr.consumeEnergy(50);
	    	    			}
	    	    			else if (plr.getSkill1dlevel() == 8) {
	    	    				target.addPotionEffect(new PotionEffect(BleachMod.defenseReject.id, 36, 0));
	    	    				plr.consumeEnergy(55);
	    	    			}
	
	    	    		}
	            	}
            	}
            }
        }
    }
    
    @SubscribeEvent
    public void onItemUseEvent(PlayerUseItemEvent.Start event) {
    	if (event.item.getItem().equals(Items.milk_bucket) && event.entityPlayer.isPotionActive(BleachMod.soulDisconnect.id)) {
    		event.setCanceled(true);
    	}
    }
    
    @SubscribeEvent
    public void onPlayerInteractEvent(final PlayerInteractEvent event) {
        final ExtendedPlayer props = ExtendedPlayer.get(event.entityPlayer);
        final Vec3 look = event.entityPlayer.getLook(1.0f);
        if (event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BleachBlocks.hollowdiamond && event.action.equals((Object)PlayerInteractEvent.Action.LEFT_CLICK_BLOCK)) {
            final EntityHollowOre var18 = new EntityHollowOre(event.entityPlayer.worldObj, 2);
            final int var19 = event.x;
            final int var20 = event.y;
            final int var21 = event.z;
            var18.setLocationAndAngles((double)var19, (double)var20, (double)var21, 0.0f, 0.0f);
            event.entityPlayer.worldObj.createExplosion((Entity)null, (double)event.x, (double)event.y, (double)event.z, 1.0f, true);
            for (int i = -2; i <= 2; ++i) {
                for (int j = -2; j <= 2; ++j) {
                    for (int k = -2; k <= 2; ++k) {
                        if (event.entityPlayer.worldObj.getBlock(event.x + i, event.y + k, event.z + j) != Blocks.bedrock) {
                            event.entityPlayer.worldObj.setBlockToAir(event.x + i, event.y + k, event.z + j);
                        }
                    }
                }
            }
            event.entityPlayer.worldObj.spawnEntityInWorld((Entity)var18);
            event.entityPlayer.worldObj.playSoundAtEntity((Entity)var18, "bleachreborn:ore_hollow", 1.4f, 1.0f);
        }
        if (event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BleachBlocks.hollowemerald && event.action.equals((Object)PlayerInteractEvent.Action.LEFT_CLICK_BLOCK)) {
            final EntityHollowOre var18 = new EntityHollowOre(event.entityPlayer.worldObj, 1);
            final int var19 = event.x;
            final int var20 = event.y;
            final int var21 = event.z;
            var18.setLocationAndAngles((double)var19, (double)var20, (double)var21, 0.0f, 0.0f);
            event.entityPlayer.worldObj.createExplosion((Entity)null, (double)event.x, (double)event.y, (double)event.z, 1.0f, true);
            for (int i = -2; i <= 2; ++i) {
                for (int j = -2; j <= 2; ++j) {
                    for (int k = -2; k <= 2; ++k) {
                        event.entityPlayer.worldObj.setBlockToAir(event.x + i, event.y + k, event.z + j);
                    }
                }
            }
            event.entityPlayer.worldObj.spawnEntityInWorld((Entity)var18);
            event.entityPlayer.worldObj.playSoundAtEntity((Entity)var18, "bleachreborn:ore_hollow", 1.4f, 1.0f);
        }
        if (event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BleachBlocks.hollowgold && event.action.equals((Object)PlayerInteractEvent.Action.LEFT_CLICK_BLOCK)) {
            final EntityHollowOre var18 = new EntityHollowOre(event.entityPlayer.worldObj, 0);
            final int var19 = event.x;
            final int var20 = event.y;
            final int var21 = event.z;
            var18.setLocationAndAngles((double)var19, (double)var20, (double)var21, 0.0f, 0.0f);
            event.entityPlayer.worldObj.createExplosion((Entity)null, (double)event.x, (double)event.y, (double)event.z, 1.0f, true);
            for (int i = -2; i <= 2; ++i) {
                for (int j = -2; j <= 2; ++j) {
                    for (int k = -2; k <= 2; ++k) {
                        event.entityPlayer.worldObj.setBlockToAir(event.x + i, event.y + k, event.z + j);
                    }
                }
            }
            event.entityPlayer.worldObj.spawnEntityInWorld((Entity)var18);
            event.entityPlayer.worldObj.playSoundAtEntity((Entity)var18, "bleachreborn:ore_hollow", 1.4f, 1.0f);
        }
        if (event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BleachBlocks.reiatsuBlock && event.action.equals(PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK)) {
        	EntityPlayer player = event.entityPlayer;
        	ExtendedPlayer props1 = ExtendedPlayer.get(player);
        	if (props1.getFaction() == 6) {
        		if (props1.getCurrentCap() >= 250) {
        			props1.setFaction(14);
        		}
        	}
        }
        if (event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == BleachBlocks.soulQuartzBlock && event.action.equals(PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK)) {
        	EntityPlayer player = event.entityPlayer;
        	ExtendedPlayer props1 = ExtendedPlayer.get(player);
        	if (props1.getFaction() == 6) {
        		if (props1.getCurrentCap() >= 250) {
        			props1.setFaction(15);
        		}
        	}
        }
    }
    
    private boolean isEntityInCube(final Entity entity) {
        for (int i = 0; i < TileSeeleSchneider.magicSquare.size(); ++i) {
            final int x = TileSeeleSchneider.magicSquare.get(i).posX;
            final int y = TileSeeleSchneider.magicSquare.get(i).posY;
            final int z = TileSeeleSchneider.magicSquare.get(i).posZ;
            final TileSeeleSchneider tile = (TileSeeleSchneider)entity.worldObj.getTileEntity(x, y, z);
            if (tile == null) {
                TileSeeleSchneider.magicSquare.remove(i);
                return false;
            }
            final int side = tile.side;
            if (entity.posX > x + 0.5f && entity.posX < x + side - 0.5f && entity.posZ > z + 0.5f && entity.posZ < z + side - 0.5f && entity.posY >= y) {
                return true;
            }
        }
        return false;
    }
    
    static {
        BleachEvents.spiritSpeedModifierUUID = UUID.fromString("36c948d8-8365-4ba7-8389-881fe302bc2a");
        BleachEvents.spiritSpeedModifier = new AttributeModifier(BleachEvents.spiritSpeedModifierUUID, "Spirit Enhanced Speed", 0.1, 0);
        BleachEvents.proxy = new CommonProxy();
    }
}

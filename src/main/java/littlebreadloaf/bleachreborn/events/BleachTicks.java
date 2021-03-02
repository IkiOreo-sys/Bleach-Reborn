package littlebreadloaf.bleachreborn.events;

import java.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.ai.attributes.*;
import cpw.mods.fml.common.eventhandler.*;
import cpw.mods.fml.common.gameevent.*;

public class BleachTicks
{
    private static UUID HealthBoost;
    
    @SubscribeEvent
    public void playerTick(final TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            final EntityPlayer player = event.player;
            final ExtendedPlayer props = ExtendedPlayer.get(player);
            int faction = props.getFaction();
            if(faction == 9 || faction == 10 || faction == 12 || faction == 13) {
                player.height = 1.8F + props.getGrowth();
                player.width = 0.6F + props.getGrowth();
            } else {
                player.height = 1.8F;
                player.width = 0.6F;
            }
            final AttributeModifier HealthBoostModifier = new AttributeModifier(BleachTicks.HealthBoost, "Health Boost", (props.getCurrentCap() / 10 - props.getCurrentCap() / 10 % 2.0) / 20.0, 1);
            final IAttributeInstance iattributeinstance = player.getEntityAttribute(SharedMonsterAttributes.maxHealth);
            iattributeinstance.removeModifier(HealthBoostModifier);
            iattributeinstance.applyModifier(HealthBoostModifier);
        }
    }
    
    @SubscribeEvent
    public void playerRespawn(final PlayerEvent.PlayerRespawnEvent event) {
        final EntityPlayer player = event.player;
        final ExtendedPlayer props = ExtendedPlayer.get(player);
        final int health = props.getCurrentCap() / 3 + 5000;
        final AttributeModifier HealthBoostModifier = new AttributeModifier(BleachTicks.HealthBoost, "Health Boost", props.getCurrentCap() / 10 / 20.0, 1);
        final IAttributeInstance iattributeinstance = player.getEntityAttribute(SharedMonsterAttributes.maxHealth);
        iattributeinstance.removeModifier(HealthBoostModifier);
        iattributeinstance.applyModifier(HealthBoostModifier);
        player.setHealth(player.getMaxHealth());
    }
    
    static {
        BleachTicks.HealthBoost = UUID.fromString("a9359d8e-4077-11e6-beb8-9e71128cae77");
    }
}

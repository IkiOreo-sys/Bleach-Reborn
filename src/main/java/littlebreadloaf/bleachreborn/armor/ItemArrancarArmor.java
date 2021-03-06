package littlebreadloaf.bleachreborn.armor;

import littlebreadloaf.bleachreborn.items.*;
import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import littlebreadloaf.bleachreborn.events.*;
import net.minecraft.entity.player.*;
import littlebreadloaf.bleachreborn.*;
import littlebreadloaf.bleachreborn.network.*;
import cpw.mods.fml.common.network.simpleimpl.*;
import net.minecraft.entity.*;
import net.minecraft.client.model.*;
import net.minecraft.init.*;

public class ItemArrancarArmor extends ItemArmor
{
    int replenishTimer;
    
    public ItemArrancarArmor(final ItemArmor.ArmorMaterial par2, final int par3, final int par4) {
        super(par2, par3, par4);
        this.replenishTimer = 200;
        this.setCreativeTab(BleachItems.tabBleach);
        if (par4 == 1) {
            this.setTextureName("bleachreborn:arrancar_top");
        }
        else if (par4 == 2) {
            this.setTextureName("bleachreborn:arrancar_pants");
        }
        else if (par4 == 3) {
            this.setTextureName("bleachreborn:arrancar_shoes");
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister par1RegisterIcon) {
        if (this == Armor.ArrancarJacket) {
            this.itemIcon = par1RegisterIcon.registerIcon("bleachreborn".toLowerCase() + ":arrancar_top");
        }
        if (this == Armor.ArrancarPants) {
            this.itemIcon = par1RegisterIcon.registerIcon("bleachreborn".toLowerCase() + ":arrancar_pants");
        }
        if (this == Armor.ArrancarShoes) {
            this.itemIcon = par1RegisterIcon.registerIcon("bleachreborn".toLowerCase() + ":arrancar_shoes");
        }
    }
    
    public String getArmorTexture(final ItemStack stack, final Entity entity, final int slot, final String layer) {
        if (stack.getItem() == Armor.ArrancarJacket || stack.getItem() == Armor.ArrancarShoes) {
            return "bleachreborn".toLowerCase() + ":textures/models/armor/arrancar_armor_1.png";
        }
        if (stack.getItem() == Armor.ArrancarPants) {
            return "bleachreborn".toLowerCase() + ":textures/models/armor/arrancar_armor_2.png";
        }
        return null;
    }
    
    public void onArmorTick(final World world, final EntityPlayer player, final ItemStack itemStack) {
        if (!world.isRemote) {
            --this.replenishTimer;
            final ExtendedPlayer props = (ExtendedPlayer)player.getExtendedProperties("BleachPlayer");
            if (this.replenishTimer <= 0 && props.getFaction() == 1) {
                props.replenishEnergy(2);
                if (player instanceof EntityPlayerMP) {
                    PacketDispatcher.sendTo((IMessage)new ServerSyncMessage(player), (EntityPlayerMP)player);
                }
                this.replenishTimer = 200;
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(final EntityLivingBase entityLiving, final ItemStack itemStack, final int armorSlot) {
        ModelBiped armorModel = null;
        if (itemStack != null) {
            armorModel = BleachMod.proxy.getArmorModel(0);
            if (armorModel != null) {
                armorModel.bipedHead.showModel = (armorSlot == 0);
                armorModel.bipedHeadwear.showModel = (armorSlot == 0);
                armorModel.bipedBody.showModel = (armorSlot == 1 || armorSlot == 2);
                armorModel.bipedRightArm.showModel = (armorSlot == 1);
                armorModel.bipedLeftArm.showModel = (armorSlot == 1);
                armorModel.bipedRightLeg.showModel = (armorSlot == 2 || armorSlot == 3);
                armorModel.bipedLeftLeg.showModel = (armorSlot == 2 || armorSlot == 3);
                armorModel.isSneak = entityLiving.isSneaking();
                armorModel.isRiding = entityLiving.isRiding();
                armorModel.isChild = entityLiving.isChild();
                armorModel.heldItemRight = ((entityLiving.getEquipmentInSlot(0) != null) ? 1 : 0);
                if (entityLiving instanceof EntityPlayer && entityLiving.getHeldItem() != null) {
                    if (entityLiving.getHeldItem().getItem() == Items.bow || entityLiving.getHeldItem().getItem() == BleachItems.quincybow || entityLiving.getHeldItem().getItem() == BleachItems.quincyweb) {
                        armorModel.aimedBow = (((EntityPlayer)entityLiving).getItemInUseDuration() > 2);
                    }
                    else if (((EntityPlayer)entityLiving).getItemInUseDuration() > 0) {
                        armorModel.heldItemRight = 3;
                    }
                }
                return armorModel;
            }
        }
        return armorModel;
    }
}

package littlebreadloaf.bleachreborn.armor;

import littlebreadloaf.bleachreborn.items.*;
import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import littlebreadloaf.bleachreborn.events.*;
import net.minecraft.potion.*;
import net.minecraft.entity.*;
import net.minecraft.client.model.*;
import littlebreadloaf.bleachreborn.*;

public class ItemSoulChain extends ItemArmor
{
    int depleteTimer;
    
    public ItemSoulChain(final ItemArmor.ArmorMaterial par2, final int par3, final int par4) {
        super(par2, par3, par4);
        this.depleteTimer = 40;
        this.setUnlocalizedName("soulchain");
        this.setTextureName("bleachreborn:soulchain");
        this.setCreativeTab(BleachItems.tabBleach);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister par1RegisterIcon) {
        this.itemIcon = par1RegisterIcon.registerIcon("bleachreborn".toLowerCase() + ":soulchain");
    }
    
    public String getArmorTexture(final ItemStack stack, final Entity entity, final int slot, final String layer) {
        return "bleachreborn".toLowerCase() + ":textures/models/armor/soul_chain.png";
    }
    
    public void onArmorTick(final World world, final EntityPlayer player, final ItemStack itemStack) {
        --this.depleteTimer;
        final ExtendedPlayer props = (ExtendedPlayer)player.getExtendedProperties("BleachPlayer");
        if (props.getCurrentEnergy() > 0.0f) {
            player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.getId(), 40, 0));
            if (this.depleteTimer <= 0) {
                this.depleteTimer = 40;
                if (!world.isRemote) {
                    props.consumeEnergy(5);
                }
            }
            if (BleachEvents.chainTimer < 0) {
                props.setChainCount(props.getChainCount() + 1);
                BleachEvents.chainTimer = 20;
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(final EntityLivingBase entityLiving, final ItemStack itemStack, final int armorSlot) {
        ModelBiped armorModel = null;
        if (itemStack != null) {
            armorModel = BleachMod.proxy.getArmorModel(21);
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
                if (entityLiving instanceof EntityPlayer) {
                    armorModel.aimedBow = (((EntityPlayer)entityLiving).getItemInUseDuration() > 2);
                }
                return armorModel;
            }
        }
        return armorModel;
    }
}

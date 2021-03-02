package littlebreadloaf.bleachreborn.armor;

import littlebreadloaf.bleachreborn.items.*;
import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;
import net.minecraft.client.model.*;
import littlebreadloaf.bleachreborn.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;

public class ItemMAcademyRobes extends ItemArmor
{
    public ItemMAcademyRobes(final ItemArmor.ArmorMaterial par2, final int par3, final int armorType) {
        super(par2, par3, armorType);
        this.setCreativeTab(BleachItems.tabBleach);
        if (armorType == 1) {
            this.setTextureName("bleachreborn:macademy_top");
        }
        else if (armorType == 2) {
            this.setTextureName("bleachreborn:macademy_bottom");
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister par1RegisterIcon) {
        if (this == Armor.MaleAcademyTop) {
            this.itemIcon = par1RegisterIcon.registerIcon("bleachreborn".toLowerCase() + ":macademy_top");
        }
        if (this == Armor.MaleAcademyBottom) {
            this.itemIcon = par1RegisterIcon.registerIcon("bleachreborn".toLowerCase() + ":macademy_bottom");
        }
    }
    
    public String getArmorTexture(final ItemStack stack, final Entity entity, final int slot, final String layer) {
        if (stack.getItem() == Armor.MaleAcademyTop) {
            return "bleachreborn".toLowerCase() + ":textures/models/armor/male_academy_1.png";
        }
        if (stack.getItem() == Armor.MaleAcademyBottom) {
            return "bleachreborn".toLowerCase() + ":textures/models/armor/male_academy_2.png";
        }
        return null;
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

package littlebreadloaf.bleachreborn.armor;

import littlebreadloaf.bleachreborn.items.*;
import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;
import net.minecraft.client.model.*;
import littlebreadloaf.bleachreborn.*;
import net.minecraft.entity.player.*;

public class ItemGolemHelmet extends ItemArmor
{
    public ItemGolemHelmet(final ItemArmor.ArmorMaterial par2, final int par3, final int par4) {
        super(par2, par3, par4);
        this.setUnlocalizedName("golemmask");
        this.setTextureName("bleachreborn:golemmask");
        this.setCreativeTab(BleachItems.tabBleach);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister par1RegisterIcon) {
        this.itemIcon = par1RegisterIcon.registerIcon("bleachreborn".toLowerCase() + ":golemmask");
    }
    
    public String getArmorTexture(final ItemStack stack, final Entity entity, final int slot, final String layer) {
        return "bleachreborn".toLowerCase() + ":textures/models/armor/golem_mask_1.png";
    }
    
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(final EntityLivingBase entityLiving, final ItemStack itemStack, final int armorSlot) {
        ModelBiped armorModel = null;
        if (itemStack != null) {
            armorModel = BleachMod.proxy.getArmorModel(1);
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

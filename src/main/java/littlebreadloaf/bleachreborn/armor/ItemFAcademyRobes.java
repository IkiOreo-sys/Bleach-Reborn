package littlebreadloaf.bleachreborn.armor;

import littlebreadloaf.bleachreborn.items.*;
import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;

public class ItemFAcademyRobes extends ItemArmor
{
    public ItemFAcademyRobes(final ItemArmor.ArmorMaterial par2, final int par3, final int armorType) {
        super(par2, par3, armorType);
        this.setCreativeTab(BleachItems.tabBleach);
        if (armorType == 1) {
            this.setTextureName("bleachreborn:facademy_top");
        }
        else if (armorType == 2) {
            this.setTextureName("bleachreborn:facademy_bottom");
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister par1RegisterIcon) {
        if (this == Armor.FemaleAcademyTop) {
            this.itemIcon = par1RegisterIcon.registerIcon("bleachreborn".toLowerCase() + ":facademy_top");
        }
        if (this == Armor.FemaleAcademyBottom) {
            this.itemIcon = par1RegisterIcon.registerIcon("bleachreborn".toLowerCase() + ":facademy_bottom");
        }
    }
    
    public String getArmorTexture(final ItemStack stack, final Entity entity, final int slot, final String layer) {
        if (stack.getItem() == Armor.FemaleAcademyTop) {
            return "bleachreborn".toLowerCase() + ":textures/models/armor/female_academy_1.png";
        }
        if (stack.getItem() == Armor.FemaleAcademyBottom) {
            return "bleachreborn".toLowerCase() + ":textures/models/armor/female_academy_2.png";
        }
        return null;
    }
}

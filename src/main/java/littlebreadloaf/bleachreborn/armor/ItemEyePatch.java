package littlebreadloaf.bleachreborn.armor;

import littlebreadloaf.bleachreborn.items.*;
import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import littlebreadloaf.bleachreborn.events.*;

public class ItemEyePatch extends ItemArmor
{
    int depleteTimer = 40;
    
    public ItemEyePatch(final ItemArmor.ArmorMaterial par2, final int par3, final int par4) {
        super(par2, par3, par4);
        this.setUnlocalizedName("eyepatch");
        this.setTextureName("bleachreborn:eyepatch");
        this.setCreativeTab(BleachItems.tabBleach);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister par1RegisterIcon) {
        this.itemIcon = par1RegisterIcon.registerIcon("bleachreborn".toLowerCase() + ":eyepatch");
    }
    
    public String getArmorTexture(final ItemStack stack, final Entity entity, final int slot, final String layer) {
        return "bleachreborn".toLowerCase() + ":textures/models/armor/eyepatch_1.png";
    }
    
    public void onArmorTick(final World world, final EntityPlayer player, final ItemStack itemStack) {
        --this.depleteTimer;
        final ExtendedPlayer props = (ExtendedPlayer)player.getExtendedProperties("BleachPlayer");
        if (props.getCurrentEnergy() > 0.0f && this.depleteTimer <= 0) {
            props.consumeEnergy((int)(0.10 * props.getCurrentCap()));
            this.depleteTimer = 40;
        }
    }
}

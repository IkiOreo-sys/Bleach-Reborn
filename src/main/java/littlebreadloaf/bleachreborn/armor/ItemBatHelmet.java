package littlebreadloaf.bleachreborn.armor;

import littlebreadloaf.bleachreborn.items.*;
import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import littlebreadloaf.bleachreborn.events.*;
import net.minecraft.potion.*;

public class ItemBatHelmet extends ItemArmor
{
    int depleteTimer;
    
    public ItemBatHelmet(final ItemArmor.ArmorMaterial par2, final int par3, final int par4) {
        super(par2, par3, par4);
        this.depleteTimer = 40;
        this.setUnlocalizedName("batmask");
        this.setCreativeTab(BleachItems.tabBleach);
        this.setTextureName("bleachreborn:batmask");
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister par1RegisterIcon) {
        this.itemIcon = par1RegisterIcon.registerIcon("bleachreborn".toLowerCase() + ":batmask");
    }
    
    public String getArmorTexture(final ItemStack stack, final Entity entity, final int slot, final String type) {
        return "bleachreborn".toLowerCase() + ":textures/models/armor/bat_mask_1.png";
    }
    
    public void onArmorTick(final World world, final EntityPlayer player, final ItemStack itemStack) {
        --this.depleteTimer;
        final ExtendedPlayer props = (ExtendedPlayer)player.getExtendedProperties("BleachPlayer");
        if (props.getCurrentEnergy() > 0.0f) {
            player.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 220, 0));
            if (this.depleteTimer <= 0) {
                this.depleteTimer = 40;
                if (!world.isRemote) {
                    props.consumeEnergy(1);
                }
            }
        }
    }
}

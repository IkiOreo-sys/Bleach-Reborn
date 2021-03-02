package littlebreadloaf.bleachreborn.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import littlebreadloaf.bleachreborn.items.*;
import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;

public class BleachBlock extends Block
{
    public BleachBlock() {
        super(Material.rock);
        this.setCreativeTab(BleachItems.tabBleach);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister itemIcon) {
        this.blockIcon = itemIcon.registerIcon("bleachreborn:" + this.getUnlocalizedName().substring(5));
    }
}

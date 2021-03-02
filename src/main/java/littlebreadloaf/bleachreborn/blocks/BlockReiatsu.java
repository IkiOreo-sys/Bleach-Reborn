package littlebreadloaf.bleachreborn.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import littlebreadloaf.bleachreborn.items.*;
import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;

public class BlockReiatsu extends Block
{
    public BlockReiatsu() {
        super(Material.iron);
        this.setCreativeTab(BleachItems.tabBleach);
        this.setBlockName("reiatsu_block");
        this.setHardness(5.0f);
        this.setResistance(15.0f);
        this.setStepSound(Block.soundTypeStone);
        this.setLightLevel(0.9f);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister icon) {
        this.blockIcon = icon.registerIcon("bleachreborn".toLowerCase() + ":reiatsu_block");
    }
}

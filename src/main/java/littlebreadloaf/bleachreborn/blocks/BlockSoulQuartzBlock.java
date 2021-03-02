package littlebreadloaf.bleachreborn.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import littlebreadloaf.bleachreborn.items.*;
import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;

public class BlockSoulQuartzBlock extends Block
{
    public BlockSoulQuartzBlock() {
        super(Material.rock);
        this.setCreativeTab(BleachItems.tabBleach);
        this.setBlockName("soul_quartz_block");
        this.setHardness(4.0f);
        this.setResistance(10.0f);
        this.setStepSound(Block.soundTypeStone);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister icon) {
        this.blockIcon = icon.registerIcon("bleachreborn".toLowerCase() + ":soul_quartz_block");
    }
}

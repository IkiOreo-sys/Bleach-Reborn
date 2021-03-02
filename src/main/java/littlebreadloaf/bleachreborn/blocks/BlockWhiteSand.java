package littlebreadloaf.bleachreborn.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import littlebreadloaf.bleachreborn.items.*;
import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;

public class BlockWhiteSand extends Block
{
    public BlockWhiteSand() {
        super(Material.sand);
        this.setCreativeTab(BleachItems.tabBleach);
        this.setBlockName("white_sand");
        this.setHardness(1.7f);
        this.setResistance(5.5f);
        this.setStepSound(Block.soundTypeStone);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister icon) {
        this.blockIcon = icon.registerIcon("bleachreborn".toLowerCase() + ":white_sand");
    }
}

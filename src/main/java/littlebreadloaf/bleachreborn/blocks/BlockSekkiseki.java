package littlebreadloaf.bleachreborn.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import littlebreadloaf.bleachreborn.items.*;
import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;

public class BlockSekkiseki extends Block
{
    public BlockSekkiseki(final int id) {
        super(Material.iron);
        this.setCreativeTab(BleachItems.tabBleach);
        this.setBlockName("sekkiseki");
        this.setHardness(10.0f);
        this.setResistance(30.0f);
        this.setStepSound(Block.soundTypeStone);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister icon) {
        this.blockIcon = icon.registerIcon("bleachreborn".toLowerCase() + ":sekkiseki");
    }
}

package littlebreadloaf.bleachreborn.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import littlebreadloaf.bleachreborn.items.*;
import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;

public class BlockHollowDiamond extends Block
{
    public BlockHollowDiamond() {
        super(Material.rock);
        this.setCreativeTab(BleachItems.tabBleach);
        this.setBlockName("hollow_diamond");
        this.setHardness(6.0f);
        this.setResistance(8.0f);
        this.setStepSound(Block.soundTypeStone);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister icon) {
        this.blockIcon = icon.registerIcon("bleachreborn".toLowerCase() + ":hollow_diamond");
    }
}

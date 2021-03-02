package littlebreadloaf.bleachreborn.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import littlebreadloaf.bleachreborn.items.*;
import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;

public class BlockHollowGold extends Block
{
    public BlockHollowGold() {
        super(Material.rock);
        this.setCreativeTab(BleachItems.tabBleach);
        this.setBlockName("hollow_gold");
        this.setHardness(6.0f);
        this.setResistance(8.0f);
        this.setStepSound(Block.soundTypeStone);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister icon) {
        this.blockIcon = icon.registerIcon("bleachreborn".toLowerCase() + ":hollow_gold");
    }
}

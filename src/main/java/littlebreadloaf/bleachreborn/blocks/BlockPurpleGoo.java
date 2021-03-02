package littlebreadloaf.bleachreborn.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import littlebreadloaf.bleachreborn.items.*;
import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;
import java.util.*;
import net.minecraft.item.*;

public class BlockPurpleGoo extends Block
{
    public BlockPurpleGoo() {
        super(Material.cake);
        this.setCreativeTab(BleachItems.tabBleach);
        this.setBlockName("purple_goo");
        this.setHardness(4.0f);
        this.setResistance(40.0f);
        this.setStepSound(Block.soundTypeStone);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister icon) {
        this.blockIcon = icon.registerIcon("bleachreborn".toLowerCase() + ":purple_goo");
    }
    
    public int quantityDropped(final Random par1Random) {
        return 0;
    }
    
    public Item getItemDropped(final int par1, final Random par2Random, final int par3) {
        return null;
    }
}

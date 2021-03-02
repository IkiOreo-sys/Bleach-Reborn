package littlebreadloaf.bleachreborn.blocks;

import net.minecraft.block.*;
import java.util.*;
import net.minecraft.block.material.*;
import littlebreadloaf.bleachreborn.items.*;
import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.item.*;

public class BlockMaskOre extends Block
{
    private Random rand;
    
    public BlockMaskOre() {
        super(Material.rock);
        this.rand = new Random();
        this.setCreativeTab(BleachItems.tabBleach);
        this.setBlockName("mask_ore");
        this.setHardness(3.0f);
        this.setResistance(10.0f);
        this.setStepSound(Block.soundTypeStone);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister icon) {
        this.blockIcon = icon.registerIcon("bleachreborn".toLowerCase() + ":mask_ore");
    }
    
    public int quantityDropped(final Random par1Random) {
        return this.rand.nextInt(3);
    }
    
    public Item getItemDropped(final int par1, final Random par2Random, final int par3) {
        return BleachItems.maskshard;
    }
}

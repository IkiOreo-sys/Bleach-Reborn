package littlebreadloaf.bleachreborn.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import littlebreadloaf.bleachreborn.items.*;
import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;

public class BlockSoulQuartzLamp extends Block
{
    public BlockSoulQuartzLamp() {
        super(Material.rock);
        this.setCreativeTab(BleachItems.tabBleach);
        this.setBlockName("soul_quartz_lamp");
        this.setHardness(3.0f);
        this.setResistance(10.0f);
        this.setStepSound(Block.soundTypeStone);
        this.setLightLevel(1.0f);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister icon) {
        this.blockIcon = icon.registerIcon("bleachreborn".toLowerCase() + ":soul_quartz_lamp");
    }
}

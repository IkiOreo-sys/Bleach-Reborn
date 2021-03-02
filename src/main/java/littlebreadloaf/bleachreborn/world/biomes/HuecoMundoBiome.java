package littlebreadloaf.bleachreborn.world.biomes;

import net.minecraft.world.biome.*;
import net.minecraft.init.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.block.*;

public class HuecoMundoBiome extends BiomeGenBase
{
    public HuecoMundoBiome(final int id) {
        super(id);
        this.theBiomeDecorator = new HuecoMundoBiomeDecorator();
        this.setBiomeName("Hueco Mundo");
        this.setDisableRain();
        this.setTemperatureRainfall(0.5f, 0.0f);
        this.setHeight(HuecoMundoBiome.height_Default);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.topBlock = (Block)Blocks.grass;
        this.fillerBlock = Blocks.clay;
    }
    
    @SideOnly(Side.CLIENT)
    public int getSkyColorByTemp(final float par1) {
        return 0;
    }
}

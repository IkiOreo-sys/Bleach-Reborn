package littlebreadloaf.bleachreborn.world.biomes;

import net.minecraft.world.biome.*;
import net.minecraft.init.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.block.*;

public class SoulSocietyForestBiome extends BiomeGenBase
{
    public SoulSocietyForestBiome(final int id) {
        super(id);
        this.theBiomeDecorator = new SoulSocietyBiomeDecorator();
        this.setBiomeName("Soul Society");
        this.setDisableRain();
        this.setTemperatureRainfall(0.5f, 0.0f);
        this.setHeight(SoulSocietyForestBiome.height_Default);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.topBlock = (Block)Blocks.grass;
        this.fillerBlock = Blocks.stone;
    }
    
    @SideOnly(Side.CLIENT)
    public int getSkyColorByTemp(final float par1) {
        return 0;
    }
}

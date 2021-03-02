package littlebreadloaf.bleachreborn.world.biomes;

import net.minecraft.world.biome.*;

public class SoulSocietyBiomeDecorator extends BiomeDecorator
{
    public SoulSocietyBiomeDecorator() {
        this.flowersPerChunk = 0;
        this.treesPerChunk = 8;
        this.grassPerChunk = 10;
        this.sandPerChunk = 0;
        this.sandPerChunk2 = 0;
        this.clayPerChunk = 0;
        this.generateLakes = false;
    }
}

package littlebreadloaf.bleachreborn.world.biomes;

import net.minecraft.world.biome.*;
import littlebreadloaf.bleachreborn.*;

public class BleachBiomes
{
    public static BiomeGenBase HuecoMundo;
    public static BiomeGenBase SoulSocietyForest;
    
    public BleachBiomes() {
        BleachBiomes.HuecoMundo = new HuecoMundoBiome(BleachIds.biomeHuecoMundoID);
        BleachBiomes.SoulSocietyForest = new SoulSocietyForestBiome(BleachIds.biomeSoulSocietyForestID);
    }
}

package littlebreadloaf.bleachreborn.world;

import cpw.mods.fml.common.*;
import java.util.*;
import net.minecraft.world.chunk.*;
import net.minecraft.world.*;
import java.io.*;
import littlebreadloaf.bleachreborn.*;
import littlebreadloaf.bleachreborn.world.gen.*;

public class BleachWorldGen implements IWorldGenerator
{
    public void generate(final Random random, final int chunkX, final int chunkZ, final World world, final IChunkProvider chunkGenerator, final IChunkProvider chunkProvider) {
        final WorldServer worlds = (WorldServer)world;
        final File theWorld = new File("./saves/" + worlds.getSaveHandler().getWorldDirectoryName() + "/DIM7");
        final File soulSociety = new File("assets/bleachreborn/maps/DIM7");
        soulSociety.mkdirs();
        if (world.provider.dimensionId == BleachIds.worldHuecoMundoID) {
            this.genHuecoMundo(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
        }
        if (world.provider.dimensionId == BleachIds.worldSoulSocietyID) {
            this.genSoulSociety(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
        }
    }
    
    private void genHuecoMundo(final Random rand, final int chunkX, final int chunkZ, final World world, final IChunkProvider chunkGenerator, final IChunkProvider chunkProvider) {
        final int k = chunkX * 16;
        final int l = chunkZ * 16;
        int x = k + rand.nextInt(16) + 8;
        int z = l + rand.nextInt(16) + 8;
        if (rand.nextInt(10) == 0) {
            new BleachGenHole(59).generate(world, rand, x, 0, z);
        }
        x = k + rand.nextInt(16) + 8;
        z = l + rand.nextInt(16) + 8;
        new BleachGenMenosTree(10).generate(world, rand, x, 0, z);
    }
    
    private void genSoulSociety(final Random rand, final int chunkX, final int chunkZ, final World world, final IChunkProvider chunkGenerator, final IChunkProvider chunkProvider) {
        final int k = chunkX * 16;
        final int l = chunkZ * 16;
        final int x = k + rand.nextInt(16) + 8;
        final int z = l + rand.nextInt(16) + 8;
    }
}

package littlebreadloaf.bleachreborn.extras;

import cpw.mods.fml.common.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.world.chunk.*;
import littlebreadloaf.bleachreborn.blocks.*;
import net.minecraft.world.gen.feature.*;

public class OreGenerator implements IWorldGenerator
{
    public void generate(final Random random, final int chunkX, final int chunkZ, final World world, final IChunkProvider chunkGenerator, final IChunkProvider chunkProvider) {
        switch (world.provider.dimensionId) {
            case -1: {
                this.generateNether(world, random, chunkX * 16, chunkZ * 16);
                break;
            }
            case 0: {
                this.generateSurface(world, random, chunkX * 16, chunkZ * 16);
                break;
            }
            case 1: {
                this.generateEnd(world, random, chunkX * 16, chunkZ * 16);
                break;
            }
        }
    }
    
    private void generateEnd(final World world, final Random random, final int i, final int j) {
    }
    
    private void generateSurface(final World world, final Random random, final int i, final int j) {
        for (int rarity1 = 0; rarity1 < 3; ++rarity1) {
            final int firstBlockXCoord = i + random.nextInt(16);
            final int firstBlockYCoord = random.nextInt(64);
            final int firstBlockZCoord = j + random.nextInt(16);
            new WorldGenMinable(BleachBlocks.hollowdiamond, 1).generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
        }
        for (int rarity2 = 0; rarity2 < 3; ++rarity2) {
            final int firstBlockXCoord = i + random.nextInt(16);
            final int firstBlockYCoord = random.nextInt(64);
            final int firstBlockZCoord = j + random.nextInt(16);
            new WorldGenMinable(BleachBlocks.hollowemerald, 1).generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
        }
        for (int rarity3 = 0; rarity3 < 3; ++rarity3) {
            final int firstBlockXCoord = i + random.nextInt(16);
            final int firstBlockYCoord = random.nextInt(64);
            final int firstBlockZCoord = j + random.nextInt(16);
            new WorldGenMinable(BleachBlocks.hollowgold, 1).generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
        }
    }
    
    private void generateNether(final World world, final Random random, final int i, final int j) {
    }
}

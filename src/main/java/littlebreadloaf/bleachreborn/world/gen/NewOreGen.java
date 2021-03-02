package littlebreadloaf.bleachreborn.world.gen;

import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.QUARTZ;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.event.terraingen.TerrainGen;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;
import littlebreadloaf.bleachreborn.blocks.BleachBlocks;

public class NewOreGen implements IWorldGenerator
{
@Override
public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
{
switch(world.provider.dimensionId)
{
case -1:
generateNether(world, random, chunkX * 16, chunkZ * 16);
break;
case 0:
generateSurface(world, random, chunkX * 16, chunkZ * 16);
break;
case 1:
generateEnd(world, random, chunkX * 16, chunkZ * 16);
break;
default:
}
}

private void generateEnd(World world, Random random, int x, int z)
{
}

private void generateSurface(World world, Random random, int x, int z)
{
	generateOre(BleachBlocks.arrancarEssenceOre, world, random, x, z, 16, 16, 13, 10, 0, 256);
}

private void generateNether(World world, Random random, int x, int z)
{
}

public void generateOre(Block block, World world, Random random, int chunk_x, int chunk_z, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY)
{


int heightRange = maxY - minY;
for (int k1 = 0; k1 < chancesToSpawn; ++k1)
{
int xrand = random.nextInt(16);
int yrand = random.nextInt(heightRange) + minY;
int zrand = random.nextInt(16);
new WorldGenMinable(block, maxVeinSize).generate(world, random, xrand, yrand, zrand);
}
}
}
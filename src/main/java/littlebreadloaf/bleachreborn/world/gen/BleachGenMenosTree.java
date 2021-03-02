package littlebreadloaf.bleachreborn.world.gen;

import net.minecraft.world.gen.feature.*;
import net.minecraft.world.*;
import java.util.*;
import littlebreadloaf.bleachreborn.entities.*;
import net.minecraft.entity.*;
import littlebreadloaf.bleachreborn.blocks.*;

public class BleachGenMenosTree extends WorldGenerator
{
    int seeLevel;
    
    public BleachGenMenosTree(final int seeLevel) {
        this.seeLevel = seeLevel;
    }
    
    public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
        if (random.nextInt(100) == 0) {
            final EntityMenosGrande Menos = new EntityMenosGrande(world);
            Menos.setLocationAndAngles((double)(i + 6), (double)j, (double)(k + 6), 0.0f, 0.0f);
            world.spawnEntityInWorld((Entity)Menos);
        }
        int radius = 2;
        if (random.nextInt(300) == 0) {
            radius = random.nextInt(3) + 6;
        }
        else {
            radius = random.nextInt(3) + 2;
        }
        for (int x = -radius; x <= radius; ++x) {
            for (int z = -radius; z <= radius; ++z) {
                for (int y = this.seeLevel; y < 25; ++y) {
                    if (Math.sqrt(z * z + x * x) <= radius) {
                        world.setBlock(x + i, y, z + k, BleachBlocks.soulQuartzBlock);
                        world.setBlock(x + i, y + random.nextInt(2), z + k, BleachBlocks.soulQuartzBlock);
                        world.setBlock(x + i, y + random.nextInt(3), z + k, BleachBlocks.soulQuartzBlock);
                        world.setBlock(x + i, y + random.nextInt(3), z + k, BleachBlocks.soulQuartzBlock);
                        world.setBlock(x + i, y + random.nextInt(4), z + k, BleachBlocks.soulQuartzBlock);
                    }
                }
            }
        }
        for (int x = -(--radius); x <= radius; ++x) {
            for (int z = -radius; z <= radius; ++z) {
                for (int y = 24; y < 40; ++y) {
                    if (Math.sqrt(z * z + x * x) <= radius) {
                        world.setBlock(x + i, y, z + k, BleachBlocks.soulQuartzBlock);
                        world.setBlock(x + i, y + random.nextInt(2), z + k, BleachBlocks.soulQuartzBlock);
                        world.setBlock(x + i, y + random.nextInt(3), z + k, BleachBlocks.soulQuartzBlock);
                        world.setBlock(x + i, y + random.nextInt(3), z + k, BleachBlocks.soulQuartzBlock);
                        world.setBlock(x + i, y + random.nextInt(4), z + k, BleachBlocks.soulQuartzBlock);
                    }
                }
            }
        }
        if (radius > 0) {
            for (int x = -(--radius); x <= radius; ++x) {
                for (int z = -radius; z <= radius; ++z) {
                    for (int y = 39; y < 55; ++y) {
                        if (Math.sqrt(z * z + x * x) <= radius) {
                            world.setBlock(x + i, y, z + k, BleachBlocks.soulQuartzBlock);
                            world.setBlock(x + i, y + random.nextInt(2), z + k, BleachBlocks.soulQuartzBlock);
                            world.setBlock(x + i, y + random.nextInt(3), z + k, BleachBlocks.soulQuartzBlock);
                            world.setBlock(x + i, y + random.nextInt(3), z + k, BleachBlocks.soulQuartzBlock);
                            world.setBlock(x + i, y + random.nextInt(4), z + k, BleachBlocks.soulQuartzBlock);
                            if (random.nextInt(30) == 0) {
                                int directionX;
                                int directionZ;
                                for (directionX = 0, directionZ = 0; directionZ == 0 && directionX == 0; directionX = random.nextInt(2) - random.nextInt(2), directionZ = random.nextInt(2) - random.nextInt(2)) {}
                                final int length = 4 + random.nextInt(4);
                                int blockX = x + i;
                                int blockZ = z + k;
                                for (int b = 0; b < length; ++b) {
                                    blockX += directionX;
                                    blockZ += directionZ;
                                    world.setBlock(blockX, y, blockZ, BleachBlocks.soulQuartzBlock);
                                    if (random.nextInt(3) == 0) {
                                        ++y;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (--radius > 0) {
            for (int x = -radius; x <= radius; ++x) {
                for (int z = -radius; z <= radius; ++z) {
                    for (int y = 54; y < 65; ++y) {
                        if (Math.sqrt(z * z + x * x) <= radius) {
                            world.setBlock(x + i, y, z + k, BleachBlocks.soulQuartzBlock);
                            world.setBlock(x + i, y + random.nextInt(2), z + k, BleachBlocks.soulQuartzBlock);
                            world.setBlock(x + i, y + random.nextInt(3), z + k, BleachBlocks.soulQuartzBlock);
                            world.setBlock(x + i, y + random.nextInt(3), z + k, BleachBlocks.soulQuartzBlock);
                            world.setBlock(x + i, y + random.nextInt(4), z + k, BleachBlocks.soulQuartzBlock);
                        }
                    }
                }
            }
        }
        return true;
    }
}

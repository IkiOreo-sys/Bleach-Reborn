package littlebreadloaf.bleachreborn.world.gen;

import net.minecraft.world.gen.feature.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.init.*;

public class BleachGenHole extends WorldGenerator
{
    int seeLevel;
    
    public BleachGenHole(final int seeLevel) {
        this.seeLevel = seeLevel;
    }
    
    public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
        if (world.getBlock(i, this.seeLevel + 1, j) == Blocks.air) {
            return false;
        }
        final int top = world.getTopSolidOrLiquidBlock(i, k);
        final int bottom = this.seeLevel;
        final int radiusMax = random.nextInt(2) + 2;
        final float radiusMin = 0.7f + random.nextInt(7) / 10;
        for (int y = 0; y < top - bottom; ++y) {
            for (int x = -radiusMax; x <= radiusMax; ++x) {
                for (int z = -radiusMax; z <= radiusMax; ++z) {
                    final float lerp = 1.0f - y / (float)(top - bottom);
                    final float radius = (float)(int)this.lerp(radiusMin, (float)radiusMax, lerp);
                    if (x * x + z * z <= radius * radius) {
                        world.setBlockToAir(x + i, y + bottom, z + k);
                    }
                }
            }
        }
        return true;
    }
    
    float lerp(final float v0, final float v1, final float t) {
        return v0 + (v1 - v0) * t;
    }
}
